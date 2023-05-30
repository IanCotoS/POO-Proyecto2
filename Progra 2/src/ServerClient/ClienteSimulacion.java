package ServerClient;

import java.net.*;
import java.io.*;

import Orden.*;

public class ClienteSimulacion {

    private Socket client;
    private ObjectOutputStream output;

    public ClienteSimulacion(){
    }

    public void conectar(Orden newOrden){
        System.out.println(newOrden);
        try {
            client = new Socket("localhost", 9999);
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(newOrden);
            output.flush(); // Se envía
            output.close();
            client.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}