package ServerClient;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteCocina {
    /*
     * Cliente que envia el numero de mesa a la cocina o el salon
     * caso cliente cocina - servidor salon utiliza puerto 5555
     * caso cliente salon - servidor cocina utiliza puerto 1234
     */
    private Socket client;// cocina
    private ObjectOutputStream output;
    private int mensaje;
    private int port;
    

    public ClienteCocina(int datos, int puerto){
        this.mensaje = datos;
        this.port = puerto;
        conectar();
    }

    public void conectar(){
        try{
            client = new Socket("localhost", port);
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(mensaje);
            //output.close();
            //client.close();
        }
        catch(Exception e){
            System.out.println("ClienteCocina "+ e);
        }
    }
}
