package ui;

import java.util.Arrays;

// Ejercicio: Ordenar un array de números con Arrays.sort()
public class Main {
    public static void main(String[] args) {
        int[] numeros = {5, 2, 9, 1, 8, 7};

        Arrays.sort(numeros);

        System.out.println(Arrays.toString(numeros)); // [1, 2, 5, 7, 8, 9]
    }
}