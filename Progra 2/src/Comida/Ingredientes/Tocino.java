package Comida.Ingredientes;

import Comida.Hamburguesa.*;
import Comida.Precios;

public class Tocino extends IngredienteDecorador{

    public Tocino(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Tocino";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_TOCINO;
    }
}
