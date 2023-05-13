package com.Comida.Ingredientes;

import com.Comida.Precios;
import com.Comida.Hamburguesa.*;

public class Jalapeno extends IngredienteDecorador{

    public Jalapeno(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Jalapeno";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_JALAPENO;
    } 
}