package com.example.examenu1.Model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class Persona {
    private String nombre;
    private String telefono;
    private String descripcion;

    public Persona(String nombre, String telefono, String descripcion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void realizarLlamada(String telefono, Activity activity) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + telefono));
        activity.startActivity(intent);
    }
}
