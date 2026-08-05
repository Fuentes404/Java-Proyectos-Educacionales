package ui;

public class Main {
    public static void main(String[] args) {

        // Creamos un arreglo para almacenar números pares.
        // El arreglo tendrá espacio para 3 elementos.
        int[] numeroPar = new int[3];

        // Creamos un arreglo para almacenar números impares.
        // El arreglo tendrá espacio para 3 elementos.
        int[] numeroImpar = new int[3];

        // Asignamos valores al arreglo de números pares.
        numeroPar[0] = 2;
        numeroPar[1] = 4;
        numeroPar[2] = 6;

        // Asignamos valores al arreglo de números impares.
        numeroImpar[0] = 1;
        numeroImpar[1] = 3;
        numeroImpar[2] = 5;

        // Mostramos cada elemento del arreglo de números pares
        // accediendo directamente a su índice.
        System.out.println(numeroPar[0]);
        System.out.println(numeroPar[1]);
        System.out.println(numeroPar[2]);

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Mostramos cada elemento del arreglo de números impares
        // accediendo directamente a su índice.
        System.out.println(numeroImpar[0]);
        System.out.println(numeroImpar[1]);
        System.out.println(numeroImpar[2]);

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos el arreglo de números pares utilizando
        // un ciclo for con índice.
        for (int i = 0; i < numeroPar.length; i++) {
            System.out.println(numeroPar[i]);
        }

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos el arreglo de números impares utilizando
        // un ciclo for con índice.
        for (int j = 0; j < numeroImpar.length; j++) {
            System.out.println(numeroImpar[j]);
        }

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos el arreglo de números pares utilizando
        // un ciclo for-each.
        for (int par : numeroPar) {
            System.out.println(par);
        }

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos el arreglo de números impares utilizando
        // un ciclo for-each.
        for (int impar : numeroImpar) {
            System.out.println(impar);
        }

    }
}