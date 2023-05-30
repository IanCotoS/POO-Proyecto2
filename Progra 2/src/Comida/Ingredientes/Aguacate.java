package Comida.Ingredientes;

import Comida.Hamburguesa.*;
import Comida.Precios;

public class Aguacate extends IngredienteDecorador{

    public Aguacate(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Aguacate";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_AGUACATE;
    } 
}
