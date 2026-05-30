package vista;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner sc;

    private VistaCliente vistaCliente;
    private VistaEmpleado vistaEmpleado;
    private VistaMesa vistaMesa;
    private VistaCategoriaPlato vistaCategoriaPlato;
    private VistaPlato vistaPlato;
    private VistaReservaPedido vistaReservaPedido;
    private VistaDetallePedido vistaDetallePedido;

    public MenuPrincipal() {
        sc = new Scanner(System.in);

        vistaCliente = new VistaCliente();
        vistaEmpleado = new VistaEmpleado();
        vistaMesa = new VistaMesa();
        vistaCategoriaPlato = new VistaCategoriaPlato();
        vistaPlato = new VistaPlato();
        vistaReservaPedido = new VistaReservaPedido();
        vistaDetallePedido = new VistaDetallePedido();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println();
            System.out.println("==================================================");
            System.out.println("              LA MESA MEDITERRÁNEA");
            System.out.println("==================================================");
            System.out.println("  1. Gestión de clientes");
            System.out.println("  2. Gestión de empleados");
            System.out.println("  3. Gestión de mesas");
            System.out.println("  4. Gestión de categorías");
            System.out.println("  5. Gestión de platos");
            System.out.println("  6. Gestión de reservas/pedidos");
            System.out.println("  7. Gestión de detalles de pedido");
            System.out.println("  8. Salir");
            System.out.println("==================================================");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    vistaCliente.mostrarMenu();
                    break;
                case 2:
                    vistaEmpleado.mostrarMenu();
                    break;
                case 3:
                    vistaMesa.mostrarMenu();
                    break;
                case 4:
                    vistaCategoriaPlato.mostrarMenu();
                    break;
                case 5:
                    vistaPlato.mostrarMenu();
                    break;
                case 6:
                    vistaReservaPedido.mostrarMenu();
                    break;
                case 7:
                    vistaDetallePedido.mostrarMenu();
                    break;
                case 8:
                    System.out.println("Programa finalizado correctamente.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 8);
    }
}