package com.Orden;

// Imports
import java.util.ArrayList;
import com.Comida.Hamburguesa.*;

public class Orden {
    
    // Atributos
    ArrayList<Hamburguesa> hamburguesas;
    boolean listo;

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

    public int getPrecio() {
        int precio = 0;
        for (Hamburguesa hamburguesa : hamburguesas) {
            precio += hamburguesa.getPrecio();
        }
        return precio;
    }

    public String getDescripcion() {
        String descripcion = "Hambuguesas:";
        int cont = 1;
        for (Hamburguesa hamburguesa : hamburguesas) {
            descripcion += "\n" + cont + ". " + hamburguesa.getDescripcion();
            cont++;
        }
        return descripcion;
    }

    // Setters
    public void agregarHamburguesa(Hamburguesa newHamburguesa) {
        this.hamburguesas.add(newHamburguesa);
    }

    public void estaListo() {
        this.listo = true;
    }
} // Fin clase Orden
