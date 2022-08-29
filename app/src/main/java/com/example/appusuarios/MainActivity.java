package com.example.appusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mRootReference;
    Button mButtonSubirDatosFireBase;
    EditText mEditTextDatoNombreUsuario,mEditTextDatoApellidoUsuario,mEditTextDatoTelefonoUsuario,mEditTextDatoDireccionUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootReference = FirebaseDatabase.getInstance().getReference();
        mButtonSubirDatosFireBase = findViewById(R.id.btnSubirDatos);
        mEditTextDatoNombreUsuario = findViewById(R.id.etNombre);
        mEditTextDatoApellidoUsuario = findViewById(R.id.etApellido);
        mEditTextDatoTelefonoUsuario = findViewById(R.id.etTelefono);
        mEditTextDatoDireccionUsuario = findViewById(R.id.etDireccion);

        mButtonSubirDatosFireBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = mEditTextDatoNombreUsuario.getText().toString();
                String apellido = mEditTextDatoApellidoUsuario.getText().toString();
                int telefono = Integer.parseInt(mEditTextDatoTelefonoUsuario.getText().toString());
                String direccion = mEditTextDatoDireccionUsuario.getText().toString();

                Map<String, Object> datosUsuario = new HashMap<>();
                datosUsuario.put("nombre", nombre);
                datosUsuario.put("apellido", apellido);
                datosUsuario.put("telefono", telefono);
                datosUsuario.put("direccion", direccion);

                mRootReference.child("Usuario").push().setValue(datosUsuario);


            }
        });

    }
}