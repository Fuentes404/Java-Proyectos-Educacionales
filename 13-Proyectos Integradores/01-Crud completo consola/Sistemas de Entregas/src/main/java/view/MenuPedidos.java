package view;

import model.EstadoPedido;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.TipoPedido;
import services.ControladorPedidos;
import util.Consola;
import util.ValidadorDatos;

import java.util.ArrayList;
import java.util.List;

public class MenuPedidos {

    private final ControladorPedidos controlador;

    public MenuPedidos(ControladorPedidos controlador) {
        this.controlador = controlador;
    }

    // Muestra el menu hasta que el usuario elige volver
    public void mostrar() {
        int opcion;
        do {
            Consola.titulo("Gestión de Pedidos");
            Consola.mensaje("1. Listar pedidos");
            Consola.mensaje("2. Nuevo pedido");
            Consola.mensaje("3. Editar pedido");
            Consola.mensaje("4. Eliminar pedido");
            Consola.mensaje("5. Ver detalle de un pedido");
            Consola.mensaje("0. Volver");
            opcion = Consola.leerOpcion("Opción: ", 0, 5);

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
                case 5:
                    verDetalle();
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    // ---------- Listar ----------

    // Muestra todos los pedidos en una tabla, con los datos propios de cada tipo en "Detalle"
    public void listar() {
        List<Object[]> filas = new ArrayList<>();
        for (Pedido pedido : controlador.getPedidos()) {
            filas.add(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getTipoPedido(),
                    pedido.getCliente(),
                    pedido.getDireccion(),
                    pedido.getDistanciaKm(),
                    pedido.getEstado(),
                    detalleDe(pedido)
            });
        }
        Consola.imprimirTabla(new String[]{"ID", "Tipo", "Cliente", "Dirección",
                "Distancia (km)", "Estado", "Detalle"}, filas);
    }

    // Texto con los datos propios de cada tipo de pedido
    private String detalleDe(Pedido pedido) {
        if (pedido instanceof PedidoComida) {
            PedidoComida comida = (PedidoComida) pedido;
            return "Restaurante: " + comida.getRestaurante() +
                    ", Preparación: " + comida.getTiempoPreparacion();
        }
        if (pedido instanceof PedidoEncomienda) {
            PedidoEncomienda encomienda = (PedidoEncomienda) pedido;
            return "Peso: " + encomienda.getPeso() + " kg, Volumen: " + encomienda.getVolumen() + " m3";
        }
        PedidoExpress express = (PedidoExpress) pedido;
        return "Tienda: " + express.getTienda();
    }

    // ---------- Crear ----------

    // Pide el tipo de pedido, luego sus datos, y crea el pedido
    private void nuevo() {
        Consola.titulo("Nuevo pedido");
        TipoPedido tipo = elegirTipo();
        if (tipo == null) {
            return;
        }

        String[] d = pedirDatos(tipo, null);
        double distancia = ValidadorDatos.convertirADecimal(d[2]);

        // Cada tipo se crea con sus propios datos
        switch (tipo) {
            case COMIDA:
                controlador.crearComida(d[0], d[1], distancia, d[3], d[4]);
                break;
            case ENCOMIENDA:
                controlador.crearEncomienda(d[0], d[1], distancia,
                        ValidadorDatos.convertirADecimal(d[3]),
                        ValidadorDatos.convertirADecimal(d[4]));
                break;
            default:
                controlador.crearExpress(d[0], d[1], distancia, d[3]);
        }
        Consola.exito("Pedido creado.");
    }

    // ---------- Editar ----------

    // Edita el pedido elegido, el formulario depende del tipo del pedido
    private void editar() {
        Pedido pedido = elegirPedido();
        if (pedido == null) {
            return;
        }

        // Se avisa antes de pedir los datos, el controlador tambien valida esto
        String errorEstado = controlador.validarEditable(pedido);
        if (errorEstado != null) {
            Consola.aviso(errorEstado);
            return;
        }

        int id = pedido.getIdPedido();
        TipoPedido tipo = pedido.getTipoPedido();

        Consola.mensaje("(Enter mantiene el valor actual)");
        String[] d = pedirDatos(tipo, valoresActuales(pedido));
        double distancia = ValidadorDatos.convertirADecimal(d[2]);

        // Cada tipo se edita con sus propios datos
        String error;
        switch (tipo) {
            case COMIDA:
                error = controlador.editarComida(id, d[0], d[1], distancia, d[3], d[4]);
                break;
            case ENCOMIENDA:
                error = controlador.editarEncomienda(id, d[0], d[1], distancia,
                        ValidadorDatos.convertirADecimal(d[3]),
                        ValidadorDatos.convertirADecimal(d[4]));
                break;
            default:
                error = controlador.editarExpress(id, d[0], d[1], distancia, d[3]);
        }

        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.exito("Pedido actualizado.");
        }
    }

    // ---------- Eliminar ----------

