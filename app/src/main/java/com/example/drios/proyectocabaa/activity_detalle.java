package com.example.drios.proyectocabaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.drios.proyectocabaa.modelo.cabana;
import com.example.drios.proyectocabaa.modelo.comentario;

public class activity_detalle extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra("id");
        cabana n = cabana.buscat(id);

        setTitle(n.nombre);
        getSupportActionBar().setSubtitle("Precio : "+n.precio);

        ImageView image2 = findViewById(R.id.img2);
        ImageView image3 = findViewById(R.id.img3);
        ImageView image4 = findViewById(R.id.img4);
        ImageView image5 = findViewById(R.id.img5);
        TextView descripcion = findViewById(R.id.descripcion);



        descripcion.setText(n.descripcion);
        image2.setImageResource(n.foto2);
        image3.setImageResource(n.foto3);
        image4.setImageResource(n.foto4);
        image5.setImageResource(n.foto5);

        // cargar comentarios
        cargarComentarios(n);

    }


    public void cargarComentarios(cabana n) {
        ListView listView = findViewById(R.id.lista);
        listView.setAdapter(new ArrayAdapter<comentario>(
                this, android.R.layout.simple_list_item_1, n.lista));
    }


    public void enviar2(View view) {
        String id = getIntent().getStringExtra("id");
        cabana n = cabana.buscat(id);

        Intent i = new Intent(this, activity_comentarios.class);
        i.putExtra("id", n.id);
        startActivity(i);
    }
}
