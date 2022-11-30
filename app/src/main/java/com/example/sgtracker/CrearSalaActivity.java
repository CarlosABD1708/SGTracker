package com.example.sgtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrearSalaActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Button newSalaBtn,joinSalaBtn;
    private DatabaseReference mDatabase;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        newSalaBtn = findViewById(R.id.newSalaBtn);
        joinSalaBtn = findViewById(R.id.joinSalaBtn);

        newSalaBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mDatabase = FirebaseDatabase.getInstance().getReference("Sala_Trabajo");
                String idSala = mDatabase.push().getKey();
                SalaTrabajo clase = new SalaTrabajo(idSala,mAuth.getUid().toString(),"NONE","NONE");
                mDatabase.child(idSala).setValue(clase);
                mDatabase = FirebaseDatabase.getInstance().getReference("Usuarios");
                mDatabase.child(mAuth.getCurrentUser().getUid()).child("id_clase").setValue(idSala);
                mDatabase.child(mAuth.getCurrentUser().getUid()).child("rolUsuario").setValue("ADMIN");
                setSalaValue();
                Toast.makeText(CrearSalaActivity.this, "Sala De Trabajo Creada", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }

        });

    }

    private void setSalaValue() {
        SharedPreferences preferences = getSharedPreferences("SalaInicio", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("sala",true);
        editor.commit();
    }
}