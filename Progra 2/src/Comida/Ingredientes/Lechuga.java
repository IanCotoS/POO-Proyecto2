package Comida.Ingredientes;

import Comida.Hamburguesa.*;
import Comida.Precios;

public class Lechuga extends IngredienteDecorador{

    public Lechuga(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Lechuga";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_LECHUGA;
    }
}
