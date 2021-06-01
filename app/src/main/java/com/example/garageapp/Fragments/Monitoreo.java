package com.example.garageapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.garageapp.R;


public class Monitoreo extends Fragment {
    public static Monitoreo ReturnInstanceView(){
        Monitoreo monitoreo=new Monitoreo();
        return monitoreo;
    }
    public Monitoreo() {
    }

    public static Monitoreo newInstance(String param1, String param2) {
        Monitoreo fragment = new Monitoreo();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monitoreo, container, false);
    }
}
