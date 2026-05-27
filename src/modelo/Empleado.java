package modelo;

public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String cargo;
    private String turno;
    private int añosExperiencia;

    public Empleado() {
    }

    public Empleado(String nombre, String cargo, String turno, int añosExperiencia) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.turno = turno;
        this.añosExperiencia = añosExperiencia;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", turno='" + turno + '\'' +
                ", añosExperiencia=" + añosExperiencia +
                '}';
    }
}