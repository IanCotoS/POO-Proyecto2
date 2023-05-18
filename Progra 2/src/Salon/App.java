import Comida.Hamburguesa.*;
import Comida.Ingredientes.*;
import ModelSalon.*;
import Orden.Orden;

public class App {
    public static void main(String[] args) throws Exception{
        Hamburguesa hamburguesaBase = new HamburguesaBase();
        System.out.println("Hamburguesa Base:");
        System.out.println("Descripción: " + hamburguesaBase.getDescripcion());
        System.out.println("Precio: " + hamburguesaBase.getPrecio());

        Hamburguesa hamburguesaTomate = new Tomate(new HamburguesaBase());
        System.out.println("\nHamburguesa Tomate:");
        System.out.println("Descripción: " + hamburguesaTomate.getDescripcion());
        System.out.println("Precio: " + hamburguesaTomate.getPrecio());

        Orden orden1 = new Orden();
        orden1.agregarHamburguesa(hamburguesaBase);
        orden1.agregarHamburguesa(hamburguesaTomate);

        Salon s = new Salon();
        Mesas mesa = s.obtenerMesaLibre();
        s.agregarOrden(mesa.getId_mesa(), orden1);
        System.out.println("\nOrden agregada a la mesa");
        System.out.println(s.obtenerInfoMesa(mesa.getId_mesa()));

        System.out.println("Mesa ocupada: " + s.obtenerMesaOcupada());
        System.out.println("Debes pagar: " + s.obtenerCuenta(mesa.getId_mesa()));
        System.out.println("\nOrden pagada de la mesa");
        System.out.println(s.obtenerInfoMesa(mesa.getId_mesa()));
    }
}
