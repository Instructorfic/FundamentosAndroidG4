package com.fic.proyectog4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String MAIN_ACTIVITY_TAG = MainActivity.class.getSimpleName();
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
            iniciarActividad();
        }
    };

    public void mostrarMensaje(String mensaje){
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
    }

    public void iniciarActividad(){
        //Intención explícita, muestra la actividad HomeActivity
        Intent intent = new Intent(this,HomeActivity.class);
        //Envío de un sólo dato
        intent.setData(Uri.parse("https://fic.uas.edu.mx"));

        //Envío de más de un dato mediante extras
        String mensaje = "Práctica de envío de datos";
        intent.putExtra("mensaje",mensaje);
        intent.putExtra("nombreUsuario",etNombreUsuario.getText().toString());
        intent.putExtra("contraseniaUsuario",etContrasenia.getText().toString());

        //Envío de más de un dato utilizando un paquete(bundle)
        Bundle paqueteDatos = new Bundle();
        paqueteDatos.putString("materia","Optativa Cómputo Móvil");
        paqueteDatos.putDouble("calificacion",7.67);

        intent.putExtras(paqueteDatos);

        startActivity(intent);
    }

    public void mostrarSitioWeb(){
        //Intención implícita, muestra el sitio web solicitado.
        Uri urlSitioWeb = Uri.parse("http://www.fic.uas.edu.mx");
        Intent intencionSitioWeb = new Intent(Intent.ACTION_VIEW,urlSitioWeb);
        startActivity(intencionSitioWeb);
    }

    protected void onStart() {
        super.onStart();
        Log.i(MAIN_ACTIVITY_TAG,"onStart()-iniciado");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(MAIN_ACTIVITY_TAG,"onRestart()-Restaurado");
    }

    protected void onResume() {
        super.onResume();
        Log.i(MAIN_ACTIVITY_TAG,"onResume()-Ejecución");
    }

    protected void onPause() {
        super.onPause();
        Log.i(MAIN_ACTIVITY_TAG,"onPause()-Pausado");
    }

    protected void onStop() {
        super.onStop();
        Log.i(MAIN_ACTIVITY_TAG,"onStop()-Detenido");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(MAIN_ACTIVITY_TAG,"onDestroy()-Destruido");
    }

}