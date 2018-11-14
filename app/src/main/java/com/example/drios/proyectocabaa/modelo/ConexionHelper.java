package com.example.drios.proyectocabaa.modelo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.drios.proyectocabaa.R;

import java.util.List;

public class ConexionHelper extends SQLiteOpenHelper{

    private static final String DATABASE ="data";
    private static final int VERSION = 4; //sirve para actualizar base de datos en caso de futuros cambios

    //crear las sentencias de la tabla de la base de datos
    public static final String TABLA = "cabana";
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String FOTOPORTADA = "fotoPortada";
    public static final String FOTO2 = "foto2";
    public static final String FOTO3 = "foto3";
    public static final String FOTO4 = "foto4";
    public static final String FOTO5 = "foto5";
    public static final String DESCRIPCION = "descripcion";
    public static final String PRECIO = "precio";

    public ConexionHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String script="";
        script += "create table "+TABLA+"(";
        script += ID+" integer primary key autoincrement,";
        script += NOMBRE+" text,";
        script += FOTOPORTADA+" integer,";
        script += FOTO2+" integer,";
        script += FOTO3+" integer,";
        script += FOTO4+" integer,";
        script += FOTO5+" integer,";
        script += DESCRIPCION+" text,";
        script += PRECIO+" integer";
        script += ");";
        db.execSQL(script);
        db.execSQL("INSERT INTO "+TABLA+" VALUES(null,'cabaña del bosque',"+ R.drawable.aportada+","+R.drawable.a2+","+R.drawable.a3+","+R.drawable.a4+","+R.drawable.a5+",'la descripcion de la cabaña de los bosques nativos',333333);");
        db.execSQL("INSERT INTO "+TABLA+" VALUES(null,'cabaña de la playa',"+R.drawable.portada2+","+R.drawable.b1+","+R.drawable.b2+","+R.drawable.b3+","+R.drawable.b4+",'la descripcion de la cabaña de la playa',450000);");
        db.execSQL("INSERT INTO "+TABLA+" VALUES(null,'cabaña del rio',"+R.drawable.portada4+","+R.drawable.c1+","+R.drawable.c2+","+R.drawable.c3+","+R.drawable.c4+",'la descripcion de la cabaña del rio',230000);");
        db.execSQL("INSERT INTO "+TABLA+" VALUES(null,'cabaña de la nieve',"+R.drawable.portada3+","+R.drawable.d1+","+R.drawable.d2+","+R.drawable.d3+","+R.drawable.d4+",'la descripcion de la cabaña de la nieve',520000);");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table "+TABLA);
        //para actualizar aplicacion
        onCreate(db);
    }
}
