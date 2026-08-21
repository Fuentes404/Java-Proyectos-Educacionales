package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // inicializar Scanner para leer la entrada del usuario por consola
        Scanner sc = new Scanner(System.in);

        // Imprime un Mensaje de entrada
        System.out.println("Calculadora basica usando estructuras de Lenguaje");

        // Variable que controla si el usuario quiere seguir calculando
        String continuar;

        // Bucle do-while: se ejecuta al menos una vez, y repite mientras el usuario responda "s"
        do {
            try {
                // Pedimos el primer numero y lo convertimos de texto a double
                System.out.println("Ingrese el primer numero: ");
                double num1 = Double.parseDouble(sc.nextLine());

                // Leemos el operador como String
                System.out.println("Ingrese el operador (+, /, *, -)");
                String operador = sc.nextLine(); // String, no double

                // Pedimos el segundo numero
                System.out.println("Ingrese el segundo numero: ");
                double num2 = Double.parseDouble(sc.nextLine());

                // Delegamos el calculo al metodo operar()
                double resultado = operar(num1, num2, operador);
                System.out.println("Resultado: " + resultado);

            } catch (NumberFormatException e) {
                // Se lanza si el usuario ingresa algo que no es un numero valido
                System.out.println("Error: debes ingresar un numero valido.");
            } catch (ArithmeticException e) {
                // Se lanza en caso de division por cero
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                // Se lanza si el operador ingresado no es reconocido
                System.out.println("Error: " + e.getMessage());
            } finally {
                // Este bloque se ejecuta siempre, haya error o no
                System.out.println("-- Calculo finalizado --");
            }

            // Preguntamos si se quiere repetir el proceso
            System.out.println("Desea Realizar otra operacion? (s/n)");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("s")); // Continua si la respuesta es "s" o "S"
    }

    // Metodo que realiza la operacion matematica segun el operador recibido
    static double operar(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                // Validamos que no se divida por cero antes de operar
                if (b == 0) {
                    throw new ArithmeticException("no se puede dividir por cero");
                }
                return a / b;
            default:
                // Si el operador no coincide con ninguno de los casos anteriores
                throw new IllegalArgumentException("operador no reconocido: " + op);
        }
    }
}