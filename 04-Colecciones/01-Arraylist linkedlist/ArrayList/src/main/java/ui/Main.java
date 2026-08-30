package ui;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Crear un ArrayList de tipo String
        ArrayList<String> lista = new ArrayList<>();

        // 1. AGREGAR ELEMENTOS
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Loro");
        System.out.println("Lista inicial: " + lista);

        // 2. AGREGAR AL PRINCIPIO Y AL FINAL
        lista.add(0, "Pez");               // equivalente a addFirst
        lista.add(lista.size(), "Conejo");       // equivalente a addLast
        System.out.println("Después de agregar: " + lista);

        // 3. CONSULTAR PRIMER Y ÚLTIMO ELEMENTO
        System.out.println("Primer animal: " + lista.get(0));
        System.out.println("Último animal: " + lista.get(lista.size() - 1));

        // 4. ELIMINAR PRIMER Y ÚLTIMO ELEMENTO
        lista.remove(0);                            // equivalente a removeFirst
        lista.remove(lista.size() - 1);             // equivalente a removeLast
        System.out.println("Después de eliminar extremos: " + lista);

        // 5. AGREGAR EN UNA POSICIÓN ESPECÍFICA
        lista.add(1, "Hamster");
        System.out.println("Después de agregar Hamster: " + lista);

        // 6. BUSCAR UN ELEMENTO
        if (lista.contains("Gato")) {
            System.out.println("El Gato está en la lista.");
        }

        // 7. OBTENER LA POSICIÓN DE UN ELEMENTO
        int posicion = lista.indexOf("Loro");
        System.out.println("El Loro está en la posición: " + posicion);

        // 8. MODIFICAR UN ELEMENTO
        lista.set(0, "Tortuga");
        System.out.println("Después de modificar: " + lista);

        // 9. ELIMINAR UN ELEMENTO ESPECÍFICO
        lista.remove("Gato");
        System.out.println("Después de eliminar Gato: " + lista);

        // 10. SABER CUÁNTOS ELEMENTOS HAY
        System.out.println("Cantidad de animales: " + lista.size());

        // 11. RECORRER LA LISTA
        System.out.println("\nAnimales:");
        for (String animal : lista) {
            System.out.println("- " + animal);
        }
    }
}