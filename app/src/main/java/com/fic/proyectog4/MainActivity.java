package com.fic.proyectog4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText etNombreUsuario, etContrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        //Variable de tipo botón y edittext
        Button btnIniciarSesion = findViewById(R.id.btnLogin);
        etNombreUsuario = findViewById(R.id.etNombreUsuario);
        etContrasenia = findViewById(R.id.etContrasenia);

        //Evento clic del botón btnIniciarSesión
        btnIniciarSesion.setOnClickListener(accionBotonIniciarSesion);

    }

    public View.OnClickListener accionBotonIniciarSesion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mostrarMensaje(etNombreUsuario.getText().toString());
        }
    };

    public void mostrarMensaje(String mensaje){
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
    }
}