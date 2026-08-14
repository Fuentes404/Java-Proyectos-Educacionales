package ui;

import model.*;

public class Main {
    public static void main(String[] args) {
        // Instancias
        Persona p1 = new Persona("Paula Vidal", 25, 8749);
        Persona p2 = new Persona("Cris medel", 40, 1524);
        Persona p3 = new Bibliotecario("Camilo Perez", 32, 4878);
        Persona p4 = new Estudiante("Siza Gudo", 15, 8985, "Liceo Bicentenario", "1° Medio");
        Persona p5 = new Adulto("Gino Valo", 35, 8585, "Trabajador Independiente");
        Persona p6 = new AdultoMayor("lila Fuentes", 65, 9835, "Pensionada");

        // Array que contiene las personas registradas en sistema
        Persona[] personas = { p1,p2,p3,p4,p5,p6 };

        // Separador
        System.out.println("");
        System.out.println("-------------------------");

        // Recorrer el sistema para mostar su informacion
        for (Persona p : personas) {
            p.mostrarInfo();
            System.out.println("-------------------------");
        }
    }
}