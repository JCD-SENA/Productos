package controlador;

import modelo.ManejarInventario;
import modelo.Producto;
import vista.VentanaListaProductos;
import vista.VentanaProducto;
import vista.VentanaRegistrar;

public class Controlador {

    private VentanaRegistrar ventanaRegistrar;
    private ManejarInventario inventario;
    private VentanaProducto ventanaProducto;
    private VentanaListaProductos ventanaListaProductos;

    public Controlador(VentanaRegistrar ventanaRegistrar, ManejarInventario inventario, VentanaProducto ventanaProducto, VentanaListaProductos ventanaListaProductos) {
        this.ventanaRegistrar = ventanaRegistrar;
        this.inventario = inventario;
        this.ventanaProducto = ventanaProducto;
        this.ventanaListaProductos = ventanaListaProductos;

        initControlador();
    }
    
    public void ocultarProducto () {
        ventanaProducto.setVisible(false);
    }

    // Inicializa el controlador y establece la visibilidad de la ventana de registro
    private void initControlador() {
        ventanaRegistrar.setControlador(this);
        ventanaRegistrar.setVisible(true);
    }

    // Registra un nuevo producto en el inventario
    public void registrarProducto(String nombre, String codigo, String categoria, int precio, int cantidad) {

        if (nombre == null || nombre.isEmpty() || codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Nombre y código del producto no pueden estar vacíos.");
        }
        Producto prod = new Producto(nombre, codigo, categoria, precio, cantidad);
        inventario.agregarProducto(prod);
    }
    
    public void refrescar () {
        ventanaListaProductos.cargar(inventario);
    }

    // Consulta un producto en el inventario por su código
    public Producto consultarProducto(String codigo) {
        return inventario.consultarProducto(codigo);
    }
    
    public void eliminarProducto(String codigo) {
        inventario.eliminarProducto(codigo);
    }

    // Muestra la lista de productos en la ventana correspondiente
    public void listarProductos() {
        ventanaListaProductos.cargar(inventario);
        ventanaListaProductos.setVisible(true);
    }

    // Carga un producto en la ventana de detalles del producto y lo muestra
    public void cargarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        ventanaProducto.cargarProducto(producto);
        ventanaProducto.setVisible(true);
    }
}
