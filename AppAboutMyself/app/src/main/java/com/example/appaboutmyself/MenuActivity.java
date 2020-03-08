package com.example.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView name, hobby;

    public static final int ACTIVIDAD1_CODE = 0, ACTIVIDAD2_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        name = findViewById(R.id.name);
        hobby = findViewById(R.id.hobby);

        Intent intentote = getIntent();

        name.setText("Hi " + intentote.getStringExtra("nombre"));
    }

    public void abrirHobby(View v){
        Intent intentito = new Intent(this, HobbyActivity.class);
        startActivityForResult(intentito, ACTIVIDAD1_CODE);
    }

    public void abrirFriends(View v){
        Intent intentito = new Intent(this, FriendsActivity.class);
        startActivity(intentito);
    }

    public void abrirMessage(View v){
        Intent intentito = new Intent(this, MessageActivity.class);
        startActivityForResult(intentito, ACTIVIDAD2_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVIDAD1_CODE && resultCode == Activity.RESULT_OK) {
            hobby.setText(data.getStringExtra("hobby"));
        }
    }
}
