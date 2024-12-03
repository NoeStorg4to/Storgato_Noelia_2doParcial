
package model;

import java.io.Serializable;

public abstract class Producto implements Serializable{
    
    protected int id; // AUTOINCREMENTAL
    protected String nombre; // MINIMO 3 CARACTERES
    protected double precioBase; //MAYOR A 0

    public Producto(String nombre, double precioBase) {
        this.id = id;
         if (nombre.length() < 3)
            throw new IllegalArgumentException ("\nEl nombre no debe contener menos de 3 caracteres.");
        this.nombre = nombre;
         if (precioBase < 0)
            throw new IllegalArgumentException ("\nEl precio no debe ser menor a cero.");
        this.precioBase = precioBase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
    /// ######### METODO ABSTRACTO ###############
    
    public abstract double calcularPrecioFinal(); // SEGUN EL TIPO DE PRODUCTO
    
       /// ######### METODO  ###############
    
    public String mostrarResumen() { // DEVUELVE ID , NOMBRE, PRECIO FINAL 
        return "--- Resumen ---\nId: " + id +
                "\nNombre: " + nombre + 
                "\nPrecio final: " + precioBase;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precioBase=" + precioBase + '}';
    }
    
}
