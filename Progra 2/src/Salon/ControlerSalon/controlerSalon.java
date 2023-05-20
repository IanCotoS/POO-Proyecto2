package ControlerSalon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import ModelSalon.*;
import Orden.Orden;
import ServerClient.ClienteCocina;
import ViewSalon.*;

public class controlerSalon {
    public Salon modelSalon;
    public vistaSalon view;
    private Pattern patron = Pattern.compile("\\d+"); // Expresión regular para encontrar dígitos

    public controlerSalon() {
        modelSalon = new Salon();
        view = new vistaSalon();
        this.view.enviarOrden.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarPedido(view.enviarOrden);
        }});
        this.view.factura.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                pagarPedido(view.factura);
        }});
        for (JButton[] mesa : view.mesas){
            for (JButton boton : mesa){
                boton.addActionListener(new ActionListener() 
                { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickMesa(boton);
                }
            });
            }
        }                       
    }

    public static void main(String[] args) {
        new controlerSalon();
    }

    public void pagarPedido(JButton btn){
        if (view.facturar.getRowCount()== 0){
            JOptionPane.showMessageDialog(null, "No hay pedidos pendientes");return;
        }
        int selectedRow=view.facturar.getSelectedRow();
        if (selectedRow!=-1){
            String value = view.facturar.getValueAt(selectedRow, 0).toString();
            Matcher matcher= patron.matcher(value);
            if (matcher.find()) {
                String numeroString = matcher.group(); // Obtener la coincidencia encontrada
                int numero = Integer.parseInt(numeroString);
                int[] posicionMesa = modelSalon.obtenerMesa(numero-1);
                if (!modelSalon.estadoOrden(posicionMesa[0], posicionMesa[1])){
                    String men = "La orden de esta mesa no esta lista.";
                    JOptionPane.showMessageDialog(null, men , "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String resultado = modelSalon.obtenerInfoOrden(posicionMesa[0], posicionMesa[1]);
                JOptionPane.showMessageDialog(null, resultado, "Factura", JOptionPane.INFORMATION_MESSAGE);
                String mens = "Has pagado: " +modelSalon.obtenerCuenta(posicionMesa[0], posicionMesa[1])+ " de la mesa "+(numero);
                JOptionPane.showMessageDialog(null, mens, "Información", JOptionPane.INFORMATION_MESSAGE);
                view.model.removeRow(selectedRow);
            }
        }else{
            String mess = "Debe presionar una de las filas.";
            JOptionPane.showMessageDialog(null, mess, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void clickMesa(JButton btn){
        int[] posicionMesa = view.posicionMesa(btn);
        if (modelSalon.estadoMesa(posicionMesa[0], posicionMesa[1])){
            JOptionPane.showMessageDialog(null, modelSalon.obtenerInfoMesa(posicionMesa[0], posicionMesa[1]), "Información", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Mesa Disponible", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void enviarPedido(JButton btn){
        Orden orden = view.pedido;
        if (orden.hamburguesas.size() == 0 ){ 
            String mens = "Debes seleccionar un tipo de orden.";
            JOptionPane.showMessageDialog(null,mens, "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Mesas m = modelSalon.obtenerMesaLibre();
        if (m == null){
            String mens = "No hay mesas disponibles.";
            JOptionPane.showMessageDialog(null,mens, "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int[] posicionMesa = m.getPosicion();
        int numM = m.getId_mesa();
        modelSalon.agregarOrden(posicionMesa[0], posicionMesa[1], orden);
        this.view.model.addRow(new Object[]{"mesa "+(numM+1),this.view.pedido.obtenerOrden(), "En espera"});
        ClienteCocina sClienteCocina = new ClienteCocina(new Object[]{numM, orden}, 1234);// conexión al servidor de la cocina
        this.view.pedido = new Orden();        
    }
    
    public int[] obtenerMesa(int id_mesa){
        return modelSalon.obtenerMesa(id_mesa);
    }

}
