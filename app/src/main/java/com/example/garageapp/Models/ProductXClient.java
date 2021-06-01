package com.example.garageapp.Models;

public class ProductXClient {
    private int id_vendedor;

    public ProductXClient(int id_vendedor, int id_producto, int cantidad) {
        this.id_vendedor = id_vendedor;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private int id_producto;
    private int cantidad;
}
