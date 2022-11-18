package com.example.sgtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.ThreadLocalRandom;

public class inicioActivity extends AppCompatActivity {
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
        mDatabase = FirebaseDatabase.getInstance().getReference("Clase_Trabajo");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        newSalaBtn = findViewById(R.id.newSalaBtn);
        joinSalaBtn = findViewById(R.id.joinSalaBtn);

        newSalaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clases clase = new Clases(mDatabase.push().getKey(),mAuth.getUid().toString(),"NONE","NONE");
                mDatabase.child(mDatabase.push().getKey()).setValue(clase);
                Toast.makeText(inicioActivity.this, "Clase Creada", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),Clase_GUI_Prueba.class);
                startActivity(i);

            }

        });

    }
}