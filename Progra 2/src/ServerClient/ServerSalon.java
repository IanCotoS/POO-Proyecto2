package ServerClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ControlerSalon.controlerSalon;

public class ServerSalon implements Runnable{
    /*
     * servidor del salon para realizar conexión con la cocina
     * recibe las ordenes que estan listas
     */
    private Object[] mesa; // numero de mesa
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
                mesa = (Object[])input.readObject(); // aca se recibe el numero de mesa que envia la cocina
                salon.modelSalon.cambiarEstadOrden((int)mesa[0]);//cambia el estado de la orden de la mesa
                int id_mesa = obtenerDatosTabla((int)mesa[0]); //nemero de la fila donde esta la mesa
                if (id_mesa!=-1){
                    salon.view.model.setValueAt("Entregada", id_mesa, 2);
                    salon.view.model.fireTableCellUpdated(id_mesa, 2);
                }
            }
        }
        catch (Exception e){
            System.out.println("ServerSalon" + e);
        }
    }

    /* 
     * si se envia el valor de la posicion0 de cada objeto de la lista de ordenes en 
     * la cocina, se puede cambiar el metodo a uno que busque en la primera columna 
     * el valor de cada fila que coincida con el valor que envia la cocina 
     */
    public int obtenerDatosTabla(int id){
        Pattern patron = Pattern.compile("\\d+");
        int filas = salon.view.facturar.getRowCount();
        for (int fila = 0; fila < filas; fila++) {
            String value = salon.view.facturar.getValueAt(fila, 0).toString();
            Matcher matcher= patron.matcher(value);
            if (matcher.find()) {
                int numero = Integer.parseInt(matcher.group());
                if((numero-1) == id){
                    return fila;
                }
            }
        }
        return -1;
    }
}
