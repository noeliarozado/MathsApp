package com.example.appmatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParImparActivity extends AppCompatActivity {
    private EditText etNúmeroPar;
    private TextView tvResultadoPar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_impar);
        // Inicializar las vistas
        etNúmeroPar = findViewById(R.id.etNúmeroPar);
        tvResultadoPar = findViewById(R.id.tvResultadoPar);
    }

    // Método que comprueba si el número introducido es válido
    private boolean validarNúmero(String número) {
        boolean válido = true;
        if (número.length() == 0) { // Si no introduce ningún número
            válido = false;
            // Mensaje de feedback
            // Toast.makeText(this, "¡ERROR! Debe introducir un número.", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, (getString(R.string.strErrorFaltaNum)), Toast.LENGTH_SHORT).show();
        } else {
            if (Integer.parseInt(número) <= 0) { // Si el número es menor que 0 no será válido
                válido = false;
                // Toast.makeText(this, "¡ERROR! El número tiene que ser mayor que 0.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strErrorNumMayCero)), Toast.LENGTH_SHORT).show();
            }
        }
        return válido;
    }

    // Método para saber si un número es par o impar
    public void numeroParImpar(View vista) {
        // Comprueba si el número introducido es válido
        if (validarNúmero(etNúmeroPar.getText().toString())) {
            // Recoger valor del EditText
            String número = etNúmeroPar.getText().toString();
            // Saber si un número es par o impar
            if (Integer.parseInt(número) % 2 == 0) { // Es par
                // tvResultadoPar.setText("El número es par.");
                tvResultadoPar.setText((getString(R.string.strEsPar)));
            } else { // Es impar
                // tvResultadoPar.setText("El número es impar.");
                tvResultadoPar.setText((getString(R.string.strEsImpar)));
            }
        }
    }

    // Método para volver a la bienvenida
    public void volver(View vista) {
        // Método finish
        finish();
    }
}