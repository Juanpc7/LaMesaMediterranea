package dao;

import conexion.ConexionBD;
import dto.CategoriaPlato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaPlatoDAO {

    public void insertarCategoria(CategoriaPlato categoria) {

        String sql = "INSERT INTO categoria_plato (nombre, descripcion) VALUES (?, ?)";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());

            ps.executeUpdate();

            System.out.println("Categoría insertada correctamente");

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar categoría");
            e.printStackTrace();
        }
    }

    public ArrayList<CategoriaPlato> listarCategorias() {

        ArrayList<CategoriaPlato> listaCategorias = new ArrayList<>();

        String sql = "SELECT * FROM categoria_plato";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaPlato categoria = new CategoriaPlato();

                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));

                listaCategorias.add(categoria);
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al listar categorías");
            e.printStackTrace();
        }

        return listaCategorias;
    }

    public void actualizarCategoria(CategoriaPlato categoria) {

        String sql = "UPDATE categoria_plato SET nombre = ?, descripcion = ? WHERE id_categoria = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getIdCategoria());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Categoría actualizada correctamente");
            } else {
                System.out.println("No existe una categoría con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría");
            e.printStackTrace();
        }
    }

    public void eliminarCategoria(int idCategoria) {

        String sql = "DELETE FROM categoria_plato WHERE id_categoria = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idCategoria);

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Categoría eliminada correctamente");
            } else {
                System.out.println("No existe una categoría con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría");
            e.printStackTrace();
        }
    }
}