package br.com.unipar.forcavendas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.forcavendas.R;
import br.com.unipar.forcavendas.model.Item;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> lista;

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

    public ItemAdapter(Context context, ArrayList<Item> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_lista_itempedido, parent, false);
        }

        Item item = lista.get(position);
        TextView nmItem = convertView.findViewById(R.id.nmItem);
        nmItem.setText(item.getDescricao());
        return convertView;
    }
}
