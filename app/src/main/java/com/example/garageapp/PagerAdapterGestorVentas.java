package com.example.garageapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class PagerAdapterGestorVentas extends FragmentPagerAdapter {

    public PagerAdapterGestorVentas(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return Inicio.ReturnInstanceView();
            case 1:
                return Mesas.ReturnInstanceView();
            case 2:
                return Productos.ReturnInstanceView();
            case 3:
                return Monitoreo.ReturnInstanceView();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
