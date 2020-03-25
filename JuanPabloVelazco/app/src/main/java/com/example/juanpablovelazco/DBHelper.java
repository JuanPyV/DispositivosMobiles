package com.example.juanpablovelazco;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "Examen.db";
    private static final String TABLA_NAME = "Examen";
    private static final String FIELD_ID = "ID";
    private static final String FIELD_NAME = "Nombre";
    private static final String FIELD_PRECIO = "Precio";

    public DBHelper(Context context){
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_NAME + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_PRECIO + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLA_NAME};
        db.execSQL(query, params);
    }


    public void save(String nombre, int precio){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(FIELD_NAME, nombre);
        valores.put(FIELD_PRECIO, precio);
        db.insert(TABLA_NAME, null, valores);
    }

    public String find(String Id){

        SQLiteDatabase db = getReadableDatabase();
        String filtro = FIELD_ID + " = ?";
        String[] args = {Id};
        String[] campo = {"nombre", "precio"};

        Cursor c = db.query(TABLA_NAME, campo, filtro, args, null, null, null);
        String result = "-1";

        if(c.moveToFirst()){

            result = c.getString(1);

        }

        return result;

    }
}

