package ModelSalon;


import Orden.Orden;

public class Mesas {
    private int id_mesa;
    private boolean estado; // true: ocupado
    private Orden pedido;
    private int fila,colunma; 
    
    public Mesas(int id_mesa, int x, int j) {
        this.id_mesa = id_mesa;
        this.fila = x;
        this.colunma = j;
        this.estado = false;
    }

    public String infoPedido(){
        return pedido.getDescripcion();
    }

    public double pagarCuenta(){
        setEstado(false);
        return pedido.getPrecio();
    }
    
    public void cambiarEstadoOrden(){
        pedido.estaListo();
    }
    
    //Getters and setters
    public String getInfo(){
        return "Mesa: " + (id_mesa+1) + infoPedido();
    }
    
    public int getId_mesa() {
        return id_mesa;
    }

    public void agregarOrden(Orden orden) {
        this.pedido = orden;
        this.estado = true;
    }

    public Orden getOrden() {
        return pedido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {//desocupar mesa
        this.estado = estado;
    }

    public int[] getPosicion() {
        return new int[]{fila, colunma};
    }
    
}
