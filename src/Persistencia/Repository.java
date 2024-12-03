
package Persistencia;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository <T>{
    
    public abstract void add(T entity);
    public abstract Optional<T> findById(int id);
    public abstract List<T> findAll();
    
   // AGREGAMOS METODO PARA FILTRAR CON UN PREDICADO Y LOS REPOSITORYS LO PUEDAN IMPLEMENTAR
    public List<T> findBy(Predicate<T> criterio);
    
}
