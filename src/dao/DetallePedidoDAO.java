package dao;

import conexion.ConexionBD;
import modelo.DetallePedido;
import modelo.Plato;
import modelo.ReservaPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetallePedidoDAO {

    public void insertarDetallePedido(DetallePedido detalle) {

        String sql = "INSERT INTO detalle_pedido (cantidad, precio_unitario, id_reserva, id_plato) VALUES (?, ?, ?, ?)";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioUnitario());
            ps.setInt(3, detalle.getReserva().getIdReserva());
            ps.setInt(4, detalle.getPlato().getIdPlato());

            ps.executeUpdate();

            System.out.println("Detalle de pedido insertado correctamente");

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al insertar detalle de pedido");
            e.printStackTrace();

        }
    }

    public ArrayList<DetallePedido> listarDetallesPedido() {

        ArrayList<DetallePedido> lista = new ArrayList<>();

        String sql = """
                SELECT d.id_detalle, d.cantidad, d.precio_unitario,
                       r.id_reserva,
                       p.id_plato, p.nombre
                FROM detalle_pedido d
                INNER JOIN reserva_pedido r ON d.id_reserva = r.id_reserva
                INNER JOIN plato p ON d.id_plato = p.id_plato
                """;

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ReservaPedido reserva = new ReservaPedido();
                reserva.setIdReserva(rs.getInt("id_reserva"));

                Plato plato = new Plato();
                plato.setIdPlato(rs.getInt("id_plato"));
                plato.setNombre(rs.getString("nombre"));

                DetallePedido detalle = new DetallePedido();

                detalle.setIdDetalle(rs.getInt("id_detalle"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioUnitario(rs.getDouble("precio_unitario"));
                detalle.setReserva(reserva);
                detalle.setPlato(plato);

                lista.add(detalle);

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al listar detalles de pedido");
            e.printStackTrace();

        }

        return lista;
    }
    public void actualizarDetallePedido(DetallePedido detalle) {

        String sql = "UPDATE detalle_pedido SET cantidad = ?, precio_unitario = ?, id_reserva = ?, id_plato = ? WHERE id_detalle = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioUnitario());
            ps.setInt(3, detalle.getReserva().getIdReserva());
            ps.setInt(4, detalle.getPlato().getIdPlato());
            ps.setInt(5, detalle.getIdDetalle());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Detalle actualizado correctamente");
            } else {
                System.out.println("No existe un detalle con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle");
            e.printStackTrace();
        }
    }

    public void eliminarDetallePedido(int idDetalle) {

        String sql = "DELETE FROM detalle_pedido WHERE id_detalle = ?";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idDetalle);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Detalle eliminado correctamente");
            } else {
                System.out.println("No existe un detalle con ese ID");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle");
            e.printStackTrace();
        }
    }
}