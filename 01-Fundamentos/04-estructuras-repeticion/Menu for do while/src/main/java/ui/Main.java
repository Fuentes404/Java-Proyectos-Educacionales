package ui;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // Atributos
        int opcion;
        int[] numeros = {10, 20, 30, 40, 50};

        // do- while : Ejecuta almenos una vez para el menu por consola
        do {
            System.out.println("---- Menu interactivo ----");
            System.out.println("");
            System.out.println("1 - Tabla de multiplicar ( USO DE FOR ) ");
            System.out.println("2 - Adivina el numero ( USO DE WHILE ) ");
            System.out.println("3 - Mostrar Array ( USO DE FOR EACH ) ");
            System.out.println("4 - Salir");
            System.out.println("Elige una opcion : ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Sabemos exactamente cuántas veces repetir (1 a 10) -> FOR
                    System.out.print("Ingresa un número: ");
                    int n = sc.nextInt();
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(n + " x " + i + " = " + (n * i));
                    }
                    break;

                case 2:
                    // No sabemos cuántos intentos hará el usuario -> WHILE
                    int secreto = 7;
                    int intento = -1;
                    while (intento != secreto) {
                        System.out.print("Adivina el número (1-10): ");
                        intento = sc.nextInt();
                    }
                    System.out.println("¡Correcto!");
                    break;

                case 3:
                    // Solo recorremos valores del array, sin necesitar el índice -> FOR-EACH
                    System.out.println("Elementos del array:");
                    for (int num : numeros) {
                        System.out.println("- " + num);
                    }
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    // Captura cualquier opción no contemplada
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4); // se repite hasta que el usuario elija salir
    }
}