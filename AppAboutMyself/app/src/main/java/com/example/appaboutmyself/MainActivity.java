package com.example.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button menu;
    private EditText name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.menu);
        name = findViewById(R.id.name);
    }

    public void abrirMenu(View v){
        Intent intentito = new Intent(this, MenuActivity.class);

        intentito.putExtra("nombre", name.getText().toString());
        startActivity(intentito);
    }
}
