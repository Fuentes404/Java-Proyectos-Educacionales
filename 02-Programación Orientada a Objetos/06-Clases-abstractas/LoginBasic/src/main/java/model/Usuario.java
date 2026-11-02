package model;

public abstract class Usuario {
    // Atributos
    protected int idUsuario;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String correo;
    protected String contrasena;
    protected final TipoRol rol;

    // Constructor
    protected Usuario(int idUsuario, String nombre, String apellido, int edad, String correo, String contrasena, TipoRol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Metodos Getter and Setter
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public TipoRol getRol() {
        return rol;
    }

    // Metodos funcionales
    public abstract void mostrarInformacion();

    // Metodos Auxiliares

    // Metodos Representativos
}