    // Elimina el pedido elegido previa confirmacion
    private void eliminar() {
        Pedido pedido = elegirPedido();
        if (pedido == null) {
            return;
        }

        if (!Consola.confirmar("¿Eliminar el pedido N° " + pedido.getIdPedido() +
                "? Si tiene una entrega registrada, también se eliminará.")) {
            return;
        }

        String error = controlador.eliminar(pedido.getIdPedido());
        if (error != null) {
            Consola.aviso(error);
        } else {
            Consola.exito("Pedido eliminado.");
        }
    }

    // ---------- Detalle ----------

    // Muestra el resumen del pedido y su tiempo estimado (polimorfismo segun el tipo)
    private void verDetalle() {
        Pedido pedido = elegirPedido();
        if (pedido == null) {
            return;
        }

        Consola.titulo("Detalle del pedido");
        Consola.mensaje(pedido.mostrarResumen());
        Consola.mensaje("Tiempo estimado de entrega: " + pedido.calcularTiempoEntrega() + " min");
        Consola.mensaje(pedido.asignarRepartidor());
    }

    // ---------- Formulario ----------

    // Pide el tipo de pedido, devuelve null si cancela
    private TipoPedido elegirTipo() {
        Consola.mensaje("1. Comida");
        Consola.mensaje("2. Encomienda");
        Consola.mensaje("3. Express");
        Consola.mensaje("0. Cancelar");
        int opcion = Consola.leerOpcion("Tipo de pedido: ", 0, 3);
        switch (opcion) {
            case 1:
                return TipoPedido.COMIDA;
            case 2:
                return TipoPedido.ENCOMIENDA;
            case 3:
                return TipoPedido.EXPRESS;
            default:
                return null;
        }
    }

    // Etiquetas del formulario segun el tipo: primero los datos base y luego los propios
    private String[] etiquetasDe(TipoPedido tipo) {
        switch (tipo) {
            case COMIDA:
                return new String[]{"Cliente", "Dirección", "Distancia (km)",
                        "Restaurante", "Tiempo de preparación"};
            case ENCOMIENDA:
                return new String[]{"Cliente", "Dirección", "Distancia (km)",
                        "Peso (kg)", "Volumen (m3)"};
            default:
                return new String[]{"Cliente", "Dirección", "Distancia (km)", "Tienda"};
        }
    }

    // Valores actuales del pedido para llenar el formulario de edicion
    private String[] valoresActuales(Pedido pedido) {
        String[] valores = new String[etiquetasDe(pedido.getTipoPedido()).length];

        // Datos base: cliente, direccion y distancia
        valores[0] = pedido.getCliente();
        valores[1] = pedido.getDireccion();
        valores[2] = String.valueOf(pedido.getDistanciaKm());

        // Datos propios del tipo
        if (pedido instanceof PedidoComida) {
            valores[3] = ((PedidoComida) pedido).getRestaurante();
            valores[4] = ((PedidoComida) pedido).getTiempoPreparacion();
        } else if (pedido instanceof PedidoEncomienda) {
            valores[3] = String.valueOf(((PedidoEncomienda) pedido).getPeso());
            valores[4] = String.valueOf(((PedidoEncomienda) pedido).getVolumen());
        } else {
            valores[3] = ((PedidoExpress) pedido).getTienda();
        }
        return valores;
    }

    // Pide cada dato del formulario y lo valida al momento
    private String[] pedirDatos(TipoPedido tipo, String[] iniciales) {
        String[] etiquetas = etiquetasDe(tipo);
        String[] datos = new String[etiquetas.length];

        for (int i = 0; i < etiquetas.length; i++) {
            final int indice = i;
            String actual = (iniciales == null) ? null : iniciales[i];
            datos[i] = Consola.leerCampo(etiquetas[i], valor -> validar(tipo, indice, valor), actual);
        }
        return datos;
    }

    // Valida un campo del formulario segun su posicion y el tipo de pedido
    private String validar(TipoPedido tipo, int indice, String valor) {
        String campo = etiquetasDe(tipo)[indice];

        // Datos base
        if (indice == 0) {
            return ValidadorDatos.validarNombre(valor, campo);
        }
        if (indice == 1) {
            return ValidadorDatos.validarTextoObligatorio(valor, campo);
        }
        if (indice == 2) {
            return ValidadorDatos.validarNumeroPositivo(valor, campo);
        }

        // Datos propios del tipo: en encomienda son numeros, en los demas texto
        if (tipo == TipoPedido.ENCOMIENDA) {
            return ValidadorDatos.validarNumeroPositivo(valor, campo);
        }
        return ValidadorDatos.validarTextoObligatorio(valor, campo);
    }

    // ---------- Auxiliar ----------

    // Muestra la lista y pide el ID, devuelve null si no hay pedidos o el ID no existe
    private Pedido elegirPedido() {
        String error = ValidadorDatos.validarLista(controlador.getPedidos());
        if (error != null) {
            Consola.aviso(error);
            return null;
        }

        listar();
        int id = Consola.leerEntero("ID del pedido");
        Pedido pedido = controlador.buscarPorId(id);
        if (pedido == null) {
            Consola.aviso("El pedido no existe.");
        }
        return pedido;
    }
}