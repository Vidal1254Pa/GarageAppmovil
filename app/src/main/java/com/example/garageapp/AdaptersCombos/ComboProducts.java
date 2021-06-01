package com.example.garageapp.AdaptersCombos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.garageapp.Models.ProductosModel;
import com.example.garageapp.R;

import java.util.ArrayList;
import java.util.List;

public class ComboProducts extends ArrayAdapter<ProductosModel.DataProducts> {
    Context context;
    List<ProductosModel.DataProducts> dataProd;
    List<ProductosModel.DataProducts> sugerencias,tempItems;
    public ComboProducts(@NonNull Context context, @NonNull List<ProductosModel.DataProducts> dataProducts) {
        super(context, 0, dataProducts);
        this.context = context;
        this.dataProd = new ArrayList<>(dataProducts);
        sugerencias= new ArrayList<>();
        tempItems = new ArrayList<>(dataProd);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_products, parent, false);
        ViewHolder vh = new ViewHolder();
        //Toast.makeText(context,position+"",Toast.LENGTH_SHORT).show();
        ((TextView) view.findViewById(R.id.itemTextProduct)).setText(getItem(position).getNombre());
        //vh.itemTextProduct = view.findViewById(R.id.itemTextProduct);
        //vh.itemTextProduct.setText(this.dataProd.get(position).getNombre());
        //view.setTag(vh);
        return view;
    }

    Filter filter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((ProductosModel.DataProducts) resultValue).getNombre();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint == null || constraint.length() == 0) {
                return new FilterResults();
            } else {
                sugerencias.clear();
                for (ProductosModel.DataProducts dtProd : tempItems) {
                    if (dtProd.getNombre().toLowerCase().startsWith(constraint.toString().toLowerCase().trim())) {
                        sugerencias.add(dtProd);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = sugerencias;
                filterResults.count = sugerencias.size();
                return filterResults;
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<ProductosModel.DataProducts> resultfiltered = (ArrayList<ProductosModel.DataProducts>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (ProductosModel.DataProducts c : resultfiltered) {
                    add(c);
                }
                notifyDataSetChanged();
            }
        }
    };

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    static class ViewHolder {
        private TextView itemTextProduct;
    }
}
