package br.com.unipar.pizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.unipar.pizzaria.adapters.SaborLista;
import br.com.unipar.pizzaria.model.Pedido;
import br.com.unipar.pizzaria.model.Sabores;
import br.com.unipar.pizzaria.utils.Globais;

public class MainActivity extends AppCompatActivity {

    private Spinner spSabores;
    private ListView lvSabores;
    private TextView tvTamanho;
    private TextView tvSabores;
    private TextView tvAdicional;
    private TextView tvValor;
    private CheckBox cbComBorda;
    private CheckBox cbRefrigerante;
    private String saborSelecionado;
    private RadioButton rbPequena;
    private RadioButton rbMedia;
    private RadioButton rbGrande;
    private Button btLimpar;
    private Double valorSabor = 0.0;
    private Double valorAdicional = 0.0;
    private String valorPedido;
    private ArrayList<Pedido> pedidos;
    private int saborRemove = -1;
    private int qtdSabores = 4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spSabores = findViewById(R.id.spSabores);
        lvSabores = findViewById(R.id.lvSabores);
        tvTamanho = findViewById(R.id.tvTamanho);
        tvSabores = findViewById(R.id.tvSabores);
        tvAdicional = findViewById(R.id.tvAdicional);
        cbComBorda = findViewById(R.id.cbComBorda);
        cbRefrigerante = findViewById(R.id.cbRefrigerante);
        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);
        tvValor = findViewById(R.id.tvValor);
        btLimpar = findViewById(R.id.btLimpar);
        if(Globais.listaSabores == null) {
            Globais.listaSabores = new ArrayList<>();
        }

        String[] vetorSabores= new String[]{"","Margherita", "Calabresa", "Quatro Queijos",
                "Pepperoni", "Frango com Catupiry", "Portuguesa", "Napolitana", "Muçarela",
                "Alho e Óleo", "Bacon com Milho", "Atum", "Palmito", "Rúcula com Tomate Seco",
                "Camarão", "Provolone", "Vegetariana", "Baiana", "Cheddar com Batata Palha",
                "Frango com Requeijão"};
        ArrayAdapter adapterSabores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorSabores);

        spSabores.setAdapter(adapterSabores);

        spSabores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                saborSelecionado = (String)spSabores.getItemAtPosition(position);
                if (saborSelecionado != ""){
                    if(qtdSabores == Globais.listaSabores.size()){
                        Toast.makeText(MainActivity.this, "O limite de sabores para seu temanho de pizza é de ("+qtdSabores+")", Toast.LENGTH_SHORT).show();
                    }else{
                        salvarSabor();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lvSabores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                saborRemove = position;
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparTela();
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
        atualizaPedido(2, String.valueOf(sabor));

    }

    private void atualizaLista(ArrayList<Sabores> lista) {

        SaborLista adapter = new SaborLista(this, lista);

        lvSabores.setAdapter(adapter);

    }

    public void selecionarOpcao(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checked = radio.isChecked();

        if(checked) {
            switch (view.getId()){
                case R.id.rbPequena:
                    valorSabor = 20.00;
                    atualizaPedido(1, "Pequena");
                    Toast.makeText(MainActivity.this, "Tamanho pequeno selecionado (1 - Sabor)", Toast.LENGTH_SHORT).show();
                    qtdSabores = 1;
                    break;
                case R.id.rbMedia:
                    valorSabor = 30.00;
                    atualizaPedido(1, "Media");
                    Toast.makeText(MainActivity.this, "Tamanho media selecionado (2 - Sabores)", Toast.LENGTH_SHORT).show();
                    qtdSabores = 2;
                    break;
                case R.id.rbGrande:
                    valorSabor = 40.00;
                    atualizaPedido(1, "Grande");
                    Toast.makeText(MainActivity.this, "Tamanho grande selecionado (4 - Sabores)", Toast.LENGTH_SHORT).show();
                    qtdSabores = 4;
                    break;
            }
        }

    }

    private void atualizaPedido(int operacao, String text) {
        String texto = "";
        switch (operacao){
            case 1:
                tvTamanho.setText("Pizza "+text+" com os seguintes sabores:");
                break;
            case 2:
                for (int i = 0; i < Globais.listaSabores.size(); i++){
                    texto = texto+"- "+Globais.listaSabores.get(i)+"\n";
                }
                tvSabores.setText(texto);
                break;
            case 3:
                tvAdicional.setText(text);
                break;
        }

        valorPedido = String.valueOf(valorAdicional + valorSabor);
        tvValor.setText("Total do Pedido: R$"+valorPedido);

    }

    public void validaAdicional(View view) {
        String adicionais = "Sem adicionais";
        if(cbComBorda.isChecked() && cbRefrigerante.isChecked()){
            valorAdicional = 15.00;
            adicionais = "Com borda e refrigerante";
        }else if (cbComBorda.isChecked()) {
            adicionais = "Com borda";
            valorAdicional = 10.00;
        }else if (cbRefrigerante.isChecked()) {
            adicionais = "Com refrigerante";
            valorAdicional = 5.00;
        }

        atualizaPedido(3, adicionais);
    }

    public void removerSabor(View view) {

        if(saborRemove == -1){
            Toast.makeText(MainActivity.this, "Selecione o sabor que deseja remover", Toast.LENGTH_SHORT).show();
        }else {

            Globais.listaSabores.remove(saborRemove);

            atualizaPedido(2, "");
            atualizaLista(Globais.listaSabores);
        }

    }

    public void SalvarPedido(View view) {
        if (Globais.listaSabores == null||Globais.listaSabores.size() == 0){
            Toast.makeText(MainActivity.this, "É necessário escolher pedidos para finalizar o pedido", Toast.LENGTH_SHORT).show();
        }else{
            int id = 0;
            String tamanho = "";
            Pedido pedido = new Pedido();
            pedido.setId(id + 1);
            pedido.setValorPedido(Double.parseDouble(valorPedido));
            pedido.setComBorda(cbComBorda.isChecked() ? true : false);
            pedido.setComRefrigerante(cbRefrigerante.isChecked() ? true : false);
            pedido.setSabores(Globais.listaSabores);
            if (rbPequena.isChecked()){
                tamanho = "PEQUENA";
            } else if (rbMedia.isChecked()) {
                tamanho = "MEDIA";
            } else if (rbGrande.isChecked()) {
                tamanho = "GRANDE";
            }
            pedido.setTamanho(tamanho);

            if(pedidos == null) {
                pedidos = new ArrayList<>();
            }
            pedidos.add(pedido);

            Toast.makeText(MainActivity.this, "Pedido adicionado com sucesso", Toast.LENGTH_SHORT).show();

            limparTela();
        }

    }

    public void limparTela() {
        if (rbPequena.isChecked()){
            rbPequena.setChecked(false);
        } else if (rbMedia.isChecked()) {
            rbMedia.setChecked(false);
        } else if (rbGrande.isChecked()) {
            rbPequena.setChecked(false);
        }
        Globais.listaSabores.clear();
        atualizaLista(Globais.listaSabores);
        cbRefrigerante.setChecked(false);
        cbComBorda.setChecked(false);
        tvValor.setText("");
        tvAdicional.setText("");
        tvSabores.setText("");
        tvTamanho.setText("");

        valorSabor = 0.0;
        valorPedido = "";
        valorAdicional = 0.0;
    }
}