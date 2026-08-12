package model;

public class Adulto extends Usuario{
    // Metodo que valida el pasaje de un Adulto
    // la notacion es similar debido a la herencia de USUARIO
    // Se debe determinar en el metodo la forma que interactua
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa Adulto aplicada.");
    }
}
