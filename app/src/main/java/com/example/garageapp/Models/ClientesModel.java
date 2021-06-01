package com.example.garageapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientesModel {
    public List<DataClientes> getGetDataClientes() {
        return getDataClientes;
    }

    public void setGetDataClientes(List<DataClientes> getDataClientes) {
        this.getDataClientes = getDataClientes;
    }

    @SerializedName("data")
    private List<DataClientes> getDataClientes;
    public class DataClientes {
        public int getId_Clientes() {
            return id_Clientes;
        }

        public void setId_Clientes(int id_Clientes) {
            this.id_Clientes = id_Clientes;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = "PEDRO";
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getDistrito() {
            return distrito;
        }

        public void setDistrito(String distrito) {
            this.distrito = distrito;
        }

        public String getRazonsocial() {
            return razonsocial;
        }

        public void setRazonsocial(String razonsocial) {
            this.razonsocial = razonsocial;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getRuc() {
            return ruc;
        }

        public void setRuc(String ruc) {
            this.ruc = ruc;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        @SerializedName("id_Clientes")
        private int id_Clientes;
        @SerializedName("nombre")
        private String nombre;
        @SerializedName("apellido")
        private String apellido;
        @SerializedName("distrito")
        private String distrito;
        @SerializedName("razonsocial")
        private String razonsocial;
        @SerializedName("telefono")
        private int telefono;
        @SerializedName("dni")
        private String dni;
        @SerializedName("ruc")
        private String ruc;
        @SerializedName("direccion")
        private String direccion;
    }
}
