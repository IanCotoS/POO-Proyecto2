package ModelSalon;
import Orden.Orden;

public class Salon {
    private Mesas[][] mesas;

    public Salon() {
        this.mesas = FactoryMesas.getMesas();
    }

    public void agregarOrden(int fila, int colunma, Orden orden){
        this.mesas[fila][colunma].agregarOrden(orden);
    }

    public double obtenerCuenta(int fila, int colunma){
        return this.mesas[fila][colunma].pagarCuenta();
    }

    public String obtenerInfoMesa(int fila, int colunma){
        return this.mesas[fila][colunma].getInfo();
    }
    
    public String obtenerInfoOrden(int fila, int colunma){
        return "Mesa "+ (mesas[fila][colunma].getId_mesa()+1)+"\n"+this.mesas[fila][colunma].getOrden().obtenerOrden();
    }
    
    public Mesas obtenerMesaLibre(){
        for (Mesas[] fila: mesas){
            for (Mesas m : fila){
                if (!m.isEstado()){
                    return m;
                }
            }
        }
        return null;
    }

    public boolean estadoMesa(int fila, int colunma){
        return this.mesas[fila][colunma].isEstado();
    }

    public void cambiarEstadOrden(int id){
        int[] m = obtenerMesa(id);
        if (m != null){
            this.mesas[m[0]][m[1]].cambiarEstadoOrden();
        }
    }

    public int[] obtenerMesa(int id_mesa){
        for (Mesas[] fila: mesas){
            for (Mesas m : fila){
                if (m.getId_mesa() == id_mesa){
                    return m.getPosicion();
                }
            }
        }
        return null;
    }

    public boolean estadoOrden(int fila, int col){
        return this.mesas[fila][col].getOrden().getListo();
    }
    
}
