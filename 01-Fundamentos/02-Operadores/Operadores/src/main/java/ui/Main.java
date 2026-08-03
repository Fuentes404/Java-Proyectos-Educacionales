package ui;

public class Main {
    public static void main(String[] args) {

        // Variables base
        int a = 10;
        int b = 3;

        // 1 - Operadores Aritmeticos
        int suma = a + b;
        int resta = a - b;
        int multiplicacion = a * b;
        int division = a / b;
        int modulo = a % b;

        System.out.println("--- Operadores aritméticos ---");
        System.out.println("Suma: " + a + " + " + b + " = " + suma);
        System.out.println("Resta: " + a + " - " + b + " = " + resta);
        System.out.println("Multiplicación: " + a + " * " + b + " = " + multiplicacion);
        System.out.println("División: " + a + " / " + b + " = " + division);
        System.out.println("Módulo: " + a + " % " + b + " = " + modulo);


        // 2 - Operadores de asignacion
        int contador = 5;
        System.out.println("\n--- Operadores de asignación ---");
        System.out.println("Valor inicial: " + contador);

        contador += 3; // contador = contador + 3
        System.out.println("Después de += 3: " + contador);

        contador *= 2; // contador = contador * 2
        System.out.println("Después de *= 2: " + contador);

        // 3. Incremento y Decremento
        int numero = 8;
        System.out.println("\n--- Incremento y decremento ---");
        System.out.println("Valor inicial: " + numero);

        numero++; // incrementa en 1
        System.out.println("Después de ++: " + numero);

        numero--; // decrementa en 1
        System.out.println("Después de --: " + numero);

        // 4 - Operadores Relacionales
        System.out.println("\n--- Operadores relacionales ---");
        System.out.println(a + " > " + b + " -> " + (a > b));
        System.out.println(a + " == " + b + " -> " + (a == b));

        // 5 - Operadores Logicos
        boolean esMayorDeEdad = true;
        boolean tieneCarnet = false;

        System.out.println("\n--- Operadores lógicos ---");
        System.out.println("¿Es mayor de edad Y tiene carnet?: " + (esMayorDeEdad && tieneCarnet));
        System.out.println("¿Es mayor de edad O tiene carnet?: " + (esMayorDeEdad || tieneCarnet));

    }
}