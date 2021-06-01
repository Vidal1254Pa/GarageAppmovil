package com.example.garageapp.APIREST;

import com.example.garageapp.Models.ClientesModel;
import com.example.garageapp.Models.ProductosModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GongoritaService {
    @GET("Gestion/Productos")
    Call<ProductosModel> getProducts();
    @GET("ClientFrecu")
    Call<ClientesModel> getClientes();
}
