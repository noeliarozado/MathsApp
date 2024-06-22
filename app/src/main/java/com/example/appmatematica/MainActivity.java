package com.example.appmatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Crear menú
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Responder a opciones del menú
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {
            case R.id.miCalculadora: { // Opción Calculadora
                Intent i = new Intent(this, CalculadoraActivity.class);
                startActivity(i);
                break;
            }
            case R.id.miTest: { // Opción Test
                Intent i = new Intent(this, TestActivity.class);
                startActivity(i);
                break;
            }
            case R.id.miAcercaDe: { // Opción Acerca de
                Intent i = new Intent(this, AcercaDeActivity.class);
                startActivity(i);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    // Método para entrar en la calculadora
    public void entrarCalculadora(View vista) {
        // Conectar esta activity con la calculadora
        Intent i = new Intent(this, CalculadoraActivity.class);
        startActivity(i);
    }

    // Método para entrar en número aleatorio
    public void entrarNúmeroAleatorio(View vista) {
        // Conectar esta activity con el número aleatorio
        Intent i = new Intent(this, AleatorioActivity.class);
        startActivity(i);
    }

    // Método para entrar en número par o impar
    public void entrarNúmeroParImpar(View vista) {
        // Conectar esta activity con el número par o impar
        Intent i = new Intent(this, ParImparActivity.class);
        startActivity(i);
    }

    // Método para entrar en número primo
    public void entrarNúmeroPrimo(View vista) {
        // Conectar esta activity con el número primo
        Intent i = new Intent(this, NumeroPrimoActivity.class);
        startActivity(i);
    }

    // Método para entrar en test
    public void entrarTest(View vista) {
        // Conectar esta activity con el test
        Intent i = new Intent(this, TestActivity.class);
        startActivity(i);
    }

    // Método para entrar en acerca de
    public void entrarAcercaDe(View vista) {
        // Conectar esta activity con acerca de
        Intent i = new Intent(this, AcercaDeActivity.class);
        startActivity(i);
    }

    // Método para salir de la aplicación con diálogo de confirmación de salida
    public void salir (View vista) {
        new AlertDialog.Builder(this)
                // .setTitle("Salir")
                .setTitle(R.string.strSalir)
                // .setMessage("¿Desea salir de la App?")
                .setMessage(getString(R.string.strPreguntaSalir))
                // .setPositiveButton("Sí", new DialogInterface.OnClickListener(){
                .setPositiveButton((getString(R.string.strSí)), new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i){
                        finish();
                    }
                })
                // .setNegativeButton("No", null)
                .setNegativeButton((getString(R.string.strNo)), null)
                .show();
    }

}