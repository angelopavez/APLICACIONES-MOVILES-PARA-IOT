package com.example.prueba2amiot;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import com.example.prueba2amiot.modelo.Funcion;
import com.example.prueba2amiot.modelo.Libro;

public class NuevaEstanteriaActivity extends AppCompatActivity {

    private Funcion funcion=Funcion.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_libro);
        Button botonIngresarlibro=(Button) findViewById(R.id.botonIngresarlibro);
        botonIngresarlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarlibro(view);
            }
        });
    }

    public void ingresarlibro(View view) {
        String nombre = ((TextView) findViewById(R.id.nombre)).getText().toString();
        String autor = ((TextView) findViewById(R.id.autor)).getText().toString();
        String condicion = ((Spinner) findViewById(R.id.condicion)).getSelectedItem().toString();
        String condicionNueva = ((TextView) findViewById(R.id.condicionNueva)).getText().toString();

        Libro libro = new libro(nombre, autor, condicion);
        funcion.agregarLibro(libro);
        finish();
}}
