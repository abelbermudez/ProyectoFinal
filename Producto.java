import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private String codProducto;
    private String nombre;
    private double costo;
    private double precio;

    public Producto(String codProducto, String nombre, double costo, double precio) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.costo = costo;
        this.precio = precio;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codProducto='" + codProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", precio=" + precio +
                '}';
    }
}