package ui;

public class Main {
    public static void main(String[] args) {

        // Creamos una matriz (arreglo bidimensional) para almacenar
        // notas de 3 estudiantes, cada uno con 3 notas.
        // Filas = estudiantes, Columnas = notas.
        int[][] notas = new int[3][3];

        // Creamos otra matriz para almacenar temperaturas registradas
        // durante 3 días, con 3 mediciones por día.
        int[][] temperaturas = new int[3][3];

        // Asignamos valores a la matriz de notas.
        // notas[fila][columna]
        notas[0][0] = 5; notas[0][1] = 6; notas[0][2] = 7;
        notas[1][0] = 4; notas[1][1] = 5; notas[1][2] = 6;
        notas[2][0] = 7; notas[2][1] = 7; notas[2][2] = 6;

        // Asignamos valores a la matriz de temperaturas.
        temperaturas[0][0] = 18; temperaturas[0][1] = 20; temperaturas[0][2] = 19;
        temperaturas[1][0] = 22; temperaturas[1][1] = 23; temperaturas[1][2] = 21;
        temperaturas[2][0] = 15; temperaturas[2][1] = 16; temperaturas[2][2] = 17;

        // Mostramos un elemento específico accediendo
        // directamente a su fila y columna.
        System.out.println(notas[0][0]);
        System.out.println(notas[1][2]);
        System.out.println(notas[2][1]);

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos la matriz de notas utilizando
        // un ciclo for anidado con índices.
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                System.out.println(notas[i][j]);
            }
        }

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos la matriz de temperaturas utilizando
        // un ciclo for anidado con índices.
        for (int fila = 0; fila < temperaturas.length; fila++) {
            for (int columna = 0; columna < temperaturas[fila].length; columna++) {
                System.out.println(temperaturas[fila][columna]);
            }
        }

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos la matriz de notas utilizando
        // un ciclo for-each anidado.
        for (int[] filaNotas : notas) {
            for (int nota : filaNotas) {
                System.out.println(nota);
            }
        }

        // Imprime una línea en blanco para separar la salida.
        System.out.println("");

        // Recorremos la matriz de temperaturas utilizando
        // un ciclo for-each anidado.
        for (int[] filaTemp : temperaturas) {
            for (int temp : filaTemp) {
                System.out.println(temp);
            }
        }
        
    }
}