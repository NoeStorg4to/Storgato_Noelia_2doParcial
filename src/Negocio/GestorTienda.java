
package Negocio;

import model.*;
import Persistencia.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class GestorTienda{
     
     private Repository<Producto> productoRepository;
     private Repository<Compra> compraRepository;
  

    public GestorTienda() {
        this.productoRepository = new ProductoRepository();
        this.compraRepository = new ComprarRepository();

    }

    public Repository<Producto> getProductoRepository() {
        return productoRepository;
    }

    public void setProductoRepository(Repository<Producto> productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Repository<Compra> getCompraRepository() {
        return compraRepository;
    }

    public void setCompraRepository(Repository<Compra> compraRepository) {
        this.compraRepository = compraRepository;
    }
    
    

    // ############# METODOS #############
    
    public void agregarProducto(Producto producto) {
        productoRepository.add(producto);
    }
    
    public Optional<Producto> buscarProductoPorId(int id) {
            return productoRepository.findById(id);
    }
    
    public  void realizarCompra(Compra compra) {
         compraRepository.add(compra);
    }
    
    public  double calcularIngresos() {
        return compraRepository.findAll().stream()
            .mapToDouble(Compra :: getTotal) // Obtiene el total  de cada compra
            .sum(); // Suma la totalidad de lo obtenido
    }
    
    public List<Producto> filtrarProductos(Predicate<Producto> criterio) {
        return productoRepository.findBy(criterio);
    }
    
    public  void aplicarDescuento(Function<Producto, Double> descuento) {
         productoRepository.findAll().forEach(producto -> { // Itera en cada producto y...
        double nuevoPrecio = descuento.apply(producto); // ...aplicamos el descuento en cada producto
        producto.setPrecioBase(nuevoPrecio); // Actualiza el precio del producto
        });
    }

}
