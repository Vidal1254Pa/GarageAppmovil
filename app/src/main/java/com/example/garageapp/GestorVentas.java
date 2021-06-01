package com.example.garageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GestorVentas extends AppCompatActivity {

    private BottomNavigationView btnNavegacion;
    private ViewPager PagerItemsGestorVentas;
    private PagerAdapterGestorVentas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_ventas);
        btnNavegacion = findViewById(R.id.btnNavegacion);
        PagerItemsGestorVentas = findViewById(R.id.PagerItemsGestorVentas);
        adapter = new PagerAdapterGestorVentas(getSupportFragmentManager());
        PagerItemsGestorVentas.setAdapter(adapter);
        getSupportActionBar().setTitle(btnNavegacion.getMenu().getItem(0).getTitle());
        btnNavegacion.getMenu().getItem(0).setChecked(true);
        btnNavegacion.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemInicio:
                        PagerItemsGestorVentas.setCurrentItem(0);//0 para vizualizar el fragment inicio
                        break;
                    case R.id.itemProductos:
                        PagerItemsGestorVentas.setCurrentItem(1);//2 para vizualizar el fragment productos
                        break;
                    case R.id.itemMonitorio:
                        PagerItemsGestorVentas.setCurrentItem(2);//3 para vizualizar el fragment monitoreo
                        break;
                }
                getSupportActionBar().setTitle(item.getTitle());
                return true;
            }
        });
        PagerItemsGestorVentas.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                btnNavegacion.getMenu().getItem(position).setChecked(true);
                getSupportActionBar().setTitle(btnNavegacion.getMenu().getItem(position).getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
