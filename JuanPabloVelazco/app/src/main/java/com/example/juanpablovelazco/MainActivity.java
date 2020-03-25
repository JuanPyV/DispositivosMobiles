package com.example.juanpablovelazco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText saludo, prefText;
    public static final int ACTIVIDAD1_CODE = 0;
    private static final String ARCHIVO = "archivo";
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludo = findViewById(R.id.saludo);
        prefText = findViewById(R.id.prefText);

        Intent intentote = getIntent();
        saludo.setText(""+intentote.getStringExtra("textito"));
        prefText.setText(""+intentote.getStringExtra("preftxt"));


    }

    public void abrirPrefs(View v){
        Intent intentito = new Intent(this, PrefsActivity.class);
        intentito.putExtra("textito", prefText.getText().toString());
        setResult(Activity.RESULT_OK, intentito);
        startActivityForResult(intentito, ACTIVIDAD1_CODE);
    }
    public void abrirDB(View v){
        Intent intentito = new Intent(this, DBActivity.class);
        startActivity(intentito);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVIDAD1_CODE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, data.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
        }
    }
}
