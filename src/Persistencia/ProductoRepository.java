
package Persistencia;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import model.*;
import Exceptions.*;
import java.util.ArrayList;

public class ProductoRepository implements Repository<Producto>{
    
    private List<Producto> productos;
    private static final GestorPersistencia<Producto> gestorPersistencia = new GestorPersistencia<>("src\\Data\\productos.dat");
    private int ultimoId;

    public ProductoRepository() {
        this.productos = gestorPersistencia.cargar();
        //this.productos = new ArrayList<>();
        //this.gestorPersistencia = gestorPersistencia;
        this.ultimoId = productos.isEmpty() ? 0 : productos.getLast().getId();
    }

    public int getUltimoId() {
        return ultimoId;
    }

    public void setUltimoId(int ultimoId) {
        this.ultimoId = ultimoId;
    }

    @Override
    public void add(Producto entity) {
         entity.setId(++ultimoId);
          productos.add(entity);
          gestorPersistencia.guardar(productos);                    
    }

    @Override
    public Optional<Producto> findById(int id) {
         return Optional.ofNullable (productos.stream() // Convertimos la lista en un stream
                 .filter(objeto -> objeto.getId() == id)    // Filtra por id, si lo encuentra lo agrega al stream
                 .findFirst()
                 .orElseThrow(() -> new ProductNotFound("Produto no encontrado con id: " + id)));
                     //lanza una exception personalizada si no lo encuentra
    }

    @Override
    public List<Producto> findAll() {
            return new ArrayList<>(productos);
    }

    @Override
    public List<Producto> findBy(Predicate<Producto> criterio) {
        return productos.stream().filter(criterio).toList();
    }
}
