package com.example.appwithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private Properties properties;
    private static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        properties = new Properties();
        //Log.wtf("ARCHIVOS", getFilesDir().toString());
        File file = new File(getFilesDir(), PROPERTIES_FILE);

        if(file.exists()){

            //Toast.makeText(this, "EXISTE ARCHIVO", Toast.LENGTH_SHORT).show();

            try {
                // cargar a objeto
                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {

            //Toast.makeText(this, "NO EXISTE ARCHIVO", Toast.LENGTH_SHORT).show();
            guardarMemoria("Saludo1", "Que ondita amiguito intentito");
            guardarMemoria("Saludo2", "Hola.");
            saveProperties();
        }



    }

    public void abrirHobby(View v){
        Intent intentito = new Intent(this, MenuActivity.class);
        startActivity(intentito);
    }

    private void saveProperties(){
        //CREA ARCHIVO VACIO PARA USO POSTERIOR
        try{
            FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
            properties.storeToXML(fos, null);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void guardarMemoria(String llave, String valor){

        properties.put(llave, valor);
        //Toast.makeText(this, "PROPIEDAD GUARDADA", Toast.LENGTH_SHORT).show();

    }

    public void guardarAlmacenamiento(View v){
        //asginar a boton
        saveProperties();
        Toast.makeText(this, "Properties guardado por usuario", Toast.LENGTH_SHORT).show();
    }

    public void imprimirSaludo1(View v){
        Toast.makeText(
                this,
                "" + properties.get("Saludo1"),
                Toast.LENGTH_SHORT).show();
    }

    public void imprimirSaludo2(View v){
        Toast.makeText(
                this,
                "" + properties.get("Saludo2"),
                Toast.LENGTH_SHORT).show();
    }
}
