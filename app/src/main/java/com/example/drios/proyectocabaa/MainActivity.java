package com.example.drios.proyectocabaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drios.proyectocabaa.modelo.cabana;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Cabañas App");
        getSupportActionBar().setSubtitle("Talca");

        RecyclerView rc = findViewById(R.id.list_recycler);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        rc.setLayoutManager(lm);
        adaptador adaptador = new adaptador(cabana.getDatos(), this, R.layout.item_card);


        //onClick
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView rc = findViewById(R.id.list_recycler);
                //sacar id del objeto seleccionado
               String id = cabana.getDatos().get(rc.getChildAdapterPosition(view)).id;

                enviar(id);
            }
        });
        rc.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //metodo automatico que permite cargar el menu creado
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.version:
                startActivity(new Intent(this, Activity_info.class));
                break;
        }
        return true;
    }

    public void enviar(String id){
        Intent i = new Intent(this, activity_detalle.class);
        i.putExtra("id", id);
        startActivity(i);
    }

}
