package com.example.juanpablovelazco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrefsActivity extends AppCompatActivity {

    private static final String ARCHIVO = "archivo";
    private SharedPreferences pref;
    EditText saludo, maintxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs);

        maintxt = findViewById(R.id.maintxt);
        saludo = findViewById(R.id.saludo);

        pref = getSharedPreferences(ARCHIVO, MODE_PRIVATE);

        Intent intentote = getIntent();
        maintxt.setText(""+intentote.getStringExtra("textito"));
    }

    public void returnMA(View v){
        Intent intentito = new Intent(this, MainActivity.class);
        intentito.putExtra("msg", "Saludos de Juan Pablo");
        intentito.putExtra("preftxt", pref.getString("saludo", "No hay dato aun"));
        setResult(Activity.RESULT_OK, intentito);
        finish();
    }

    public void guardar(View v){

        SharedPreferences.Editor editorcito = pref.edit();
        editorcito.putString("saludo", saludo.getText().toString());
        editorcito.commit();
    }

    public void borrarTodo(View v){

        SharedPreferences.Editor editorcito = pref.edit();
        editorcito.clear();
        editorcito.commit();
    }


}
