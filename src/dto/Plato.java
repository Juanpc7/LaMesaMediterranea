package dto;

public class Plato {

    private int idPlato;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponible;
    private CategoriaPlato categoria;

    public Plato() {
    }

    public Plato(String nombre, String descripcion, double precio, boolean disponible, CategoriaPlato categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
        this.categoria = categoria;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public CategoriaPlato getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPlato categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format(
                "%-5d %-20s %-10.2f %-12s %-20s",
                idPlato,
                nombre,
                precio,
                disponible ? "SI" : "NO",
                categoria.getNombre()
        );
    }
}