import model.Persona;

public class Main {
    public static void main(String[] args) {

        // Creamos un objeto de tipo Persona
        Persona persona1 = new Persona();

        // Llamamos a sus métodos
        persona1.saludar();
        persona1.mostrarInformacion();

        // Podemos modificar sus atributos porque son public
        persona1.nombre = "Ana Torres";
        persona1.edad = 30;
        persona1.cargo = "Gerente";

        persona1.mostrarInformacion();

        // Creamos un segundo objeto para comparar
        // sigue con los valores por defecto
        Persona persona2 = new Persona();
        persona2.mostrarInformacion();
    }
}