package Simulacion.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

public class ViewSimulacion extends Thread{

    public JFrame frame;
    public JButton botonEnviar;
    public JButton botonEncender;
    public JPanel panel;

    public ViewSimulacion(){
        frame = new JFrame("Simulacion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botonEnviar = new JButton("Enviar orden");

        botonEncender = new JButton("Detener hilo");

        panel = new JPanel(new BorderLayout());
        panel.add(botonEnviar, BorderLayout.WEST);
        panel.add(botonEncender, BorderLayout.EAST);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void mostrarHiloEncender(){
        botonEncender.setText("Detener hilo");
        JOptionPane.showMessageDialog(null, 
        "El hilo se ha reanudado", "Hilo", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarHiloApagado(){
        botonEncender.setText("Reanudar hilo");
        JOptionPane.showMessageDialog(null, 
        "El hilo se ha detenido", "Hilo", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarOrdenEnviada(){
        JOptionPane.showMessageDialog(null,
        "Orden enviada a salon", "Orden", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarEstadoHilo(boolean estado){
        if (estado){
            mostrarHiloEncender();
        }
        else{
            mostrarHiloApagado();
        }
    }
}