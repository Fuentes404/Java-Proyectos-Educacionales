package model;

public class Gimnasio implements Ubicable {
    // Atributos
    private String nombreGimnasio;
    private String direccion;

    // Constructor
    public Gimnasio(String nombreGimnasio, String direccion) {
        this.nombreGimnasio = nombreGimnasio;
        this.direccion = direccion;
    }

    // Getter y Setter
    public String getNombreGimnasio() {
        return nombreGimnasio;
    }
    public void setNombreGimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
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
        System.out.println("Gimnasio: " + getNombreGimnasio() + " | Direccion: " + getDireccion());
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Gimnasio{" + "nombreGimnasio='" + nombreGimnasio + '\'' + ", direccion='" + direccion + '\'' + '}';
    }
}