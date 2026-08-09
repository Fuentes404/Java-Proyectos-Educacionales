package model;

public class Colegio implements Ubicable {
    // Atributos
    private String nombreColegio;
    private String direccion;

    // Constructor
    public Colegio(String nombreColegio, String direccion) {
        this.nombreColegio = nombreColegio;
        this.direccion = direccion;
    }

    // Getter y Setter
    public String getNombreColegio() {
        return nombreColegio;
    }
    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    // Metodo mostrar informacion
    public void mostrarInfo() {
        System.out.println("Colegio: " + getNombreColegio() + " | Direccion: " + getDireccion());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Colegio{" + "nombreColegio='" + nombreColegio + '\'' + ", direccion='" + direccion + '\'' + '}';
    }
}