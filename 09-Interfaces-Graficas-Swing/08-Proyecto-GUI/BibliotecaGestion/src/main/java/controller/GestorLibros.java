package controller;

import model.Categoria;
import model.Libro;

import java.util.ArrayList;

public class GestorLibros {

    // — Referencias
    private ArrayList<Libro> libros;
    private ArrayList<Categoria> categorias;

    // — Constructor
    public GestorLibros() {
        this.libros = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    // — Metodos de Entrada
    public void agregarCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria no puede ser nula");
        }
        categorias.add(categoria);
    }

    public void crearLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        validarDatos(libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getCategoria(), libro.getStock());
        validarIsbnRepetido(libro.getIsbn());
        libros.add(libro);
    }

    public void eliminarLibro(String isbn) {
        Libro libro = buscarPorIsbn(isbn);
        if (libro == null) {
            throw new IllegalArgumentException("El libro no existe");
        }
        libros.remove(libro);
    }

    public void editarLibro(String isbn, String titulo, String autor, Categoria categoria, int stock) {
        Libro libro = buscarPorIsbn(isbn);
        if (libro == null) {
            throw new IllegalArgumentException("El libro no existe");
        }
        validarDatos(isbn, titulo, autor, categoria, stock);
        libro.setTitulo(titulo.trim());
        libro.setAutor(autor.trim());
        libro.setCategoria(categoria);
        libro.setStock(stock);
    }

    // — Metodos de control
    private void validarDatos(String isbn, String titulo, String autor, Categoria categoria, int stock) {
        ValidadorDatos.isbn(isbn);
        ValidadorDatos.noVacio(titulo, "titulo");
        ValidadorDatos.noVacio(autor, "autor");
        if (categoria == null) {
            throw new IllegalArgumentException("Debe seleccionar una categoria");
        }
        ValidadorDatos.stock(stock);
    }

    private void validarIsbnRepetido(String isbn) {
        if (buscarPorIsbn(isbn) != null) {
            throw new IllegalArgumentException("Ya existe un libro con ese ISBN");
        }
    }

    // — Metodos de Salida
    public ArrayList<Libro> obtenerLibros() {
        return new ArrayList<>(libros);
    }

    public ArrayList<Categoria> obtenerCategorias() {
        return new ArrayList<>(categorias);
    }

    public Libro buscarPorIsbn(String isbn) {
        if (isbn == null) {
            return null;
        }
        String buscado = normalizarIsbn(isbn);
        for (Libro l : libros) {
            if (normalizarIsbn(l.getIsbn()).equals(buscado)) {
                return l;
            }
        }
        return null;
    }

    public ArrayList<Libro> buscarLibros(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return obtenerLibros();
        }
        String buscado = texto.trim().toLowerCase();
        String isbnBuscado = normalizarIsbn(buscado);

        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            boolean porIsbn = !isbnBuscado.isEmpty() && normalizarIsbn(l.getIsbn()).contains(isbnBuscado);
            if (porIsbn
                    || l.getTitulo().toLowerCase().contains(buscado)
                    || l.getAutor().toLowerCase().contains(buscado)
                    || l.getCategoria().getNombre().toLowerCase().contains(buscado)) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    // — Metodos Auxiliares
    private String normalizarIsbn(String isbn) {
        return isbn.replace("-", "").trim();
    }
}