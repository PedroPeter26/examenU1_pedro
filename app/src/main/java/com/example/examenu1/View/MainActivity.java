package com.example.examenu1.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examenu1.Adapter.PersonaAdapter;
import com.example.examenu1.Model.Persona;
import com.example.examenu1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Persona> personasLista = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rcview);

        personasLista.add(new Persona("Pedro", "8715889697", "Lo conocí en la UTT"));
        personasLista.add(new Persona("Melany", "8715889697", "La conocí en Galerías"));
        personasLista.add(new Persona("Manolo", "8715889697", "Es mi primo de la casa de la tía Manola"));
        personasLista.add(new Persona("Maria Félix", "8715889697", "La conocí en un restaurante de Sushi"));
        personasLista.add(new Persona("Jose Angel", "8715889697", "Lo conocí en la UTT"));

        PersonaAdapter miAdapter = new PersonaAdapter(personasLista);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(miAdapter);
    }
}