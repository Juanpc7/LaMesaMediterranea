package dao;

import conexion.ConexionBD;
import dto.Cliente;
import dto.Empleado;
import dto.Mesa;
import dto.ReservaPedido;

import java.sql.*;
import java.util.ArrayList;

public class ReservaPedidoDAO {

    public void insertarReservaPedido(ReservaPedido reserva) {

        String sql = "INSERT INTO reserva_pedido (fecha, importe_total, id_cliente, id_empleado, id_mesa) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setTimestamp(1, Timestamp.valueOf(reserva.getFecha()));
            ps.setDouble(2, reserva.getImporteTotal());
            ps.setInt(3, reserva.getCliente().getIdCliente());
            ps.setInt(4, reserva.getEmpleado().getIdEmpleado());
            ps.setInt(5, reserva.getMesa().getIdMesa());

            ps.executeUpdate();

            System.out.println("Reserva/Pedido insertado correctamente");

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar reserva/pedido");
            e.printStackTrace();
        }
    }

    public ArrayList<ReservaPedido> listarReservasPedidos() {

        ArrayList<ReservaPedido> lista = new ArrayList<>();

        String sql = """
                SELECT r.id_reserva, r.fecha, r.importe_total,
                       c.id_cliente, c.nombre AS nombre_cliente, c.dni, c.telefono, c.correo, c.direccion,
                       e.id_empleado, e.nombre AS nombre_empleado, e.cargo, e.turno, e.anios_experiencia,
                       m.id_mesa, m.numero, m.capacidad, m.ubicacion, m.estado
                FROM reserva_pedido r
                INNER JOIN cliente c ON r.id_cliente = c.id_cliente
                INNER JOIN empleado e ON r.id_empleado = e.id_empleado
                INNER JOIN mesa m ON r.id_mesa = m.id_mesa
                """;

        try {
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                cliente.setDni(rs.getString("dni"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setDireccion(rs.getString("direccion"));

                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre_empleado"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setTurno(rs.getString("turno"));
                empleado.setAñosExperiencia(rs.getInt("anios_experiencia"));

                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("id_mesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setUbicacion(rs.getString("ubicacion"));
                mesa.setEstado(rs.getString("estado"));

                ReservaPedido reserva = new ReservaPedido();
                reserva.setIdReserva(rs.getInt("id_reserva"));
                reserva.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                reserva.setImporteTotal(rs.getDouble("importe_total"));
                reserva.setCliente(cliente);
                reserva.setEmpleado(empleado);
                reserva.setMesa(mesa);

                lista.add(reserva);
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al listar reservas/pedidos");
            e.printStackTrace();
        }

        return lista;
    }
    public void actualizarReservaPedido(ReservaPedido reserva) {

        String sql = "UPDATE reserva_pedido SET importe_total = ?, id_cliente = ?, id_empleado = ?, id_mesa = ? WHERE id_reserva = ?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setDouble(1, reserva.getImporteTotal());
            ps.setInt(2, reserva.getCliente().getIdCliente());
            ps.setInt(3, reserva.getEmpleado().getIdEmpleado());
            ps.setInt(4, reserva.getMesa().getIdMesa());
            ps.setInt(5, reserva.getIdReserva());

            int filas = ps.executeUpdate();

            if (filas > 0) {

                System.out.println("Reserva/Pedido actualizado correctamente");

            } else {

                System.out.println("No existe una reserva con ese ID");

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al actualizar reserva/pedido");
            e.printStackTrace();

        }
    }

    public void eliminarReservaPedido(int idReserva) {

        String sql = "DELETE FROM reserva_pedido WHERE id_reserva = ?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idReserva);

            int filas = ps.executeUpdate();

            if (filas > 0) {

                System.out.println("Reserva/Pedido eliminado correctamente");

            } else {

                System.out.println("No existe una reserva con ese ID");

            }

            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar reserva/pedido");
            e.printStackTrace();

        }
    }
}