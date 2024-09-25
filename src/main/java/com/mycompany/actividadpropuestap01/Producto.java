package com.mycompany.actividadpropuestap01;


public class Producto {

    //Variables
    
    int IdProducto;
    String Nombre;
    double Precio;
    String Categoria;
    
    public Producto(int IdProducto, String Nombre, double Precio, String Categoria) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Categoria = Categoria;
    }
   

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
      
    
}
