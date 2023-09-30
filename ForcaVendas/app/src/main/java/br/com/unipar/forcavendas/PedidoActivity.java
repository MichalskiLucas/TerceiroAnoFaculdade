package br.com.unipar.forcavendas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.unipar.forcavendas.adapter.ItemPedidoVendaAdapter;
import br.com.unipar.forcavendas.adapter.ParcelaAdapter;
import br.com.unipar.forcavendas.controller.ClienteController;
import br.com.unipar.forcavendas.controller.EnderecoController;
import br.com.unipar.forcavendas.controller.ItemController;
import br.com.unipar.forcavendas.controller.ItemPedidoVendaController;
import br.com.unipar.forcavendas.controller.PedidoVendaController;
import br.com.unipar.forcavendas.model.Cliente;
import br.com.unipar.forcavendas.model.Endereco;
import br.com.unipar.forcavendas.model.Item;
import br.com.unipar.forcavendas.model.ItemPedidoVenda;
import br.com.unipar.forcavendas.model.Parcela;
import br.com.unipar.forcavendas.model.PedidoVenda;

public class PedidoActivity extends AppCompatActivity {

    private Spinner spinnerItens;
    private RadioButton rbEntrega;
    private RadioButton rbRetirada;
    private EditText cdEndereco;
    private EditText cdItem;
    private EditText qtItem;
    private EditText vlUnit;
    private EditText unMedida;
    private ListView lvItens;
    private EditText totPedido;
    private EditText totItens;
    private RadioButton rbAvista;
    private RadioButton rbAprazo;
    private EditText qtParcelas;
    private ListView lvParcelas;
    private Button btVoltar;
    private Button btSalvar;
    private Button btAddItem;
    private EditText codPedido;
    private TextView tvEndereco;
    private EditText descItem;
    private ClienteController clienteController;
    private ItemController itemController;
    private TextView tvParcelas;
    private List<String> listaClienteString = new ArrayList<>();
    private ArrayList<ItemPedidoVenda> listaItemPedido = new ArrayList<>();
    private ArrayList<Parcela> listaParcela = new ArrayList<Parcela>();
    private EnderecoController enderecoController;
    private PedidoVendaController pedidoVendaController;
    private ItemPedidoVendaController itemPedidoVendaController;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        spinnerItens = findViewById(R.id.spinnerItens);
        rbEntrega = findViewById(R.id.rbEntrega);
        rbRetirada = findViewById(R.id.rbRetirada);
        cdEndereco = findViewById(R.id.cdEndereco);
        cdItem = findViewById(R.id.cdItem);
        qtItem = findViewById(R.id.qtItem);
        vlUnit = findViewById(R.id.vlUnit);
        unMedida = findViewById(R.id.unMedida);
        lvItens = findViewById(R.id.lvItens);
        totPedido = findViewById(R.id.totPedido);
        totItens = findViewById(R.id.totItens);
        rbAvista = findViewById(R.id.rbAvista);
        rbAprazo = findViewById(R.id.rbAprazo);
        qtParcelas  = findViewById(R.id.qtParcelas);
        lvParcelas = findViewById(R.id.lvParcelas);
        btSalvar = findViewById(R.id.btSalvar);
        btVoltar = findViewById(R.id.btVoltar);
        tvEndereco = findViewById(R.id.tvEndereco);
        btAddItem = findViewById(R.id.btAddItem);
        codPedido = findViewById(R.id.codPedido);
        descItem = findViewById(R.id.descItem);
        tvParcelas = findViewById(R.id.tvParcelas);
        clienteController = new ClienteController(this);
        itemController = new ItemController(this);
        listaClienteString = carregaCliente();
        enderecoController = new EnderecoController(this);
        pedidoVendaController = new PedidoVendaController(this);
        itemPedidoVendaController = new ItemPedidoVendaController(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaClienteString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItens.setAdapter(adapter);
        retornaPedido();
        atualizaListaItem(listaItemPedido);

        btVoltar.setOnClickListener(v -> retornarPagina());
        btSalvar.setOnClickListener(v -> salvarPedido());
        
        cdEndereco.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if (!cdEndereco.getText().toString().equals("")){
                        Endereco endereco;
                        endereco = enderecoController.retornarEndereco(Integer.parseInt(cdEndereco.getText().toString()));
                        validaEndereco(endereco);
                        if (endereco == null){
                            cdEndereco.setError("Endereco nao cadastrado");
                        }
                    }

                }
            }
        });

        cdItem.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String s = cdItem.getText().toString();
                    if(!s.equals("")){
                        int idItem = Integer.parseInt(cdItem.getText().toString());
                        Item item = itemController.retornarItem(idItem);
                        vlUnit.setText(String.valueOf(item.getVlrUnit()));
                        descItem.setText(item.getDescricao());
                        unMedida.setText(String.valueOf(item.getUnMedida()));
                    }

                }
            }
        });


        qtParcelas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    calculaParcelas();
                }
            }
        });

        btAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionaListaItem();
                atualizaListaItem(listaItemPedido);
                atualizaValorTotal(listaItemPedido);
                atualizaTotalItem(listaItemPedido);
                limpaCamposItem();
            }
        });

    }

    private void salvarPedido() {
        PedidoVenda pedidoVenda = new PedidoVenda();
        String[] parts = spinnerItens.getSelectedItem().toString().split("-");
        int codCliente = Integer.parseInt(parts[0].trim());
        String tpPagamento = "";
        if (rbAvista.isChecked()){
            tpPagamento = "A";
        } else if (rbAprazo.isChecked()) {
            if(qtParcelas.getText().toString().equals("")){
                qtParcelas.setError("É necessário informar pelos uma parcela");
            }else{
                tpPagamento = "P";
            }

        }
        String validacao = pedidoVendaController.validaPedido(codCliente,  tpPagamento);

        if (!validacao.equals("")){
            if (validacao.contains("cliente")){
                Toast.makeText(this,
                        "Erro ao cadastrar Pedido, Cliente deve ser informado.",
                        Toast.LENGTH_LONG).show();
            }
            if (validacao.contains("pagamento")){
                Toast.makeText(this,
                        "Erro ao cadastrar Pedido, Tipo de pagamento deve ser informado.",
                        Toast.LENGTH_LONG).show();
            }
        }else{
            if(listaItemPedido.stream().count() > 0){
                parts = spinnerItens.getSelectedItem().toString().split("-");
                codCliente = Integer.parseInt(parts[0].trim());
                pedidoVenda.setCodCliente(codCliente);
                pedidoVenda.setValorTotal(Double.parseDouble(totPedido.getText().toString()));
                pedidoVenda.setCodigo(Integer.parseInt(codPedido.getText().toString()));

                if (rbAvista.isChecked()){
                    pedidoVenda.setTpPagamento("A");
                } else if (rbAprazo.isChecked()) {
                    if(qtParcelas.getText().toString().equals("")){
                        qtParcelas.setError("É necessário informar pelos uma parcela");
                    }else{
                        pedidoVenda.setTpPagamento("P");
                    }

                }

                if (rbEntrega.isChecked()){
                    if (cdEndereco.getText().toString().equals("")){
                        cdEndereco.setError("É necessário informar o endereco");
                    }else{
                        pedidoVenda.setCodEnderecoEntrega(Integer.parseInt(cdEndereco.getText().toString()));
                    }
                }


                if (pedidoVendaController.salvarPedido(pedidoVenda) > 0){

                    for(int i = 0; i < listaItemPedido.size(); i++){
                        ItemPedidoVenda itemPedidoVenda = new ItemPedidoVenda();
                        itemPedidoVenda.setCodigoPedido(listaItemPedido.get(i).getCodigoPedido());
                        itemPedidoVenda.setQtItem(listaItemPedido.get(i).getQtItem());
                        itemPedidoVenda.setCodigo(listaItemPedido.get(i).getCodigo());
                        itemPedidoVenda.setDescItem(listaItemPedido.get(i).getDescItem());
                        itemPedidoVenda.setCodigoItem(listaItemPedido.get(i).getCodigoItem());
                        itemPedidoVenda.setVlUnitItem(listaItemPedido.get(i).getVlUnitItem());

                        if (itemPedidoVendaController.salvarItemPedido(itemPedidoVenda) > 0){
                            continue;
                        }else{
                            Toast.makeText(this,
                                    "Erro ao cadastrar item do pedido, Verifique o LOG.",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }

                    }

                    Toast.makeText(this,
                            "Pedido cadastrado com sucesso!!",
                            Toast.LENGTH_LONG).show();
                    retornarPagina();
                }else {
                    Toast.makeText(this,
                            "Erro ao cadastrar Pedido, Verifique o LOG.",
                            Toast.LENGTH_LONG).show();
                }


            }else{
                Toast.makeText(this,
                        "Não foi selecionado nenhum item",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    private void retornarPagina() {
        Intent intent = new Intent(this,
                MainActivity.class);

        startActivity(intent);
    }

    private void validaEndereco(Endereco endereco) {
        Double valor = Double.parseDouble(totPedido.getText().toString());
        if(!endereco.getCidade().contains("Toledo") && endereco.getUf().equals("PR")){
            valor += 20.0;
        }
        if (!endereco.getUf().equals("PR")){
            valor += 50.0;
        }
        totPedido.setText(String.valueOf(valor));
    }

    private void calculaParcelas() {
        int qtParcela = Integer.parseInt(qtParcelas.getText().toString());
        Double total = Double.parseDouble(totPedido.getText().toString());
        Double valorParcela;
        if (qtParcela <= 0){
            qtParcelas.setError("Nao é possivel colocar um valor menor ou igual a zero");
        }else{
            valorParcela = total/qtParcela;
            for (int i = 0; i < qtParcela; i++){
                Parcela parcela = new Parcela(i+1, valorParcela);
                listaParcela.add(parcela);
            }
            atualizaListaParcela(listaParcela);
        }
    }

    private void limpaCamposItem() {
        cdItem.setText("");
        vlUnit.setText("");
        descItem.setText("");
        unMedida.setText("");
        qtItem.setText("");
    }

    private void atualizaTotalItem(ArrayList<ItemPedidoVenda> listaItemPedido) {
        int totalItem = 0;

        for (int i = 0; i < listaItemPedido.size(); i++){
            totalItem += listaItemPedido.get(i).getQtItem();
        }
        totItens.setText(String.valueOf(totalItem));
    }

    private void atualizaValorTotal(ArrayList<ItemPedidoVenda> listaItemPedido) {
        Double valorTotal = 0.0;

        for (int i = 0; i < listaItemPedido.size(); i++){
            Item item = itemController.retornarItem(listaItemPedido.get(i).getCodigoItem());
            valorTotal += item.getVlrUnit() * listaItemPedido.get(i).getQtItem();
        }
        totPedido.setText(String.valueOf(valorTotal));
    }

    private void retornaPedido() {
        Random random = new Random();
        if(codPedido.getText().toString() == null || codPedido.getText().toString().isEmpty()){
            codPedido.setText(String.valueOf(random.nextInt(999999)));
        }
    }

    private void adicionaListaItem() {

        ItemPedidoVenda itemPedidoVenda = new ItemPedidoVenda();
        Random random = new Random();
        itemPedidoVenda.setCodigo(random.nextInt(999999));
        itemPedidoVenda.setQtItem(Integer.parseInt(qtItem.getText().toString()));
        itemPedidoVenda.setVlUnitItem(Double.parseDouble(vlUnit.getText().toString()));
        itemPedidoVenda.setCodigoItem(Integer.parseInt(cdItem.getText().toString()));
        itemPedidoVenda.setDescItem(descItem.getText().toString());
        itemPedidoVenda.setCodigoPedido(Integer.parseInt(codPedido.getText().toString()));
        listaItemPedido.add(itemPedidoVenda);
    }
    private void atualizaListaParcela(ArrayList<Parcela> listaParcela) {
        ParcelaAdapter adapter = new ParcelaAdapter(this, listaParcela);
        if (listaParcela.size() > 0){
            lvParcelas.setVisibility(View.VISIBLE);
            lvParcelas.setAdapter(adapter);
        }
    }

    private void atualizaListaItem(ArrayList<ItemPedidoVenda> listaItemPedido) {
        ItemPedidoVendaAdapter adapter = new ItemPedidoVendaAdapter(this, listaItemPedido);
        if (listaItemPedido.size() > 0){
            lvItens.setVisibility(View.VISIBLE);
            lvItens.setAdapter(adapter);
        }
    }

    public List<String> carregaCliente(){
        List<Cliente> listaCliente = clienteController.retornaTodos();
        String var;
        List<String> listaString = new ArrayList<>();
        for (int i = 0; i < listaCliente.size(); i++){
            var = listaCliente.get(i).getCodigo()+" - "+listaCliente.get(i).getNome();
            listaString.add(var);
        }
        return listaString;
    }

    public void OpcaoEntrega(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checkado = radio.isChecked();

        if(view.getId() == R.id.rbEntrega && checkado){
            rbRetirada.setChecked(false);
            cdEndereco.setVisibility(View.VISIBLE);
            tvEndereco.setVisibility(View.VISIBLE);
        }else if(view.getId() == R.id.rbRetirada && checkado){
            rbEntrega.setChecked(false);
            cdEndereco.setVisibility(View.GONE);
            tvEndereco.setVisibility(View.GONE);
        }
    }

    public void OpcaoPagamento(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checkado = radio.isChecked();

        if(view.getId() == R.id.rbAvista && checkado){
            atualizaValorTotal(listaItemPedido);
            Double valorTotal = Double.parseDouble(totPedido.getText().toString());
            valorTotal -= valorTotal*0.05;
            totPedido.setText(String.valueOf(valorTotal));
            rbAprazo.setChecked(false);
            qtParcelas.setVisibility(View.GONE);
            tvParcelas.setVisibility(View.GONE);
        }else if(view.getId() == R.id.rbAprazo && checkado){
            atualizaValorTotal(listaItemPedido);
            Double valorTotal = Double.parseDouble(totPedido.getText().toString());
            valorTotal += valorTotal*0.05;
            totPedido.setText(String.valueOf(valorTotal));

            totPedido.setText(String.valueOf(valorTotal));
            rbAvista.setChecked(false);
            qtParcelas.setVisibility(View.VISIBLE);
            tvParcelas.setVisibility(View.VISIBLE);
        }
    }
}