package ui;

import model.HiloPar;
import model.HiloImpar;

public class Main {
    public static void main(String[] args) {

        // Se crea la instancia
        HiloPar hiloPares = new HiloPar("Hilo-Pares");
        HiloImpar hiloImpares = new HiloImpar("Hilo-Impares");

        // cada start() ejecuta el run() correspondiente en paralelo
        hiloPares.start();
        hiloImpares.start();

        try {
            // join() SÍ bloquea: main se detiene aquí hasta que hiloPares termine su run()
            hiloPares.join();

            // Luego espera a que hiloImpares también termine
            hiloImpares.join();
        } catch (InterruptedException e) {
            // join() también puede ser interrumpido, por eso es checked exception
            System.out.println("main fue interrumpido mientras esperaba a los hilos.");
        }

        // Este print solo se ejecuta cuando AMBOS hilos ya terminaron
        System.out.println("main -> ambos hilos han finalizado, fin del programa.");
    }
}