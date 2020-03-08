package com.example.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HobbyActivity extends AppCompatActivity {

    private Button menu;
    private EditText hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);

        menu = findViewById(R.id.menu);
        hobby = findViewById(R.id.hobbyText);
    }

    public void finDeActividad(View v){

        Intent intent = new Intent();

        intent.putExtra("hobby", hobby.getText().toString());

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
