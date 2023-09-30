package br.com.unipar.forcavendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    private Button btItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btItem = findViewById(R.id.btItem);

        btItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityItem();
            }
        });

    }

    private void abrirActivityItem() {
        Intent intent = new Intent(this,
                ItemActivity.class);

        startActivity(intent);
    }
}