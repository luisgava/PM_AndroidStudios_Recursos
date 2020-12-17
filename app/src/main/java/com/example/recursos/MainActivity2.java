package com.example.recursos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private Toolbar myToolbar;
    Button btnMostrarLista;
    ArrayList<String> listaDatos = new ArrayList<String>();
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // damos funcionalidad al toolbar
        myToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);

        // Recuperación de un dato.
        int valor3 = getIntent().getIntExtra("valor1", 0);
        TextView txtDato1 = findViewById(R.id.textViewMetodo1);
        txtDato1.setText(Integer.toString(valor3));

        //Recuperación de TODOS los datos.
        Bundle datos = getIntent().getExtras();
        int valor1 = datos.getInt("valo1");
        int valor2 = datos.getInt("valor2");
        int res = valor1 + valor2;

        TextView txtRes = findViewById(R.id.textViewResultado);
        txtRes.setText(Integer.toString(res));

        btnMostrarLista = findViewById(R.id.buttonMostrarLista);
        btnMostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creamos un array con los datos de la lista
                listaDatos.add("item1");
                listaDatos.add("item2");
                listaDatos.add("item3");
                listaDatos.add("item4");
                listaDatos.add("item5");

                // creamos el adaptador de la lista
                // Al adaptador le decimos como mostrar los datos y qué datos mostrar
                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_multiple_choice, listaDatos);

                lista = findViewById(R.id.lstLista);
                lista.setAdapter(adaptador);
            }
        });
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
            case R.id.botonArriba:
                Toast.makeText(this, "botón flechita arriba", Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}