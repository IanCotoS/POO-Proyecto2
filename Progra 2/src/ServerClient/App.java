package ServerClient;

import Cocina.ControlerCocina.ControladorCocina;
import ControlerSalon.controlerSalon;
import Simulacion.Controler.ControlerSimulacion;

public class App {
    public static void main(String[] args) throws Exception{

        // Simulacion
        ControlerSimulacion simulacion = new ControlerSimulacion();
        simulacion.start();

        // salon
        controlerSalon controler = new controlerSalon();
        ServerSalon servidorSalon = new ServerSalon(controler); // servidor para recibir ordenes listas de la cocina
        server servidoServer = new server(controler.modelSalon);

        //cocina
        ControladorCocina controlador = new ControladorCocina();
        ServerCocina servidorCocina = new ServerCocina(controlador);
        
    }
}
