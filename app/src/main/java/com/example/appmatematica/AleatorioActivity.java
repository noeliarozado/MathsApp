package com.example.appmatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AleatorioActivity extends AppCompatActivity {
    private EditText etNúmero1Aleatorio;
    private EditText etNúmero2Aleatorio;
    private TextView tvResultadoAleatorio;
    private Switch sAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        // Inicializar las vistas
        etNúmero1Aleatorio = findViewById(R.id.etNúmero1Aleatorio);
        etNúmero2Aleatorio = findViewById(R.id.etNúmero2Aleatorio);
        tvResultadoAleatorio = findViewById(R.id.tvResultadoAleatorio);
        sAleatorio = findViewById(R.id.sAleatorio);
    }

    // Método para saber si está encendido
    private boolean aleatorioEncendido() {
        boolean encendido = true;
        if (!sAleatorio.isChecked()) { // Si está apagado
            encendido = false;
            Context context = getApplicationContext();
            // Mensaje de feedback
            // Toast toast = Toast.makeText(context, "Está apagado. Pulse el botón para encenderlo.", Toast.LENGTH_LONG);
            Toast toast = Toast.makeText(context, (getString(R.string.strBotónApagado)), Toast.LENGTH_LONG);
            toast.show(); // Mostrar mensaje de feedback
        }
        return encendido;
    }

    // Método que comprueba si el número introducido es válido
    private boolean validarNúmeros(String númeroInicial, String númeroFinal) {
        boolean válidos = true;
        if (númeroInicial.length() == 0 || númeroFinal.length() == 0) { // Si no introduce algún número
            válidos = false;
            // Mensaje de feedback
            // Toast.makeText(this, "¡ERROR! Debe introducir dos números.", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, (getString(R.string.strErrorDosNúmeros)), Toast.LENGTH_SHORT).show();
        } else {
            // Si los números son menores que 0 no serán válidos
            if (Integer.parseInt(númeroInicial) <= 0 || Integer.parseInt(númeroFinal) <= 0) {
                válidos = false;
                // Mensaje de feedback
                // Toast.makeText(this, "¡ERROR! Los números tienen que ser mayores que 0.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strErrorMayorCero)), Toast.LENGTH_SHORT).show();
            // Si los números son iguales no serán válidos
            } else if (Integer.parseInt(númeroInicial) == Integer.parseInt(númeroFinal)) {
                válidos = false;
                // Mensaje de feedback
                // Toast.makeText(this, "¡ERROR! Los números no pueden ser iguales.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strErrorNúmerosIguales)), Toast.LENGTH_SHORT).show();
            // Si el primer número es mayor que el segundo no será válido
            } else if (Integer.parseInt(númeroInicial) > Integer.parseInt(númeroFinal)) {
                válidos = false;
                // Mensaje de feedback
                // Toast.makeText(this, "¡ERROR! El primer número tiene que ser menor que el segundo número.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strErrorNúmeroMayor)), Toast.LENGTH_SHORT).show();
            } else { // Si cumple los requisitos será válido
                válidos = true;
            }
        }
        return válidos;
    }

    // Método para calcular un número aleatorio
    public void númeroAleatorio(View vista) {
        if (aleatorioEncendido()) { // Si está encendido
            // Comprueba si los números introducidos son válidos
            if (validarNúmeros(etNúmero1Aleatorio.getText().toString(), etNúmero2Aleatorio.getText().toString())){
                // Recoger valores de los EditText
                String número1 = etNúmero1Aleatorio.getText().toString();
                String número2 = etNúmero2Aleatorio.getText().toString();
                // Calcular un número aleatorio dentro del rango
                int resultado = (int)(Math.random()*(Integer.parseInt(número2)-Integer.parseInt(número1)+1)+Integer.parseInt(número1));
                // Mostrar resultado en TextView
                // tvResultadoAleatorio.setText("Ha salido el: " + resultado);
                tvResultadoAleatorio.setText((getString(R.string.strResultadoAleatorio)) + resultado);
            }
        }
    }

    // Método para volver a la bienvenida
    public void volver(View vista) {
        // Método finish
        finish();
    }
}