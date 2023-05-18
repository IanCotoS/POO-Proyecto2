package ServerClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import ModelSalon.Mesas;
import ModelSalon.Salon;
import Orden.Orden;

public class server implements Runnable{
    /*
     * servidor para realizar conexión con la simulación
     */
    private Orden orden;
    private Salon s;

    Socket client; // simulacion
    ServerSocket server; //salon
    ObjectInputStream input; // recibe la orden 

    public server(Salon salon){
        Thread hiloSalon = new Thread(this);
        this.s= salon;
        hiloSalon.start();

    }

    private Mesas buscarMesa(){
        return s.obtenerMesaLibre();
    }

    @Override
    public void run() {
        try{
            server = new ServerSocket(5555);
            client = server.accept();
            while (true){
                input = new ObjectInputStream(client.getInputStream());
                orden = (Orden)input.readObject();
                Mesas mesa = buscarMesa();
                if (mesa!= null){
                    s.agregarOrden(mesa.getId_mesa(), orden);
                }else{
                    String mens = "No hay mesas disponibles en el salón.";
                    JOptionPane.showMessageDialog(null, mens, "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                input.close();
                //client.close();
            }
        }
        catch (Exception e){
            System.out.println("error " + e);
        }
    }

}
