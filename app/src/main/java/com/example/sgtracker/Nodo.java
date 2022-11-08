package com.example.sgtracker;

public class Nodo {

    public String id_nodo;
    public String id_class;
    public String latitud;
    public String longitud;

   public Nodo(){

   }

   public Nodo(String latitud,String longitud,String id_nodo){
       this.latitud =  latitud;
       this.longitud = longitud;
       this.id_nodo = id_nodo;
       this.id_class = id_nodo;
   }
}
