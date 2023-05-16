package ViewSalon;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ModelSalon.FactoryMesas;

public class vistaSalon implements ChangeListener{
    private JButton[][] mesas;
    private JRadioButton hambuerguesa;//hamburguesa basica
    private JButton enviarOrden;
    private JButton factura; // realiza el pago de la cuenta
    private JTable facturar; // muestra todas las mesas y ordenes
    private JFrame ventana;
    private JPanel pnlMesas;
    private JLabel orden;
    
    public vistaSalon() {
        ventana = new JFrame("Salon");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //agregarRadioButtons();
        agregarComponentes();
        ventana.pack();
        ventana.setVisible(true);
        ventana.setSize(500, 500);
    }

    private void agregarComponentes(){
        orden = new JLabel("Seleccione su tipo de orden: ");
        orden.setBounds(FactoryMesas.cantMesas,1, 5, 15);
        pnlMesas = new JPanel();
        pnlMesas.setLayout(new GridLayout(FactoryMesas.cantMesas/2,FactoryMesas.cantMesas/2));
        agregarMesas();
        ventana.add(orden);
        ventana.add(pnlMesas,BorderLayout.WEST);
    }

    private void agregarMesas(){
        mesas = new JButton[FactoryMesas.cantMesas/2][FactoryMesas.cantMesas/2];
        for (int i=0; i< FactoryMesas.cantMesas/2; i++){
            for (int j=0; j< FactoryMesas.cantMesas/2; j++){
                JButton btn = new JButton();
                btn.setSize(100, 100);
                ImageIcon imagenIcono = new ImageIcon("Progra 2/src/Imagenes/mesas.png");
                Image imagen = imagenIcono.getImage();
                Image imagenEscalada = imagen.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(imagenEscalada));
                btn.addActionListener(new ActionListener() 
                { 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Click(btn);
                    }
                });
                mesas[i][j]=btn;
                pnlMesas.add(btn);
            }
        }
    }
    private void Click(JButton btn) {
        System.out.println("Me has presionado");
    }
    private void agregarRadioButtons(){
        hambuerguesa=new JRadioButton("Hamburguesa Basica");
        hambuerguesa.setBounds(10,20,100,30);
        hambuerguesa.addChangeListener( this);
        ventana.add(hambuerguesa,BorderLayout.NORTH);
        agregarComponentes();    
    }

    
    public static void main(String[] args) {
        new vistaSalon();
    }

    

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
    }
    
}
