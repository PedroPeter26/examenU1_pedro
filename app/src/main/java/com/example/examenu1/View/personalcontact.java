package com.example.examenu1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.examenu1.R;

public class personalcontact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcontact);

        TextView nombre2 = findViewById(R.id.nombre2);
        TextView descripcion = findViewById(R.id.descripcion);

        Intent intent = getIntent();

        if (intent != null) {
            String nombrePersona = intent.getStringExtra("nombrepersona");
            String descripcionPersona = intent.getStringExtra("descripcion");

            nombre2.setText(nombrePersona);
            descripcion.setText(descripcionPersona);
        }
        else {
            nombre2.setText("error");
            descripcion.setText("ERROR");
        }
    }
}
