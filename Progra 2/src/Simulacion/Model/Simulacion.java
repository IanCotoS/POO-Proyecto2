package Simulacion.Model;

import Orden.*;
import ServerClient.*;

public class Simulacion{
    
    private FactoryOrden creaOrdenes;
    private boolean activo;
    private ClienteSimulacion cliente;

    public Simulacion(){
        creaOrdenes = new FactoryOrden();
        activo = true;
    }

    public Orden crearOrden(){
        return creaOrdenes.crearOrden();
    }

    public void setEstado(boolean estado){
        activo = estado;
    }

    public boolean getEstado(){
        return activo;
    }

    public void enviarOrden(Orden newOrden){
        cliente.conectar(newOrden);
    }
}
