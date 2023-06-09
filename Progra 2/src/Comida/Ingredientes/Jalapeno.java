package Comida.Ingredientes;

import Comida.Precios;
import Comida.Hamburguesa.*;

public class Jalapeno extends IngredienteDecorador{

    public Jalapeno(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Jalapeño";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_JALAPENO;
    } 
}