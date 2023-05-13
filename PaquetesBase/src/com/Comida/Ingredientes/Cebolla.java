package com.Comida.Ingredientes;

import com.Comida.Hamburguesa.*;
import com.Comida.Precios;

public class Cebolla extends IngredienteDecorador{

    public Cebolla(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Cebolla";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_CEBOLLA;
    } 
}