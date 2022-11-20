package com.example.sgtracker;

public class SalaTrabajo {
    public String id_clase;
    public String id_admin;
    public String miembrosClase;
    public String rutasClase;

    public SalaTrabajo(){

    }

    public SalaTrabajo(String id_clase, String id_admin, String miembrosClase , String rutasClase){
        this.id_admin = id_admin;
        this.id_clase = id_clase;
        this.miembrosClase = miembrosClase;
        this.rutasClase = rutasClase;
    }

}
