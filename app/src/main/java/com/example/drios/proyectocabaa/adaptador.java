package com.example.drios.proyectocabaa;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drios.proyectocabaa.modelo.cabana;

import java.util.List;

public class adaptador
        extends RecyclerView.Adapter<adaptador.CabanaHolder>
            implements View.OnClickListener{

    //atributos a necesitar
    List<cabana> lista;
    Activity activity;
    int resourse;

    //evento onClick
    private View.OnClickListener Listener;

    public adaptador(List<cabana> lista, Activity activity, int resourse) {
        this.lista = lista;
        this.activity = activity;
        this.resourse = resourse;
    }


    //contructores del adaptador

    @NonNull
    @Override
    public CabanaHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            //generando intefaz
        View view = LayoutInflater.from(parent.getContext())
                .inflate(resourse,parent,false);

        //evento onClick
        view.setOnClickListener(this);

        return new CabanaHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CabanaHolder holder, int i) {
        //sacar los objetos de la lista
        cabana c = lista.get(i);
        holder.nombre.setText(c.nombre);
        holder.foto.setImageResource(c.fotoPortada);
        holder.id.setText(c.id);
    }


    @Override
    public int getItemCount() {
        //especifica todos los elementos a recorrer
        return lista.size();
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.Listener=listener;
    }


    @Override
    public void onClick(View v) {
        if (Listener != null){
            Listener.onClick(v);
        }
    }


    //llamar a los item de card con holder
    public class CabanaHolder extends RecyclerView.ViewHolder {

        ImageView foto;
        TextView nombre, id;

        public CabanaHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.card_img);
            nombre = itemView.findViewById(R.id.card_nombre);
            id = itemView.findViewById(R.id.card_id);



        }
    }

}
