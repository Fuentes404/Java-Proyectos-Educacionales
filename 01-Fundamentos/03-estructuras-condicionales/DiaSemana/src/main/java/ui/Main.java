package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicializar la librería Scanner para leer datos desde el teclado
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número equivalente a un día de la semana
        System.out.println(" Ingrese un numero equivalente a un dia de la semana : ");
        int dia = sc.nextInt();

        // Validar el número ingresado con estructuras condicionales:
        // - Si está entre 1 y 5 -> es día de semana (laboral)
        // - Si es 6 o 7 -> es fin de semana
        // - Cualquier otro valor -> se considera número inválido
        if (dia >= 1 && dia <= 5) {
            System.out.println("Es un dia de semana laboral");
        } else if (dia == 6 || dia == 7) {
            System.out.println("Es Fin de semana");
        } else {
            System.out.println("Error numero invalido");
        }

        // Cerrar el Scanner para liberar recursos del sistema
        sc.close();

    }
}