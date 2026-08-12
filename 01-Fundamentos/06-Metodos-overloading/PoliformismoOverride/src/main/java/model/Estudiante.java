package model;

public class Estudiante extends Usuario{
    // Metodo que valida el pasaje de un ESTUDIANTE
    // la notacion es similar debido a la herencia de USUARIO
    // Se debe determinar en el metodo la forma que interactua
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa estudiante aplicada.");
    }
}
