package vista;

import dao.ClienteDAO;
import dto.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaCliente {

    private Scanner sc;
    private ClienteDAO clienteDAO;

    public VistaCliente() {
        sc = new Scanner(System.in);
        clienteDAO = new ClienteDAO();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

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
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private void insertarCliente() {

        String dni;
        do {
            System.out.print("DNI: ");
            dni = sc.nextLine();

            if (dni.length() != 9) {
                System.out.println("El DNI debe tener 9 caracteres.");
            }

        } while (dni.length() != 9);

        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isBlank());

        String telefono;
        do {
            System.out.print("Teléfono: ");
            telefono = sc.nextLine();

            if (telefono.length() != 9) {
                System.out.println("El teléfono debe tener 9 dígitos.");
            }

        } while (telefono.length() != 9);

        String correo;
        do {
            System.out.print("Correo: ");
            correo = sc.nextLine();

            if (!correo.contains("@") || !correo.contains(".")) {
                System.out.println("Correo no válido.");
            }

        } while (!correo.contains("@") || !correo.contains("."));

        String direccion;
        do {
            System.out.print("Dirección: ");
            direccion = sc.nextLine();

            if (direccion.isBlank()) {
                System.out.println("La dirección no puede estar vacía.");
            }

        } while (direccion.isBlank());

        Cliente cliente = new Cliente(
                dni,
                nombre,
                telefono,
                correo,
                direccion
        );

        clienteDAO.insertarCliente(cliente);
    }

    private void listarClientes() {

        ArrayList<Cliente> clientes = clienteDAO.listarClientes();

        System.out.println("\nLISTADO DE CLIENTES");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-12s %-20s %-15s %-30s %-25s%n",
                "ID", "DNI", "NOMBRE", "TELÉFONO", "CORREO", "DIRECCIÓN");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    private void actualizarCliente() {

        System.out.print("ID Cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();

        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isBlank());

        String telefono;
        do {
            System.out.print("Teléfono: ");
            telefono = sc.nextLine();

            if (telefono.length() != 9) {
                System.out.println("El teléfono debe tener 9 dígitos.");
            }

        } while (telefono.length() != 9);

        String correo;
        do {
            System.out.print("Correo: ");
            correo = sc.nextLine();

            if (!correo.contains("@") || !correo.contains(".")) {
                System.out.println("Correo no válido.");
            }

        } while (!correo.contains("@") || !correo.contains("."));

        String direccion;
        do {
            System.out.print("Dirección: ");
            direccion = sc.nextLine();

            if (direccion.isBlank()) {
                System.out.println("La dirección no puede estar vacía.");
            }

        } while (direccion.isBlank());

        Cliente cliente = new Cliente();

        cliente.setIdCliente(idCliente);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setDireccion(direccion);

        clienteDAO.actualizarCliente(cliente);
    }

    private void eliminarCliente() {

        System.out.print("ID Cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();

        clienteDAO.eliminarCliente(idCliente);
    }
}