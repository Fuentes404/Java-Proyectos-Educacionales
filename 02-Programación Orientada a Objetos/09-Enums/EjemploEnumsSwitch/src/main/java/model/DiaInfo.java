package model;

public class DiaInfo {

    // Referencia
    private final Dia dia;

    // Constructor
    public DiaInfo(Dia dia) {
        this.dia = dia;
    }

    // Meteodo Getter
    public Dia getDia() {
        return dia;
    }

    // Metodo con Switch
    public String getDescripcion() {
        String descripcion;
        switch (dia) {
            case LUNES:
                descripcion = "Inicio de semana laboral";
                break;
            case MARTES:
            case MIERCOLES:
            case JUEVES:
                descripcion = "Mitad de semana";
                break;
            case VIERNES:
                descripcion = "¡Casi fin de semana!";
                break;
            case SABADO:
            case DOMINGO:
                descripcion = "Fin de semana";
                break;
            default:
                throw new IllegalStateException("Día no válido: " + dia);
        }
        return descripcion;
    }

    // Determina si el dia corresponde a un dia laboral
    public boolean esLaboral() {
        switch (dia) {
            case SABADO:
            case DOMINGO:
                return false;
            default:
                return true;
        }
    }
}