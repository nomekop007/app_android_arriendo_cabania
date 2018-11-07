package com.example.drios.proyectocabaa.modelo;

import com.example.drios.proyectocabaa.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class cabana{
    public String id;
    public String nombre;
    public int fotoPortada;
    public int foto2;
    public int foto3;
    public int foto4;
    public int foto5;
    public String descripcion;
    public int precio;
    public List<comentario> lista;

    public cabana(String id, String nombre, int fotoPortada, int foto2, int foto3, int foto4, int foto5, String descripcion, int precio, List<comentario> lista) {
        this.id = id;
        this.nombre = nombre;
        this.fotoPortada = fotoPortada;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
        this.descripcion = descripcion;
        this.precio = precio;
        this.lista = lista;
    }

    public static List<cabana> getDatos(){
        List<cabana> listCabana =  new ArrayList<>();

        List<comentario> listComentarios = new ArrayList<>();
        listComentarios.add( new comentario("diego","very good"));
        listComentarios.add( new comentario("pamela","good"));
        listComentarios.add( new comentario("nicolas","good"));
        listComentarios.add( new comentario("javiera","bat"));
        listComentarios.add( new comentario("pablo","very good"));
        listComentarios.add( new comentario("rober","very bat"));

        List<comentario> listComentarios2 = new ArrayList<>();
        listComentarios2.add( new comentario("cecilia","very good"));
        listComentarios2.add( new comentario("vale","very bat"));


        List<comentario> listComentarios3 = new ArrayList<>();
        listComentarios3.add( new comentario("pablo","very good"));
        listComentarios3.add( new comentario("rober","very bat"));
        listComentarios3.add( new comentario("pamela","good"));


        List<comentario> listComentarios4 = new ArrayList<>();
        listComentarios4.add( new comentario("pablo","very good"));
        listComentarios4.add( new comentario("rober","very bat"));
        listComentarios4.add( new comentario("pamela","good"));
        listComentarios4.add( new comentario("javier","very very good"));
        listComentarios4.add( new comentario("pablo","very good"));
        listComentarios4.add( new comentario("rober","very bat"));
        listComentarios4.add( new comentario("pamela","good"));
        listComentarios4.add( new comentario("javier","very very good"));

        listCabana.add(new cabana("1","cabaña del bosque",R.drawable.aportada,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,"la descripcion de la cabaña de los bosques nativos",700000,listComentarios));
        listCabana.add(new cabana("2","cabaña de la playa",R.drawable.portada2,R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,"la descripcion de la cabaña de la playa",4500000,listComentarios2));
        listCabana.add(new cabana("3","cabaña del rio",R.drawable.portada4,R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,"la descripcion de la cabaña del rio",2300000,listComentarios3));
        listCabana.add(new cabana("4","cabaña de la nieve",R.drawable.portada3,R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,"la descripcion de la cabaña de la nieve",5200000,listComentarios4));
        listCabana.add(new cabana("5","cabaña del bosque",R.drawable.aportada,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,"la descripcion de la cabaña de los bosques nativos",700000,listComentarios));
        listCabana.add(new cabana("6","cabaña de la playa",R.drawable.portada2,R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,"la descripcion de la cabaña de la playa",4500000,listComentarios2));
        listCabana.add(new cabana("7","cabaña del rio",R.drawable.portada4,R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,"la descripcion de la cabaña del rio",2300000,listComentarios3));
        listCabana.add(new cabana("8","cabaña de la nieve",R.drawable.portada3,R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,"la descripcion de la cabaña de la nieve",5200000,listComentarios4));

        return listCabana;
    }

    public static cabana buscat(String id){
        for (cabana cab : getDatos()){
            if (id.equals(cab.id)){
                return cab;
            }
        }

        return null;
    }


}
