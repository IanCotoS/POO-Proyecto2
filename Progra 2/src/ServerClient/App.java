package ServerClient;

import java.io.ObjectOutputStream;
import java.net.Socket;

import Comida.Hamburguesa.*;
import Comida.Ingredientes.*;
import ControlerSalon.controlerSalon;
import Orden.Orden;

public class App {
    public static void main(String[] args) throws Exception{
        controlerSalon controler = new controlerSalon();
        server server = new server(controler.modelSalon);
        Socket client;
        ObjectOutputStream output;

        Hamburguesa hamburguesaConTodo = new Jalapeno(new Tocino(new Queso(new Pepinillos(new Ketchup(new Mayonesa(
            new HuevoFrito(new Cebolla(new Aguacate(new Tomate(new Lechuga(new HamburguesaBase())))))))))));
        System.out.println("\nHamburguesa Completa:");
        System.out.println("Descripción: " + hamburguesaConTodo.getDescripcion());
        System.out.println("Precio: " + hamburguesaConTodo.getPrecio());

        Orden orden1 = new Orden();
        orden1.agregarHamburguesa(hamburguesaConTodo);

        try{
            client = new Socket("localhost", 5555);
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(orden1);
            output.flush();
            output.close();
            //client.close();
        }
        catch(Exception e){
            System.out.println("hay algo "+e);
        }
    }
}
