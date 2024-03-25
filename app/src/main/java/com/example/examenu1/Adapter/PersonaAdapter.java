package com.example.examenu1.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenu1.Model.Persona;
import com.example.examenu1.R;
import com.example.examenu1.View.personalcontact;

import org.w3c.dom.Text;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.ViewHolder> {

    List<Persona> miLista;
    Persona p;
    View view;

    public PersonaAdapter(List<Persona> miLista) {
        this.miLista = miLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view1 = layoutInflater.inflate(R.layout.rpersona, parent, false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Persona persona = miLista.get(position);
        holder.setdata(persona);

        holder.nombre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), personalcontact.class);
                intent.putExtra("nombrepersona", persona.getNombre());
                intent.putExtra("descripcion", persona.getDescripcion());
                v.getContext().startActivity(intent);
            }
        });

        holder.telefono1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity) v.getContext(), new String[]{Manifest.permission.CALL_PHONE}, 666);
                }
                else {
                    persona.realizarLlamada(persona.getTelefono(), (Activity) v.getContext());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return miLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre1;
        TextView telefono1;
        String descripcion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre1 = itemView.findViewById(R.id.nombre1);
            telefono1 = itemView.findViewById(R.id.telefono1);
            view = itemView;
        }

        public void setdata(Persona persona) {
            p = persona;
            nombre1.setText(persona.getNombre());
            telefono1.setText(persona.getTelefono());
        }
    }
}
