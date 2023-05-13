package com.Comida.Ingredientes;

import com.Comida.Hamburguesa.*;

abstract class IngredienteDecorador implements Hamburguesa{

    protected Hamburguesa tempHamburguesa;

    public IngredienteDecorador(Hamburguesa newHamburguesa) {
        this.tempHamburguesa = newHamburguesa;
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion();
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio();
    }
    
}
