package vista;

import dao.ReservaPedidoDAO;
import dto.Cliente;
import dto.Empleado;
import dto.Mesa;
import dto.ReservaPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaReservaPedido {

    private Scanner sc;
    private ReservaPedidoDAO reservaPedidoDAO;

    public VistaReservaPedido() {
        sc = new Scanner(System.in);
        reservaPedidoDAO = new ReservaPedidoDAO();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE RESERVAS/PEDIDOS ---");
            System.out.println("1. Insertar reserva/pedido");
            System.out.println("2. Listar reservas/pedidos");
            System.out.println("3. Actualizar reserva/pedido");
            System.out.println("4. Eliminar reserva/pedido");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    insertarReservaPedido();
                    break;
                case 2:
                    listarReservasPedidos();
                    break;
                case 3:
                    actualizarReservaPedido();
                    break;
                case 4:
                    eliminarReservaPedido();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private void insertarReservaPedido() {

        int idCliente;
        do {
            System.out.print("ID Cliente: ");
            idCliente = sc.nextInt();

            if (idCliente <= 0) {
                System.out.println("El ID del cliente debe ser mayor que 0.");
            }

        } while (idCliente <= 0);

        int idEmpleado;
        do {
            System.out.print("ID Empleado: ");
            idEmpleado = sc.nextInt();

            if (idEmpleado <= 0) {
                System.out.println("El ID del empleado debe ser mayor que 0.");
            }

        } while (idEmpleado <= 0);

        int idMesa;
        do {
            System.out.print("ID Mesa: ");
            idMesa = sc.nextInt();

            if (idMesa <= 0) {
                System.out.println("El ID de la mesa debe ser mayor que 0.");
            }

        } while (idMesa <= 0);

        double importeTotal;
        do {
            System.out.print("Importe total: ");
            importeTotal = sc.nextDouble();
            sc.nextLine();

            if (importeTotal < 0) {
                System.out.println("El importe no puede ser negativo.");
            }

        } while (importeTotal < 0);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);

        Mesa mesa = new Mesa();
        mesa.setIdMesa(idMesa);

        ReservaPedido reserva = new ReservaPedido(
                LocalDateTime.now(),
                importeTotal,
                cliente,
                empleado,
                mesa
        );

        reservaPedidoDAO.insertarReservaPedido(reserva);
    }

    private void listarReservasPedidos() {

        ArrayList<ReservaPedido> reservas = reservaPedidoDAO.listarReservasPedidos();

        System.out.println("\nLISTADO DE RESERVAS/PEDIDOS");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-20s %-15s %-10s%n",
                "ID", "CLIENTE", "EMPLEADO", "MESA", "IMPORTE");
        System.out.println("--------------------------------------------------------------------------------");

        for (ReservaPedido reserva : reservas) {
            System.out.println(reserva);
        }

        System.out.println("--------------------------------------------------------------------------------");
    }

    private void actualizarReservaPedido() {

        System.out.print("ID Reserva/Pedido: ");
        int idReserva = sc.nextInt();

        int idCliente;
        do {
            System.out.print("ID Cliente: ");
            idCliente = sc.nextInt();

            if (idCliente <= 0) {
                System.out.println("El ID del cliente debe ser mayor que 0.");
            }

        } while (idCliente <= 0);

        int idEmpleado;
        do {
            System.out.print("ID Empleado: ");
            idEmpleado = sc.nextInt();

            if (idEmpleado <= 0) {
                System.out.println("El ID del empleado debe ser mayor que 0.");
            }

        } while (idEmpleado <= 0);

        int idMesa;
        do {
            System.out.print("ID Mesa: ");
            idMesa = sc.nextInt();

            if (idMesa <= 0) {
                System.out.println("El ID de la mesa debe ser mayor que 0.");
            }

        } while (idMesa <= 0);

        double importeTotal;
        do {
            System.out.print("Importe total: ");
            importeTotal = sc.nextDouble();
            sc.nextLine();

            if (importeTotal < 0) {
                System.out.println("El importe no puede ser negativo.");
            }

        } while (importeTotal < 0);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);

        Mesa mesa = new Mesa();
        mesa.setIdMesa(idMesa);

        ReservaPedido reserva = new ReservaPedido();

        reserva.setIdReserva(idReserva);
        reserva.setCliente(cliente);
        reserva.setEmpleado(empleado);
        reserva.setMesa(mesa);
        reserva.setImporteTotal(importeTotal);

        reservaPedidoDAO.actualizarReservaPedido(reserva);
    }

    private void eliminarReservaPedido() {

        System.out.print("ID Reserva/Pedido: ");
        int idReserva = sc.nextInt();
        sc.nextLine();

        reservaPedidoDAO.eliminarReservaPedido(idReserva);
    }
}