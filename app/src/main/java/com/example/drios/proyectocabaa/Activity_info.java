package com.example.drios.proyectocabaa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Activity_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Equipo");
        getSupportActionBar().setSubtitle("Programadores");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
