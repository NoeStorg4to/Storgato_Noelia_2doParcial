
package model;

public class Electronico extends Producto{
    
    private int garantia; // MAYOR O IGUAL A 0 

    public Electronico(int garantia, String nombre, double precioBase) {
        super(nombre, precioBase);
         if (garantia <= 0)
            throw new IllegalArgumentException ("\nLa garantia no debe ser menor o igual a 0 meses.");
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public double calcularPrecioFinal() {
         // INCREMENTAR 25 % SI LA GARANTIA SUPERA LOS 12 MESES
        if (garantia > 12) {
            double precioFinal = (precioBase* 25) / 100;
            return precioFinal;
        }
        return precioBase;
    }
}
