package com.example.garageapp;

public class ProdxMesa {
    public int getId_Mesa() {
        return id_Mesa;
    }

    public String[][] getLista_Prod_Mesa() {
        return Lista_Prod_Mesa;
    }

    private int id_Mesa;

    public void setId_Mesa(int id_Mesa) {
        this.id_Mesa = id_Mesa;
    }

    public void setLista_Prod_Mesa(String[][] lista_Prod_Mesa) {
        Lista_Prod_Mesa = lista_Prod_Mesa;
    }

    private String[][] Lista_Prod_Mesa;
}
