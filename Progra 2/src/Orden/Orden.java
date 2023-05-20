package Orden;

import java.io.Serializable;
// Imports
import java.util.ArrayList;
import Comida.Hamburguesa.*;

public class Orden implements Serializable{
    
    // Atributos
    public ArrayList<Hamburguesa> hamburguesas;
    private boolean listo;
    private double precio;

    // Constructor
    public Orden() {
        this.hamburguesas = new ArrayList<Hamburguesa>();
        this.listo = false;
    }

    // Getters
    public ArrayList<Hamburguesa> getHamburguesas() {
        return hamburguesas;
    }

    public boolean getListo() {
        return listo;
    }

    public String getDescripcion() {
        String descripcion = "      Está listo: " + getListo() + 
        "\nHambuguesas: (" + hamburguesas.size() + " pedidos en total)";
        int cont = 1;
        for (Hamburguesa hamburguesa : hamburguesas) {
            descripcion += "\n" + cont + ". " + hamburguesa.getDescripcion() + "\n     Precio: " + hamburguesa.getPrecio();
            cont++;
        }
        descripcion += "\nPrecio total: " + getPrecio();
        return descripcion;
    }

    public String obtenerOrden(){
        String descripcion = "";
        for (Hamburguesa hamburguesa : hamburguesas) {
            descripcion += "Hamburguesa "+hamburguesa.getDescripcion() + ",\n";
        }
        return descripcion.substring(0, descripcion.length() - 2)+".\n Precio: "+getPrecio();
    }
    public double getPrecio() {
        return precio;
    }

    // Setters
    public void estaListo() {
        this.listo = true;
    }

    public void calcularPrecio(Hamburguesa newHamburguesa) {
        this.precio = newHamburguesa.getPrecio();
    }

    public void agregarCosto(Hamburguesa newHamburguesa) {
        this.precio += newHamburguesa.getPrecio();
    }

    public void agregarHamburguesa(Hamburguesa newHamburguesa) {
        this.hamburguesas.add(newHamburguesa);
        agregarCosto(newHamburguesa);
    }

} // Fin clase Orden
