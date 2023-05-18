package Cocina.ControlerCocina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Cocina.ModelCocina.ModeloCocina;
import Cocina.ViewCocina.View;

public class ControladorCocina {
    private ModeloCocina cocina;
    private View vistaCocina;
    private Pattern patron = Pattern.compile("\\d+");
    
    public ControladorCocina() {
        cocina = new ModeloCocina();
        vistaCocina = new View();
        this.vistaCocina.completarOrden.addActionListener((ActionListener) new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarPedido(vistaCocina.completarOrden);
        }});
    }

    private void enviarPedido(JButton btn){
        int selectedRow= vistaCocina.ordenes.getSelectedRow();
        if (selectedRow!=-1){
            String value = vistaCocina.ordenes.getValueAt(selectedRow, 0).toString();
            Matcher matcher= patron.matcher(value);
            if (matcher.find()) {
                String numeroString = matcher.group(); // Obtener la coincidencia encontrada
                int numero = Integer.parseInt(numeroString);
                System.out.println("Orden de la mesa "+ numero +" entregada.");
            }
        }else{
            String mess = "Debe presionar una de las filas.";
            JOptionPane.showMessageDialog(null, mess, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    };

    public static void main(String[] args) {
        new ControladorCocina();
    }   

}
