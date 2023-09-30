package br.com.unipar.forcavendas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    private Button btItem;
    private Button btEndereco;
    private Button btCliente;
    private Button btPedido;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btItem = findViewById(R.id.btItem);
        btCliente = findViewById(R.id.btCliente);
        btEndereco = findViewById(R.id.btEndereco);
        btPedido = findViewById(R.id.btPedido);

        btItem.setOnClickListener(v -> abrirActivityItem());
        btEndereco.setOnClickListener(v -> abrirActivityEndereco());
        btCliente.setOnClickListener(v -> abrirActivityCliente());
        btPedido.setOnClickListener(v -> abrirActivityPedido());

    }

    private void abrirActivityPedido() {
        Intent intent = new Intent(this,
                PedidoActivity.class);

        startActivity(intent);
    }

    private void abrirActivityItem() {
        Intent intent = new Intent(this,
                ItemActivity.class);

        startActivity(intent);
    }
    private void abrirActivityEndereco() {
        Intent intent = new Intent(this,
                EnderecoActivity.class);

        startActivity(intent);
    }
    private void abrirActivityCliente() {
        Intent intent = new Intent(this,
                ClienteActivity.class);

        startActivity(intent);
    }
}