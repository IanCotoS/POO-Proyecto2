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
        controlerSalon controlerSalon = new controlerSalon();
        ServerSalon servidorSalon = new ServerSalon(controlerSalon); // servidor para recibir ordenes listas de la cocina
        server servidorSimulacionSalon = new server(controlerSalon.modelSalon, controlerSalon.view);

        //cocina
        ControladorCocina controlerCocina = new ControladorCocina();
        ServerCocina servidorCocina = new ServerCocina(controlerCocina);
        
    }
}
