package main;

import model.Usuario;
import model.UsuarioAdmin;
import model.UsuarioCliente;

public class Main {
    static void main() {
        // Instancias
        Usuario cliente = new UsuarioCliente(1,"Alejandro", "Perez", 25, "alejandro@correo.com", "123456");
        Usuario admin = new UsuarioAdmin(2, "Juan", "uno", 40, "juan@correo.com", "123456");

        // Prueba metodos
        cliente.mostrarInformacion();
        admin.mostrarInformacion();

        // metodos representativos
        System.out.println(cliente.getRol());
        System.out.println(admin.getRol());
    }
}
