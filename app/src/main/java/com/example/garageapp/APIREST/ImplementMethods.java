package com.example.garageapp.APIREST;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.garageapp.Models.ProductosModel;
import com.example.garageapp.R;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImplementMethods {
    private Context context;
    private  static Retrofit retrofit;

    public ImplementMethods(@NonNull Context context) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(this.context.getString(R.string.url_WebService))
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .build();
    }

    public static GongoritaService getMethods() {
        return retrofit.create(GongoritaService.class);
    }

}
