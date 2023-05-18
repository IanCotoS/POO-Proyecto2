package ServerClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Cocina.ControlerCocina.ControladorCocina;

public class ServerCocina implements Runnable {
    private int mesa;
    private ControladorCocina controladorCocina;

    Socket client; // simulacion
    ServerSocket server; //salon
    ObjectInputStream input; // recibe la orden 

    public ServerCocina(ControladorCocina cookCocina){
        Thread hiloSalon = new Thread(this);
        this.controladorCocina = cookCocina;
        hiloSalon.start();

    }

    @Override
    public void run() {
        try{
            server = new ServerSocket(1234);
            while (true){
                client = server.accept();
                input = new ObjectInputStream(client.getInputStream());
                mesa = (int) input.readObject();
                controladorCocina.cocina.agregarOrden(new int[]{mesa, 0});
                controladorCocina.vistaCocina.model.addRow(new Object[]{"Mesa "+(mesa+1), "En espera"});
                //input.close();
                //client.close();
            }
        }
        catch (Exception e){
            System.out.println("ServerCocina " + e);
        }
    }
}
