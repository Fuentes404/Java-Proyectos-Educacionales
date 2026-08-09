package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializar Scanner
        Scanner scanner = new Scanner(System.in);

        // Leer un String
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();

        // Leer un entero
        System.out.print("Ingresa tu edad: ");
        int edad = scanner.nextInt();

        // Leer un double
        System.out.print("Ingresa tu estatura (en metros): ");
        double estatura = scanner.nextDouble();

        // Limpiar el buffer antes de leer otra línea
        scanner.nextLine();

        // Leer otro String
        System.out.print("Ingresa tu ciudad: ");
        String ciudad = scanner.nextLine();

        // Mostrar los datos ingresados
        System.out.println("\n--- Datos ingresados ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Estatura: " + estatura + " m");
        System.out.println("Ciudad: " + ciudad);

        scanner.close();
    }
}