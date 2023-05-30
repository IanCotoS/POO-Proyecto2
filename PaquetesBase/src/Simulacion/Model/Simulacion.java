package Simulacion.Model;

import com.Orden.*;

public class Simulacion{
    
    private FactoryOrden creaOrdenes;
    private boolean activo;

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
}
