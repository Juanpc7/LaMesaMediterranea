package modelo;

import java.time.LocalDateTime;

public class ReservaPedido {

    private int idReserva;
    private LocalDateTime fecha;
    private double importeTotal;

    private Cliente cliente;
    private Empleado empleado;
    private Mesa mesa;

    public ReservaPedido() {
    }

    public ReservaPedido(LocalDateTime fecha, double importeTotal,
                         Cliente cliente, Empleado empleado, Mesa mesa) {

        this.fecha = fecha;
        this.importeTotal = importeTotal;
        this.cliente = cliente;
        this.empleado = empleado;
        this.mesa = mesa;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "ReservaPedido{" +
                "idReserva=" + idReserva +
                ", fecha=" + fecha +
                ", importeTotal=" + importeTotal +
                ", cliente=" + cliente.getNombre() +
                ", empleado=" + empleado.getNombre() +
                ", mesa=" + mesa.getNumero() +
                '}';
    }
}