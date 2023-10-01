package br.com.unipar.forcavendas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.forcavendas.R;
import br.com.unipar.forcavendas.model.Parcela;

public class ParcelaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Parcela> lista;

    public ParcelaAdapter(Context context, ArrayList<Parcela> lista) {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_lista_parcela, parent, false);
        }

        Parcela parcela = lista.get(position);
        TextView nrParcela = convertView.findViewById(R.id.nrParcela);
        TextView nrValor = convertView.findViewById(R.id.nrValor);
        nrParcela.setText(String.valueOf(parcela.getId()));
        nrValor.setText(String.valueOf(parcela.getVlParcela()));
        return convertView;
    }
}
