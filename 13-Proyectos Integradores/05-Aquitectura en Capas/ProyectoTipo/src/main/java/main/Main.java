package main;

// Considerar: importar los elementos de la UI o GUI según corresponda.
// Considerar: importar Scanner o Swing según cómo se muestren los datos.
// Considerar: importar lo necesario para la conexión a la BD.

// - Función: Arranca el sistema y prepara la aplicación.
// Considerar: aquí no va lógica de negocio ni diseño de pantallas.
public class Main {
    public static void main(String[] args) {

        // — Metodo de arranque: punto donde inicia el programa
        // Considerar: si se usa Swing, abrir la ventana con SwingUtilities.invokeLater.
        // Considerar: avisar si algo falla al iniciar (try/catch).

        // — Instancias ( UI o GUI ): creación de los objetos principales
        // Considerar: crear en este orden: conexión (dao), gestor (services), ventana (ui).
        // Considerar: pasar cada objeto por el constructor de quien lo necesita.

        // — Metodos de apertura: mostrar la aplicación
        // Ej: ventana.setVisible(true);
        // Considerar: cerrar la conexión a la BD al terminar el programa.

    }
}