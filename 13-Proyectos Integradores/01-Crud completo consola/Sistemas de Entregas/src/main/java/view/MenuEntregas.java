package view;

import model.Entrega;
import model.Pedido;
import model.Repartidor;
import services.ControladorEntregas;
import services.ControladorPedidos;
import services.ControladorRepartidores;
import util.Consola;
import util.ValidadorDatos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MenuEntregas {

    private final ControladorEntregas controlador;
    private final ControladorPedidos controladorPedidos;
    private final ControladorRepartidores controladorRepartidores;

    public MenuEntregas(ControladorEntregas controlador, ControladorPedidos controladorPedidos,
                        ControladorRepartidores controladorRepartidores) {
        this.controlador = controlador;
        this.controladorPedidos = controladorPedidos;
        this.controladorRepartidores = controladorRepartidores;
    }

    // Muestra el menu hasta que el usuario elige volver
    public void mostrar() {
        int opcion;
        do {
            Consola.titulo("Gestión de Entregas");
            Consola.mensaje("1. Listar entregas");
            Consola.mensaje("2. Nueva entrega (asignar pedido)");
            Consola.mensaje("3. Editar entrega");
            Consola.mensaje("4. Eliminar entrega");
            Consola.mensaje("5. Enviar pedidos de un repartidor");
            Consola.mensaje("0. Volver");
            opcion = Consola.leerOpcion("Opción: ", 0, 5);

            switch (opcion) {
                case 1:
                    listar();
                    break;
                case 2:
                    nueva();
                    break;
                case 3:
                    editar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    enviar();
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    // ---------- Listar ----------

    // Muestra las entregas con el nombre del repartidor y el estado del pedido
    public void listar() {
        List<Object[]> filas = new ArrayList<>();
        for (Entrega entrega : controlador.getEntregas()) {
            Repartidor repartidor = controladorRepartidores.buscarPorId(entrega.getIdRepartidor());
            Pedido pedido = controladorPedidos.buscarPorId(entrega.getIdPedido());

            filas.add(new Object[]{
                    entrega.getId(),
                    entrega.getIdPedido(),
                    repartidor != null ? repartidor.getNombre() : null,
                    entrega.getFecha(),
                    entrega.getHora().withNano(0),
                    pedido != null ? pedido.getEstado() : null
            });
        }
        Consola.imprimirTabla(new String[]{"ID", "Pedido", "Repartidor", "Fecha", "Hora",
                "Estado pedido"}, filas);
    }

    // ---------- Crear ----------

    // Asigna un pedido pendiente a un repartidor
    private void nueva() {
        Consola.titulo("Nueva entrega");

        // Debe haber pedidos disponibles y repartidores
        List<Pedido> pedidos = controlador.getPedidosDisponibles();
        if (pedidos.isEmpty()) {
            Consola.aviso("No hay pedidos pendientes disponibles para asignar.");
            return;
        }
        String errorLista = ValidadorDatos.validarLista(controladorRepartidores.getRepartidores());
        if (errorLista != null) {
            Consola.aviso(errorLista + " Cree un repartidor primero.");
            return;
        }

        // Pedidos disponibles
        Consola.mensaje("Pedidos disponibles:");
        List<Object[]> filasPedidos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            filasPedidos.add(new Object[]{pedido.getIdPedido(), pedido.getTipoPedido(),
                    pedido.getCliente()});
        }
        Consola.imprimirTabla(new String[]{"ID", "Tipo", "Cliente"}, filasPedidos);
        int idPedido = Consola.leerEntero("ID del pedido");

        // Repartidores
        Consola.mensaje("Repartidores:");
        listarRepartidores();
        int idRepartidor = Consola.leerEntero("ID del repartidor");

        String error = controlador.crear(idPedido, idRepartidor);
        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.exito("Entrega creada.");
        }
    }

    // ---------- Editar ----------

    // Cambia repartidor, fecha y hora de la entrega elegida
    private void editar() {
        Entrega entrega = elegirEntrega();
        if (entrega == null) {
            return;
        }

        // Se pide cada dato, Enter mantiene el valor actual
        Consola.mensaje("Repartidores:");
        listarRepartidores();
        Consola.mensaje("(Enter mantiene el valor actual)");

        int idRepartidor = Integer.parseInt(Consola.leerCampo("ID del repartidor",
                v -> ValidadorDatos.validarEntero(v, "ID del repartidor"),
                String.valueOf(entrega.getIdRepartidor())));
        String fecha = Consola.leerCampo("Fecha (AAAA-MM-DD)",
                ValidadorDatos::validarFecha, entrega.getFecha().toString());
        String hora = Consola.leerCampo("Hora (HH:mm)",
                ValidadorDatos::validarHora, entrega.getHora().withSecond(0).withNano(0).toString());

        String error = controlador.editar(entrega.getId(), idRepartidor,
                LocalDate.parse(fecha.trim()), LocalTime.parse(hora.trim()));
        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.exito("Entrega actualizada.");
        }
    }

    // ---------- Eliminar ----------

    // Deshace la asignacion de la entrega elegida
    private void eliminar() {
        Entrega entrega = elegirEntrega();
        if (entrega == null) {
            return;
        }

        if (!Consola.confirmar("¿Eliminar la entrega N° " + entrega.getId() + "?")) {
            return;
        }

        String error = controlador.eliminar(entrega.getId());
        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.exito("Entrega eliminada.");
        }
    }

    // ---------- Enviar ----------

    // Envia todos los pedidos pendientes del repartidor de la entrega elegida
    private void enviar() {
        Entrega entrega = elegirEntrega();
        if (entrega == null) {
            return;
        }

        Repartidor repartidor = controladorRepartidores.buscarPorId(entrega.getIdRepartidor());
        String nombre = (repartidor != null) ? repartidor.getNombre() : "el repartidor";

        if (!Consola.confirmar("Se enviarán todos los pedidos pendientes de " + nombre + ". ¿Continuar?")) {
            return;
        }

        // Los mensajes del hilo del repartidor salen directamente por consola
        String error = controlador.enviar(entrega.getIdRepartidor(), mensaje -> Consola.mensaje("   >> " + mensaje));
        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.mensaje("El reparto avanza en segundo plano, los mensajes irán apareciendo.");
        }
    }

    // ---------- Auxiliares ----------

    // Muestra la lista de repartidores
    private void listarRepartidores() {
        List<Object[]> filas = new ArrayList<>();
        for (Repartidor repartidor : controladorRepartidores.getRepartidores()) {
            filas.add(new Object[]{repartidor.getId(), repartidor.getNombre()});
        }
        Consola.imprimirTabla(new String[]{"ID", "Nombre"}, filas);
    }

    // Muestra la lista y pide el ID, devuelve null si no hay entregas o el ID no existe
    private Entrega elegirEntrega() {
        String error = ValidadorDatos.validarLista(controlador.getEntregas());
        if (error != null) {
            Consola.aviso(error);
            return null;
        }

        listar();
        int id = Consola.leerEntero("ID de la entrega");
        Entrega entrega = controlador.buscarPorId(id);
        if (entrega == null) {
            Consola.aviso("La entrega no existe.");
        }
        return entrega;
    }
}