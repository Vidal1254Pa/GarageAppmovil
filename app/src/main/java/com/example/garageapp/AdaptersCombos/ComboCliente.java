package com.example.garageapp.AdaptersCombos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.garageapp.Models.ClientesModel;
import com.example.garageapp.Models.ProductosModel;
import com.example.garageapp.R;

import java.util.ArrayList;
import java.util.List;

public class ComboCliente extends ArrayAdapter<ClientesModel.DataClientes> {
    Context context;
    List<ClientesModel.DataClientes> dtCliente;
    List<ClientesModel.DataClientes> sugerencias, tempItems;

    public ComboCliente(@NonNull Context context, @NonNull List<ClientesModel.DataClientes> dataClientes) {
        super(context, 0, dataClientes);
        this.context = context;
        this.dtCliente = new ArrayList<>(dataClientes);
        sugerencias = new ArrayList<>();
        tempItems = new ArrayList<>(dtCliente);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            public CharSequence convertResultToString(Object resultValue) {
                if (((ClientesModel.DataClientes) resultValue).getNombre() != null) {
                    return ((ClientesModel.DataClientes) resultValue).getDni();
                }
                if (((ClientesModel.DataClientes) resultValue).getRazonsocial() != null) {
                    return ((ClientesModel.DataClientes) resultValue).getRuc();
                }
                return "";
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                if (constraint == null || constraint.length() == 0) {
                    return new FilterResults();
                } else {
                    sugerencias.clear();
                    for (ClientesModel.DataClientes dtCli : tempItems) {
                        if (dtCli.getNombre() != null) {
                            if (dtCli.getNombre().toLowerCase().startsWith(constraint.toString().toLowerCase().trim())) {
                                sugerencias.add(dtCli);
                            }
                        } else {
                            if (dtCli.getRazonsocial() != null) {
                                if (dtCli.getRazonsocial().toLowerCase().startsWith(constraint.toString().toLowerCase().trim())) {
                                    sugerencias.add(dtCli);
                                }
                            }
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
                ArrayList<ClientesModel.DataClientes> resultfiltered = (ArrayList<ClientesModel.DataClientes>) results.values;
                if (results != null && results.count > 0) {
                    Toast.makeText(context, resultfiltered.get(0).getNombre(), Toast.LENGTH_SHORT).show();
                    clear();
                    for (ClientesModel.DataClientes c : resultfiltered) {
                        add(c);
                    }
                    notifyDataSetChanged();
                }
            }
        };
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_products, parent, false);
        ViewHolder vh = new ViewHolder();
        if (getItem(position).getNombre() != null) {
            ((TextView) view.findViewById(R.id.itemTextProduct)).setText(getItem(position).getNombre() + " " + getItem(position).getApellido());
        } else {
            if (getItem(position).getRazonsocial() != null) {
                ((TextView) view.findViewById(R.id.itemTextProduct)).setText(getItem(position).getRazonsocial());
            }
        }
        //vh.itemTextProduct = view.findViewById(R.id.itemTextProduct);
        //vh.itemTextProduct.setText(this.dataProd.get(position).getNombre());
        //view.setTag(vh);
        return view;
    }

    public class ViewHolder {
        private TextView itemTextCliente;
    }
}
