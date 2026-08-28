package ui;

import java.util.Scanner;
import services.GestorEstudiantes;

public class Main {
    public static void main(String[] args) {

        // Scanner para leer la informacion ingresada a la consola
        Scanner sc = new Scanner(System.in);

        // Gestor de Estudiantes
        GestorEstudiantes gestor = new GestorEstudiantes();

        // Menu
        // Bucle Principal
        int opcion;
        do {
            System.out.println("----- Menu Registro de Estudiantes -----");
            System.out.println("1. Crear Registro Estudiante");
            System.out.println("2. Eliminar Registro de Estudiante");
            System.out.println("3. Ver registro de Estudiantes");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opcion valida: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(sc.nextLine());

                    System.out.print("Curso: ");
                    String curso = sc.nextLine();

                    System.out.print("Colegio: ");
                    String colegio = sc.nextLine();

                    gestor.crearEstudiante(nombre, edad, curso, colegio);
                    break;
                }

                case 2: {
                    System.out.print("Ingrese el nombre del estudiante a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    gestor.eliminarEstudiante(nombreEliminar);
                    break;
                }

                case 3: {
                    gestor.verEstudiantes();
                    break;
                }

                case 0: {
                    System.out.println("Saliendo del sistema...");
                    break;
                }

                default:
                    System.out.println("Opcion Invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}