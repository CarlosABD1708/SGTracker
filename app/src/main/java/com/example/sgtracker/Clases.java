package com.example.sgtracker;

import java.util.List;

public class Clases {
    public String id_clase;
    public String id_admin;
    public String miembrosClase;
    public String rutasClase;

    public Clases(){

    }

    public Clases(String id_clase,String id_admin,String miembrosClase ,String rutasClase){
        this.id_admin = id_admin;
        this.id_clase = id_clase;
        this.miembrosClase = miembrosClase;
        this.rutasClase = rutasClase;
    }

}
