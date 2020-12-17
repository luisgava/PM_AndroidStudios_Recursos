package com.example.recursos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.configuracion:
                Toast.makeText(this, "Configuracion", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nuevo:
                Toast.makeText(this, "nuevo", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.buscar:
                Toast.makeText(this, "buscar", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void pasarSiguiente(View view) {
        EditText edt1 = findViewById(R.id.edt1);
        EditText edt2 = findViewById(R.id.edt2);
        Intent instance = new Intent(this, MainActivity2.class);

        // esto deja preparados los dos valores para ser usados al crear la nueva actividad
        // a la que nos lleva el botón.
        instance.putExtra("valor1", Integer.parseInt(edt1.getText().toString()));
        instance.putExtra("valor2", Integer.parseInt(edt2.getText().toString()));

        startActivity(instance);
    }
}