package com.example.drios.proyectocabaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drios.proyectocabaa.modelo.DAO;
import com.example.drios.proyectocabaa.modelo.cabana;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class activity_comentarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Comentarios");
        getSupportActionBar().setSubtitle("nuevo");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //metodo automatico que permite cargar el menu creado
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.check:
                String id = getIntent().getStringExtra("id");
                DAO dao = new DAO(this);
                cabana n = dao.find(id);

                EditText nombre = findViewById(R.id.txtName);
                EditText cometario = findViewById(R.id.txtcomentario);
                String Nombre = nombre.getText().toString();
                String Comentario = cometario.getText().toString();


                //validar campos
                if (Nombre.isEmpty() || Comentario.isEmpty()){
                    Toast.makeText(this, "campos vacios!", Toast.LENGTH_SHORT).show();
                }else {
                    //insertar en base de datos
                    insertarComentario(Nombre, Comentario, id);
                    Toast.makeText(this, "comentado!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, activity_detalle.class);
                    i.putExtra("id", n.id);
                    startActivity(i);
                }
                break;

            case R.id.version:
                Intent c = new Intent(this, Activity_info.class);
                startActivity(c);
                break;

            default:
                String ID = getIntent().getStringExtra("id");
                DAO daoo = new DAO(this);
                cabana x = daoo.find(ID);
                Intent z = new Intent(this, activity_detalle.class);
                z.putExtra("id", x.id);
                startActivity(z);
                break;

        }
        return true;
    }


    public void insertarComentario(String nombre, String comentario, String id) {
        String Url = "http://raspberry.todojava.net/index.php/insertarComentario";

        RequestParams params = new RequestParams();

        params.put("nombre", nombre);
        params.put("comentario", comentario);
        params.put("id", id);

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String respuesta = new String(responseBody);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {


            }
        });

    }//end funciotn


}
