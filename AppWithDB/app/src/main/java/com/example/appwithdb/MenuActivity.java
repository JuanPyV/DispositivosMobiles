package com.example.appwithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView hobbyT;
    private EditText hobbyM;
    private Button friends, guardar;
    private DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        hobbyT = findViewById(R.id.hobbyt);
        hobbyM = findViewById(R.id.hobbym);
        friends = findViewById(R.id.friendsb);
        guardar = findViewById(R.id.guardar);
        db = new DBHelper(this);
        String hobbyText = db.find("User");
        hobbyT.setText(hobbyText + "");
    }

    public void abrirFriends(View v){
        Intent intentito = new Intent(this, FriendsActivity.class);
        startActivity(intentito);
    }

    public void guardar(View v){

        db.save("User", hobbyM.getText().toString());
        hobbyM.setText("");
        Toast.makeText(this, "Hobby guardado", Toast.LENGTH_SHORT).show();
        String hobbyText = db.find("User");
        hobbyT.setText(hobbyText + "");
    }

    public void setHobby(View v){

    }


}
