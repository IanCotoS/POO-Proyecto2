package Simulacion.Model;

import Comida.Hamburguesa.*;
import Orden.*;
import java.util.Random;

public class FactoryOrden {
    
    FactoryHamburguesa factoryHamburguesa;
    Random rnd;

    public FactoryOrden() {
        this.factoryHamburguesa = new FactoryHamburguesa();
        this.rnd = new Random();
    }

    public Orden crearOrden() {
        Orden orden = new Orden();
        int numHamburguesas = rnd.nextInt(Constantes.CANTIDAD_HAMBURGUESAS_MAX) + 1;
        for (int cont = 0; cont < numHamburguesas; cont++) {
            Hamburguesa hamburguesa = factoryHamburguesa.crearHamburguesa();
            orden.agregarHamburguesa(hamburguesa);
        }
        return orden;
    }
}
