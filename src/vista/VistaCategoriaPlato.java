package vista;

import dao.CategoriaPlatoDAO;
import dto.CategoriaPlato;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaCategoriaPlato {

    private Scanner sc;
    private CategoriaPlatoDAO categoriaDAO;

    public VistaCategoriaPlato() {
        sc = new Scanner(System.in);
        categoriaDAO = new CategoriaPlatoDAO();
    }

    public void mostrarMenu() {

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
                case 1:
                    insertarCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    actualizarCategoria();
                    break;
                case 4:
                    eliminarCategoria();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private void insertarCategoria() {

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

        CategoriaPlato categoria = new CategoriaPlato(
                nombre,
                descripcion
        );

        categoriaDAO.insertarCategoria(categoria);
    }

    private void listarCategorias() {

        ArrayList<CategoriaPlato> categorias = categoriaDAO.listarCategorias();

        System.out.println("\nLISTADO DE CATEGORÍAS");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-40s%n",
                "ID", "NOMBRE", "DESCRIPCIÓN");
        System.out.println("--------------------------------------------------------------------------");

        for (CategoriaPlato categoria : categorias) {
            System.out.println(categoria);
        }

        System.out.println("--------------------------------------------------------------------------");
    }

    private void actualizarCategoria() {

        System.out.print("ID Categoría: ");
        int idCategoria = sc.nextInt();
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

        CategoriaPlato categoria = new CategoriaPlato();

        categoria.setIdCategoria(idCategoria);
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);

        categoriaDAO.actualizarCategoria(categoria);
    }

    private void eliminarCategoria() {

        System.out.print("ID Categoría: ");
        int idCategoria = sc.nextInt();
        sc.nextLine();

        categoriaDAO.eliminarCategoria(idCategoria);
    }
}