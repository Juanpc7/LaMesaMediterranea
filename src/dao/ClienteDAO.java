package dao;

import conexion.ConexionBD;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class ClienteDAO {

    public void insertarCliente(Cliente cliente) {

        String sql = "INSERT INTO cliente (dni, nombre, telefono, correo, direccion) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getDireccion());

            ps.executeUpdate();

            System.out.println("Cliente insertado correctamente");

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al insertar cliente");
            e.printStackTrace();

        }
    }

    public ArrayList<Cliente> listarClientes() {

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setDireccion(rs.getString("direccion"));

                listaClientes.add(cliente);

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al listar clientes");
            e.printStackTrace();

        }

        return listaClientes;
    }
    public void actualizarCliente(Cliente cliente) {

        String sql = "UPDATE cliente SET nombre = ?, telefono = ?, correo = ?, direccion = ? WHERE id_cliente = ?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getIdCliente());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {

                System.out.println("Cliente actualizado correctamente");

            } else {

                System.out.println("No existe un cliente con ese ID");

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al actualizar cliente");
            e.printStackTrace();

        }
    }
    public void eliminarCliente(int idCliente) {

        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idCliente);

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {

                System.out.println("Cliente eliminado correctamente");

            } else {

                System.out.println("No existe un cliente con ese ID");

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar cliente");
            e.printStackTrace();

        }
    }
}
