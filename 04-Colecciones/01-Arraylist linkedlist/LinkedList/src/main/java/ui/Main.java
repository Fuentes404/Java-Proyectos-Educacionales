import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // Crear una LinkedList de tipo String
        LinkedList<String> lista = new LinkedList<>();

        // 1. AGREGAR ELEMENTOS
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Loro");
        System.out.println("Lista inicial: " + lista);

        // 2. AGREGAR AL PRINCIPIO Y AL FINAL
        lista.addFirst("Pez");
        lista.addLast("Conejo");
        System.out.println("Después de agregar: " + lista);

        // 3. CONSULTAR PRIMER Y ÚLTIMO ELEMENTO
        System.out.println("Primer animal: " + lista.getFirst());
        System.out.println("Último animal: " + lista.getLast());

        // 4. ELIMINAR PRIMER Y ÚLTIMO ELEMENTO
        lista.removeFirst();
        lista.removeLast();
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