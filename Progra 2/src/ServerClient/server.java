package ServerClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import ModelSalon.Mesas;
import ModelSalon.salon;
import ViewSalon.vistaSalon;
import Orden.Orden;

public class server implements Runnable{
    /*
     * servidor para realizar conexión con la simulación
     */
    private Orden orden;
    private salon salon;
    private vistaSalon view;

    private Socket client; // simulacion
    private ServerSocket server; //salon
    private ObjectInputStream input; // recibe la orden

    public server(salon salon, vistaSalon view){
        Thread hiloSalon = new Thread(this);
        this.salon= salon;
        this.view = view;
        hiloSalon.start();
    }

    private Mesas buscarMesa(){
        return salon.obtenerMesaLibre();
    }

    @Override
    public void run() {
        try{
            server = new ServerSocket(9999);
            while (true){
                client = server.accept();
                input = new ObjectInputStream(client.getInputStream());
                orden = (Orden)input.readObject();
                Mesas mesa = buscarMesa();
                if (mesa!= null){
                    int[] posicionMesa = mesa.getPosicion();
                    salon.agregarOrden(posicionMesa[0], posicionMesa[1], orden);
                    int numM = mesa.getId_mesa();
                    salon.agregarOrden(posicionMesa[0], posicionMesa[1], orden);
                    view.model.addRow(new Object[]{"Mesa "+(numM+1), orden.obtenerOrden(), "En espera"});
                    ClienteCocina clienteCocina = new ClienteCocina(new Object[]{numM, orden}, 1234);// conexión al servidor de la cocina
                }else{
                    String mens = "No hay mesas disponibles en el salón.";
                    JOptionPane.showMessageDialog(null, mens, "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                input.close();
            }
        }
        catch (Exception e){
            System.out.println("error " + e);
        }
    }

}
