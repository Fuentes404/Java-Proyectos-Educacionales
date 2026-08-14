package model;

public class Estudiante extends Persona {
    // Atributos
    private String rol = "Estudiante";
    private String institucion;
    private String periodoEstudio;

    // Constructor
    public Estudiante(String nombre, int edad, int idPersona, String institucion, String periodoEstudio) {
        super(nombre, edad, idPersona);
        this.institucion = institucion;
        this.periodoEstudio = periodoEstudio;
    }

    // Getter and Setters
    public String getRol() {
        return rol;
    }
    public String getInstitucion() {
        return institucion;
    }
    public String getPeriodoEstudio() {
        return periodoEstudio;
    }
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    public void setPeriodoEstudio(String periodoEstudio) {
        this.periodoEstudio = periodoEstudio;
    }

    // Metodo mostrar Informacion
    @Override
    public void mostrarInfo() {
        System.out.println("Datos de Usuario: " +
                "\nNombre: " + getNombre() +
                "\nEdad : " + getEdad() +
                "\nId Persona: " + getIdPersona() +
                "\nRol: " + getRol() +
                "\nInstitucion: " + getInstitucion() +
                "\nPeriodo Escolar: " + getPeriodoEstudio());
    }
}