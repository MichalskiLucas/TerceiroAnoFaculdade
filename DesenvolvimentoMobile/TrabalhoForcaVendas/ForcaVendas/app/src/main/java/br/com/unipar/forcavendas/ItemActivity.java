package br.com.unipar.forcavendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.unipar.forcavendas.controller.ItemController;
import br.com.unipar.forcavendas.model.Endereco;
import br.com.unipar.forcavendas.model.Item;

public class ItemActivity extends AppCompatActivity {
    private EditText cdItem;
    private EditText dsItem;
    private EditText vlUnit;
    private EditText unMedida;
    private Button btSalvar;
    private Button btVoltar;
    private ListView lvItems;
    private ItemController itemController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        cdItem = findViewById(R.id.cdItem);
        dsItem = findViewById(R.id.dsItem);
        vlUnit = findViewById(R.id.vlUnit);
        unMedida = findViewById(R.id.unMedida);
        btVoltar = findViewById(R.id.btVoltar);
        btSalvar = findViewById(R.id.btSalvar);
        lvItems = findViewById(R.id.lvItems);
        itemController = new ItemController(this);
        atualizaLista();
        btSalvar.setOnClickListener(v -> salvarItem());

        btVoltar.setOnClickListener(v -> voltarActivity());

    }
    private void atualizaLista() {
        List<Item> listaItem = itemController.retornarTodos();
        ArrayAdapter<Item> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaItem);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        lvItems.setAdapter(adapter);
    }

    private void salvarItem() {
        Item item = new Item();

        String validacao = itemController.validaItems(cdItem.getText().toString(),
                dsItem.getText().toString(), vlUnit.getText().toString(),
                unMedida.getText().toString());

        if (!validacao.equals("")){
            if (validacao.contains("codigo")){
                cdItem.setError(validacao);
            }
            if (validacao.contains("descricao")){
                dsItem.setError(validacao);
            }
            if (validacao.contains("unitario")){
                vlUnit.setError(validacao);
            }
            if (validacao.contains("medida")){
                unMedida.setError(validacao);
            }
        }else{
            int codItem = Integer.parseInt(cdItem.getText().toString());;
            String descItem = dsItem.getText().toString();
            Double valUnit = Double.parseDouble(vlUnit.getText().toString());
            String uniMedida = unMedida.getText().toString();
            item.setCodigo(codItem);
            item.setDescricao(descItem);
            item.setVlrUnit(valUnit);
            item.setUnMedida(uniMedida);
            if (itemController.salvarItem(item) > 0){
                Toast.makeText(this,
                        "Item cadastrado com sucesso!!",
                        Toast.LENGTH_LONG).show();
                voltarActivity();
            }else {
                Toast.makeText(this,
                        "Erro ao cadastrar Item, verifique LOG.",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    public void voltarActivity(){
        Intent intent = new Intent(ItemActivity.this,
                MainActivity.class);

        startActivity(intent);
    }
}