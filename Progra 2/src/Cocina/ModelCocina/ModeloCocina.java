package Cocina.ModelCocina;

import java.util.ArrayList;

import Orden.Orden;

public class ModeloCocina {
    public ArrayList<Object[]> ordenes;
    // [numero mesa, orden] 

    public ModeloCocina() {
        this.ordenes = new ArrayList<Object[]>();
    }

    public void eliminarOrden(int arr){
       ordenes.remove(ordenes.get(arr));
    }
    
    public void agregarOrden(Object[] arr){
        ordenes.add(arr);
    }

    public int obtenerMesa(int id){
        return (int)ordenes.get(id)[0];
    }
}
