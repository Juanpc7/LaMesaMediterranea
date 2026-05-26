package main;

import dao.ClienteDAO;
import modelo.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ClienteDAO clienteDAO = new ClienteDAO();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    insertarCliente();
                    break;

                case 2:

                    listarClientes();
                    break;

                case 3:

                    actualizarCliente();
                    break;

                case 4:

                    eliminarCliente();
                    break;

                case 5:

                    System.out.println("Saliendo del programa...");
                    break;

            }

        } while (opcion != 3);

    }

    public static void mostrarMenu() {

        System.out.println("\n===== LA MESA MEDITERRÁNEA =====");
        System.out.println("1. Insertar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Actualizar cliente");
        System.out.println("4. Eliminar cliente");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

    }

    public static void insertarCliente() {

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente(
                dni,
                nombre,
                telefono,
                correo,
                direccion
        );

        clienteDAO.insertarCliente(cliente);

    }

    public static void listarClientes() {

        ArrayList<Cliente> clientes = clienteDAO.listarClientes();

        for (Cliente cliente : clientes) {

            System.out.println(cliente);

        }

    }
    public static void actualizarCliente() {

        System.out.print("ID del cliente a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nuevo teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Nuevo correo: ");
        String correo = sc.nextLine();

        System.out.print("Nueva dirección: ");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente();

        cliente.setIdCliente(id);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setDireccion(direccion);

        clienteDAO.actualizarCliente(cliente);

    }
    public static void eliminarCliente() {

        System.out.print("ID del cliente a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        clienteDAO.eliminarCliente(id);

    }
}