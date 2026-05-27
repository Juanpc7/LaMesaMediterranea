package modelo;

public class DetallePedido {

    private int idDetalle;
    private int cantidad;
    private double precioUnitario;

    private ReservaPedido reserva;
    private Plato plato;

    public DetallePedido() {
    }

    public DetallePedido(int cantidad, double precioUnitario, ReservaPedido reserva, Plato plato) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.reserva = reserva;
        this.plato = plato;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public ReservaPedido getReserva() {
        return reserva;
    }

    public void setReserva(ReservaPedido reserva) {
        this.reserva = reserva;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "idDetalle=" + idDetalle +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", reserva=" + reserva.getIdReserva() +
                ", plato=" + plato.getNombre() +
                '}';
    }
}