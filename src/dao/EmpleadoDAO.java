package dao;

import conexion.ConexionBD;
import modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

    public void insertarEmpleado(Empleado empleado) {

        String sql = "INSERT INTO empleado (nombre, cargo, turno, anios_experiencia) VALUES (?, ?, ?, ?)";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getCargo());
            ps.setString(3, empleado.getTurno());
            ps.setInt(4, empleado.getAniosExperiencia());

            ps.executeUpdate();

            System.out.println("Empleado insertado correctamente");

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al insertar empleado");
            e.printStackTrace();

        }
    }

    public ArrayList<Empleado> listarEmpleados() {

        ArrayList<Empleado> lista = new ArrayList<>();

        String sql = "SELECT * FROM empleado";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Empleado empleado = new Empleado();

                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setTurno(rs.getString("turno"));
                empleado.setAniosExperiencia(rs.getInt("anios_experiencia"));

                lista.add(empleado);

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al listar empleados");
            e.printStackTrace();

        }

        return lista;
    }
    public void actualizarEmpleado(Empleado empleado) {

        String sql = "UPDATE empleado SET nombre = ?, cargo = ?, turno = ?, anios_experiencia = ? WHERE id_empleado = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getCargo());
            ps.setString(3, empleado.getTurno());
            ps.setInt(4, empleado.getAniosExperiencia());
            ps.setInt(5, empleado.getIdEmpleado());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Empleado actualizado correctamente");
            } else {
                System.out.println("No existe un empleado con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado");
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado(int idEmpleado) {

        String sql = "DELETE FROM empleado WHERE id_empleado = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idEmpleado);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Empleado eliminado correctamente");
            } else {
                System.out.println("No existe un empleado con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado");
            e.printStackTrace();
        }
    }
}