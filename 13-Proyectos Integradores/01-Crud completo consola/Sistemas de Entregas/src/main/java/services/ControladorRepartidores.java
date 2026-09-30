package services;

import model.Repartidor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorRepartidores {

    // Lista que guarda todos los repartidores
    private final List<Repartidor> repartidores = new ArrayList<>();

    // Contador de IDs mientras no exista la base de datos
    private int siguienteId = 1;

    // Controlador de entregas, se conecta desde el menu principal
    private ControladorEntregas controladorEntregas;

    // Conecta el controlador de entregas
    public void setControladorEntregas(ControladorEntregas controladorEntregas) {
        this.controladorEntregas = controladorEntregas;
    }

    // ---------- Crear ----------

    // Crea un repartidor nuevo y lo agrega a la lista
    public Repartidor crear(String nombre) {
        Repartidor repartidor = new Repartidor(nombre);
        repartidor.setId(siguienteId++);
        repartidores.add(repartidor);
        return repartidor;
    }

    // ---------- Editar ----------

    // Cambia el nombre de un repartidor, devuelve el error o null si todo salio bien
    public String editar(int id, String nuevoNombre) {
        Repartidor repartidor = buscarPorId(id);
        if (repartidor == null) {
            return "El repartidor no existe.";
        }
        repartidor.setNombre(nuevoNombre);
        return null;
    }

    // ---------- Eliminar ----------

    // Elimina un repartidor de la lista, devuelve el error o null si todo salio bien
    public String eliminar(int id) {
        Repartidor repartidor = buscarPorId(id);
        if (repartidor == null) {
            return "El repartidor no existe.";
        }
        // No se elimina si tiene entregas pendientes o en reparto
        if (controladorEntregas.tieneEntregasEnProceso(id)) {
            return "No se puede eliminar: el repartidor tiene entregas en proceso.";
        }
        // Sus entregas terminadas se eliminan junto con el
        controladorEntregas.eliminarPorRepartidor(id);
        repartidores.remove(repartidor);
        return null;
    }

    // ---------- Consultas ----------

    // Busca un repartidor por su ID, devuelve null si no existe
    public Repartidor buscarPorId(int id) {
        for (Repartidor repartidor : repartidores) {
            if (repartidor.getId() == id) {
                return repartidor;
            }
        }
        return null;
    }

    // Lista de solo lectura para consultas
    public List<Repartidor> getRepartidores() {
        return Collections.unmodifiableList(repartidores);
    }
}