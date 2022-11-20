package com.example.sgtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IniciarSesionActivity extends AppCompatActivity {
    private EditText correo;
    private EditText pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        correo = findViewById(R.id.correo);
        pass = findViewById(R.id.pass);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
         FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void Iniciar_Sesion(View view){
        mAuth.signInWithEmailAndPassword(correo.getText().toString(), pass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Has Iniciado Sesion",Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            SetInicioValue();
                            Intent i = new Intent(getApplicationContext(),CrearSalaActivity.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(getApplicationContext(), "Fallo Al Iniciar Sesion.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void SetInicioValue() {
        SharedPreferences preferences = getSharedPreferences("InicioSesion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("sesion",true);
        editor.commit();
    }
}