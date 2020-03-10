package com.example.appwithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity {

    private EditText name, hobby;
    private Button saveb, searchb, deleteb, returnb;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        name = findViewById(R.id.name);
        hobby = findViewById(R.id.hobby);
        returnb = findViewById(R.id.returnb);
        saveb = findViewById(R.id.saveb);
        searchb = findViewById(R.id.searchb);
        deleteb = findViewById(R.id.deleteb);

        db = new DBHelper(this);
    }

    public void regresaHobby(View v){
        finish();
    }

    public void guardar(View v){

        db.save(name.getText().toString(), hobby.getText().toString());
        name.setText("");
        hobby.setText("");
        Toast.makeText(this, "Amigo y hobby guardado", Toast.LENGTH_SHORT).show();
    }

    public void borrar(View v){

        int rows = db.delete(name.getText().toString());
        Toast.makeText(this, "Se borraron: " + rows + " datos", Toast.LENGTH_SHORT).show();
    }

    public void buscar(View v){

        String hobbyText = db.find(name.getText().toString());
        hobby.setText(hobbyText + "");
    }


}
