package br.com.unipar.forcavendas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.forcavendas.R;
import br.com.unipar.forcavendas.model.Cliente;
import br.com.unipar.forcavendas.model.ItemPedidoVenda;

public class ClienteAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cliente> lista;

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

    public ClienteAdapter(Context context, ArrayList<Cliente> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_lista_cliente, parent, false);
        }

        Cliente cliente = lista.get(position);
        TextView nmCliente = convertView.findViewById(R.id.nmCliente);
        nmCliente.setText(cliente.getNome());
        return convertView;
    }
}
