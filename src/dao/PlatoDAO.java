package dao;

import conexion.ConexionBD;
import modelo.CategoriaPlato;
import modelo.Plato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlatoDAO {

    public void insertarPlato(Plato plato) {

        String sql = "INSERT INTO plato (nombre, descripcion, precio, disponible, id_categoria) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, plato.getNombre());
            ps.setString(2, plato.getDescripcion());
            ps.setDouble(3, plato.getPrecio());
            ps.setBoolean(4, plato.isDisponible());
            ps.setInt(5, plato.getCategoria().getIdCategoria());

            ps.executeUpdate();

            System.out.println("Plato insertado correctamente");

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar plato");
            e.printStackTrace();
        }
    }

    public ArrayList<Plato> listarPlatos() {

        ArrayList<Plato> listaPlatos = new ArrayList<>();

        String sql = """
                SELECT p.id_plato, p.nombre, p.descripcion, p.precio, p.disponible,
                       c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS descripcion_categoria
                FROM plato p
                INNER JOIN categoria_plato c ON p.id_categoria = c.id_categoria
                """;

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CategoriaPlato categoria = new CategoriaPlato();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
                categoria.setDescripcion(rs.getString("descripcion_categoria"));

                Plato plato = new Plato();
                plato.setIdPlato(rs.getInt("id_plato"));
                plato.setNombre(rs.getString("nombre"));
                plato.setDescripcion(rs.getString("descripcion"));
                plato.setPrecio(rs.getDouble("precio"));
                plato.setDisponible(rs.getBoolean("disponible"));
                plato.setCategoria(categoria);

                listaPlatos.add(plato);
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al listar platos");
            e.printStackTrace();
        }

        return listaPlatos;
    }
    public void actualizarPlato(Plato plato) {

        String sql = "UPDATE plato SET nombre = ?, descripcion = ?, precio = ?, disponible = ?, id_categoria = ? WHERE id_plato = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, plato.getNombre());
            ps.setString(2, plato.getDescripcion());
            ps.setDouble(3, plato.getPrecio());
            ps.setBoolean(4, plato.isDisponible());
            ps.setInt(5, plato.getCategoria().getIdCategoria());
            ps.setInt(6, plato.getIdPlato());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Plato actualizado correctamente");
            } else {
                System.out.println("No existe un plato con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar plato");
            e.printStackTrace();
        }
    }

    public void eliminarPlato(int idPlato) {

        String sql = "DELETE FROM plato WHERE id_plato = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idPlato);

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Plato eliminado correctamente");
            } else {
                System.out.println("No existe un plato con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar plato");
            e.printStackTrace();
        }
    }
}