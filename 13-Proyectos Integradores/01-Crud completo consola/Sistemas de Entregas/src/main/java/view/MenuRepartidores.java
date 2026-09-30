package view;

import model.Repartidor;
import services.ControladorRepartidores;
import util.Consola;
import util.ValidadorDatos;

import java.util.ArrayList;
import java.util.List;

public class MenuRepartidores {

    private final ControladorRepartidores controlador;

    public MenuRepartidores(ControladorRepartidores controlador) {
        this.controlador = controlador;
    }

    // Muestra el menu hasta que el usuario elige volver
    public void mostrar() {
        int opcion;
        do {
            Consola.titulo("Gestión de Repartidores");
            Consola.mensaje("1. Listar repartidores");
            Consola.mensaje("2. Nuevo repartidor");
            Consola.mensaje("3. Editar repartidor");
            Consola.mensaje("4. Eliminar repartidor");
            Consola.mensaje("0. Volver");
            opcion = Consola.leerOpcion("Opción: ", 0, 4);

            switch (opcion) {
                case 1:
                    listar();
                    break;
                case 2:
                    nuevo();
                    break;
                case 3:
                    editar();
                    break;
                case 4:
                    eliminar();
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    // ---------- Listar ----------

    // Muestra todos los repartidores en una tabla
    public void listar() {
        List<Object[]> filas = new ArrayList<>();
        for (Repartidor repartidor : controlador.getRepartidores()) {
            filas.add(new Object[]{repartidor.getId(), repartidor.getNombre()});
        }
        Consola.imprimirTabla(new String[]{"ID", "Nombre"}, filas);
    }

    // ---------- Crear ----------

    // Pide el nombre y crea el repartidor
    private void nuevo() {
        Consola.titulo("Nuevo repartidor");
        String nombre = Consola.leerCampo("Nombre", v -> ValidadorDatos.validarNombre(v, "Nombre"));
        controlador.crear(nombre);
        Consola.exito("Repartidor creado.");
    }

    // ---------- Editar ----------

    // Cambia el nombre de un repartidor existente
    private void editar() {
        Repartidor repartidor = elegirRepartidor();
        if (repartidor == null) {
            return;
        }

        Consola.mensaje("(Enter mantiene el valor actual)");
        String nombre = Consola.leerCampo("Nombre",
                v -> ValidadorDatos.validarNombre(v, "Nombre"), repartidor.getNombre());

        String error = controlador.editar(repartidor.getId(), nombre);
        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.exito("Repartidor actualizado.");
        }
    }

    // ---------- Eliminar ----------

    // Elimina un repartidor previa confirmacion
    private void eliminar() {
        Repartidor repartidor = elegirRepartidor();
        if (repartidor == null) {
            return;
        }

        if (!Consola.confirmar("¿Eliminar al repartidor " + repartidor.getNombre() + "?")) {
            return;
        }

        String error = controlador.eliminar(repartidor.getId());
        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.exito("Repartidor eliminado.");
        }
    }

    // ---------- Auxiliar ----------

    // Muestra la lista y pide el ID, devuelve null si no hay repartidores o el ID no existe
    private Repartidor elegirRepartidor() {
        String error = ValidadorDatos.validarLista(controlador.getRepartidores());
        if (error != null) {
            Consola.aviso(error);
            return null;
        }

        listar();
        int id = Consola.leerEntero("ID del repartidor");
        Repartidor repartidor = controlador.buscarPorId(id);
        if (repartidor == null) {
            Consola.aviso("El repartidor no existe.");
        }
        return repartidor;
    }
}