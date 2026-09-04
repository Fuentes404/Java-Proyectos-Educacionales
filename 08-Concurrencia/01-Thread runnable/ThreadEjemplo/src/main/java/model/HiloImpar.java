package model;

// Heredamos de Thread:
// esta clase ES un hilo, no solo usa uno
// Por ende cada clase que herede sera un hilo
// no existe la herencia multiple
public class HiloImpar extends Thread {

    // Constructor ( con los elementos que hereda en este caso nombre del hilo )
    public HiloImpar(String nombre) {
        super(nombre);
    }

    // Código que correrá "al mismo tiempo" que el run() de HiloPar
    @Override
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(getName() + " -> " + i);

            try {
                // Cada hilo tiene su propio sleep, independiente del otro hilo
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(getName() + " fue interrumpido.");
            }
        }
        System.out.println(getName() + " ha finalizado.");
    }
}