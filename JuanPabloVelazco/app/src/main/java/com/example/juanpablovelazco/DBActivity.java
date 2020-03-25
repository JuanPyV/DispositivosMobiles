package com.example.juanpablovelazco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class DBActivity extends AppCompatActivity {

    private DBHelper db;
    private EditText id, nombre, precio;
    private Properties properties;
    private static final String PROPERTIES_FILE = "properties1E.xml";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);

        id = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        precio = findViewById(R.id.precio);


        db = new DBHelper(this);

        properties = new Properties();
        File file = new File(getFilesDir(), PROPERTIES_FILE);

        if(file.exists()){


            try {
                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {

            saveProperties();
        }


    }

    public void limpiarFormato(View V){
        id.setText("");
        nombre.setText("");
        precio.setText("");

    }

    public void guardar(View v){
        db.save(nombre.getText().toString(), Integer.parseInt(precio.getText().toString()));
        Toast.makeText(this, "Nombre y precio guardados", Toast.LENGTH_SHORT).show();
    }

    public void buscar(View v){

        String nombre = db.find(id.getText().toString());
        precio.setText(nombre + "");
    }

    private void saveProperties(){

        try{
            FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
            properties.storeToXML(fos, null);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
