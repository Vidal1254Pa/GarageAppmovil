package com.example.garageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GestorVentas extends AppCompatActivity {

    private BottomNavigationView btnNavegacion;
    private ViewPager PagerItemsGestorVentas;
    private PagerAdapterGestorVentas adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_ventas);
        btnNavegacion=findViewById(R.id.btnNavegacion);
        PagerItemsGestorVentas=findViewById(R.id.PagerItemsGestorVentas);
        adapter=new PagerAdapterGestorVentas(getSupportFragmentManager());
        PagerItemsGestorVentas.setAdapter(adapter);
        getSupportActionBar().setTitle(btnNavegacion.getMenu().getItem(0).getTitle());
        btnNavegacion.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemInicio:
                        PagerItemsGestorVentas.setCurrentItem(0);//0 para vizualizar el fragment inicio
                        break;
                    case R.id.itemProductos:
                        PagerItemsGestorVentas.setCurrentItem(2);//2 para vizualizar el fragment productos
                        break;
                    case R.id.itemMonitorio:
                        PagerItemsGestorVentas.setCurrentItem(3);//3 para vizualizar el fragment monitoreo
                        break;
                    /*case R.id.itemMesas:
                        PagerItemsGestorVentas.setCurrentItem(1);//1 para vizualizar el fragment mesas
                        break;*/
                }
                getSupportActionBar().setTitle(item.getTitle());
                return true;
            }
        });
    }
}
