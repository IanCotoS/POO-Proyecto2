package com.Comida.Ingredientes;

import com.Comida.Hamburguesa.*;
import com.Comida.Precios;

public class Queso extends IngredienteDecorador{

    public Queso(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Queso";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_QUESO;
    }
}