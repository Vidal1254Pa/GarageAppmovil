package com.example.garageapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProdxMesaAdapter extends RecyclerView.Adapter<ProdxMesaAdapter.ViewHolder> {
    private ArrayList<ProdxMesa> dataItemList;
    private Context context;

    public ProdxMesaAdapter(ArrayList<ProdxMesa> dataProdxMesa, Context context) {
        dataItemList = dataProdxMesa;
        context = context;
    }

    @NonNull
    @Override
    public ProdxMesaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monit_mesas_prod, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdxMesaAdapter.ViewHolder holder, int position) {
        holder.txtNumMesa.setText("Mesa Nº" + dataItemList.get(position).getId_Mesa());
        for (int i = 0; i < dataItemList.get(position).getLista_Prod_Mesa().length; i++) {
            TextView childTextPedido=new TextView(context);
            childTextPedido.setCompoundDrawables(context.getResources().getDrawable(R.drawable.ic_cancel_24/*falta agregar la condicional para validar estado*/),null,null,null);
            childTextPedido.setCompoundDrawablePadding(5);
            childTextPedido.setText("pruebas");
            holder.ContenerPedidos.addView(childTextPedido);
        }
    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout ContenerPedidos;
        public TextView txtNumMesa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumMesa = itemView.findViewById(R.id.txtNumMesa);
            ContenerPedidos = itemView.findViewById(R.id.ContenerPedidos);
        }
    }
}
