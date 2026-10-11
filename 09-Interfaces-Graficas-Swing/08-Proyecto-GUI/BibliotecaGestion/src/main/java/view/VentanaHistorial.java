package view;

import controller.GestorPrestamos;
import model.Prestamo;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaHistorial extends JDialog {

    // - Atributos
    private JPanel panelBotones;
    private JButton btnCerrar;

    // - Tabla
    private JTable tablaHistorial;
    private DefaultTableModel modeloTabla;
    private JScrollPane scrollTabla;

    // - Dependencias
    private final Usuario usuario;
    private final GestorPrestamos gestorPrestamos;

    // - Constructor
    public VentanaHistorial(Window padre, Usuario usuario, GestorPrestamos gestorPrestamos) {
        super(padre, "Historial de " + usuario.getNombre(), ModalityType.APPLICATION_MODAL);
        this.usuario = usuario;
        this.gestorPrestamos = gestorPrestamos;

        configurarVentana();
        inicializarComponentes();
        configurarDiseno();
        configurarEventos();
        cargarTabla();
    }

    private void configurarVentana() {
        setSize(650, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setResizable(false);
    }

    private void inicializarComponentes() {
        panelBotones = new JPanel(new FlowLayout());
        btnCerrar = new JButton("Cerrar");

        // Tabla (celdas no editables)
        String[] columnas = {"ID Prestamo", "Libro", "Fecha Prestamo", "Fecha Devolucion", "Devuelto"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tablaHistorial = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaHistorial);
    }

    private void configurarDiseno() {
        scrollTabla.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        tablaHistorial.setRowHeight(25);
        tablaHistorial.getTableHeader().setReorderingAllowed(false);

        panelBotones.add(btnCerrar);

        add(scrollTabla, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        btnCerrar.addActionListener(e -> dispose());
    }

    // - Controladores
    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        for (Prestamo p : gestorPrestamos.obtenerPrestamosEstudiante(usuario.getIdUsuario())) {
            modeloTabla.addRow(new Object[]{
                    p.getIdPrestamo(),
                    p.getLibro().getTitulo(),
                    p.getFechaPrestamo(),
                    p.getFechaDevolucion(),
                    p.isDevuelto() ? "Si" : "No"
            });
        }
    }
}