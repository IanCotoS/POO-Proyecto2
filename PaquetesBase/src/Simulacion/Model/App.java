package Simulacion.Model;

import com.Orden.*;

public class App {
    public static void main(String[] args) throws Exception {

        // Prueba FactoryHamburguesa
        // FactoryHamburguesa factoryHamburguesa = new FactoryHamburguesa();
        // Hamburguesa hamburguesaRnd = factoryHamburguesa.crearHamburguesa();
        // System.out.println(hamburguesaRnd.getDescripcion());

        // Prueba FactoryOrden
        FactoryOrden factoryOrden = new FactoryOrden();
        Orden orden = factoryOrden.crearOrden();
        System.out.println(orden.getDescripcion());
    }
}
