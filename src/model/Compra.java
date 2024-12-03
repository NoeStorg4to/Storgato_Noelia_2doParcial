
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int idCompra;
    private String cliente;
    private List<Producto> productos;
    private double total;

    public Compra(String cliente) {
        this.idCompra = idCompra;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    // ############# METODOS #############
    
    public void agregarProducto(Producto producto) {
        productos.add(producto); 
        total = calcularTotal();
    }
    
    public double calcularTotal() {
        return productos.stream()
                .mapToDouble (Producto :: calcularPrecioFinal)
                .sum();
    }
    
    public String mostrarDetalle() {
        return "---- Detalles ----\nId de la compra: " + idCompra +
                "Cliente: " + cliente +
                "Total: " + total;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", cliente=" + cliente + ", productos=" + productos + ", total=" + total + '}';
    }
    
    
    
}
