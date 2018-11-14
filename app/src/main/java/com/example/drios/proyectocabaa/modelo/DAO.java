package com.example.drios.proyectocabaa.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    private ConexionHelper helper;
    private ContentValues values;
    private SQLiteDatabase db;

    public DAO(Context context) {
        helper = new ConexionHelper(context);
        values = new ContentValues();
    }

    public cabana find(String id){
        String sql = "select * from "+ConexionHelper.TABLA+" where "+ConexionHelper.ID+"= ?"; //crear consulta sql

        cabana m = new cabana(); //objeto vacio

        db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, new String[]{id+""}); //

        if (cursor.moveToFirst()){
            // cargar lo que contiene el cursor en el objeto vacio
            m.id = ""+cursor.getInt(0);
            m.nombre = cursor.getString(1);
            m.fotoPortada = cursor.getInt(2);
            m.foto2 = cursor.getInt(3);
            m.foto3 = cursor.getInt(4);
            m.foto4 = cursor.getInt(5);
            m.foto5 = cursor.getInt(6);
            m.descripcion = cursor.getString(7);
            m.precio = cursor.getInt(8);
        }
        db.close();

        return m;

    }



    public List<cabana> cabanasList(){
        List<cabana> list = new ArrayList<>();
        db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+ConexionHelper.TABLA,null);

        while (cursor.moveToNext()) {
            cabana m = new cabana();

            m.id = ""+cursor.getInt(0);

            m.nombre = cursor.getString(1);
            m.fotoPortada = cursor.getInt(2);
            m.foto2 = cursor.getInt(3);
            m.foto3 = cursor.getInt(4);
            m.foto4 = cursor.getInt(5);
            m.foto5 = cursor.getInt(6);
            m.descripcion = cursor.getString(7);
            m.precio = cursor.getInt(8);

            list.add(m);
        }

        db.close();
        return list;
    }

}
