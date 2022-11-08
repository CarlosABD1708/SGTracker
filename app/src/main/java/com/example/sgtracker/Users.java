package com.example.sgtracker;

public class Users {

    public String username;
    public String email;
    public String id_class;
    public String id_ruta;
    public String id_workstation;

    public Users(){

    }

    public Users(String username,String email,String id_class,String id_ruta,String id_workstation){
        this.username = username;
        this.email = email;
        this.id_class = id_class;
        this.id_ruta = id_ruta;
        this.id_workstation = id_workstation;
    }

}
