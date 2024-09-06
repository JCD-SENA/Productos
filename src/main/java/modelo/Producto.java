package modelo;

import javax.swing.JOptionPane;

public class Producto {
    private String nombre;
    private String codigo;
    private String categoria;
    private int cantidad;
    private int precio;

    public Producto (String nombre, String codigo, String categoria, int precio, int cantidad) {
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
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
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
    
    public void editar(String nombre, String categoria, int cantidad, int precio) {
        if (nombre.length() < 1) {
            JOptionPane.showMessageDialog(null, "El producto debe tener un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidad < 0) {
            JOptionPane.showMessageDialog(null, "Un producto no puede tener una cantidad negativa", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (categoria.length() < 1)
            this.setCategoria("Sin categoria.");

        if (precio < 0) {
            JOptionPane.showMessageDialog(null, "Un producto no puede un precio negativo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.setNombre(nombre);
        this.setCategoria(categoria);
        this.setCantidad(cantidad);
        this.setPrecio(precio);
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ", "+categoria+") tiene " + cantidad + " unidades y cuesta "+precio+"¤";
    }
}
