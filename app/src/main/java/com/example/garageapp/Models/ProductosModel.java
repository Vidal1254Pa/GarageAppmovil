package com.example.garageapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductosModel {
    public List<DataProducts> getGetDataProductos() {
        return getDataProductos;
    }

    public void setGetDataProductos(List<DataProducts> getDataProductos) {
        this.getDataProductos = getDataProductos;
    }

    @SerializedName("data")
    private List<DataProducts> getDataProductos;

    public class DataProducts {
        public int getId_Producto() {
            return id_Producto;
        }

        public void setId_Producto(int id_Producto) {
            this.id_Producto = id_Producto;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

        public int getId_Categoria() {
            return id_Categoria;
        }

        public void setId_Categoria(int id_Categoria) {
            this.id_Categoria = id_Categoria;
        }

        public Double getPrecio() {
            return Precio;
        }

        public void setPrecio(Double precio) {
            Precio = precio;
        }

        @SerializedName("id_Producto")
        private int id_Producto;
        @SerializedName("Nombre")
        private String Nombre;
        @SerializedName("id_Categoria")
        private int id_Categoria;
        @SerializedName("Precio")
        private Double Precio;
    }
}
