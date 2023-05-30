package Simulacion.Model;

import Comida.Hamburguesa.*;
import Comida.Ingredientes.*;
import java.util.Random;

public class FactoryHamburguesa {

    boolean ingredientes[];
    Random rnd;
    
    public FactoryHamburguesa() {
        this.ingredientes = new boolean[Constantes.CANTIDAD_INGREDIENTES_MAX];
        this.rnd = new Random();
    }

    public void seleccionaIngredientes(){
        for (int cont = 0; cont < ingredientes.length; cont++) {
            ingredientes[cont] = rnd.nextBoolean();
        }
    }

    public Hamburguesa crearHamburguesa() {
        Hamburguesa hamburguesa = new HamburguesaBase();
        seleccionaIngredientes();
        if (ingredientes[0]) {
            hamburguesa = new Aguacate(hamburguesa);
        }
        if(ingredientes[1]) {
            hamburguesa = new Cebolla(hamburguesa);
        }
        if(ingredientes[2]) {
            hamburguesa = new HuevoFrito(hamburguesa);
        }
        if(ingredientes[3]) {
            hamburguesa = new Jalapeno(hamburguesa);
        }
        if(ingredientes[4]) {
            hamburguesa = new Ketchup(hamburguesa);
        }
        if(ingredientes[5]) {
            hamburguesa = new Lechuga(hamburguesa);
        }
        if(ingredientes[6]) {
            hamburguesa = new Mayonesa(hamburguesa);
        }
        if(ingredientes[7]) {
            hamburguesa = new Pepinillos(hamburguesa);
        }
        if(ingredientes[8]) {
            hamburguesa = new Queso(hamburguesa);
        }
        if(ingredientes[9]) {
            hamburguesa = new Tocino(hamburguesa);
        }
        if(ingredientes[10]) {
            hamburguesa = new Tomate(hamburguesa);
        }
        return hamburguesa;
    }
}
