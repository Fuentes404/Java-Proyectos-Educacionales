package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicializar la librería Scanner para leer datos desde el teclado
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número equivalente a un día de la semana
        // En caso de que la variable no sea definida por scarnner esta debera estar definida implicitamente
        System.out.println(" Ingrese un numero equivalente a un dia de la semana : ");
        int dia = sc.nextInt();

        // Validar el número ingresado con switch:
        // - Casos 1 a 5 -> es día de semana (laboral)
        // - Casos 6 y 7 -> es fin de semana
        // - default -> se considera número inválido
        switch (dia) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Es un dia de semana laboral");
                break;
            case 6:
            case 7:
                System.out.println("Es Fin de semana");
                break;
            default:
                System.out.println("Error numero invalido");
                break;
        }

        // Cerrar el Scanner para liberar recursos del sistema
        sc.close();

    }
}