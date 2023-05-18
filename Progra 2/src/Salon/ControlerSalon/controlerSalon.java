package ControlerSalon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ModelSalon.*;
import Orden.Orden;
import ViewSalon.*;

public class controlerSalon {
    public Salon modelSalon;
    private vistaSalon view;
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
        for (JButton mesa : view.mesas){
            mesa.addActionListener(new ActionListener() 
            { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickMesa(mesa);
                }
            });
        }                       
    }

    public static void main(String[] args) {
        new controlerSalon();
    }

    public void pagarPedido(JButton btn){
        int selectedRow=view.facturar.getSelectedRow();
        if (selectedRow!=-1){
            String value = view.facturar.getValueAt(selectedRow, 0).toString();
            Matcher matcher= patron.matcher(value);
            if (matcher.find()) {
                String numeroString = matcher.group(); // Obtener la coincidencia encontrada
                int numero = Integer.parseInt(numeroString);
                JOptionPane.showMessageDialog(null, modelSalon.obtenerInfoOrden(numero-1), "Factura", JOptionPane.INFORMATION_MESSAGE);
                String mens = "Has pagado : " +modelSalon.obtenerCuenta(numero-1)+ " de la mesa "+(numero);
                JOptionPane.showMessageDialog(null, mens, "Información", JOptionPane.INFORMATION_MESSAGE);
                view.model.removeRow(selectedRow);
            }
        }else{
            String mess = "Debe presionar una de las filas.";
            JOptionPane.showMessageDialog(null, mess, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void clickMesa(JButton btn){
        System.out.println("A presionado la mesa: "+ (view.mesas.indexOf(btn)));
        int numero = (view.mesas.indexOf(btn));
        JOptionPane.showMessageDialog(null, modelSalon.obtenerInfoMesa(numero), "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    public void enviarPedido(JButton btn){
        Orden orden = view.pedido;
        System.out.println("\nOrden en el controler: " + orden.getDescripcion());
        int numM = modelSalon.obtenerMesaLibre().getId_mesa();
        modelSalon.agregarOrden(numM, orden);
        this.view.model.addRow(new Object[]{"mesa "+(numM+1),this.view.pedido.obtenerOrden()});
        this.view.pedido = new Orden();

    }
    
    

}
