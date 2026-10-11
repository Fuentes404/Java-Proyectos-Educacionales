package controller;

import model.Estudiante;
import model.Usuario;

import java.util.ArrayList;

public class GestorUsuarios {

    // — Referencias
    private ArrayList<Usuario> usuarios;

    // — Constructor
    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    // — Metodos de Entrada
    public void crearUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        String curso = (usuario instanceof Estudiante) ? ((Estudiante) usuario).getCurso() : null;
        validarDatos(usuario.getNombre(), usuario.getRut(), usuario.getCorreo(),
                usuario instanceof Estudiante, curso);
        ValidadorDatos.contrasena(usuario.getContrasena());
        validarIdRepetido(usuario.getIdUsuario());
        validarCorreoRepetido(usuario.getCorreo(), usuario.getIdUsuario());
        validarRutRepetido(usuario.getRut(), usuario.getIdUsuario());

        usuario.setNombre(usuario.getNombre().trim());
        usuario.setRut(usuario.getRut().trim());
        usuario.setCorreo(usuario.getCorreo().trim());
        if (usuario instanceof Estudiante) {
            ((Estudiante) usuario).setCurso(curso.trim());
        }
        usuarios.add(usuario);
    }

    public void editarUsuario(int idUsuario, String nombre, String rut, String correo, String curso) {
        Usuario usuario = buscarPorId(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        boolean esEstudiante = usuario instanceof Estudiante;
        validarDatos(nombre, rut, correo, esEstudiante, curso);
        validarCorreoRepetido(correo, idUsuario);
        validarRutRepetido(rut, idUsuario);

        usuario.setNombre(nombre.trim());
        usuario.setRut(rut.trim());
        usuario.setCorreo(correo.trim());
        if (esEstudiante) {
            ((Estudiante) usuario).setCurso(curso.trim());
        }
    }

    public void eliminarUsuario(int idUsuario) {
        Usuario usuario = buscarPorId(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        usuarios.remove(usuario);
    }

    public void cambiarContrasena(Usuario usuario, String antigua, String nueva, String confirmacion) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        if (!usuario.getContrasena().equals(antigua)) {
            throw new IllegalArgumentException("La contraseña antigua no es correcta");
        }
        if (!nueva.equals(confirmacion)) {
            throw new IllegalArgumentException("La nueva contraseña y la confirmacion no coinciden");
        }
        ValidadorDatos.contrasena(nueva);
        usuario.setContrasena(nueva);
    }

    // — Metodos de control
    private void validarDatos(String nombre, String rut, String correo, boolean esEstudiante, String curso) {
        ValidadorDatos.nombre(nombre);
        ValidadorDatos.rut(rut);
        ValidadorDatos.correo(correo);
        if (esEstudiante) {
            ValidadorDatos.curso(curso);
        }
    }

    private void validarIdRepetido(int idUsuario) {
        if (buscarPorId(idUsuario) != null) {
            throw new IllegalArgumentException("Ya existe un usuario con ese ID");
        }
    }

    private void validarCorreoRepetido(String correo, int idExcluido) {
        Usuario existente = buscarCorreo(correo);
        if (existente != null && existente.getIdUsuario() != idExcluido) {
            throw new IllegalArgumentException("Ya existe un usuario con ese correo");
        }
    }

    private void validarRutRepetido(String rut, int idExcluido) {
        String buscado = normalizarRut(rut);
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() != idExcluido && normalizarRut(u.getRut()).equals(buscado)) {
                throw new IllegalArgumentException("Ya existe un usuario con ese RUT");
            }
        }
    }

    // — Metodos de Salida
    public ArrayList<Usuario> obtenerUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public Usuario buscarPorId(int idUsuario) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == idUsuario) {
                return u;
            }
        }
        return null;
    }

    public int generarId() {
        int max = 0;
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() > max) {
                max = u.getIdUsuario();
            }
        }
        return max + 1;
    }

    public Usuario autentificar(String correo, String contrasena) {
        Usuario usuario = buscarCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }
        return null;
    }

    // — Metodos Auxiliares
    private Usuario buscarCorreo(String correo) {
        if (correo == null) {
            return null;
        }
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo.trim())) {
                return u;
            }
        }
        return null;
    }

    private String normalizarRut(String rut) {
        return rut.replace(".", "").trim().toUpperCase();
    }
}