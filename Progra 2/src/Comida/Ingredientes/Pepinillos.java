package Comida.Ingredientes;

import Comida.Hamburguesa.*;
import Comida.Precios;

public class Pepinillos extends IngredienteDecorador{

    public Pepinillos(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Pepinillos";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_PEPINILLOS;
    } 
}