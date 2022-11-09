package com.example.sgtracker;

import java.security.PublicKey;
import java.util.List;

public class Rutas {
    public String id_ruta;
    public List<String> nodosRuta;

    public Rutas(){

    }
    public Rutas(String id_ruta,List<String> nodosRuta){

        this.id_ruta = id_ruta;
        this.nodosRuta = nodosRuta;
    }
}
