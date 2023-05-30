package Cocina;

import Cocina.ControlerCocina.ControladorCocina;
import ServerClient.ServerCocina;

public class App {
    public static void main(String[] args) throws Exception{
        //cocina
        ControladorCocina controlador = new ControladorCocina();
        ServerCocina servidorCocina = new ServerCocina(controlador);
    }
}
