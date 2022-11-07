package com.example.prueba2amiot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.prueba2amiot.modelo.Funcion;
import com.example.prueba2amiot.modelo.Libro;

public class MainActivity extends AppCompatActivity {

    private Funcion funcion=Funcion.getInstancia();
    private ArrayList<Libro> libros=funcion.getFuncion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ver_lista=(Button) findViewById(R.id.ver_estanteria);
        ver_lista.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(libros.size()>0){
                    Intent intent = new Intent(MainActivity.this, EstanteriaActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "la lista esta sin nada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button botonNuevo=(Button) findViewById(R.id.botonNuevo);
        botonNuevo.setOnClickListener(new View.OnClickListener()){
            @Override
                    public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, NuevaEstanteriaActivity.class);
                startActivity(intent);
            }
        }};
        Button botonEliminar=(Button) findViewById(R.id.botonEliminar);
            botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                libros.eliminarVendidos();
                Toast.makeText(MainActivity.this, "Se han eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }