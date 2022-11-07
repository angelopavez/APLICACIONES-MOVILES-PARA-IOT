package com.example.prueba2amiot.modelo;

import java.util.ArrayList;

public class Funcion {
    private static Funcion instancia=new Funcion();
    private ArrayList<Libro> Funcion;

    private Funcion() {
        Funcion=new ArrayList<>();
        agregarLibro(new Libro("Alicia en el pais de las maravillas","Luisito","Nuevo"));

    }
    public static Funcion getInstancia() {return instancia;}

    public void agregarLibro(Libro libro) { Funcion.add(libro);}

    public libro getLibro(int id) { return Funcion.get(id); }
    public ArrayList<libro> getFuncion() { return Funcion; }

    public void eliminarVendidos ()
    {
        for(int i=0; i<Funcion.size(); i++)
        {
            if(Funcion.get(i).isEstado()==Libro.VENDIDO)
            {
                Funcion.remove(i);
                i--;
            }
        }
    }
}
