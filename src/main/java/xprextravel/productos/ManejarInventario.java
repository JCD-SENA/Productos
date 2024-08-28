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
        if (!inventario.containsKey(prod))
            inventario.put(prod.getCodigo(), prod);
        else
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
    
    public String listarProductos () {
        String resp = "";
        
        for (Producto prod : inventario.values()) {
            resp += prod + "\n";
        }
        
        return resp;
    }
}