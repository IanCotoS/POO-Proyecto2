package Comida.Ingredientes;

import Comida.Hamburguesa.*;
import Comida.Precios;

public class Ketchup extends IngredienteDecorador{

    public Ketchup(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Ketchup";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_KETCHUP;
    }
}
