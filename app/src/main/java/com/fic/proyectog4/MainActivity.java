package com.fic.proyectog4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
             mostrarSitioWeb();
            //iniciarActividad();
            //mostrarMensaje(etNombreUsuario.getText().toString());
        }
    };

    public void mostrarMensaje(String mensaje){
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
    }

    public void iniciarActividad(){
        //Intención explícita, muestra la actividad HomeActivity
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public void mostrarSitioWeb(){
        //Intención implícita, muestra el sitio web solicitado.
        Uri urlSitioWeb = Uri.parse("http://www.fic.uas.edu.mx");
        Intent intencionSitioWeb = new Intent(Intent.ACTION_VIEW,urlSitioWeb);
        startActivity(intencionSitioWeb);
    }
}