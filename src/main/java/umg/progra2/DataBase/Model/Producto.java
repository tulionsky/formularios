package umg.progra2.DataBase.Model;

public class Producto {
    private int idProducto;
    private String descripcion;
    private String origen;

    // Constructor
    public Producto() {}

    public Producto(int idProducto, String descripcion, String origen) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.origen = origen;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
