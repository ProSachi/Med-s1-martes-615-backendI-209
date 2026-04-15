package app;

import model.Administrador;
import model.Cliente;
import model.Usuario;
import service.UsuarioGestor;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioGestor gestor = new UsuarioGestor();

        boolean ejecutar = true;
        while (ejecutar) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    crearAdministrador(scanner, gestor);
                    break;
                case 2:
                    crearCliente(scanner, gestor);
                    break;
                case 3:
                    listarUsuarios(gestor);
                    break;
                case 4:
                    actualizarUsuario(scanner, gestor);
                    break;
                case 5:
                    buscarUsuario(scanner, gestor);
                    break;
                case 6:
                    eliminarUsuario(scanner, gestor);
                    break;
                case 7:
                    demostrarPolimorfismo(gestor);
                    break;
                case 0:
                    ejecutar = false;
                    System.out.println("Aplicacion finalizada.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Simulador Frontend - Backend Usuarios ===");
        System.out.println("1. Crear administrador");
        System.out.println("2. Crear cliente");
        System.out.println("3. Listar usuarios");
        System.out.println("4. Actualizar nombre de usuario");
        System.out.println("5. Buscar usuario por ID");
        System.out.println("6. Eliminar usuario por ID");
        System.out.println("7. Demostrar polimorfismo");
        System.out.println("0. Salir");
    }

    private static void crearAdministrador(Scanner scanner, UsuarioGestor gestor) {
        int id = leerEntero(scanner, "ID: ");
        String nombre = leerTexto(scanner, "Nombre: ");
        String correo = leerTexto(scanner, "Correo: ");
        int nivelAcceso = leerEntero(scanner, "Nivel de acceso: ");

        Usuario admin = new Administrador(id, nombre, correo, nivelAcceso);
        gestor.guardar(admin);
        System.out.println("Administrador creado correctamente.");
    }

    private static void crearCliente(Scanner scanner, UsuarioGestor gestor) {
        int id = leerEntero(scanner, "ID: ");
        String nombre = leerTexto(scanner, "Nombre: ");
        String correo = leerTexto(scanner, "Correo: ");
        int puntos = leerEntero(scanner, "Puntos de fidelidad: ");

        Usuario cliente = new Cliente(id, nombre, correo, puntos);
        gestor.guardar(cliente);
        System.out.println("Cliente creado correctamente.");
    }

    private static void listarUsuarios(UsuarioGestor gestor) {
        List<Usuario> usuarios = gestor.listarTodos();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        System.out.println("\nUsuarios registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.resumen());
        }
        System.out.println("Total: " + gestor.totalUsuarios());
    }

    private static void actualizarUsuario(Scanner scanner, UsuarioGestor gestor) {
        int id = leerEntero(scanner, "ID del usuario a actualizar: ");
        String nuevoNombre = leerTexto(scanner, "Nuevo nombre: ");

        boolean actualizado = gestor.actualizarNombre(id, nuevoNombre);
        if (actualizado) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No existe usuario con ese ID.");
        }
    }

    private static void buscarUsuario(Scanner scanner, UsuarioGestor gestor) {
        int id = leerEntero(scanner, "ID a buscar: ");
        Usuario usuario = gestor.buscar(id);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.println("Encontrado: " + usuario.resumen());
    }

    private static void eliminarUsuario(Scanner scanner, UsuarioGestor gestor) {
        int id = leerEntero(scanner, "ID a eliminar: ");
        boolean eliminado = gestor.eliminar(id);

        if (eliminado) {
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("No existe usuario con ese ID.");
        }
    }

    private static void demostrarPolimorfismo(UsuarioGestor gestor) {
        List<Usuario> usuarios = gestor.listarTodos();
        if (usuarios.isEmpty()) {
            System.out.println("Agregue usuarios para ver el polimorfismo en accion.");
            return;
        }

        System.out.println("\nPolimorfismo: mismo metodo, diferentes comportamientos por tipo real:");
        for (Usuario usuario : usuarios) {
            saludarUsuario(usuario);
        }
    }

    private static void saludarUsuario(Usuario usuario) {
        System.out.println("Hola " + usuario.getNombre() + ", rol detectado: " + usuario.getRol());
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    private static String leerTexto(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println("El valor no puede estar vacio.");
        }
    }
}
