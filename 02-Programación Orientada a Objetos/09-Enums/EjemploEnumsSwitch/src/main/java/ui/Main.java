package ui;

import model.Dia;
import model.DiaInfo;

public class Main {
    public static void main(String[] args) {
        // Se crea objeto diaInfo
        DiaInfo info = new DiaInfo(Dia.MIERCOLES);
        // Se muestra la informacion del dia
        mostrar(info);
    }

    // La UI solo llama a métodos públicos, no sabe cómo se calcula
    private static void mostrar(DiaInfo info) {
        System.out.println("Día: " + info.getDia());
        System.out.println("Descripción: " + info.getDescripcion());
        System.out.println("¿Es laboral?: " + (info.esLaboral() ? "Sí" : "No"));
    }
}