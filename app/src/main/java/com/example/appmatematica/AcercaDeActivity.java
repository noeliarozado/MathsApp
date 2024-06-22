package com.example.appmatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }

    // Método para mostrar una acción implícita (abrir una web para aprender más matemáticas)
    public void aprendaMás(View vista) {
        Intent i = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.matematicasonline.es/"));
        startActivity(i);
    }

    // Método para volver a la bienvenida
    public void volver(View vista) {
        // Método finish
        finish();
    }
}