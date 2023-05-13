package com.Comida.Ingredientes;

import com.Comida.Hamburguesa.*;
import com.Comida.Precios;

public class Tomate extends IngredienteDecorador{

    public Tomate(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Tomate";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_TOMATE;
    }
}