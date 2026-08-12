package ui;

import model.Usuario;
import model.Estudiante;
import model.Adulto;
import model.TerceraEdad;

public class Main {
    public static void main(String[] args) {
        public static void main(String[] args) {

            // inicializar las clases ESTUDIANTE - ADULTO - TERCERA EDAD
            Usuario[] usuarios = {
                    new Estudiante(),
                    new Adulto(),
                    new TerceraEdad()
            };

            // Recorrer los usuario y mostrar el metodo validar pasaje
            for (Usuario u : usuarios) {
                u.validarPasaje();
            }
    }
}