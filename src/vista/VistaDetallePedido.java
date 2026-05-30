package vista;

import dao.DetallePedidoDAO;
import dto.DetallePedido;
import dto.Plato;
import dto.ReservaPedido;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaDetallePedido {

    private Scanner sc;
    private DetallePedidoDAO detallePedidoDAO;

    public VistaDetallePedido() {
        sc = new Scanner(System.in);
        detallePedidoDAO = new DetallePedidoDAO();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE DETALLES DE PEDIDO ---");
            System.out.println("1. Insertar detalle");
            System.out.println("2. Listar detalles");
            System.out.println("3. Actualizar detalle");
            System.out.println("4. Eliminar detalle");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    insertarDetallePedido();
                    break;
                case 2:
                    listarDetallesPedido();
                    break;
                case 3:
                    actualizarDetallePedido();
                    break;
                case 4:
                    eliminarDetallePedido();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private void insertarDetallePedido() {

        int idReserva;
        do {
            System.out.print("ID Reserva: ");
            idReserva = sc.nextInt();

            if (idReserva <= 0) {
                System.out.println("El ID de la reserva debe ser mayor que 0.");
            }

        } while (idReserva <= 0);

        int idPlato;
        do {
            System.out.print("ID Plato: ");
            idPlato = sc.nextInt();

            if (idPlato <= 0) {
                System.out.println("El ID del plato debe ser mayor que 0.");
            }

        } while (idPlato <= 0);

        int cantidad;
        do {
            System.out.print("Cantidad: ");
            cantidad = sc.nextInt();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que 0.");
            }

        } while (cantidad <= 0);

        double precioUnitario;
        do {
            System.out.print("Precio unitario: ");
            precioUnitario = sc.nextDouble();
            sc.nextLine();

            if (precioUnitario < 0) {
                System.out.println("El precio unitario no puede ser negativo.");
            }

        } while (precioUnitario < 0);

        ReservaPedido reserva = new ReservaPedido();
        reserva.setIdReserva(idReserva);

        Plato plato = new Plato();
        plato.setIdPlato(idPlato);

        DetallePedido detalle = new DetallePedido(
                cantidad,
                precioUnitario,
                reserva,
                plato
        );

        detallePedidoDAO.insertarDetallePedido(detalle);
    }

    private void listarDetallesPedido() {

        ArrayList<DetallePedido> detalles = detallePedidoDAO.listarDetallesPedido();

        System.out.println("\nLISTADO DE DETALLES DE PEDIDO");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-20s %-10s%n",
                "ID", "CANTIDAD", "PLATO", "PRECIO");
        System.out.println("----------------------------------------------------------------");

        for (DetallePedido detalle : detalles) {
            System.out.println(detalle);
        }

        System.out.println("----------------------------------------------------------------");
    }

    private void actualizarDetallePedido() {

        System.out.print("ID Detalle: ");
        int idDetalle = sc.nextInt();

        int idReserva;
        do {
            System.out.print("ID Reserva: ");
            idReserva = sc.nextInt();

            if (idReserva <= 0) {
                System.out.println("El ID de la reserva debe ser mayor que 0.");
            }

        } while (idReserva <= 0);

        int idPlato;
        do {
            System.out.print("ID Plato: ");
            idPlato = sc.nextInt();

            if (idPlato <= 0) {
                System.out.println("El ID del plato debe ser mayor que 0.");
            }

        } while (idPlato <= 0);

        int cantidad;
        do {
            System.out.print("Cantidad: ");
            cantidad = sc.nextInt();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que 0.");
            }

        } while (cantidad <= 0);

        double precioUnitario;
        do {
            System.out.print("Precio unitario: ");
            precioUnitario = sc.nextDouble();
            sc.nextLine();

            if (precioUnitario < 0) {
                System.out.println("El precio unitario no puede ser negativo.");
            }

        } while (precioUnitario < 0);

        ReservaPedido reserva = new ReservaPedido();
        reserva.setIdReserva(idReserva);

        Plato plato = new Plato();
        plato.setIdPlato(idPlato);

        DetallePedido detalle = new DetallePedido();

        detalle.setIdDetalle(idDetalle);
        detalle.setReserva(reserva);
        detalle.setPlato(plato);
        detalle.setCantidad(cantidad);
        detalle.setPrecioUnitario(precioUnitario);

        detallePedidoDAO.actualizarDetallePedido(detalle);
    }

    private void eliminarDetallePedido() {

        System.out.print("ID Detalle: ");
        int idDetalle = sc.nextInt();
        sc.nextLine();

        detallePedidoDAO.eliminarDetallePedido(idDetalle);
    }
}