package com.example.sgtracker;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarseActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText pass;
    private EditText passconf;
    private EditText nombres;
    private EditText app;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.correo);
        pass = findViewById(R.id.pass);
        passconf = findViewById(R.id.passconf);
        nombres = findViewById(R.id.nombres);
        app = findViewById(R.id.app);
        mDatabase = FirebaseDatabase.getInstance().getReference("Usuarios");
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //updateUI(currentUser);
    }

    public void registrar_usuario(View view){
        //WDatabaseReference mDatabase = database.getReference("https://console.firebase.google.com/project/sgtracker-b466e/database/sgtracker-b466e-default-rtdb/data/~2F?hl=es");
        if (pass.getText().toString().equals(passconf.getText().toString())){
            mAuth.createUserWithEmailAndPassword(correo.getText().toString(), pass.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                              String Nombre_usuario;
                                Nombre_usuario = nombres.getText().toString() + app.getText().toString();
                                Usuarios usuario = new Usuarios(mAuth.getUid().toString(),Nombre_usuario,correo.getText().toString());
                                mDatabase.child(mAuth.getUid().toString()).setValue(usuario);
                                Toast.makeText(getApplicationContext(), "Usuario Creado",Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(),inicioActivity.class);
                                startActivity(i);
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Fallo Authentication.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else{
            Toast.makeText(this,"Las Contraseñas No Coinciden",Toast.LENGTH_SHORT).show();
        }



    }

}