package Simulacion.Model;

import com.Orden.*;

public class Simulacion{
    
    FactoryOrden creaOrdenes;

    public Simulacion(){
        creaOrdenes = new FactoryOrden();
    }

    Orden crearOrden(){
        return creaOrdenes.crearOrden();
    }

}
