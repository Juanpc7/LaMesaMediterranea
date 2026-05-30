package vista;

import dao.MesaDAO;
import dto.Mesa;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaMesa {

    private Scanner sc;
    private MesaDAO mesaDAO;

    public VistaMesa() {
        sc = new Scanner(System.in);
        mesaDAO = new MesaDAO();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE MESAS ---");
            System.out.println("1. Insertar mesa");
            System.out.println("2. Listar mesas");
            System.out.println("3. Actualizar mesa");
            System.out.println("4. Eliminar mesa");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    insertarMesa();
                    break;
                case 2:
                    listarMesas();
                    break;
                case 3:
                    actualizarMesa();
                    break;
                case 4:
                    eliminarMesa();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private void insertarMesa() {

        int numero;
        do {
            System.out.print("Número de mesa: ");
            numero = sc.nextInt();

            if (numero <= 0) {
                System.out.println("El número debe ser mayor que 0.");
            }

        } while (numero <= 0);

        int capacidad;
        do {
            System.out.print("Capacidad: ");
            capacidad = sc.nextInt();
            sc.nextLine();

            if (capacidad <= 0) {
                System.out.println("La capacidad debe ser mayor que 0.");
            }

        } while (capacidad <= 0);

        String ubicacion;
        do {
            System.out.print("Ubicación: ");
            ubicacion = sc.nextLine();

            if (ubicacion.isBlank()) {
                System.out.println("La ubicación no puede estar vacía.");
            }

        } while (ubicacion.isBlank());

        String estado;
        do {
            System.out.print("Estado: ");
            estado = sc.nextLine();

            if (estado.isBlank()) {
                System.out.println("El estado no puede estar vacío.");
            }

        } while (estado.isBlank());

        Mesa mesa = new Mesa(
                numero,
                capacidad,
                ubicacion,
                estado
        );

        mesaDAO.insertarMesa(mesa);
    }

    private void listarMesas() {

        ArrayList<Mesa> mesas = mesaDAO.listarMesas();

        System.out.println("\nLISTADO DE MESAS");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-5s %-8s %-10s %-20s %-15s%n",
                "ID", "NÚMERO", "CAPACIDAD", "UBICACIÓN", "ESTADO");
        System.out.println("----------------------------------------------------------------");

        for (Mesa mesa : mesas) {
            System.out.println(mesa);
        }

        System.out.println("----------------------------------------------------------------");
    }

    private void actualizarMesa() {

        System.out.print("ID Mesa: ");
        int idMesa = sc.nextInt();

        int numero;
        do {
            System.out.print("Número: ");
            numero = sc.nextInt();

            if (numero <= 0) {
                System.out.println("El número debe ser mayor que 0.");
            }

        } while (numero <= 0);

        int capacidad;
        do {
            System.out.print("Capacidad: ");
            capacidad = sc.nextInt();
            sc.nextLine();

            if (capacidad <= 0) {
                System.out.println("La capacidad debe ser mayor que 0.");
            }

        } while (capacidad <= 0);

        String ubicacion;
        do {
            System.out.print("Ubicación: ");
            ubicacion = sc.nextLine();

            if (ubicacion.isBlank()) {
                System.out.println("La ubicación no puede estar vacía.");
            }

        } while (ubicacion.isBlank());

        String estado;
        do {
            System.out.print("Estado: ");
            estado = sc.nextLine();

            if (estado.isBlank()) {
                System.out.println("El estado no puede estar vacío.");
            }

        } while (estado.isBlank());

        Mesa mesa = new Mesa();

        mesa.setIdMesa(idMesa);
        mesa.setNumero(numero);
        mesa.setCapacidad(capacidad);
        mesa.setUbicacion(ubicacion);
        mesa.setEstado(estado);

        mesaDAO.actualizarMesa(mesa);
    }

    private void eliminarMesa() {

        System.out.print("ID Mesa: ");
        int idMesa = sc.nextInt();
        sc.nextLine();

        mesaDAO.eliminarMesa(idMesa);
    }
}