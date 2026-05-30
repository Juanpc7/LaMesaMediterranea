package dao;

import conexion.ConexionBD;
import dto.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDAO {

    public void insertarMesa(Mesa mesa) {

        String sql = "INSERT INTO mesa (numero, capacidad, ubicacion, estado) VALUES (?, ?, ?, ?)";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, mesa.getNumero());
            ps.setInt(2, mesa.getCapacidad());
            ps.setString(3, mesa.getUbicacion());
            ps.setString(4, mesa.getEstado());

            ps.executeUpdate();

            System.out.println("Mesa insertada correctamente");

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al insertar mesa");
            e.printStackTrace();

        }
    }

    public ArrayList<Mesa> listarMesas() {

        ArrayList<Mesa> lista = new ArrayList<>();

        String sql = "SELECT * FROM mesa";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Mesa mesa = new Mesa();

                mesa.setIdMesa(rs.getInt("id_mesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setUbicacion(rs.getString("ubicacion"));
                mesa.setEstado(rs.getString("estado"));

                lista.add(mesa);

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al listar mesas");
            e.printStackTrace();

        }

        return lista;
    }
    public void actualizarMesa(Mesa mesa) {

        String sql = "UPDATE mesa SET numero = ?, capacidad = ?, ubicacion = ?, estado = ? WHERE id_mesa = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, mesa.getNumero());
            ps.setInt(2, mesa.getCapacidad());
            ps.setString(3, mesa.getUbicacion());
            ps.setString(4, mesa.getEstado());
            ps.setInt(5, mesa.getIdMesa());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Mesa actualizada correctamente");
            } else {
                System.out.println("No existe una mesa con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar mesa");
            e.printStackTrace();
        }
    }

    public void eliminarMesa(int idMesa) {

        String sql = "DELETE FROM mesa WHERE id_mesa = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idMesa);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Mesa eliminada correctamente");
            } else {
                System.out.println("No existe una mesa con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar mesa");
            e.printStackTrace();
        }
    }
}