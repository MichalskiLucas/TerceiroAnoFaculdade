package br.com.unipar.pizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.unipar.pizzaria.adapters.SaborLista;
import br.com.unipar.pizzaria.model.Sabores;
import br.com.unipar.pizzaria.utils.Globais;

public class MainActivity extends AppCompatActivity {

    private Spinner spSabores;
    private ListView lvSabores;
    private TextView tvPedido;
    private String saborSelecionado;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSabores = findViewById(R.id.spSabores);
        lvSabores = findViewById(R.id.lvSabores);
        tvPedido = findViewById(R.id.tvPedido);

        String[] vetorSabores = new String[]{"", "Strogonoff", "Frango c/ Catupiry"};

        ArrayAdapter adapterSabores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorSabores);

        spSabores.setAdapter(adapterSabores);

        spSabores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                saborSelecionado = (String)spSabores.getItemAtPosition(position);
                salvarSabor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void salvarSabor() {
        Sabores sabor = new Sabores(saborSelecionado);

        if(Globais.listaSabores == null) {
            Globais.listaSabores = new ArrayList<>();
        }

        if(sabor != null){
            Globais.listaSabores.add(sabor);
        }

        atualizaLista(Globais.listaSabores);

    }

    private void atualizaLista(ArrayList<Sabores> lista) {

        SaborLista adapter = new SaborLista(this, lista);

        lvSabores.setAdapter(adapter);

    }

    public void selecionarOpcao(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checked = radio.isChecked();

        switch (view.getId()){
            case R.id.rbPequena:
                AtualizaPedido(1, "Pequena");
            case R.id.rbMedia:
                AtualizaPedido(1, "Media");
            case R.id.rbGrande:
                AtualizaPedido(1, "Grande");
        }


    }

    private void AtualizaPedido(int operacao, String text) {

        switch (operacao){
            case 1:
                tvPedido.setText("Pizza "+text+" com os seguintes sabores");
        }

    }
}