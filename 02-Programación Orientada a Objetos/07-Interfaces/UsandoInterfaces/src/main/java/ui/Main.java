package ui;

import model.Profesor;
import model.Matematicas;
import model.Historia;
import model.Ubicable;
import model.Colegio;
import model.Gimnasio;

public class Main {
    public static void main(String[] args) {

        // Instanciar los profesores (Matematicas, Historia)
        Profesor[] profesores = new Profesor[4];

        profesores[0] = new Matematicas("Andrea Reyes", 35, "Algebra");
        profesores[1] = new Matematicas("Felipe Soto", 40, "Geometria");
        profesores[2] = new Historia("Camila Vidal", 29, "Edad Media");
        profesores[3] = new Historia("Diego Herrera", 47, "Revolucion Industrial");

        // Mostrar Profesores de Matematicas
        System.out.println("=== PROFESORES DE MATEMATICAS ===");
        for (Profesor p : profesores) {
            if (p instanceof Matematicas) {
                p.mostrarInfo();
            }
        }

        // Mostrar Profesores de Historia
        System.out.println("\n=== PROFESORES DE HISTORIA ===");
        for (Profesor p : profesores) {
            if (p instanceof Historia) {
                p.mostrarInfo();
            }
        }

        // Instanciar los lugares (Colegio, Gimnasio)
        Ubicable[] lugares = new Ubicable[2];

        lugares[0] = new Colegio("Colegio San Martin", "Av. Siempre Viva 123");
        lugares[1] = new Gimnasio("Gimnasio PowerFit", "Calle Los Robles 456");

        // Mostrar Lugares
        System.out.println("\n=== LUGARES ===");
        for (Ubicable u : lugares) {
            u.mostrarInfo();
        }
    }
}