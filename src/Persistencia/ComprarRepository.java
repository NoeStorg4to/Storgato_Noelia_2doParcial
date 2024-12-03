
package Persistencia;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import model.*;
import Exceptions.*;
import java.util.ArrayList;

public class ComprarRepository implements Repository<Compra>{
     
    private List<Compra> compras;
    private  static final GestorPersistencia<Compra> gestorPersistencia = new GestorPersistencia<> ("src\\Data\\compras.dat");
     private int ultimoId;

    public ComprarRepository() {
       this.compras = gestorPersistencia.cargar();
       // this.compras = new ArrayList<>();
        //this.gestorPersistencia = gestorPersistencia;
        this.ultimoId = compras.isEmpty() ? 0 : compras.getLast().getIdCompra();
    }


    public int getUltimoId() {
        return ultimoId;
    }

    public void setUltimoId(int ultimoId) {
        this.ultimoId = ultimoId;
    }

    @Override
    public void add(Compra entity) {
        entity.setIdCompra(++ultimoId);
         compras.add(entity);
         gestorPersistencia.guardar(compras);   
    }

    @Override
    public Optional<Compra> findById(int id) {
         return Optional.ofNullable (compras.stream() // Convertimos la lista en un stream
                 .filter(objeto -> objeto.getIdCompra() == id)    // Filtra por id, si lo encuentra lo agrega al stream
                 .findFirst()
                 .orElseThrow(() -> new CompraNotFound("Compra no encontrada con id: " + id)));
                 //lanza una exception personalizada si no lo encuentra
    }

    @Override
    public List<Compra> findAll() {
            return new ArrayList<>(compras);
    }

    @Override
    public List<Compra> findBy(Predicate<Compra> criterio) {
         return compras.stream().filter(criterio).toList();
    }

}
