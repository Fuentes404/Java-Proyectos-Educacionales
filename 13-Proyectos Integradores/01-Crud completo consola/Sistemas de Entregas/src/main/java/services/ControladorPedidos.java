package services;

import model.EstadoPedido;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorPedidos {

    // Lista que guarda todos los pedidos, sin importar su tipo
    private final List<Pedido> pedidos = new ArrayList<>();

    // Contador de IDs mientras no exista la base de datos
    private int siguienteId = 1;

    // Controlador de entregas, se conecta desde el menu principal
    private ControladorEntregas controladorEntregas;

    // Conecta el controlador de entregas
    public void setControladorEntregas(ControladorEntregas controladorEntregas) {
        this.controladorEntregas = controladorEntregas;
    }

    // ---------- Crear ----------

    // Crea un pedido de comida
    public PedidoComida crearComida(String cliente, String direccion, double distanciaKm,
                                    String restaurante, String tiempoPreparacion) {
        PedidoComida pedido = new PedidoComida(siguienteId++, cliente, direccion,
                distanciaKm, restaurante, tiempoPreparacion);
        pedidos.add(pedido);
        return pedido;
    }

    // Crea un pedido de encomienda
    public PedidoEncomienda crearEncomienda(String cliente, String direccion, double distanciaKm,
                                            double peso, double volumen) {
        PedidoEncomienda pedido = new PedidoEncomienda(siguienteId++, cliente, direccion,
                distanciaKm, peso, volumen);
        pedidos.add(pedido);
        return pedido;
    }

    // Crea un pedido express
    public PedidoExpress crearExpress(String cliente, String direccion, double distanciaKm,
                                      String tienda) {
        PedidoExpress pedido = new PedidoExpress(siguienteId++, cliente, direccion,
                distanciaKm, tienda);
        pedidos.add(pedido);
        return pedido;
    }

    // ---------- Editar ----------

    // Edita un pedido de comida, devuelve el error o null si todo salio bien
    public String editarComida(int id, String cliente, String direccion, double distanciaKm,
                               String restaurante, String tiempoPreparacion) {
        Pedido pedido = buscarPorId(id);
        String error = validarEditable(pedido);
        if (error != null) {
            return error;
        }
        if (!(pedido instanceof PedidoComida)) {
            return "El pedido no es de tipo comida.";
        }
        PedidoComida comida = (PedidoComida) pedido;
        actualizarBase(comida, cliente, direccion, distanciaKm);
        comida.setRestaurante(restaurante);
        comida.setTiempoPreparacion(tiempoPreparacion);
        return null;
    }

    // Edita un pedido de encomienda, devuelve el error o null si todo salio bien
    public String editarEncomienda(int id, String cliente, String direccion, double distanciaKm,
                                   double peso, double volumen) {
        Pedido pedido = buscarPorId(id);
        String error = validarEditable(pedido);
        if (error != null) {
            return error;
        }
        if (!(pedido instanceof PedidoEncomienda)) {
            return "El pedido no es de tipo encomienda.";
        }
        PedidoEncomienda encomienda = (PedidoEncomienda) pedido;
        actualizarBase(encomienda, cliente, direccion, distanciaKm);
        encomienda.setPeso(peso);
        encomienda.setVolumen(volumen);
        return null;
    }

    // Edita un pedido express, devuelve el error o null si todo salio bien
    public String editarExpress(int id, String cliente, String direccion, double distanciaKm,
                                String tienda) {
        Pedido pedido = buscarPorId(id);
        String error = validarEditable(pedido);
        if (error != null) {
            return error;
        }
        if (!(pedido instanceof PedidoExpress)) {
            return "El pedido no es de tipo express.";
        }
        PedidoExpress express = (PedidoExpress) pedido;
        actualizarBase(express, cliente, direccion, distanciaKm);
        express.setTienda(tienda);
        return null;
    }

    // Revisa que el pedido se pueda modificar, devuelve el error o null si se puede
    public String validarEditable(Pedido pedido) {
        if (pedido == null) {
            return "El pedido no existe.";
        }
        // Un pedido entregado queda congelado con sus datos
        if (pedido.getEstado() == EstadoPedido.ENTREGADO) {
            return "Un pedido entregado no se puede modificar.";
        }
        if (pedido.getEstado() == EstadoPedido.EN_REPARTO) {
            return "No se puede modificar un pedido que está en reparto.";
        }
        return null;
    }

    // Actualiza los datos que comparten todos los tipos de pedido
    private void actualizarBase(Pedido pedido, String cliente, String direccion, double distanciaKm) {
        pedido.setCliente(cliente);
        pedido.setDireccion(direccion);
        pedido.setDistanciaKm(distanciaKm);
    }

    // ---------- Eliminar ----------

    // Elimina un pedido de la lista, devuelve el error o null si todo salio bien
    public String eliminar(int id) {
        Pedido pedido = buscarPorId(id);
        if (pedido == null) {
            return "El pedido no existe.";
        }
        if (pedido.getEstado() == EstadoPedido.EN_REPARTO) {
            return "No se puede eliminar: el pedido está en reparto.";
        }
        // Un pedido pendiente con entrega ya esta asignado a un repartidor
        if (pedido.getEstado() == EstadoPedido.PENDIENTE
                && controladorEntregas.buscarPorPedido(id) != null) {
            return "No se puede eliminar: el pedido ya está asignado a un repartidor.";
        }
        // Los pedidos entregados y cancelados se eliminan junto con su entrega
        controladorEntregas.eliminarPorPedido(id);
        pedidos.remove(pedido);
        return null;
    }

    // ---------- Consultas ----------

    // Busca un pedido por su ID, devuelve null si no existe
    public Pedido buscarPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == id) {
                return pedido;
            }
        }
        return null;
    }

    // Lista de solo lectura para consultas
    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }
}