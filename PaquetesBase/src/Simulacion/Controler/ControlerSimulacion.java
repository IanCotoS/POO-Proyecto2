package Simulacion.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulacion.View.*;
import Simulacion.Model.*;
import com.Orden.*;

public class ControlerSimulacion extends Thread{
    
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
        System.out.println(estado);
        view.mostrarEstadoHilo(estado);
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (model.getEstado()){
                try {
                    Thread.sleep(Constantes.ESPERA_ORDEN_MILISEGUNDOS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                enviarOrden();
            }
        }
    }
}

