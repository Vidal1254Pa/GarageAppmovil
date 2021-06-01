package com.example.garageapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.garageapp.Fragments.Inicio;
import com.example.garageapp.Fragments.Monitoreo;
import com.example.garageapp.Fragments.Productos;

public class PagerAdapterGestorVentas extends FragmentPagerAdapter {

    public PagerAdapterGestorVentas(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Inicio.ReturnInstanceView();
            case 1:
                return Productos.ReturnInstanceView();
            case 2:
                return Monitoreo.ReturnInstanceView();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
