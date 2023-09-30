package br.com.unipar.forcavendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.unipar.forcavendas.controller.ClienteController;
import br.com.unipar.forcavendas.controller.EnderecoController;
import br.com.unipar.forcavendas.model.Cliente;
import br.com.unipar.forcavendas.model.Endereco;
import br.com.unipar.forcavendas.model.Item;

public class ClienteActivity extends AppCompatActivity {

    private EditText cdCliente;
    private EditText nmCliente;
    private EditText nrCPF;
    private EditText dtNasc;
    private EditText cdEndereco;
    private Button btSalvar;
    private Button btVoltar;

    private ClienteController clienteController;
    private EnderecoController enderecoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        cdCliente = findViewById(R.id.cdCliente);
        nmCliente = findViewById(R.id.nmCliente);
        nrCPF = findViewById(R.id.nrCPF);
        dtNasc = findViewById(R.id.dtNasc);
        cdEndereco = findViewById(R.id.cdEndereco);
        btSalvar = findViewById(R.id.btSalvar);
        btVoltar = findViewById(R.id.btVoltar);
        clienteController = new ClienteController(this);
        enderecoController = new EnderecoController(this);

        btSalvar.setOnClickListener(v -> salvarCliente());
        btVoltar.setOnClickListener(v -> voltarActivity());
    }

    private void salvarCliente() {
        Cliente cliente = new Cliente();

        String validacao = clienteController.validaCliente(cdCliente.getText().toString(),
                                                           nmCliente.getText().toString(),
                                                           nrCPF.getText().toString(),
                                                           dtNasc.getText().toString(),
                                                           cdEndereco.getText().toString());

        if (!validacao.equals("")){
            if (validacao.contains("codigo")){
                cdCliente.setError(validacao);
            }
            if (validacao.contains("nome")){
                nmCliente.setError(validacao);
            }
            if (validacao.contains("CPF")){
                nrCPF.setError(validacao);
            }
            if (validacao.contains("nascimento")){
                dtNasc.setError(validacao);
            }
            if (validacao.contains("endereco")){
                cdEndereco.setError(validacao);
            }
        }else{
            int codCliente = Integer.parseInt(cdEndereco.getText().toString());;
            String nomeCliente = nmCliente.getText().toString();
            String nrCPFCliente = nrCPF.getText().toString();
            String dateNasc = dtNasc.getText().toString();
            int codEndereco = Integer.parseInt(cdEndereco.getText().toString());
            Endereco endereco;
            endereco = enderecoController.retornarEndereco(codEndereco);
            if (endereco != null){
                cliente.setCodigo(codCliente);
                cliente.setNome(nomeCliente);
                cliente.setCpf(nrCPFCliente);
                cliente.setDtNasc(dateNasc);
                cliente.setCodEndereco(codEndereco);
                if (clienteController.insereCliente(cliente) > 0){
                    Toast.makeText(this,
                            "Cliente cadastrado com sucesso!!",
                            Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this,
                            "Erro ao cadastrar Cliente, Verifique o LOG.",
                            Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(this,
                        "Erro ao cadastrar Cliente, Endereco nao existente.",
                        Toast.LENGTH_LONG).show();
            }


        }
    }
    public void voltarActivity(){
        Intent intent = new Intent(ClienteActivity.this,
                MainActivity.class);

        startActivity(intent);
    }
}