package com.example.appmatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NumeroPrimoActivity extends AppCompatActivity {
    private EditText etNúmeroPrimo;
    private TextView tvResultadoPrimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_primo);
        // Inicializar las vistas
        etNúmeroPrimo = findViewById(R.id.etNúmeroPrimo);
        tvResultadoPrimo = findViewById(R.id.tvResultadoPrimo);
    }

    // Método que comprueba si el número introducido es válido
    private boolean validarNúmero(String número) {
        boolean válido = true;
        if (número.length() == 0) { // Si no introduce ningún número
            válido = false;
            // Mensaje de feedback
            // Toast.makeText(this, "¡ERROR! Debe introducir un número.", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, (getString(R.string.strErrorIntroduceNum)), Toast.LENGTH_SHORT).show();
        } else {
            if (Integer.parseInt(número) <= 0) { // Si el número es menor que 0 no será válido
                válido = false;
                // Toast.makeText(this, "¡ERROR! El número tiene que ser mayor que 0.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strErrorNumMayorCero)), Toast.LENGTH_SHORT).show();
            }
        }
        return válido;
    }

    // Método para saber si un número es primo o no
    public void númeroPrimo(View vista) {
        // Comprueba si el número introducido es válido
        if (validarNúmero(etNúmeroPrimo.getText().toString())) {
            // Recoger valor del EditText
            String número = etNúmeroPrimo.getText().toString();
            // Calcular si un número es primo o no
            int contador = 0;
            for (int i = 1; i <= Integer.parseInt(número); i++) {
                if (Integer.parseInt(número) % i == 0) { // Es primo si solo puede dividirse por sí mismo o por 1
                    contador++;
                }
            }
            if (contador != 2) { // El número no es primo
                // tvResultadoPrimo.setText("El número no es primo.");
                tvResultadoPrimo.setText((getString(R.string.strNoPrimo)));
            } else { // El número es primo
                // tvResultadoPrimo.setText("El número es primo.");
                tvResultadoPrimo.setText((getString(R.string.strEsPrimo)));
            }
        }
    }

    // Método para volver a la bienvenida
    public void volver(View vista) {
        // Método finish
        finish();
    }
}