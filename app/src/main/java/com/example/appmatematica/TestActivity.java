package com.example.appmatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    private RadioButton rbRespuesta1_1;
    private RadioButton rbRespuesta1_2;
    private RadioButton rbRespuesta2_1;
    private RadioButton rbRespuesta2_2;
    private CheckBox cbRespuesta3_1;
    private CheckBox cbRespuesta3_2;
    private CheckBox cbRespuesta3_3;
    private CheckBox cbRespuesta4_1;
    private CheckBox cbRespuesta4_2;
    private CheckBox cbRespuesta4_3;
    private CheckBox cbRespuesta4_4;
    private Spinner sRespuestas5;
    private Spinner sRespuestas6;
    private TextView tvPuntuación;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Inicializar las vistas
        rbRespuesta1_1 = findViewById(R.id.rbRespuesta1_1);
        rbRespuesta1_2 = findViewById(R.id.rbRespuesta1_2);
        rbRespuesta2_1 = findViewById(R.id.rbRespuesta2_1);
        rbRespuesta2_2 = findViewById(R.id.rbRespuesta2_2);
        cbRespuesta3_1 = findViewById(R.id.cbRespuesta3_1);
        cbRespuesta3_2 = findViewById(R.id.cbRespuesta3_2);
        cbRespuesta3_3 = findViewById(R.id.cbRespuesta3_3);
        cbRespuesta4_1 = findViewById(R.id.cbRespuesta4_1);
        cbRespuesta4_2 = findViewById(R.id.cbRespuesta4_2);
        cbRespuesta4_3 = findViewById(R.id.cbRespuesta4_3);
        cbRespuesta4_4 = findViewById(R.id.cbRespuesta4_4);
        sRespuestas5 = findViewById(R.id.sRespuestas5);
        sRespuestas6 = findViewById(R.id.sRespuestas6);
        tvPuntuación = findViewById(R.id.tvPuntuación);
    }

    // Método que calcula los puntos obtenidos en la pregunta 1
    private int puntosPregunta1 () {
        int puntos = 0;
            if (rbRespuesta1_1.isChecked()) {
                puntos = 1; // Respuesta correcta
            } else {
                puntos = 0; // Respuesta incorrecta
            }
            return puntos;
    }

    // Método que calcula los puntos obtenidos en la pregunta 2
    private int puntosPregunta2 () {
        int puntos = 0;
            if (rbRespuesta2_2.isChecked()) {
                puntos = 1; // Respuesta correcta
            } else {
                puntos = 0; // Respuesta incorrecta
            }
        return puntos;
    }

    // Método que calcula los puntos obtenidos en la pregunta 3
    private int puntosPregunta3 () {
        int puntos = 0;
            if (cbRespuesta3_1.isChecked() && cbRespuesta3_3.isChecked()) {
                puntos = 1; // Respuesta correcta
            } else {
                puntos = 0; // Respuesta incorrecta
            }
        return puntos;
    }

    // Método que calcula los puntos obtenidos en la pregunta 4
    private int puntosPregunta4 () {
        int puntos = 0;
            if (cbRespuesta4_2.isChecked() && cbRespuesta4_4.isChecked()) {
                puntos = 1; // Respuesta correcta
            } else {
                puntos = 0; // Respuesta incorrecta
            }
        return puntos;
    }

    // Método que calcula los puntos obtenidos en la pregunta 5
    private int puntosPregunta5 () {
        int puntos = 0;
            if (sRespuestas5.getSelectedItemPosition()==1 || sRespuestas5.getSelectedItemPosition()==3) {
                puntos = 0; // Respuesta incorrecta
            } else {
                puntos = 1; // Respuesta correcta
            }
        return puntos;
    }

    // Método que calcula los puntos obtenidos en la pregunta 6
    private int puntosPregunta6 () {
        int puntos = 0;
            if (sRespuestas6.getSelectedItemPosition() == 1 || sRespuestas5.getSelectedItemPosition() == 3) {
                puntos = 0; // Respuesta incorrecta
            } else {
                puntos = 1; // Respuesta correcta
            }
        return puntos;
    }

    // Método que calcula la puntuación del test
    public void resolver (View vista) {
        // Si en alguna de las preguntas no se ha seleccionado una respuesta
        if((!rbRespuesta1_1.isChecked() && !rbRespuesta1_2.isChecked()) ||
                (!rbRespuesta2_1.isChecked() && !rbRespuesta2_2.isChecked()) ||
                (!cbRespuesta3_1.isChecked() && !cbRespuesta3_2.isChecked() && !cbRespuesta3_3.isChecked()) ||
                (!cbRespuesta4_1.isChecked() && !cbRespuesta4_2.isChecked() && !cbRespuesta4_3.isChecked() && !cbRespuesta4_4.isChecked()) ||
                (sRespuestas5.getSelectedItemPosition() == 0) ||
                (sRespuestas6.getSelectedItemPosition() == 0))
        {
            if (!rbRespuesta1_1.isChecked() && !rbRespuesta1_2.isChecked()) {
                // Si no selecciona una respuesta en la pregunta 1
                // Toast.makeText(this, "¡ERROR! Debe seleccionar una respuesta en la Pregunta 1.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strPregunta1)), Toast.LENGTH_SHORT).show();
            }
            if (!rbRespuesta2_1.isChecked() && !rbRespuesta2_2.isChecked()) {
                // Si no selecciona una respuesta en la pregunta 2
                // Toast.makeText(this, "¡ERROR! Debe seleccionar una respuesta en la Pregunta 2.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strPregunta2)), Toast.LENGTH_SHORT).show();
            }
            if (!cbRespuesta3_1.isChecked() && !cbRespuesta3_2.isChecked() && !cbRespuesta3_3.isChecked()) {
                // Si no selecciona ninguna respuesta en la pregunta 3
                // Toast.makeText(this, "¡ERROR! Debe seleccionar una respuesta en la Pregunta 3.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strPregunta3)), Toast.LENGTH_SHORT).show();
            }
            if (!cbRespuesta4_1.isChecked() && !cbRespuesta4_2.isChecked() && !cbRespuesta4_3.isChecked() && !cbRespuesta4_4.isChecked()) {
                // Si no selecciona ninguna respuesta en la pregunta 4
                // Toast.makeText(this, "¡ERROR! Debe seleccionar una respuesta en la Pregunta 4.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strPregunta4)), Toast.LENGTH_SHORT).show();
            }
            if (sRespuestas5.getSelectedItemPosition()==0) {
                // Si no selecciona ninguna respuesta en la pregunta 5
                // Toast.makeText(this, "¡ERROR! Debe seleccionar una respuesta en la Pregunta 5.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strPregunta5)), Toast.LENGTH_SHORT).show();
            }
            if (sRespuestas6.getSelectedItemPosition()==0){
                // Si no selecciona ninguna respuesta en la pregunta 6
                // Toast.makeText(this, "¡ERROR! Debe seleccionar una respuesta en la Pregunta 6.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, (getString(R.string.strPregunta6)), Toast.LENGTH_SHORT).show();
            }
        } else { // Se ha contestado a todas las preguntas
            int puntos = puntosPregunta1() + puntosPregunta2() + puntosPregunta3() + puntosPregunta4() +
                    puntosPregunta5() + puntosPregunta6(); // Suma de los puntos obtenidos
            switch (puntos) {
                case 0:
                    // tvPuntuación.setText("0 puntos sobre 6");
                    tvPuntuación.setText(getString(R.string.str0Puntos));
                    break;
                case 1:
                    // tvPuntuación.setText("1 puntos sobre 6");
                    tvPuntuación.setText(getString(R.string.str1Punto));
                    break;
                case 2:
                    // tvPuntuación.setText("2 puntos sobre 6");
                    tvPuntuación.setText(getString(R.string.str2Puntos));
                    break;
                case 3:
                    // tvPuntuación.setText("3 puntos sobre 6");
                    tvPuntuación.setText(getString(R.string.str3Puntos));
                    break;
                case 4:
                    // tvPuntuación.setText("4 puntos sobre 6");
                    tvPuntuación.setText(getString(R.string.str4Puntos));
                    break;
                case 5:
                    // tvPuntuación.setText("5 puntos sobre 6");
                    tvPuntuación.setText(getString(R.string.str5Puntos));
                    break;
                case 6:
                    // tvPuntuación.setText("6 puntos sobre 6");
                    tvPuntuación.setText(getString(R.string.str6Puntos));
                    break;
            }
        }
    }

    // Método para volver a la bienvenida
    public void volver(View vista) {
        // Método finish
        finish();
    }
}