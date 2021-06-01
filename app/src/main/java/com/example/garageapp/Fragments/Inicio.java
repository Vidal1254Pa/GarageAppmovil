package com.example.garageapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.garageapp.R;



public class Inicio extends Fragment {

    public static Inicio ReturnInstanceView(){
        Inicio inicio=new Inicio();
        return inicio;
    }
    public Inicio() {
    }

    public static Inicio newInstance(String param1, String param2) {
        Inicio fragment = new Inicio();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }
}
