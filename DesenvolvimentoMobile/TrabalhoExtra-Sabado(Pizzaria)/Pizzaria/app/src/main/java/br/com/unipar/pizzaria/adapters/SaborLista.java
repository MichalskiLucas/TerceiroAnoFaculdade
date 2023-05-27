package br.com.unipar.pizzaria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.pizzaria.R;
import br.com.unipar.pizzaria.model.Sabores;

public class SaborLista extends BaseAdapter {
    private Context context;
    private ArrayList<Sabores> lista;

    public SaborLista(Context context, ArrayList<Sabores> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item_list_sabores, parent, false);

        }

        Sabores sabores = lista.get(position);
        TextView tvSabor = convertView.findViewById(R.id.tvSabor);

        tvSabor.setText(sabores.getNomeSabor());
        return convertView;

    }
}
