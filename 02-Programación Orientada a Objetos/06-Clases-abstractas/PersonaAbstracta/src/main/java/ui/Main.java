package ui;

import model.Persona;
import model.Proveedor;
import model.Trabajador;
import model.Cliente;

public class Main {
    public static void main(String[] args) {

        // Instanciar las personas (Trabajador, Cliente, Proveedor)
        Persona[] personas = new Persona[6];

        personas[0] = new Trabajador("Juan Pérez", 30, "T001");
        personas[1] = new Trabajador("María López", 28, "T002");
        personas[2] = new Cliente("Carlos Soto", 45, "C001");
        personas[3] = new Cliente("Ana Muñoz", 33, "C002");
        personas[4] = new Proveedor("Pedro Ramírez", 50, "P001");
        personas[5] = new Proveedor("Laura Fuentes", 38, "P002");

        // Mostrar Trabajadores
        System.out.println("=== TRABAJADORES ===");
        for (Persona p : personas) {
            if (p instanceof Trabajador) {
                p.mostrarInfo();
            }
        }

        // Mostrar Clientes
        System.out.println("\n=== CLIENTES ===");
        for (Persona p : personas) {
            if (p instanceof Cliente) {
                p.mostrarInfo();
            }
        }

        // Mostrar Proveedores
        System.out.println("\n=== PROVEEDORES ===");
        for (Persona p : personas) {
            if (p instanceof Proveedor) {
                p.mostrarInfo();
            }
        }
    }
}