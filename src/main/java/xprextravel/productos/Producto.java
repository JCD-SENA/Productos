package xprextravel.productos;

public class Producto {
    private String nombre;
    private String codigo;
    private String categoria;
    private int cantidad;
    private double precio;

    public Producto (String nombre, String codigo, String categoria, double precio, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        if (categoria.length() < 1)
            this.categoria = "Sin categoria.";
        else
            this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ", "+categoria+") tiene " + cantidad + " unidades y cuesta "+precio+"¤";
    }
}
