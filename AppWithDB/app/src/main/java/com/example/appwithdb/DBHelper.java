package com.example.appwithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "Act4Database.db";
    private static final String TABLA_NAME = "Hobbies";
    private static final String FIELD_ID = "ID";
    private static final String FIELD_NAME = "Nombre";
    private static final String FIELD_HOBBY = "Hobby";

    public DBHelper(Context context){
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_NAME + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_HOBBY + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLA_NAME};
        db.execSQL(query, params);
    }

    public void save(String nombre, String hobby){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(FIELD_NAME, nombre);
        valores.put(FIELD_HOBBY, hobby);
        db.insert(TABLA_NAME, null, valores);


    }

    public int delete(String nombre){

        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {nombre};
        return db.delete(TABLA_NAME, clause, args);

    }

    public String find(String nombre){

        SQLiteDatabase db = getReadableDatabase();
        String filtrito = FIELD_NAME + " = ?";
        String[] args = {nombre};

        Cursor c = db.query(TABLA_NAME, null, filtrito, args, null, null, null);
        String result = "-1";

        if(c.moveToFirst()){

            result = c.getString(2);
        }

        /*
        while(c.moveToNext()) {

        }
        */

        return result;

    }
}
