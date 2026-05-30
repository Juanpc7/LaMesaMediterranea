package vista;

import dao.PlatoDAO;
import dto.CategoriaPlato;
import dto.Plato;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaPlato {

    private Scanner sc;
    private PlatoDAO platoDAO;

    public VistaPlato() {
        sc = new Scanner(System.in);
        platoDAO = new PlatoDAO();
    }

    public void mostrarMenu() {

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
                case 1:
                    insertarPlato();
                    break;
                case 2:
                    listarPlatos();
                    break;
                case 3:
                    actualizarPlato();
                    break;
                case 4:
                    eliminarPlato();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private void insertarPlato() {

        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isBlank());

        String descripcion;
        do {
            System.out.print("Descripción: ");
            descripcion = sc.nextLine();

            if (descripcion.isBlank()) {
                System.out.println("La descripción no puede estar vacía.");
            }

        } while (descripcion.isBlank());

        double precio;
        do {
            System.out.print("Precio: ");
            precio = sc.nextDouble();

            if (precio < 0) {
                System.out.println("El precio no puede ser negativo.");
            }

        } while (precio < 0);

        System.out.print("Disponible (true/false): ");
        boolean disponible = sc.nextBoolean();

        int idCategoria;
        do {
            System.out.print("ID Categoría: ");
            idCategoria = sc.nextInt();
            sc.nextLine();

            if (idCategoria <= 0) {
                System.out.println("El ID de la categoría debe ser mayor que 0.");
            }

        } while (idCategoria <= 0);

        CategoriaPlato categoria = new CategoriaPlato();
        categoria.setIdCategoria(idCategoria);

        Plato plato = new Plato(
                nombre,
                descripcion,
                precio,
                disponible,
                categoria
        );

        platoDAO.insertarPlato(plato);
    }

    private void listarPlatos() {

        ArrayList<Plato> platos = platoDAO.listarPlatos();

        System.out.println("\nLISTADO DE PLATOS");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-12s %-20s%n",
                "ID", "NOMBRE", "PRECIO", "DISPONIBLE", "CATEGORÍA");
        System.out.println("--------------------------------------------------------------------------------");

        for (Plato plato : platos) {
            System.out.println(plato);
        }

        System.out.println("--------------------------------------------------------------------------------");
    }

    private void actualizarPlato() {

        System.out.print("ID Plato: ");
        int idPlato = sc.nextInt();
        sc.nextLine();

        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isBlank());

        String descripcion;
        do {
            System.out.print("Descripción: ");
            descripcion = sc.nextLine();

            if (descripcion.isBlank()) {
                System.out.println("La descripción no puede estar vacía.");
            }

        } while (descripcion.isBlank());

        double precio;
        do {
            System.out.print("Precio: ");
            precio = sc.nextDouble();

            if (precio < 0) {
                System.out.println("El precio no puede ser negativo.");
            }

        } while (precio < 0);

        System.out.print("Disponible (true/false): ");
        boolean disponible = sc.nextBoolean();

        int idCategoria;
        do {
            System.out.print("ID Categoría: ");
            idCategoria = sc.nextInt();
            sc.nextLine();

            if (idCategoria <= 0) {
                System.out.println("El ID de la categoría debe ser mayor que 0.");
            }

        } while (idCategoria <= 0);

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

    private void eliminarPlato() {

        System.out.print("ID Plato: ");
        int idPlato = sc.nextInt();
        sc.nextLine();

        platoDAO.eliminarPlato(idPlato);
    }
}