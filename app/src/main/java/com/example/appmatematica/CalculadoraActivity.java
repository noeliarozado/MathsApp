package com.example.appmatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CalculadoraActivity extends AppCompatActivity {
    private EditText etNúmero1;
    private EditText etNúmero2;
    private TextView tvResultadoCalculadora;
    private ToggleButton tbCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        // Inicializar las vistas
        etNúmero1 = findViewById(R.id.etNúmero1);
        etNúmero2 = findViewById(R.id.etNúmero2);
        tvResultadoCalculadora = findViewById(R.id.tvResultadoCalculadora);
        tbCalculadora = findViewById(R.id.tbCalculadora);
    }

    // Método para saber si la calculadora está encendida
    private boolean calculadoraEncendida() {
        boolean encendida = true;
        if (!tbCalculadora.isChecked()) { // Si la calculadora está apagada
            encendida = false;
            Context context = getApplicationContext();
            // Mensaje de feedback
            // Toast toast = Toast.makeText(context, "La calculadora está apagada. Pulse el botón para encenderla.", Toast.LENGTH_LONG);
            Toast toast = Toast.makeText(context, (getString(R.string.strCalcuApagada)), Toast.LENGTH_LONG);
            toast.show(); // Mostrar mensaje de feedback
        }
        return encendida;
    }

    // Método para asegurarse de que se introducen los dos números
    private boolean faltaNumero() {
        boolean falta = (etNúmero1.getText().toString().length()==0 || etNúmero2.getText().toString().length()==0);
        if (falta) //Si falta alguno de los dos números
            // Mensaje de feedback
            // Toast.makeText(this, "¡ERROR! Hay que introducir 2 números para realizar las operaciones.", Toast.LENGTH_LONG).show();
            Toast.makeText(this, (getString(R.string.strErrorDosNum)), Toast.LENGTH_LONG).show();
        return falta;
    }

    // Método sumar
    public void sumar(View vista) {
        if (calculadoraEncendida()) { // Permite realizar la operación sumar si está encendida
            if (!faltaNumero()) { // Si no falta algún número realiza las operaciones
                // Recoger valores de los EditText
                String número1 = etNúmero1.getText().toString();
                String número2 = etNúmero2.getText().toString();
                // Obtener resultado de sumar números
                int resultado = Integer.parseInt(número1) + Integer.parseInt(número2);
                // Mostrar resultado en TextView
                // tvResultadoCalculadora.setText("Resultado: " + resultado);
                tvResultadoCalculadora.setText((getString(R.string.strResultadoSumar)) + resultado);
            }
        }
    }

    // Método restar
    public void restar(View vista) {
        if (calculadoraEncendida()) { // Permite realizar la operación restar si está encendida
            if (!faltaNumero()) { // Si no falta algún número realiza las operaciones
                // Recoger valores de los EditText
                String número1 = etNúmero1.getText().toString();
                String número2 = etNúmero2.getText().toString();
                // Obtener resultado de restar números
                int resultado = Integer.parseInt(número1) - Integer.parseInt(número2);
                // Mostrar resultado en TextView
                tvResultadoCalculadora.setText((getString(R.string.strResultadoRestar)) + resultado);
                // tvResultadoCalculadora.setText("Resultado: " + resultado);
            }
        }
    }

    // Método multiplicar
    public void multiplicar(View vista) {
        if (calculadoraEncendida()) { // Permite realizar la operación multiplicar si está encendida
            if (!faltaNumero()) { // Si no falta algún número realiza las operaciones
                // Recoger valores de los EditText
                String número1 = etNúmero1.getText().toString();
                String número2 = etNúmero2.getText().toString();
                // Obtener resultado de multiplicar números
                int resultado = Integer.parseInt(número1) * Integer.parseInt(número2);
                // Mostrar resultado en TextView
                // tvResultadoCalculadora.setText("Resultado: " + resultado);
                tvResultadoCalculadora.setText((getString(R.string.strResultadoMultiplicar)) + resultado);
            }
        }
    }

    // Método dividir
    public void dividir(View vista) {
        if (calculadoraEncendida()) { // Permite realizar la operación dividir si está encendida
            if (!faltaNumero()) { // Si no falta algún número realiza las operaciones
                // Recoger valores de los EditText
                String número1 = etNúmero1.getText().toString();
                String número2 = etNúmero2.getText().toString();
                // Obtener resultado de dividir números
                if (Float.parseFloat(número2) != 0) { // Si el divisor es distinto de cero
                    float resultado = Float.parseFloat(número1) / Float.parseFloat(número2);
                    // Mostrar resultado en TextView
                    tvResultadoCalculadora.setText((getString(R.string.strResultadoDividir)) + resultado);
                } else { // Si el divisor es 0
                    // Mensaje de feedback
                    // Toast.makeText(this, "¡ERROR! El el divisor no puede ser 0.", Toast.LENGTH_LONG).show();
                    Toast.makeText(this, (getString(R.string.strErrorDivisorCero)), Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    // Método para volver a la bienvenida
    public void volver(View vista) {
        // Método finish
        finish();
    }
}