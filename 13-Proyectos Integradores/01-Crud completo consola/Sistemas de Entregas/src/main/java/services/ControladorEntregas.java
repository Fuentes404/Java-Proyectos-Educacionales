package services;

import model.Entrega;
import model.EstadoPedido;
import model.Pedido;
import model.Repartidor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ControladorEntregas {

    // Lista que guarda todas las entregas
    private final List<Entrega> entregas = new ArrayList<>();

    // Contador de IDs mientras no exista la base de datos
    private int siguienteId = 1;

    // Controladores de los que se obtienen los pedidos y repartidores
    private final ControladorPedidos controladorPedidos;
    private final ControladorRepartidores controladorRepartidores;

    public ControladorEntregas(ControladorPedidos controladorPedidos,
                               ControladorRepartidores controladorRepartidores) {
        this.controladorPedidos = controladorPedidos;
        this.controladorRepartidores = controladorRepartidores;
    }

    // ---------- Crear ----------

    // Asigna un pedido pendiente a un repartidor, devuelve el error o null si todo salio bien
    public String crear(int idPedido, int idRepartidor) {
        Pedido pedido = controladorPedidos.buscarPorId(idPedido);
        Repartidor repartidor = controladorRepartidores.buscarPorId(idRepartidor);

        // Validaciones
        if (pedido == null) {
            return "El pedido no existe.";
        }
        if (repartidor == null) {
            return "El repartidor no existe.";
        }
        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            return "Solo se pueden asignar pedidos pendientes.";
        }
        if (buscarPorPedido(idPedido) != null) {
            return "El pedido ya está asignado a un repartidor.";
        }

        // Se registra la entrega y se agrega el pedido a la ruta del repartidor
        Entrega entrega = new Entrega(siguienteId++, idPedido, idRepartidor,
                LocalDate.now(), LocalTime.now());
        entregas.add(entrega);
        repartidor.getPedidosAsignados().add(pedido);
        return null;
    }

    // ---------- Editar ----------

    // Cambia repartidor, fecha y hora de una entrega, devuelve el error o null si todo salio bien
    public String editar(int idEntrega, int idNuevoRepartidor, LocalDate fecha, LocalTime hora) {
        Entrega entrega = buscarPorId(idEntrega);
        if (entrega == null) {
            return "La entrega no existe.";
        }

        Repartidor nuevo = controladorRepartidores.buscarPorId(idNuevoRepartidor);
        if (nuevo == null) {
            return "El repartidor no existe.";
        }

        // Solo se edita mientras el pedido siga pendiente
        Pedido pedido = controladorPedidos.buscarPorId(entrega.getIdPedido());
        if (pedido == null || pedido.getEstado() != EstadoPedido.PENDIENTE) {
            return "Solo se pueden editar entregas de pedidos pendientes.";
        }

        // Se saca el pedido de la ruta anterior y se pasa a la nueva
        Repartidor anterior = controladorRepartidores.buscarPorId(entrega.getIdRepartidor());
        if (anterior != null) {
            anterior.getPedidosAsignados().remove(pedido);
        }
        nuevo.getPedidosAsignados().add(pedido);

        // Se actualizan los datos de la entrega
        entrega.setIdRepartidor(idNuevoRepartidor);
        entrega.setFecha(fecha);
        entrega.setHora(hora);
        return null;
    }

    // ---------- Eliminar ----------

    // Deshace la asignacion de un pedido pendiente, devuelve el error o null si todo salio bien
    public String eliminar(int idEntrega) {
        Entrega entrega = buscarPorId(idEntrega);
        if (entrega == null) {
            return "La entrega no existe.";
        }

        // Solo se elimina mientras el pedido siga pendiente
        Pedido pedido = controladorPedidos.buscarPorId(entrega.getIdPedido());
        if (pedido == null || pedido.getEstado() != EstadoPedido.PENDIENTE) {
            return "No se puede eliminar: la entrega está en proceso o ya fue realizada.";
        }

        // Se quita el pedido de la ruta del repartidor
        Repartidor repartidor = controladorRepartidores.buscarPorId(entrega.getIdRepartidor());
        if (repartidor != null) {
            repartidor.getPedidosAsignados().remove(pedido);
        }
        entregas.remove(entrega);
        return null;
    }

    // Elimina la entrega de un pedido, la usa ControladorPedidos al eliminar un pedido
    public void eliminarPorPedido(int idPedido) {
        Entrega entrega = buscarPorPedido(idPedido);
        if (entrega == null) {
            return;
        }

        // Se quita el pedido de la ruta del repartidor
        Repartidor repartidor = controladorRepartidores.buscarPorId(entrega.getIdRepartidor());
        Pedido pedido = controladorPedidos.buscarPorId(idPedido);
        if (repartidor != null && pedido != null) {
            repartidor.getPedidosAsignados().remove(pedido);
        }
        entregas.remove(entrega);
    }

    // Elimina todas las entregas de un repartidor, la usa ControladorRepartidores al eliminarlo
    public void eliminarPorRepartidor(int idRepartidor) {
        Iterator<Entrega> iterador = entregas.iterator();
        while (iterador.hasNext()) {
            if (iterador.next().getIdRepartidor() == idRepartidor) {
                iterador.remove();
            }
        }
    }

    // ---------- Enviar ----------

    // Envia los pedidos pendientes de un repartidor, devuelve el error o null si salio bien
    // La salida recibe los mensajes del hilo
    public String enviar(int idRepartidor, Consumer<String> salida) {
        Repartidor repartidor = controladorRepartidores.buscarPorId(idRepartidor);
        if (repartidor == null) {
            return "El repartidor no existe.";
        }

        // Ruta con solo los pedidos que siguen pendientes
        List<Pedido> ruta = new ArrayList<>();
        for (Pedido pedido : repartidor.getPedidosAsignados()) {
            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {
                ruta.add(pedido);
            }
        }
        if (ruta.isEmpty()) {
            return "El repartidor no tiene pedidos pendientes para enviar.";
        }

        // Los pedidos salen a reparto
        for (Pedido pedido : ruta) {
            pedido.setEstado(EstadoPedido.EN_REPARTO);
        }

        // Repartidor de esta ruta, sus mensajes salen por la salida indicada
        Repartidor enRuta = new Repartidor(repartidor.getId(), repartidor.getNombre(), ruta, salida);

        // Al terminar la ruta sin interrupciones, los pedidos pasan a entregados
        Thread hilo = new Thread(() -> {
            enRuta.run();
            if (!Thread.currentThread().isInterrupted()) {
                for (Pedido pedido : ruta) {
                    pedido.setEstado(EstadoPedido.ENTREGADO);
                }
            }
        }, "ruta-" + repartidor.getNombre());
        hilo.start();
        return null;
    }

    // ---------- Consultas ----------

    // Revisa si un repartidor tiene entregas con pedidos pendientes o en reparto
    public boolean tieneEntregasEnProceso(int idRepartidor) {
        for (Entrega entrega : entregas) {
            if (entrega.getIdRepartidor() == idRepartidor) {
                Pedido pedido = controladorPedidos.buscarPorId(entrega.getIdPedido());
                if (pedido != null && (pedido.getEstado() == EstadoPedido.PENDIENTE
                        || pedido.getEstado() == EstadoPedido.EN_REPARTO)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Pedidos que se pueden asignar: pendientes y sin entrega
    public List<Pedido> getPedidosDisponibles() {
        List<Pedido> disponibles = new ArrayList<>();
        for (Pedido pedido : controladorPedidos.getPedidos()) {
            if (pedido.getEstado() == EstadoPedido.PENDIENTE
                    && buscarPorPedido(pedido.getIdPedido()) == null) {
                disponibles.add(pedido);
            }
        }
        return disponibles;
    }

    // Busca una entrega por su ID, devuelve null si no existe
    public Entrega buscarPorId(int id) {
        for (Entrega entrega : entregas) {
            if (entrega.getId() == id) {
                return entrega;
            }
        }
        return null;
    }

    // Busca la entrega de un pedido, devuelve null si no tiene
    public Entrega buscarPorPedido(int idPedido) {
        for (Entrega entrega : entregas) {
            if (entrega.getIdPedido() == idPedido) {
                return entrega;
            }
        }
        return null;
    }

    // Lista de solo lectura para consultas
    public List<Entrega> getEntregas() {
        return Collections.unmodifiableList(entregas);
    }
}