package com.example.drios.proyectocabaa.modelo;

public class comentario {
    public String nombre;
    public String comentario;

    public comentario(String nombre, String comentario) {
        this.nombre = nombre;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        String s = "";

        s = s.concat(nombre+"\n");
        s = s.concat(comentario+"\n");

        return s;
    }
}
