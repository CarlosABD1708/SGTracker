package com.example.sgtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ThreadLocalRandom;

public class inicioActivity extends AppCompatActivity {

    Button newSalaBtn,joinSalaBtn;
    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        newSalaBtn = findViewById(R.id.newSalaBtn);
        joinSalaBtn = findViewById(R.id.joinSalaBtn);

        newSalaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                String cadena = "";
                int longitud = 12;
                for (int x = 0; x < longitud; x++) {
                    int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
                    char caracterAleatorio = banco.charAt(indiceAleatorio);
                    cadena += caracterAleatorio;
                }



            }

        });

    }
}