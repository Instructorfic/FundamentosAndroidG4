package com.fic.proyectog4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    final String HOME_ACTIVITY_TAG = HomeActivity.class.getSimpleName();
    Button btnVisualizarSitioWeb, btnMarcarNumero;
    EditText etSitioWeb, etNumeroTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Obtener datos
        Intent obtenerIntencion = getIntent();


        String mensaje = obtenerIntencion.getStringExtra("mensaje");
        String nombreUsuario = obtenerIntencion.getStringExtra("nombreUsuario");
        String contraseniaUsuario = obtenerIntencion.getStringExtra("contraseniaUsuario");
        //Obtener datos enviados mediante extras
        Log.i(HOME_ACTIVITY_TAG,mensaje);
        Log.i(HOME_ACTIVITY_TAG,nombreUsuario);
        Log.i(HOME_ACTIVITY_TAG,contraseniaUsuario);
        //Obtener un único dato
        Log.i(HOME_ACTIVITY_TAG, String.valueOf(obtenerIntencion.getData()));

        //Obtener datos enviados mediante un paquete(bundle)
        Bundle recibeDatosPaquete = obtenerIntencion.getExtras();
        Log.i(HOME_ACTIVITY_TAG,recibeDatosPaquete.getString("materia"));
        Log.i(HOME_ACTIVITY_TAG, String.valueOf(recibeDatosPaquete.getDouble("calificacion")));

        btnVisualizarSitioWeb = findViewById(R.id.btnVisualizarSitioWeb);
        btnMarcarNumero = findViewById(R.id.btnMarcarNumero);

        etSitioWeb = findViewById(R.id.etSitioWeb);
        etNumeroTelefono = findViewById(R.id.etNumeroTelefono);

        btnVisualizarSitioWeb.setOnClickListener(accionBotonVisualizar);
        btnMarcarNumero.setOnClickListener(accionBotonMarcar);
    }

    public View.OnClickListener accionBotonVisualizar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            visualizarSitioWeb(etSitioWeb.getText().toString());
        }
    };

    public View.OnClickListener accionBotonMarcar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            marcarNumero(etNumeroTelefono.getText().toString());
        }
    };

    public void visualizarSitioWeb(String urlSitioWeb){
        Uri uri = Uri.parse(urlSitioWeb);
        Intent intencionVisualizarSitioWeb = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intencionVisualizarSitioWeb);
    }

    public void marcarNumero(String numeroTelefono){
        Uri uri = Uri.parse("tel:"+numeroTelefono);
        Intent intencionMarcarNumero = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intencionMarcarNumero);
    }

    public void visualizarConfiguracionInalambrica(){
        Intent intencionVisualizarConfiguracionInalambrica = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(intencionVisualizarConfiguracionInalambrica);
    }
}