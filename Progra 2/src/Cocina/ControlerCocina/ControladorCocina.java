package Cocina.ControlerCocina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Cocina.ModelCocina.ModeloCocina;
import Cocina.ViewCocina.View;
import ServerClient.ClienteCocina;

public class ControladorCocina {
    public ModeloCocina cocina;
    public View vistaCocina;
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
        if (vistaCocina.ordenes.getRowCount()== 0){
            JOptionPane.showMessageDialog(null, "No hay mesas ocupadas");return;
        }
        int selectedRow= vistaCocina.ordenes.getSelectedRow();
        if (selectedRow!=-1){
            String value = vistaCocina.ordenes.getValueAt(selectedRow, 0).toString();
            Matcher matcher= patron.matcher(value);
            if (matcher.find()) {
                //String numeroString = matcher.group(); // Obtener la coincidencia encontrada
                //int numero = Integer.parseInt(numeroString);
                vistaCocina.model.removeRow(selectedRow);
                ClienteCocina client = new ClienteCocina(new Object[]{this.cocina.obtenerMesa(selectedRow)}, 5555);
                cocina.eliminarOrden(selectedRow);
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
