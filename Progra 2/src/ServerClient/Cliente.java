package ServerClient;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    Socket client;// cocina
    ObjectOutputStream output;
    

    public Cliente(){
        conectar();
    }

    public void conectar(){
        
        try{
            client = new Socket("127.0.0.1", 5555);
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject();
            output.flush();
            output.close();
            //client.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
