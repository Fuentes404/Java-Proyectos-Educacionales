package ui;

public class Main {
    public static void main(String[] args) {

        // Variables
        // String: Permite ingresar datos escritos como variable
        String nombre = "Camila";
        // int: Permite ingresar numeros Enteros como variable
        int edad = 25;
        // double: Permite ingresar numero con decimales como variable
        double altura = 1.68;
        // boolean: Permite ingresar un comparador True o False como variable
        boolean estudiante = true;
        // char: Permite ingresar un solo caracter como variable
        char inicial = 'C';
        // long: Permite ingresar numeros enteros muy grandes como variable
        long poblacionMundial = 8000000000l;
        // float: Permite ingresar numeros decimales (menor precisión que double)
        float peso = 58.5f;

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("Estudiante: " + estudiante);
        System.out.println("Inicial: " + inicial);
        System.out.println("Poblacion mundial: " + poblacionMundial);
        System.out.println("Peso: " + peso);

        // Casting

        // 1) Casting implícito (automático): de int a double, sin pérdida de datos
        double edadComoDouble = edad;
        System.out.println("Casting implícito (int a double): " + edad + " -> " + edadComoDouble);

        // 2) Casting explícito (manual): de double a int, se pierden los decimales
        int alturaComoInt = (int) altura;
        System.out.println("Casting explícito (double a int): " + altura + " -> " + alturaComoInt);

    }
}