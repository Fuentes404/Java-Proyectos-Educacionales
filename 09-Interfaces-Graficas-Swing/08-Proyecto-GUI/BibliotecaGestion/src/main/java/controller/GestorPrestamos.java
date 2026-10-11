package controller;

import model.Estudiante;
import model.Libro;
import model.Prestamo;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestorPrestamos {

    // — Referencias
    private ArrayList<Prestamo> prestamos;
    private final GestorUsuarios gestorUsuarios;
    private final GestorLibros gestorLibros;

    // — Constructor
    public GestorPrestamos(GestorUsuarios gestorUsuarios, GestorLibros gestorLibros) {
        this.prestamos = new ArrayList<>();
        this.gestorUsuarios = gestorUsuarios;
        this.gestorLibros = gestorLibros;
    }

    // — Metodos de Entrada
    public void crearPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El prestamo no puede ser nulo");
        }
        validarIdRepetido(prestamo.getIdPrestamo());
        Estudiante estudiante = validarEstudianteExiste(prestamo.getEstudiante());
        Libro libro = validarLibroExiste(prestamo.getLibro());
        ValidadorDatos.fechas(prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion());
        validarStockDisponible(libro);
        validarPrestamoActivoRepetido(estudiante, libro);

        libro.setStock(libro.getStock() - 1);
        prestamos.add(prestamo);
    }

    public void editarPrestamo(int idPrestamo, LocalDate fechaDevolucion) {
        Prestamo prestamo = buscarPorId(idPrestamo);
        if (prestamo == null) {
            throw new IllegalArgumentException("El prestamo no existe");
        }
        if (prestamo.isDevuelto()) {
            throw new IllegalArgumentException("No se puede editar un prestamo ya devuelto");
        }
        ValidadorDatos.fechas(prestamo.getFechaPrestamo(), fechaDevolucion);
        prestamo.setFechaDevolucion(fechaDevolucion);
    }

    public void registrarDevolucion(int idPrestamo) {
        Prestamo prestamo = buscarPorId(idPrestamo);
        if (prestamo == null) {
            throw new IllegalArgumentException("El prestamo no existe");
        }
        if (prestamo.isDevuelto()) {
            throw new IllegalArgumentException("El prestamo ya fue devuelto");
        }
        prestamo.setDevuelto(true);
        reponerStock(prestamo.getLibro());
    }

    public void eliminarPrestamo(int idPrestamo) {
        Prestamo prestamo = buscarPorId(idPrestamo);
        if (prestamo == null) {
            throw new IllegalArgumentException("El prestamo no existe");
        }
        if (!prestamo.isDevuelto()) {
            reponerStock(prestamo.getLibro());
        }
        prestamos.remove(prestamo);
    }

    // — Metodos de control
    private void validarIdRepetido(int idPrestamo) {
        if (buscarPorId(idPrestamo) != null) {
            throw new IllegalArgumentException("Ya existe un prestamo con ese ID");
        }
    }

    private Estudiante validarEstudianteExiste(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("Debe seleccionar un estudiante");
        }
        Usuario existente = gestorUsuarios.buscarPorId(estudiante.getIdUsuario());
        if (!(existente instanceof Estudiante)) {
            throw new IllegalArgumentException("El estudiante no existe");
        }
        return (Estudiante) existente;
    }

    private Libro validarLibroExiste(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("Debe seleccionar un libro");
        }
        Libro existente = gestorLibros.buscarPorIsbn(libro.getIsbn());
        if (existente == null) {
            throw new IllegalArgumentException("El libro no existe");
        }
        return existente;
    }

    private void validarStockDisponible(Libro libro) {
        if (libro.getStock() <= 0) {
            throw new IllegalArgumentException("No hay stock disponible de ese libro");
        }
    }

    private void validarPrestamoActivoRepetido(Estudiante estudiante, Libro libro) {
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()
                    && p.getEstudiante().getIdUsuario() == estudiante.getIdUsuario()
                    && p.getLibro().getIsbn().equals(libro.getIsbn())) {
                throw new IllegalArgumentException("El estudiante ya tiene ese libro en prestamo");
            }
        }
    }

    // — Metodos de Salida
    public ArrayList<Prestamo> obtenerPrestamos() {
        return new ArrayList<>(prestamos);
    }

    public ArrayList<Prestamo> obtenerPrestamosActivos() {
        ArrayList<Prestamo> activos = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()) {
                activos.add(p);
            }
        }
        return activos;
    }

    public ArrayList<Prestamo> obtenerPrestamosEstudiante(int idUsuario) {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.getEstudiante().getIdUsuario() == idUsuario) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public ArrayList<Prestamo> buscarPrestamos(ArrayList<Prestamo> base, String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return new ArrayList<>(base);
        }
        String buscado = texto.trim().toLowerCase();

        ArrayList<Prestamo> resultado = new ArrayList<>();
        for (Prestamo p : base) {
            if (p.getEstudiante().getNombre().toLowerCase().contains(buscado)
                    || p.getLibro().getTitulo().toLowerCase().contains(buscado)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public int contarPrestamosLibro(String isbn) {
        int total = 0;
        for (Prestamo p : prestamos) {
            if (p.getLibro().getIsbn().equals(isbn)) {
                total++;
            }
        }
        return total;
    }

    public int contarActivos(String isbn) {
        int total = 0;
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto() && p.getLibro().getIsbn().equals(isbn)) {
                total++;
            }
        }
        return total;
    }

    public int contarActivos(int idUsuario) {
        int total = 0;
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto() && p.getEstudiante().getIdUsuario() == idUsuario) {
                total++;
            }
        }
        return total;
    }

    public Prestamo buscarPorId(int idPrestamo) {
        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo() == idPrestamo) {
                return p;
            }
        }
        return null;
    }

    public int generarId() {
        int max = 0;
        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo() > max) {
                max = p.getIdPrestamo();
            }
        }
        return max + 1;
    }

    public boolean puedeGestionarPrestamos() {
        return hayEstudiantes() && !gestorLibros.obtenerLibros().isEmpty();
    }

    // — Metodos Auxiliares
    private boolean hayEstudiantes() {
        for (Usuario u : gestorUsuarios.obtenerUsuarios()) {
            if (u instanceof Estudiante) {
                return true;
            }
        }
        return false;
    }

    private void reponerStock(Libro libro) {
        Libro existente = gestorLibros.buscarPorIsbn(libro.getIsbn());
        if (existente != null) {
            existente.setStock(existente.getStock() + 1);
        }
    }
}