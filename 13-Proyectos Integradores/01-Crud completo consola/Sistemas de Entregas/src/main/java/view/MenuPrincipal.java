package view;

import services.ControladorEntregas;
import services.ControladorPedidos;
import services.ControladorRepartidores;
import util.Consola;

public class MenuPrincipal {

    // Controladores, se crean una sola vez para toda la aplicacion
    private final ControladorPedidos controladorPedidos = new ControladorPedidos();
    private final ControladorRepartidores controladorRepartidores = new ControladorRepartidores();
    private final ControladorEntregas controladorEntregas =
            new ControladorEntregas(controladorPedidos, controladorRepartidores);

    // Cada menu recibe los controladores que necesita
    private final MenuRepartidores menuRepartidores = new MenuRepartidores(controladorRepartidores);
    private final MenuPedidos menuPedidos = new MenuPedidos(controladorPedidos);
    private final MenuEntregas menuEntregas =
            new MenuEntregas(controladorEntregas, controladorPedidos, controladorRepartidores);

    public MenuPrincipal() {
        // Pedidos y repartidores consultan a entregas al eliminar
        controladorPedidos.setControladorEntregas(controladorEntregas);
        controladorRepartidores.setControladorEntregas(controladorEntregas);
    }

    // Muestra el menu principal hasta que el usuario elige salir
    public void iniciar() {
        int opcion;
        do {
            Consola.titulo("Sistema de Gestión de Entregas");
            Consola.mensaje("1. Repartidores");
            Consola.mensaje("2. Pedidos");
            Consola.mensaje("3. Entregas");
            Consola.mensaje("0. Salir");
            opcion = Consola.leerOpcion("Opción: ", 0, 3);

            switch (opcion) {
                case 1:
                    menuRepartidores.mostrar();
                    break;
                case 2:
                    menuPedidos.mostrar();
                    break;
                case 3:
                    menuEntregas.mostrar();
                    break;
                default:
                    Consola.mensaje("Hasta pronto.");
            }
        } while (opcion != 0);
    }
}