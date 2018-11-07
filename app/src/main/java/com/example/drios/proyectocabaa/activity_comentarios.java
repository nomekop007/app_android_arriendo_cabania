package com.example.drios.proyectocabaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.drios.proyectocabaa.modelo.cabana;

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
                cabana n = cabana.buscat(id);

                Toast.makeText(this,"comentado!" , Toast.LENGTH_SHORT).show();
               Intent i = new Intent(this, activity_detalle.class);
                i.putExtra("id", n.id);
                startActivity(i);
                break;
            case R.id.version:

                Intent c = new Intent(this, Activity_info.class);
                startActivity(c);
                break;
            default:
                String ID = getIntent().getStringExtra("id");
                cabana x = cabana.buscat(ID);
                Intent z = new Intent(this, activity_detalle.class);
                z.putExtra("id", x.id);
                startActivity(z);
                break;

        }
        return true;
    }

}
