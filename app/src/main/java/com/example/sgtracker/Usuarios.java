package com.example.sgtracker;

public class Usuarios {
    public String id_usuario;
    public String id_clase;
    public String id_ruta;
    public String latitud;
    public String longitud;
    public String nombreUsuario;
    public String correoUsuario;
    public String rolUsuario;
    public String statusUsuario;

    public Usuarios(){

    }

    public Usuarios(String id_usuario,String nombreUsuario,String correoUsuario) {
        this.id_usuario = id_usuario;
        this.correoUsuario = correoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.rolUsuario = "none";
        this.id_clase = "none";
        this.id_ruta = "none";
        this.latitud = "none";
        this.longitud = "none";
        this.statusUsuario = "none";
    }
}
