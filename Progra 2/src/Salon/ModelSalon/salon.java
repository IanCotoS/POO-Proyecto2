package ModelSalon;
import java.util.ArrayList;

import Orden.Orden;

public class Salon {
    ArrayList<Mesas> mesas;

    public Salon() {
        this.mesas = FactoryMesas.getMesas();
    }

    public void agregarOrden(int id_mesa, Orden orden){
        this.mesas.get(id_mesa).agregarOrden(orden);
    }

    public double obtenerCuenta(int id_mesa){
        return this.mesas.get(id_mesa).pagarCuenta();
    }

    public String obtenerInfoMesa(int id_mesa){
        return this.mesas.get(id_mesa).getInfo();
    }
    public String obtenerInfoOrden(int id_mesa){
        return "Mesa "+ (id_mesa+1)+"\n"+this.mesas.get(id_mesa).getOrden().obtenerOrden();
    }
    public Mesas obtenerMesaLibre(){
        for (Mesas m: mesas){
            if (!m.isEstado()){
                return m;
            }
        }
        return null;
    }

    public int obtenerMesaOcupada(){
        for (Mesas m: mesas){
            if (m.isEstado()){
                return m.getId_mesa();
            }
        }
        return -1;
    }
    
}
