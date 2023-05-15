package Comida.Hamburguesa;

import Comida.Ingredientes.*;

public class BurguerMaker { // Como el app del paquete
    public static void main(String[] args) throws Exception {
        
        // Prueba decorator
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
    }   
}
