package ServerClient;

import Cocina.ControlerCocina.ControladorCocina;
import ControlerSalon.controlerSalon;

public class App {
    public static void main(String[] args) throws Exception{
        // salon
        controlerSalon controler = new controlerSalon();
        ServerSalon servidorSalon = new ServerSalon(controler); // servidor para recibir ordenes listas de la cocina

        //cocina
        ControladorCocina controlador = new ControladorCocina();
        ServerCocina servidorCocina = new ServerCocina(controlador);
        
    }
}
