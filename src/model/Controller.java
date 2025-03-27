package model;

public class Controller {

    private Producto[] productos;

    public Controller() {
        this.productos = new Producto[0];
    }

    public boolean listProducts(int size) {
        boolean newList = false;
        if (size > 0 && size <= 20) {
            productos = new Producto[size];
            newList = true;
        }
        return newList;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public void registerProduct(String nombreProducto, int codigoProducto, double precioUnitario, int cantidadStock) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = new Producto(nombreProducto, codigoProducto, precioUnitario, cantidadStock);
                break;
            }
        }
    }

    public boolean updateProductStock(int codigoProducto, int nuevaCantidad) {
        boolean actualizado = false;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].getCodigoProducto() == codigoProducto) {
                productos[i].setCantidadStock(nuevaCantidad);
                actualizado = true;
                break;
            }
        }
        return actualizado;
    }

    public boolean existCode(int codigoProducto) {
        boolean encontrado = false;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].getCodigoProducto() == codigoProducto) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public String showProductInformation(int codigoProducto) {
        String info = "";
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].getCodigoProducto() == codigoProducto) {
                info += "Nombre: " + productos[i].getNombreProducto() + "\n";
                info += "Codigo: " + productos[i].getCodigoProducto() + "\n";
                info += "Precio Unitario: " + productos[i].getPrecioUnitario() + "\n";
                info += "Stock: " + productos[i].getCantidadStock();
                break;
            }
        }
        return info;
    }

    public String showMostExpensiveProduct() {
        String info = "";
        double productExpensive = 0;
        int codigoProducto = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productExpensive < productos[i].getPrecioUnitario()) {
                productExpensive = productos[i].getPrecioUnitario();
                codigoProducto = productos[i].getCodigoProducto();
            }
        }
        info = showProductInformation(codigoProducto);
        return info;
    }

    public double showTotalInventoryCost() {
        double total = 0;
        for (int i = 0; i < productos.length; i++) {
            total += productos[i].getPrecioUnitario() * productos[i].getCantidadStock();
        }
        return total;
    }

}

/**
 * Metodos
 */
