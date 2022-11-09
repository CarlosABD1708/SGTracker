package com.example.sgtracker;

import java.sql.Struct;

public class Nodos {
    public String id_nodo;
    public String latitude;
    public String longitud;
    public String status;

    public Nodos(){

    }

    public Nodos(String id_nodo,String latitude,String longitud,String status){
        this.id_nodo = id_nodo;
        this.latitude = latitude;
        this.longitud = longitud;
        this.status = status;
    }


}
