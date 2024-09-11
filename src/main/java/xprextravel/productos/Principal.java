package xprextravel.productos;

import controlador.Controlador;
import modelo.ManejarInventario;
import vista.VentanaListaProductos;
import vista.VentanaProducto;
import vista.VentanaRegistrar;

public class Principal {
    public static void main(String[] args) {

        ManejarInventario inventario = new ManejarInventario();
        VentanaRegistrar ventanaRegistrar = new VentanaRegistrar();
        VentanaProducto ventanaProducto = new VentanaProducto();
        VentanaListaProductos ventanaListaProductos = new VentanaListaProductos();


        Controlador controlador = new Controlador(ventanaRegistrar, inventario, ventanaProducto, ventanaListaProductos);
    }
}
