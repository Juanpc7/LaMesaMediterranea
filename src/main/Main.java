package main;

import dao.*;
import modelo.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ClienteDAO clienteDAO = new ClienteDAO();
    static CategoriaPlatoDAO categoriaDAO = new CategoriaPlatoDAO();
    static PlatoDAO platoDAO = new PlatoDAO();
    static EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    static MesaDAO mesaDAO = new MesaDAO();
    static ReservaPedidoDAO reservaPedidoDAO = new ReservaPedidoDAO();
    static DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenuPrincipal();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> menuClientes();
                case 2 -> menuCategorias();
                case 3 -> menuPlatos();
                case 4 -> menuEmpleados();
                case 5 -> menuMesas();
                case 6 -> menuReservas();
                case 7 -> menuDetalles();
                case 8 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 8);
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("\n==================================");
        System.out.println("      LA MESA MEDITERRÁNEA");
        System.out.println("==================================");
        System.out.println("1. Gestión de clientes");
        System.out.println("2. Gestión de categorías");
        System.out.println("3. Gestión de platos");
        System.out.println("4. Gestión de empleados");
        System.out.println("5. Gestión de mesas");
        System.out.println("6. Gestión de reservas/pedidos");
        System.out.println("7. Gestión de detalles de pedido");
        System.out.println("8. Salir");
        System.out.println("==================================");
        System.out.print("Seleccione una opción: ");
    }

    public static void menuClientes() {
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
                case 1 -> insertarCliente();
                case 2 -> listarClientes();
                case 3 -> actualizarCliente();
                case 4 -> eliminarCliente();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void menuCategorias() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CATEGORÍAS ---");
            System.out.println("1. Insertar categoría");
            System.out.println("2. Listar categorías");
            System.out.println("3. Actualizar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarCategoria();
                case 2 -> listarCategorias();
                case 3 -> actualizarCategoria();
                case 4 -> eliminarCategoria();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void menuPlatos() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PLATOS ---");
            System.out.println("1. Insertar plato");
            System.out.println("2. Listar platos");
            System.out.println("3. Actualizar plato");
            System.out.println("4. Eliminar plato");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarPlato();
                case 2 -> listarPlatos();
                case 3 -> actualizarPlato();
                case 4 -> eliminarPlato();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void menuEmpleados() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE EMPLEADOS ---");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarEmpleado();
                case 2 -> listarEmpleados();
                case 3 -> actualizarEmpleado();
                case 4 -> eliminarEmpleado();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void menuMesas() {
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
                case 1 -> insertarMesa();
                case 2 -> listarMesas();
                case 3 -> actualizarMesa();
                case 4 -> eliminarMesa();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void menuReservas() {
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
                case 1 -> insertarReservaPedido();
                case 2 -> listarReservasPedidos();
                case 3 -> actualizarReservaPedido();
                case 4 -> eliminarReservaPedido();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void menuDetalles() {
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
                case 1 -> insertarDetallePedido();
                case 2 -> listarDetallesPedido();
                case 3 -> actualizarDetallePedido();
                case 4 -> eliminarDetallePedido();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
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

        Cliente cliente = new Cliente(dni, nombre, telefono, correo, direccion);
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

    public static void insertarCategoria() {
        System.out.print("Nombre de la categoría: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        CategoriaPlato categoria = new CategoriaPlato(nombre, descripcion);
        categoriaDAO.insertarCategoria(categoria);
    }

    public static void listarCategorias() {
        ArrayList<CategoriaPlato> categorias = categoriaDAO.listarCategorias();
        for (CategoriaPlato categoria : categorias) {
            System.out.println(categoria);
        }
    }

    public static void actualizarCategoria() {
        System.out.print("ID de la categoría: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();

        CategoriaPlato categoria = new CategoriaPlato();
        categoria.setIdCategoria(id);
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);

        categoriaDAO.actualizarCategoria(categoria);
    }

    public static void eliminarCategoria() {
        System.out.print("ID de la categoría a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        categoriaDAO.eliminarCategoria(id);
    }

    public static void insertarPlato() {
        System.out.print("Nombre del plato: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Disponible (true/false): ");
        boolean disponible = sc.nextBoolean();
        System.out.print("ID de la categoría: ");
        int idCategoria = sc.nextInt();
        sc.nextLine();

        CategoriaPlato categoria = new CategoriaPlato();
        categoria.setIdCategoria(idCategoria);

        Plato plato = new Plato(nombre, descripcion, precio, disponible, categoria);
        platoDAO.insertarPlato(plato);
    }

    public static void listarPlatos() {
        ArrayList<Plato> platos = platoDAO.listarPlatos();
        for (Plato plato : platos) {
            System.out.println(plato);
        }
    }

    public static void actualizarPlato() {
        System.out.print("ID del plato a modificar: ");
        int idPlato = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = sc.nextDouble();
        System.out.print("Disponible (true/false): ");
        boolean disponible = sc.nextBoolean();
        System.out.print("Nuevo ID de categoría: ");
        int idCategoria = sc.nextInt();
        sc.nextLine();

        CategoriaPlato categoria = new CategoriaPlato();
        categoria.setIdCategoria(idCategoria);

        Plato plato = new Plato();
        plato.setIdPlato(idPlato);
        plato.setNombre(nombre);
        plato.setDescripcion(descripcion);
        plato.setPrecio(precio);
        plato.setDisponible(disponible);
        plato.setCategoria(categoria);

        platoDAO.actualizarPlato(plato);
    }

    public static void eliminarPlato() {
        System.out.print("ID del plato a eliminar: ");
        int idPlato = sc.nextInt();
        sc.nextLine();
        platoDAO.eliminarPlato(idPlato);
    }

    public static void insertarEmpleado() {
        System.out.print("Nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        System.out.print("Turno: ");
        String turno = sc.nextLine();
        System.out.print("Años de experiencia: ");
        int aniosExperiencia = sc.nextInt();
        sc.nextLine();

        Empleado empleado = new Empleado(nombre, cargo, turno, aniosExperiencia);
        empleadoDAO.insertarEmpleado(empleado);
    }

    public static void listarEmpleados() {
        ArrayList<Empleado> empleados = empleadoDAO.listarEmpleados();
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public static void actualizarEmpleado() {
        System.out.print("ID del empleado a modificar: ");
        int idEmpleado = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo cargo: ");
        String cargo = sc.nextLine();
        System.out.print("Nuevo turno: ");
        String turno = sc.nextLine();
        System.out.print("Años de experiencia: ");
        int anios = sc.nextInt();
        sc.nextLine();

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleado.setNombre(nombre);
        empleado.setCargo(cargo);
        empleado.setTurno(turno);
        empleado.setAñosExperiencia(anios);

        empleadoDAO.actualizarEmpleado(empleado);
    }

    public static void eliminarEmpleado() {
        System.out.print("ID del empleado a eliminar: ");
        int idEmpleado = sc.nextInt();
        sc.nextLine();
        empleadoDAO.eliminarEmpleado(idEmpleado);
    }

    public static void insertarMesa() {
        System.out.print("Número de mesa: ");
        int numero = sc.nextInt();
        System.out.print("Capacidad: ");
        int capacidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();

        Mesa mesa = new Mesa(numero, capacidad, ubicacion, estado);
        mesaDAO.insertarMesa(mesa);
    }

    public static void listarMesas() {
        ArrayList<Mesa> mesas = mesaDAO.listarMesas();
        for (Mesa mesa : mesas) {
            System.out.println(mesa);
        }
    }

    public static void actualizarMesa() {
        System.out.print("ID de la mesa a modificar: ");
        int idMesa = sc.nextInt();
        System.out.print("Nuevo número de mesa: ");
        int numero = sc.nextInt();
        System.out.print("Nueva capacidad: ");
        int capacidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Nueva ubicación: ");
        String ubicacion = sc.nextLine();
        System.out.print("Nuevo estado: ");
        String estado = sc.nextLine();

        Mesa mesa = new Mesa();
        mesa.setIdMesa(idMesa);
        mesa.setNumero(numero);
        mesa.setCapacidad(capacidad);
        mesa.setUbicacion(ubicacion);
        mesa.setEstado(estado);

        mesaDAO.actualizarMesa(mesa);
    }

    public static void eliminarMesa() {
        System.out.print("ID de la mesa a eliminar: ");
        int idMesa = sc.nextInt();
        sc.nextLine();
        mesaDAO.eliminarMesa(idMesa);
    }

    public static void insertarReservaPedido() {
        System.out.print("ID del cliente: ");
        int idCliente = sc.nextInt();
        System.out.print("ID del empleado: ");
        int idEmpleado = sc.nextInt();
        System.out.print("ID de la mesa: ");
        int idMesa = sc.nextInt();
        System.out.print("Importe total: ");
        double importeTotal = sc.nextDouble();
        sc.nextLine();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);

        Mesa mesa = new Mesa();
        mesa.setIdMesa(idMesa);

        ReservaPedido reserva = new ReservaPedido(LocalDateTime.now(), importeTotal, cliente, empleado, mesa);
        reservaPedidoDAO.insertarReservaPedido(reserva);
    }

    public static void listarReservasPedidos() {
        ArrayList<ReservaPedido> reservas = reservaPedidoDAO.listarReservasPedidos();
        for (ReservaPedido reserva : reservas) {
            System.out.println(reserva);
        }
    }

    public static void actualizarReservaPedido() {
        System.out.print("ID de la reserva: ");
        int idReserva = sc.nextInt();
        System.out.print("Nuevo importe total: ");
        double importe = sc.nextDouble();
        System.out.print("Nuevo ID cliente: ");
        int idCliente = sc.nextInt();
        System.out.print("Nuevo ID empleado: ");
        int idEmpleado = sc.nextInt();
        System.out.print("Nuevo ID mesa: ");
        int idMesa = sc.nextInt();
        sc.nextLine();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);

        Mesa mesa = new Mesa();
        mesa.setIdMesa(idMesa);

        ReservaPedido reserva = new ReservaPedido();
        reserva.setIdReserva(idReserva);
        reserva.setImporteTotal(importe);
        reserva.setCliente(cliente);
        reserva.setEmpleado(empleado);
        reserva.setMesa(mesa);

        reservaPedidoDAO.actualizarReservaPedido(reserva);
    }

    public static void eliminarReservaPedido() {
        System.out.print("ID de la reserva a eliminar: ");
        int idReserva = sc.nextInt();
        sc.nextLine();
        reservaPedidoDAO.eliminarReservaPedido(idReserva);
    }

    public static void insertarDetallePedido() {
        System.out.print("ID de la reserva: ");
        int idReserva = sc.nextInt();
        System.out.print("ID del plato: ");
        int idPlato = sc.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Precio unitario: ");
        double precioUnitario = sc.nextDouble();
        sc.nextLine();

        ReservaPedido reserva = new ReservaPedido();
        reserva.setIdReserva(idReserva);

        Plato plato = new Plato();
        plato.setIdPlato(idPlato);

        DetallePedido detalle = new DetallePedido(cantidad, precioUnitario, reserva, plato);
        detallePedidoDAO.insertarDetallePedido(detalle);
    }

    public static void listarDetallesPedido() {
        ArrayList<DetallePedido> detalles = detallePedidoDAO.listarDetallesPedido();
        for (DetallePedido detalle : detalles) {
            System.out.println(detalle);
        }
    }

    public static void actualizarDetallePedido() {
        System.out.print("ID del detalle: ");
        int idDetalle = sc.nextInt();
        System.out.print("Nuevo ID de reserva: ");
        int idReserva = sc.nextInt();
        System.out.print("Nuevo ID de plato: ");
        int idPlato = sc.nextInt();
        System.out.print("Nueva cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Nuevo precio unitario: ");
        double precioUnitario = sc.nextDouble();
        sc.nextLine();

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

    public static void eliminarDetallePedido() {
        System.out.print("ID del detalle a eliminar: ");
        int idDetalle = sc.nextInt();
        sc.nextLine();
        detallePedidoDAO.eliminarDetallePedido(idDetalle);
    }
}