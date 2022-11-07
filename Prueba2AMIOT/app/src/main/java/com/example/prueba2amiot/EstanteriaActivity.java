package com.example.prueba2amiot;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.prueba2amiot.modelo.Funcion;
import com.example.prueba2amiot.modelo.Libro;

import java.util.ArrayList;

public class EstanteriaActivity extends ListActivity{

    ListView estanteria;

     @Override
     protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         cargarEstanteria();
     }
     public void cargarEstanteria()
     {
         estanteria=getListView();
         ArrayList<Libro> libros= Funcion.getInstancia().getFuncion();

         ArrayAdapter<Libro> estanteriaAdapter=new ArrayAdapter<Libro>(this,
                android.R.layout.simple_list_item_1,
                libros);
         estanteria.setAdapter(estanteriaAdapter);
     }

     @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id)
     {
         Intent intent=new Intent(EstanteriaActivity.this, MostradorActivity.class);
         intent.putExtra("idLibro",(int)id);
         startActivityForResult(intent,1);
     }

     @Override
     protected void onActovityResult(int requestCode, int resultCode, Intent data)
     {
         super.onActivityResult(requestCode,resultCode,data);
         if(requestCode==1)
         {
             if(resultCode==RESULT_OK)
             {
                 cargarEstanteria();
             }
         }
     }
}
