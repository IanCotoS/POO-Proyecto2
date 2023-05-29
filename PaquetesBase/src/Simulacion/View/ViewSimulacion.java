package Simulacion.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;

public class ViewSimulacion extends Thread{

    JFrame frame;
    JButton butonEnviar;
    JButton botonEncender;
    JPanel panel;

    public ViewSimulacion(){
        frame = new JFrame("Simulacion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        butonEnviar = new JButton("Enviar orden");

        botonEncender = new JButton("Encender hilo envio");

        panel = new JPanel(new BorderLayout());
        panel.add(butonEnviar, BorderLayout.WEST);
        panel.add(botonEncender, BorderLayout.EAST);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}