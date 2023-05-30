package Simulacion.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulacion.View.*;
import Simulacion.Model.*;
import com.Orden.*;

public class ControlerSimulacion{
    
    public ViewSimulacion view;
    public Simulacion model;

    public ControlerSimulacion(){
        view = new ViewSimulacion();
        model = new Simulacion();
        view.botonEnviar.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarOrden();
        }});
        view.botonEncender.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarEstadoHilo();
        }});
    }
    

    public void enviarOrden(){
        Orden newOrden = model.crearOrden();
        System.out.println(newOrden.toString());
        // Enviar orden
        view.mostrarOrdenEnviada();
    }

    public void cambiarEstadoHilo(){
        boolean estado = !model.getEstado();
        model.setEstado(estado);
        view.mostrarEstadoHilo(estado);
    }
}

