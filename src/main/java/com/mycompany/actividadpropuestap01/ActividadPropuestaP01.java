package com.mycompany.actividadpropuestap01;

/*
Ejercicio 2: Filtrar y agrupar datos de un archivo secuencialmente
Enunciado:
Tienes un archivo productos.txt que contiene información de productos en el formato 
id_producto,nombre,precio,categoria. Crea un programa que lea este archivo, agrupe 
los productos por categoría, y escriba un archivo separado para cada categoría con 
el nombre de los productos y sus precios.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ActividadPropuestaP01 {

    public static void main(String[] args) {

        //Creamos una lista para almacenar productos
        ArrayList<Producto> productos = new ArrayList<>();
        
        try {
                //Lectura de archivo
                BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
                System.out.println("Archivo leído.");
                
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Leer la línea y separar los campos
                    String[] campos = linea.split(",");
                    int idProducto = Integer.parseInt(campos[0]);
                    String nombre = campos[1];
                    double precio = Double.parseDouble(campos[2]);
                    String categoria = campos[3];
                    
                    //Creamos un objeto Producto
                    Producto producto = new Producto(idProducto, nombre, precio, categoria);                    
                    //Agregar a la lista
                    productos.add(producto);
                    
                }
                
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error: Archivo no encontrado.");
            }
        
            // Agrupar los productos por categoría
            // Creamos una lista para almacenar las categorías únicas
            ArrayList<String> categorias = new ArrayList<>();

            // Recorremos la lista de productos
            for (Producto producto : productos) {
                // Verificamos si la categoría del producto ya está en la lista de categorías
                if (!categorias.contains(producto.getCategoria())) {
                    // Si no está, la agregamos a la lista
                    categorias.add(producto.getCategoria());
                }
            }

            // Escribir los archivos por categoría
            // Recorremos la lista de categorías
            for (String categoria : categorias) {
                // Creamos una lista para almacenar los productos de la categoría actual
                ArrayList<Producto> productosCategoria = new ArrayList<>();

                // Recorremos la lista de productos nuevamente
                for (Producto producto : productos) {
                    // Verificamos si el producto pertenece a la categoría actual
                    if (producto.getCategoria().equals(categoria)) {
                        // Si pertenece, lo agregamos a la lista de productos de la categoría
                        productosCategoria.add(producto);
                    }
                }

                // Creamos un archivo para la categoría actual
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(categoria + ".txt"))) {
                    // Recorremos la lista de productos de la categoría
                    for (Producto producto : productosCategoria) {
                        // Escribimos el nombre y precio del producto en el archivo
                        writer.write(producto.getNombre() + "," + producto.getPrecio() + "\n");
                    }
                } catch (IOException e) {
                    // Manejamos cualquier excepción que pueda ocurrir al escribir el archivo
                    System.out.println("Error al escribir el archivo.");
                }
        }
    }
}
