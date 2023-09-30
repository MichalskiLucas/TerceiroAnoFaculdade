package br.com.unipar.forcavendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.unipar.forcavendas.controller.EnderecoController;
import br.com.unipar.forcavendas.model.Endereco;

public class EnderecoActivity extends AppCompatActivity {
    private EditText cdEndereco;
    private EditText nmLogradouro;
    private EditText cdNumero;
    private EditText nmBairro;
    private EditText nmCidade;
    private EditText sgEstado;
    private Button btSalvar;
    private Button btVoltar;
    private EnderecoController enderecoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        cdEndereco   = findViewById(R.id.cdEndereco);
        nmLogradouro = findViewById(R.id.nmLogradouro);
        cdNumero     = findViewById(R.id.cdNumero);
        nmBairro     = findViewById(R.id.nmBairro);
        nmCidade     = findViewById(R.id.nmCidade);
        sgEstado     = findViewById(R.id.sgEstado);
        btSalvar = findViewById(R.id.btSalvar);
        btVoltar = findViewById(R.id.btVoltar);
        enderecoController = new EnderecoController(this);

        btSalvar.setOnClickListener(v -> salvarEndereco());
        btVoltar.setOnClickListener(v -> voltarActivity());

    }

    private void salvarEndereco() {
        Endereco endereco = new Endereco();

        String validacao = enderecoController.validaCliente(cdEndereco.getText().toString(),
                                                            nmLogradouro.getText().toString(),
                                                            cdNumero.getText().toString(),
                                                            nmBairro.getText().toString(),
                                                            nmCidade.getText().toString(),
                                                            sgEstado.getText().toString());

        if (!validacao.equals("")){
            if (validacao.contains("endereco")){
                cdEndereco.setError(validacao);
            }
            if (validacao.contains("logradouro")){
                nmLogradouro.setError(validacao);
            }
            if (validacao.contains("numero")){
                cdNumero.setError(validacao);
            }
            if (validacao.contains("bairro")){
                nmBairro.setError(validacao);
            }
            if (validacao.contains("cidade")){
                nmCidade.setError(validacao);
            }
            if (validacao.contains("sigla")){
                sgEstado.setError(validacao);
            }
        }else{
            int codEndereco = Integer.parseInt(cdEndereco.getText().toString());;
            String nomeLogradouro = nmLogradouro.getText().toString();
            String numero = cdNumero.getText().toString();
            String cidade = nmCidade.getText().toString();
            String bairro = nmBairro.getText().toString();
            String sigla = sgEstado.getText().toString();
            endereco.setCodigo(codEndereco);
            endereco.setNumero(numero);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setUf(sigla);
            endereco.setLogradouro(nomeLogradouro);
            if (enderecoController.salvarEndereco(endereco) > 0){
                Toast.makeText(this,
                        "Endereco cadastrado com sucesso!!",
                        Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,
                        "Erro ao cadastrar Endereco, Verifique o LOG.",
                        Toast.LENGTH_LONG).show();
            }


        }
    }
    public void voltarActivity(){
        Intent intent = new Intent(EnderecoActivity.this,
                MainActivity.class);

        startActivity(intent);
    }
}