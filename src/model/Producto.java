package model;

public class Producto {

    private String nombreProducto;
    private int codigoProducto;
    private double precioUnitario;
    private int cantidadStock;

    public Producto(String nombreProducto, int codigoProducto, double precioUnitario, int cantidadStock) {
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.precioUnitario = precioUnitario;
        this.cantidadStock = cantidadStock;
    }

    public enum CategoriaProducto {
        COMPUTADOR, PERIFERICO, SOFTWARE;

    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

}
