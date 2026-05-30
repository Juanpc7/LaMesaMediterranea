package vista;

import dao.EmpleadoDAO;
import dto.Empleado;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaEmpleado {

    private Scanner sc;
    private EmpleadoDAO empleadoDAO;

    public VistaEmpleado() {
        sc = new Scanner(System.in);
        empleadoDAO = new EmpleadoDAO();
    }

    public void mostrarMenu() {

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
                case 1:
                    insertarEmpleado();
                    break;
                case 2:
                    listarEmpleados();
                    break;
                case 3:
                    actualizarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private void insertarEmpleado() {

        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isBlank());

        String cargo;
        do {
            System.out.print("Cargo: ");
            cargo = sc.nextLine();

            if (cargo.isBlank()) {
                System.out.println("El cargo no puede estar vacío.");
            }

        } while (cargo.isBlank());

        String turno;
        do {
            System.out.print("Turno: ");
            turno = sc.nextLine();

            if (turno.isBlank()) {
                System.out.println("El turno no puede estar vacío.");
            }

        } while (turno.isBlank());

        int añosExperiencia;
        do {
            System.out.print("Años de experiencia: ");
            añosExperiencia = sc.nextInt();
            sc.nextLine();

            if (añosExperiencia < 0) {
                System.out.println("Los años de experiencia no pueden ser negativos.");
            }

        } while (añosExperiencia < 0);

        Empleado empleado = new Empleado(
                nombre,
                cargo,
                turno,
                añosExperiencia
        );

        empleadoDAO.insertarEmpleado(empleado);
    }

    private void listarEmpleados() {

        ArrayList<Empleado> empleados = empleadoDAO.listarEmpleados();

        System.out.println("\nLISTADO DE EMPLEADOS");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-20s %-15s %-10s%n",
                "ID", "NOMBRE", "CARGO", "TURNO", "AÑOS");
        System.out.println("--------------------------------------------------------------------------");

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        System.out.println("--------------------------------------------------------------------------");
    }

    private void actualizarEmpleado() {

        System.out.print("ID Empleado: ");
        int idEmpleado = sc.nextInt();
        sc.nextLine();

        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isBlank());

        String cargo;
        do {
            System.out.print("Cargo: ");
            cargo = sc.nextLine();

            if (cargo.isBlank()) {
                System.out.println("El cargo no puede estar vacío.");
            }

        } while (cargo.isBlank());

        String turno;
        do {
            System.out.print("Turno: ");
            turno = sc.nextLine();

            if (turno.isBlank()) {
                System.out.println("El turno no puede estar vacío.");
            }

        } while (turno.isBlank());

        int añosExperiencia;
        do {
            System.out.print("Años de experiencia: ");
            añosExperiencia = sc.nextInt();
            sc.nextLine();

            if (añosExperiencia < 0) {
                System.out.println("Los años de experiencia no pueden ser negativos.");
            }

        } while (añosExperiencia < 0);

        Empleado empleado = new Empleado();

        empleado.setIdEmpleado(idEmpleado);
        empleado.setNombre(nombre);
        empleado.setCargo(cargo);
        empleado.setTurno(turno);
        empleado.setAñosExperiencia(añosExperiencia);

        empleadoDAO.actualizarEmpleado(empleado);
    }

    private void eliminarEmpleado() {

        System.out.print("ID Empleado: ");
        int idEmpleado = sc.nextInt();
        sc.nextLine();

        empleadoDAO.eliminarEmpleado(idEmpleado);
    }
}