package ServerClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Cocina.ControlerCocina.ControladorCocina;
import Orden.Orden;

public class ServerCocina implements Runnable {
    private ControladorCocina controladorCocina;
    private Object[] datosOrden;

    Socket client; //salon
    ServerSocket server; //cocina
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
                datosOrden = (Object[]) input.readObject();  //[Num mesa, Orden]
                controladorCocina.cocina.agregarOrden(datosOrden);
                Orden orden = (Orden)datosOrden[1];
                controladorCocina.vistaCocina.model.addRow(new Object[]{"Mesa "+(((int)datosOrden[0])+1),orden.obtenerOrden(), "En espera"});
                //input.close();
                //client.close();
            }
        }
        catch (Exception e){
            System.out.println("ServerCocina " + e);
        }
    }
}
