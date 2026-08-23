package main;

import service.GestorPersonas;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scanner para leer lo que el usuario escribe por consola
        Scanner sc = new Scanner(System.in);

        // Gestor encargado de crear y almacenar las personas (estudiantes/profesores)
        GestorPersonas gestor = new GestorPersonas();

        int opcion;

        // Bucle principal del menú: se repite hasta que el usuario elija salir (0)
        do {
            System.out.println("\n------ MENÚ ------");
            System.out.println("1. Crear Estudiante");
            System.out.println("2. Crear Profesor");
            System.out.println("3. Mostrar todas las personas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Ejecuta el metodo crear Estudiante
                    crearEstudiante(sc, gestor);
                    break;

                case 2:
                    // Ejecuta el metodo crar Prfesor
                    crearProfesor(sc, gestor);
                    break;

                case 3:
                    // Muestra en consola todas las personas registradas hasta el momento
                    gestor.mostrarTodas();
                    break;

                case 0:
                    // Termina el programa
                    System.out.println("Saliendo...");
                    break;

                default:
                    // Si el usuario ingresa un número que no está en el menú
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        // Se cierra el Scanner al finalizar el programa
        sc.close();
    }

    // Metodo que crea el registro de un estudiante mediante el gestor
    private static void crearEstudiante(Scanner sc, GestorPersonas gestor) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.print("Grado: ");
        String grado = sc.nextLine();

        // Se delega la creación al gestor
        gestor.crearEstudiante(nombre, edad, grado);
        System.out.println("Estudiante creado con éxito.");
    }

    // Metodo que crea el registro de un profesor mediante el gestor
    private static void crearProfesor(Scanner sc, GestorPersonas gestor) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.print("Asignatura: ");
        String asignatura = sc.nextLine();

        gestor.crearProfesor(nombre, edad, asignatura);
        System.out.println("Profesor creado con éxito.");
    }
}