package com.example.activirty21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Handler.Callback {

    private RecyclerView recyclerView;
    private ArrayList<String>name, hobby, age, phone, address;
    private Handler dataHandler;

    // URL to get contacts JSON
    private static String url = "https://raw.githubusercontent.com/JuanPyV/DispositivosMoviles/master/Activity2.1/app/src/main/res/JSON/amiwos.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        dataHandler = new Handler(Looper.getMainLooper(), this);

        name = new ArrayList<>();
        hobby = new ArrayList<>();
        age = new ArrayList<>();
        phone = new ArrayList<>();
        address = new ArrayList<>();
    }




    public void llenarRecycler(View v) throws IOException, JSONException {


        Request r = new Request("https://raw.githubusercontent.com/JuanPyV/DispositivosMoviles/master/Activity2.1/app/src/main/res/JSON/amiwos.json", dataHandler);
        r.start();


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(llm);

        friendAdapter adapter =new friendAdapter(name, hobby, this);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        try {
            JSONArray datos = (JSONArray) msg.obj;
            //Toast.makeText(this, datos.toString(), Toast.LENGTH_SHORT).show();
            for(int i = 0; i < datos.length(); i++){

                JSONObject actual = datos.getJSONObject(i);
                name.add(actual.getString("name"));
                hobby.add(actual.getString("hobby"));
                age.add(actual.getInt("age") + "");
                phone.add(actual.getString("phone"));
                address.add(actual.getString("address"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;

    }


    @Override
    public void onClick(View v) {

        int pos = recyclerView.getChildLayoutPosition(v);
        Toast.makeText(this, name.get(pos) + " " +
                hobby.get(pos) + " " +
                age.get(pos) + " " +
                phone.get(pos) + " " +
                address.get(pos), Toast.LENGTH_LONG).show();
    }
}
