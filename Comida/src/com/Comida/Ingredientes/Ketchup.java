package com.Comida.Ingredientes;

import com.Comida.Hamburguesa.*;
import com.Comida.Precios;

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
