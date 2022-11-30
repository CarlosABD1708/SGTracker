package com.example.sgtracker;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private SharedPreferences sesion,sala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sesion = getSharedPreferences("InicioSesion",Context.MODE_PRIVATE);
        sala = getSharedPreferences("SalaInicio",Context.MODE_PRIVATE);
        boolean sala_value = sala.getBoolean("sala",false);
        boolean sesion_value = sesion.getBoolean("sesion",false);
        if(sesion_value == true) {
            Intent i;
            if(sala_value == true){
                i = new Intent(this, MapsActivity.class);
            }else{
                i = new Intent(this, CrearSalaActivity.class);
            }
            startActivity(i);
        }

    }

    public void goto_IniciarSesion(View view){
        Intent i = new Intent(this,IniciarSesionActivity.class);
        startActivity(i);
    }

    public void goto_Registrar(View view){
        Intent i = new Intent(this,RegistrarseActivity.class);
        startActivity(i);
    }
}