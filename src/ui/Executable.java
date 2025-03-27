package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private static Scanner input;
    private static Controller controller;

    public static void main(String[] args) {
        Executable();
        menu();
    }

    public static void Executable() {
        input = new Scanner(System.in);
        controller = new Controller();
    }

    public static void menu() {
        System.out.println("\nBienvenido a Martech, la tienda online de productos tecnologicos");

        int var2 = 0;
        do {
            System.out.println("\nMENU PRINCIPAL\n");
            System.out.println("1. Registrar productos");
            System.out.println("2. Actualizar stock de un producto");
            System.out.println("3. Consultar informacion de un producto");
            System.out.println("4. Consultar producto con el precio mas alto");
            System.out.println("5. Calcular el valor total del inventario registrado");
            System.out.println("0. Salir");
            var2 = input.nextInt();
            switch (var2) {
                case 0:
                    System.out.println("Muchas gracias por usar nuestros servicios. Adios :D");
                    break;
                case 1:
                    registerProduct();
                    break;
                case 2:
                    updateProductStock();
                    break;
                case 3:
                    showProductInformation();
                    break;
                case 4:
                    showMostExpensiveProduct();
                    break;
                case 5:
                    showTotalInventoryCost();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (var2 != 0);

    }

    public static void listProducts() {
        System.out.println("Ingrese la cantidad de productos a registrar: ");
        int size = input.nextInt();
        boolean newList = controller.listProducts(size);
        if (newList) {
            System.out.println("Lista de productos creada con exito");
        } else {
            System.out.println("Error, la cantidad de productos debe ser mayor a 0 y menor o igual a 20");
        }
    }

    public static void registerProduct() {
        for (int i = 0; i < controller.getProductos().length; i++) {
            System.out.println("Ingrese el nombre del producto: ");
            String nombreProducto = input.next();
            System.out.println("Ingrese el codigo del producto: ");
            int codigoProducto = input.nextInt();
            System.out.println("Ingrese el precio unitario del producto: ");
            double precioUnitario = input.nextDouble();
            System.out.println("Ingrese la cantidad de stock del producto: ");
            int cantidadStock = input.nextInt();
            controller.registerProduct(nombreProducto, codigoProducto, precioUnitario, cantidadStock);
            System.out.println("Producto registrado con exito");
        }
    }

    public static void updateProductStock() {
        System.out.println("Ingrese el codigo del producto a actualizar: ");
        int codigoProducto = input.nextInt();
        System.out.println("Ingrese la nueva cantidad de stock: ");
        int nuevaCantidad = input.nextInt();
        boolean updated = controller.updateProductStock(codigoProducto, nuevaCantidad);
        if (updated) {
            System.out.println("Stock actualizado con exito");
        } else {
            System.out.println("Error, el producto no existe en la lista");
        }
    }

    public static void showProductInformation() {
        System.out.println("Ingrese el codigo del producto a buscar: ");
        int codigoProducto = input.nextInt();
        boolean found = controller.existCode(codigoProducto);
        if (found) {
            String info = controller.showProductInformation(codigoProducto);
            System.out.println(info);
        } else {
            System.out.println("El producto no existe en la lista");
        }
    }

    public static void showMostExpensiveProduct() {
        System.out.println(controller.showMostExpensiveProduct());
    }

    public static void showTotalInventoryCost() {
        System.out.println("El valor total del inventario es: " + controller.showTotalInventoryCost());
    }
}
