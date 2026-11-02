package model;

public class UsuarioCliente extends Usuario{
    // Atributos

    // Constructor
    public UsuarioCliente(int idUsuario, String nombre, String apellido, int edad, String correo, String contrasena){
        super(idUsuario, nombre, apellido, edad, correo, contrasena, TipoRol.CLIENTE);
    }

    // Metodos Getter and Setter

    // Metodos Funcionales
    public void mostrarInformacion(){
        System.out.println("Cliente: " + getNombre() + " " + getApellido());
        System.out.println("Correo: " + getCorreo());
    }
    // Metodos Auxiliares

    // Metodos Representativos
}
