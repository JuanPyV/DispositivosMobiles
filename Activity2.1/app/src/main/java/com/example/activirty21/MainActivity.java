package com.example.activirty21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        datos = new ArrayList<>();
        datos.add("Carnes");
        datos.add("Mayra");
        datos.add("Guido");
        datos.add("Pedro");
        datos.add("Pica");
        datos.add("Piedra");





    }

    public void llenarRecycler(View v) {

        friendAdapter adapter =new friendAdapter(datos, this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

        int pos = recyclerView.getChildLayoutPosition(v);
        Toast.makeText(this, datos.get(pos), Toast.LENGTH_SHORT).show();
    }
}
