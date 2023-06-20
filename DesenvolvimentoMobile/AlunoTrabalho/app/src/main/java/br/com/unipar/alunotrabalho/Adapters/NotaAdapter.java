package br.com.unipar.alunotrabalho.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.alunotrabalho.R;

public class NotaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> lista;

    public NotaAdapter(Context context, ArrayList<String> lista) {
        this.context = context;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).
                    inflate(R.layout.activity_itens_nota,
                            viewGroup, false);
        }

        String nota = lista.get(i);
        TextView tvNota = view.findViewById(R.id.tvNotas);

        tvNota.setText(nota);

        return view;
    }
}
