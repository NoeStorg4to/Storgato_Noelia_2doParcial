
package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class GestorPersistencia <T extends Serializable> {
        
//    private final String archivo = "src\\Data\\productos.dat"; 
//
//    public String getArchivo() {
//        return archivo;
//    }
    
    private String archivo;

    public GestorPersistencia(String archivo) {
        this.archivo = archivo;
    }

    public String getArchivo() {
        return archivo;
    }

    
    public  void guardar(List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
            System.out.println("Datos guardados exitosamente en el archivo: " + getArchivo());
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los datos: " + e.getMessage(), e);
            }
    }
    
    public List<T> cargar(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<T>) ois.readObject(); 
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar los datos: " + e.getMessage(), e);
            }
        }
    
}
