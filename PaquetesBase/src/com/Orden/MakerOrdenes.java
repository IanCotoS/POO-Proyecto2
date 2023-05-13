package com.Orden;

import com.Comida.Hamburguesa.*;
import com.Comida.Ingredientes.*;

public class MakerOrdenes { // Como el app del paquete
    public static void main(String[] args) throws Exception {
        
        // Prueba Ordenes
        Hamburguesa hamburguesaBase = new HamburguesaBase();
        System.out.println("Hamburguesa Base:");
        System.out.println("Descripción: " + hamburguesaBase.getDescripcion());
        System.out.println("Precio: " + hamburguesaBase.getPrecio());

        Hamburguesa hamburguesaTomate = new Tomate(new HamburguesaBase());
        System.out.println("\nHamburguesa Tomate:");
        System.out.println("Descripción: " + hamburguesaTomate.getDescripcion());
        System.out.println("Precio: " + hamburguesaTomate.getPrecio());

        Hamburguesa hamburguesaLechuga = new Lechuga(new HamburguesaBase());
        System.out.println("\nHamburguesa Lechuga:");
        System.out.println("Descripción: " + hamburguesaLechuga.getDescripcion());
        System.out.println("Precio: " + hamburguesaLechuga.getPrecio());

        Hamburguesa hamburguesaLechugaTomate = new Tomate(new Lechuga(new HamburguesaBase()));
        System.out.println("\nHamburguesa Lechuga y Tomate:");
        System.out.println("Descripción: " + hamburguesaLechugaTomate.getDescripcion());
        System.out.println("Precio: " + hamburguesaLechugaTomate.getPrecio());

        Hamburguesa hamburguesaConTodo = new Jalapeno(new Tocino(new Queso(new Pepinillos(new Ketchup(new Mayonesa(
            new HuevoFrito(new Cebolla(new Aguacate(new Tomate(new Lechuga(new HamburguesaBase())))))))))));
        System.out.println("\nHamburguesa Completa:");
        System.out.println("Descripción: " + hamburguesaConTodo.getDescripcion());
        System.out.println("Precio: " + hamburguesaConTodo.getPrecio());

        Orden orden1 = new Orden();
        orden1.agregarHamburguesa(hamburguesaBase);
        orden1.agregarHamburguesa(hamburguesaTomate);
        orden1.agregarHamburguesa(hamburguesaLechuga);
        orden1.agregarHamburguesa(hamburguesaLechugaTomate);
        orden1.agregarHamburguesa(hamburguesaConTodo);
        orden1.estaListo();
        System.out.println("\nOrden Completa:");
        System.out.println("Está listo: " + orden1.getListo());
        System.out.println("Descripción: " + orden1.getDescripcion());
        System.out.println("Precio: " + orden1.getPrecio());
    }   
}
