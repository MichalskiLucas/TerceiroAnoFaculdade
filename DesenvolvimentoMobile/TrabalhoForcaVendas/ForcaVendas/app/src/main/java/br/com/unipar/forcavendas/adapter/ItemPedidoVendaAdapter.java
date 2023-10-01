package br.com.unipar.forcavendas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.forcavendas.R;
import br.com.unipar.forcavendas.model.ItemPedidoVenda;

public class ItemPedidoVendaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ItemPedidoVenda> lista;

    public ItemPedidoVendaAdapter(Context context, ArrayList<ItemPedidoVenda> lista) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_lista_itempedido, parent, false);
        }

        ItemPedidoVenda itemPedidoVenda = lista.get(position);
        TextView nmItem = convertView.findViewById(R.id.nmItem);
        TextView qtItem = convertView.findViewById(R.id.qtItem);
        nmItem.setText(itemPedidoVenda.getDescItem());
        qtItem.setText(String.valueOf(itemPedidoVenda.getQtItem()));
        return convertView;
    }
}
