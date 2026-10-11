package app;

import controller.GestorLibros;
import controller.GestorPrestamos;
import controller.GestorUsuarios;
import model.*;
import view.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // - Usuarios
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        gestorUsuarios.crearUsuario(new Bibliotecario(1, "Claudio", "11111111-1", "claudio@correo.com", "123456"));
        gestorUsuarios.crearUsuario(new Estudiante(2, "Ana", "22222222-2", "ana@correo.com", "123456", "3°A"));
        gestorUsuarios.crearUsuario(new Estudiante(3, "Pedro Soto", "12345678-5", "pedro@correo.com", "123456", "1°A"));
        gestorUsuarios.crearUsuario(new Estudiante(4, "Maria Rojas", "13456789-K", "maria@correo.com", "123456", "2°B"));
        gestorUsuarios.crearUsuario(new Estudiante(5, "Juan Perez", "14567890-1", "juan@correo.com", "123456", "3°B"));
        gestorUsuarios.crearUsuario(new Estudiante(6, "Camila Diaz", "15678901-2", "camila@correo.com", "123456", "4°A"));
        gestorUsuarios.crearUsuario(new Estudiante(7, "Diego Muñoz", "16789012-3", "diego@correo.com", "123456", "4°B"));

        // - Libros
        GestorLibros gestorLibros = new GestorLibros();

        Categoria novela = new Categoria(1, "Novela");
        Categoria accion = new Categoria(2, "Accion");
        Categoria teatro = new Categoria(3, "Teatro");
        Categoria ciencias = new Categoria(4, "Ciencias");
        Categoria historia = new Categoria(5, "Historia");

        gestorLibros.agregarCategoria(novela);
        gestorLibros.agregarCategoria(accion);
        gestorLibros.agregarCategoria(teatro);
        gestorLibros.agregarCategoria(ciencias);
        gestorLibros.agregarCategoria(historia);

        gestorLibros.crearLibro(new Libro("9780000000011", "El misterio sin resolver", "Luis Pato", novela, 5));
        gestorLibros.crearLibro(new Libro("9780000000028", "Cartas anonimas", "Benjamin Pulpo", novela, 4));
        gestorLibros.crearLibro(new Libro("9780000000035", "La casa de las sombras", "Luisa Gato", novela, 3));
        gestorLibros.crearLibro(new Libro("9780000000042", "Mision en la selva", "Tomas Zorro", accion, 6));
        gestorLibros.crearLibro(new Libro("9780000000059", "Carrera contra el tiempo", "Marta Lobo", accion, 7));
        gestorLibros.crearLibro(new Libro("9780000000066", "El maniqui rojo", "Luis Pato", teatro, 4));
        gestorLibros.crearLibro(new Libro("9780000000073", "Una noche de estreno", "Clara gato", teatro, 5));
        gestorLibros.crearLibro(new Libro("9780000000080", "Los secretos del atomo", "Benjamin Pulpo", ciencias, 2));
        gestorLibros.crearLibro(new Libro("9780000000097", "Viaje al fondo del mar", "Elena Foca", ciencias, 3));
        gestorLibros.crearLibro(new Libro("9780000000103", "Cronicas de un imperio", "Andres Oso", historia, 2));

        // - Prestamos
        GestorPrestamos gestorPrestamos = new GestorPrestamos(gestorUsuarios, gestorLibros);

        SwingUtilities.invokeLater(() ->
                new VentanaLogin(gestorUsuarios, gestorLibros, gestorPrestamos).setVisible(true));
    }
}