package com.example.drios.proyectocabaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.drios.proyectocabaa.modelo.DAO;
import com.example.drios.proyectocabaa.modelo.cabana;
import com.example.drios.proyectocabaa.modelo.comentario;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class activity_detalle extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra("id");
        DAO dao = new DAO(this);
        cabana n = dao.find(id);

        setTitle(n.nombre);
        getSupportActionBar().setSubtitle("Precio : " + n.precio);

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

        buscarComentarios(id);

    }


    @Override
    protected void onResume() {
        //actualziar pagina
        String id = getIntent().getStringExtra("id");
        buscarComentarios(id);
        super.onResume();
    }

    // public void cargarComentarios(cabana n) {
    //   ListView listView = findViewById(R.id.lista);
    // listView.setAdapter(new ArrayAdapter<comentario>(
    //       this, android.R.layout.simple_list_item_1, n.lista));
    // }


    public void buscarComentarios(String id) {
        String Url = "http://raspberry.todojava.net/index.php/buscarComentarios";

        RequestParams params = new RequestParams();
        params.put("id", id);

        AsyncHttpClient client = new AsyncHttpClient();

        client.post(Url, params, new AsyncHttpResponseHandler() {
            @Override
            //
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) { //si la conexion es correcta
                    String respuesta = new String(responseBody);
                    cargaRecycler(respuesta);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                TextView txterror = findViewById(R.id.detalle);
                txterror.setText("ERROR: error de conexion a internet");
            }
        });

    }//end funciotn


    public void enviar2(View view) {
        String id = getIntent().getStringExtra("id");

        DAO dao = new DAO(this);
        cabana n = dao.find(id);
        Intent i = new Intent(this, activity_comentarios.class);
        i.putExtra("id", n.id);
        startActivity(i);
    }


    public void cargaRecycler(String respuesta) {


        try {
            List<comentario> lista = new ArrayList<>();
            //extrae el arreglo en el json
            JSONArray json = new JSONArray(respuesta);

            //recorrer arreglo
            for (int i = 0; i < json.length(); i++) {
                comentario c = new comentario();
                c.nombre = json.getJSONObject(i).getString("nombre");
                c.comentario = json.getJSONObject(i).getString("comentario");
                lista.add(c);
            }

            //cargar en el listView la lista de cometarios
            ListView listView = findViewById(R.id.lista);
            listView.setAdapter(new ArrayAdapter<comentario>(
                    this, android.R.layout.simple_list_item_1, lista));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
