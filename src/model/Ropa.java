
package model;


public class Ropa extends Producto{
    
    private String talla; // “S”, “M”, “L”, “XL” NO PUEDE SER NULO

    public Ropa(String talla, String nombre, double precioBase) {
        super(nombre, precioBase);
          if (talla == null)
            throw new IllegalArgumentException ("\nLa talla no puede ser nula.");
         if (!talla.equals("S") && !talla.equals("M") && !talla.equals("L") && !talla.equals("XL"))
            throw new IllegalArgumentException ("\nLa talla no puede ser distinto de “S”, “M”, “L”, “XL”");
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public double calcularPrecioFinal() {
        // INCREMENTAR 10 % SI LA TALLA ES XL
        if (talla.equals("XL")) {
            double precioFinal = (precioBase* 10) / 100;
            return precioFinal;
        }
        return precioBase;
    }

}
