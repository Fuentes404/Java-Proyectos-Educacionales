package model;

// Heredamos de Thread:
// esta clase ES un hilo, no solo usa uno
// Por ende cada clase que herede sera un hilo
// no existe la herencia multiple
public class HiloPar extends Thread {

    // Constructor ( con los elementos que hereda en este caso nombre del hilo )
    public HiloPar(String nombre) {
        super(nombre);
    }

    // Metodo que Thread ejecuta automáticamente en un hilo nuevo cuando llamamos start()
    // Recordar que sobreescribe el metodo run() desde la clase Thread que es un hilo
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            // getName() viene heredado de Thread, devuelve el nombre asignado al hilo
            System.out.println(getName() + " -> " + i);

            try {
                // Pausa SOLO este hilo 400ms, sin bloquear los demás hilos del programa
                Thread.sleep(400);
            } catch (InterruptedException e) {
                // Excepción obligatoria: sleep() puede ser interrumpido por otro hilo
                System.out.println(getName() + " fue interrumpido.");
            }
        }
        System.out.println(getName() + " ha finalizado.");
    }
}