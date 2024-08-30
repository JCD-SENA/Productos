package xprextravel.productos;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class ManejarInventario {
    //La llave es el codigo del producto
    private HashMap<String, Producto> inventario;
    
    public ManejarInventario () {
        inventario = new HashMap<String, Producto>();
    }
    
    public void agregarProducto (Producto prod) {
        if (!inventario.containsKey(prod)) {
            if (prod.getCodigo().length() < 1) {
                JOptionPane.showMessageDialog(null, "El producto necesita un código valido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (prod.getNombre().length() < 1) {
                JOptionPane.showMessageDialog(null, "El producto debe tener un nombre", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (prod.getCantidad() < 0) {
                JOptionPane.showMessageDialog(null, "Un producto no puede tener una cantidad negativa", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (prod.getPrecio() < 0) {
                JOptionPane.showMessageDialog(null, "Un producto no puede un precio negativo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            inventario.put(prod.getCodigo(), prod);
            JOptionPane.showMessageDialog(null, "Se ha registrado el producto "+prod.getNombre());
        } else
            JOptionPane.showMessageDialog(null, "El producto ya se encuentra en el inventario", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public Producto consultarProducto (String cod) {
        //Si encuentra el producto va a retornarlo, de lo contrario da null
        if (inventario.containsKey(cod))
            return inventario.get(cod);
        else
            JOptionPane.showMessageDialog(null, "El producto no se encuentra en el inventario", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    
    public void eliminarProducto (String cod) {
        if (inventario.containsKey(cod)) {
            inventario.remove(cod);
            JOptionPane.showMessageDialog(null, "Se ha borrado el producto");
        } else
            JOptionPane.showMessageDialog(null, "El producto no se encuentra en el inventario", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void actualizarProducto (Producto prod) {
        inventario.put(prod.getCodigo(), prod);
    }
    
    public String listarProductosPorCategoria (String categoria) {
        if (inventario.size() > 0) {
            String resp = "";
            double precioTotal = 0;

            for (Producto prod : inventario.values()) {
                if (categoria == null || prod.getCategoria().equals(categoria)) {
                    resp += prod + "\n";
                    precioTotal += prod.getPrecio() * prod.getCantidad();
                }
            }

            resp += "\nPrecio total: "+precioTotal;

            return resp;
        } else {
            return "No hay nada registrado...";
        }
    }
    
    public String listarProductos () {
        return listarProductosPorCategoria(null);
    }
}