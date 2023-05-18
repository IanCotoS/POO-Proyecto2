package Cocina.ModelCocina;

import java.util.ArrayList;

public class ModeloCocina {
    public ArrayList<int[]> ordenes;
    // [numero mesa, estado] : estado( true=1 , false=0)

    public ModeloCocina() {
    }

    private void eliminarOrden(int[] arr){
        ordenes.remove(arr);
    }
    
    public void agregarOrden(int[] arr){
        ordenes.add(arr);
    }
}
