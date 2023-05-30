package Simulacion.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulacion.View.*;
import Simulacion.Model.*;
import Orden.*;

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
        model.enviarOrden(newOrden);
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
                int cont = 0;
                while (cont < 10 && model.getEstado()){
                    try {
                        Thread.sleep(Constantes.ESPERA_ORDEN_MILISEGUNDOS/10);
                        cont++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (cont >= 10){
                    enviarOrden();
                }
            }
        }
    }
}

