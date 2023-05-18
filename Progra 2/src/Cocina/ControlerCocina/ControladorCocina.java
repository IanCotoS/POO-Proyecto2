package Cocina.ControlerCocina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Cocina.ModelCocina.ModeloCocina;
import Cocina.ViewCocina.View;
import ServerClient.ClienteCocina;

public class ControladorCocina {
    public ModeloCocina cocina;
    public View vistaCocina;
    
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
            vistaCocina.model.removeRow(selectedRow);
            ClienteCocina client = new ClienteCocina(selectedRow, 5555);
            cocina.eliminarOrden(new int[]{selectedRow, 0});
            
        }else{
            String mess = "Debe presionar una de las filas.";
            JOptionPane.showMessageDialog(null, mess, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    };

    public static void main(String[] args) {
        new ControladorCocina();
    }   

}
