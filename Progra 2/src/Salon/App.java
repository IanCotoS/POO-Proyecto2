import ControlerSalon.controlerSalon;
import ServerClient.ServerSalon;

public class App {
    public static void main(String[] args) throws Exception{
        // salon
        controlerSalon controler = new controlerSalon();
        ServerSalon servidorSalon = new ServerSalon(controler); // servidor para recibir ordenes listas de la cocina
    }
}
