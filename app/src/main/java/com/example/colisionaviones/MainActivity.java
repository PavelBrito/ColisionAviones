package com.example.colisionaviones;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//import AvionAdapter;
//import Avion;
//import Aerolineas;
//import Analizador;
//import AvionHolder;
//import Direccion;
//import Planificador;
//import Plano;
//import androidx.gridlayout:gridlayout:+.;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAviones = findViewById(R.id.listaAviones);
        btnNext = findViewById(R.id.btnNext);
        plano =  Planificador.crearRutaInicial();
        adapter = new AvionAdapter(plano.aviones, plano.colisiones);
        listaAviones.setAdapter(adapter);
        listaAviones.setLayoutManager(new GridLayoutManager(this, 5));

        btnNext.setOnClickListener(v -> {
            plano = plano.next();
            adapter.notifyDataSetChanged();
        });


    }
}