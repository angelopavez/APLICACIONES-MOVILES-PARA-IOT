package com.example.prueba2amiot.modelo;

public class Libro {
    private String nombre;
    private String autor;
    private String condicion;
    private boolean estado;

    public static final boolean PENDIENTE=true;
    public static final boolean VENDIDO=false;


    public Libro(String nombre, String autor, String condicion){
        this.nombre = nombre;
        this.autor = autor;
        this.condicion = condicion;
        this.estado=PENDIENTE;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCondicion() {
        return condicion;
    }
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String vendido;
        if(estado==VENDIDO)
        {
            vendido="comprado";
        }
        else
        {
            vendido="pendiente";
        }
        return nombre + ": " + vendido;
    }
}
