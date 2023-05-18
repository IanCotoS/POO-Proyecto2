package ServerClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ControlerSalon.controlerSalon;

public class ServerSalon implements Runnable{
    /*
     * servidor del salon para realizar conexión cocina
     * recibe las ordenes que estan listas
     */
    private int mesa; // numero de mesa
    private controlerSalon salon;
    Socket client; 
    ServerSocket server; 
    ObjectInputStream input; // recibe la orden 

    public ServerSalon(controlerSalon s){
        Thread hiloSalon = new Thread(this);
        this.salon = s;
        hiloSalon.start();

    }

    @Override
    public void run() {
        try{
            server = new ServerSocket(5555);
            System.out.println("Servidor en ejecución");
            while (true){
                client = server.accept();
                input = new ObjectInputStream(client.getInputStream());
                mesa = (int)input.readObject();
                int[] posicionMesa = salon.modelSalon.obtenerMesa(mesa);
                salon.modelSalon.cambiarEstadOrden(posicionMesa[0], posicionMesa[1]);//cambia el estado de la orden de la mesa
                Object[] data = obtenerDatosTabla(mesa); //datos de la fila donde esta la mesa
                data[2] = true; // estado de la orden
                salon.view.model.removeRow(mesa);
                salon.view.model.insertRow(mesa, data); //reemplazo la fila donde esta la orden que envio la cocina
                //input.close();
                //client.close();
            }
        }
        catch (Exception e){
            System.out.println("ServerSalon" + e);
        }
    }

    public Object[] obtenerDatosTabla(int m){
        int columnas = salon.view.facturar.getColumnCount();
        Object[] datosFila = new Object[columnas];
        if (m != -1) { // Verifica que se haya seleccionado una fila
            for (int columna = 0; columna < columnas; columna++) {
                datosFila[columna] = salon.view.facturar.getValueAt(m, columna);
            }
        }
        return datosFila;
    }
}
