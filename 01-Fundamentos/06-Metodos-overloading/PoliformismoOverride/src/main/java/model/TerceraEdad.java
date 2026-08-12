package model;

public class TerceraEdad extends Usuario{
    // Metodo que valida el pasaje de una persona TERCERA EDAD
    // la notacion es similar debido a la herencia de USUARIO
    // Se debe determinar en el metodo la forma que interactua
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa tercera edad aplicada.");
    }
}
