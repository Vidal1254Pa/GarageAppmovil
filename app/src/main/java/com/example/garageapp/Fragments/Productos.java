package com.example.garageapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.garageapp.APIREST.GongoritaService;
import com.example.garageapp.APIREST.ImplementMethods;
import com.example.garageapp.AdaptersCombos.ComboCliente;
import com.example.garageapp.AdaptersCombos.ComboProducts;
import com.example.garageapp.Models.ClientesModel;
import com.example.garageapp.Models.ProductXClient;
import com.example.garageapp.Models.ProductosModel;
import com.example.garageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Productos extends Fragment implements View.OnClickListener {
    private AutoCompleteTextView AutoCompleteEditProduct, AutoCompleteEditCliente;
    private GongoritaService gongoritaService;
    private ComboProducts comboProductsAdapter;
    private ComboCliente comboClientesAdapter;
    private Button btnAddProducxClient;
    EditText EdtCantidadProd;
    public static Productos ReturnInstanceView() {
        Productos productos = new Productos();
        return productos;
    }

    public Productos() {

    }

    public static Productos newInstance(String param1, String param2) {
        Productos fragment = new Productos();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        AutoCompleteEditCliente = view.findViewById(R.id.AutoCompleteEditCliente);
        EdtCantidadProd=view.findViewById(R.id.EdtCantidadProd);
        AutoCompleteEditProduct = view.findViewById(R.id.AutoCompleteEditProduct);
        btnAddProducxClient=view.findViewById(R.id.btnAddProducxClient);
        btnAddProducxClient.setOnClickListener(this);
        AutoCompleteEditProduct.setThreshold(1);
        AutoCompleteEditCliente.setThreshold(1);
        try {
            gongoritaService = new ImplementMethods(getContext()).getMethods();
            gongoritaService.getProducts().enqueue(new Callback<ProductosModel>() {
                @Override
                public void onResponse(Call<ProductosModel> call, Response<ProductosModel> response) {
                    comboProductsAdapter=new ComboProducts(getContext(),new ArrayList(response.body().getGetDataProductos()));
                    AutoCompleteEditProduct.setAdapter(comboProductsAdapter);
                    AutoCompleteEditProduct.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            AutoCompleteEditProduct.showDropDown();
                            return false;
                        }
                    });
                }

                @Override
                public void onFailure(Call<ProductosModel> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gongoritaService = new ImplementMethods(getContext()).getMethods();
            gongoritaService.getClientes().enqueue(new Callback<ClientesModel>() {
                @Override
                public void onResponse(Call<ClientesModel> call, Response<ClientesModel> response) {
                    comboClientesAdapter=new ComboCliente(getContext(),new ArrayList(response.body().getGetDataClientes()));
                    AutoCompleteEditCliente.setAdapter(comboClientesAdapter);
                    AutoCompleteEditCliente.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            AutoCompleteEditCliente.showDropDown();
                            return false;
                        }
                    });
                }
                @Override
                public void onFailure(Call<ClientesModel> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddProducxClient:
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Vendedores_ProducxClient");
                ProductXClient user = new ProductXClient(1, 2,Integer.parseInt(EdtCantidadProd.getText().toString()));
                myRef.setValue(user);
                ValueEventListener postListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get Post object and use the values to update the UI
                        Toast.makeText(getContext(),dataSnapshot.toString(),Toast.LENGTH_SHORT).show();
                        // ..
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                    }
                };
                myRef.addValueEventListener(postListener);
                break;
        }
    }
}
