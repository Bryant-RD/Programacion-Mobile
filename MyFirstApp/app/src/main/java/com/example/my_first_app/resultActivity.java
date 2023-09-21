package com.example.my_first_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView primero = (TextView)findViewById(R.id.lblPrimero);
        TextView segundo = (TextView)findViewById(R.id.lblSegundo);
        TextView tercero = (TextView)findViewById(R.id.lblTercero);

        Bundle datosRecibidos = getIntent().getExtras();

        primero.setText("Hola mi nombre es: " + datosRecibidos.getString("nombre") + " " + datosRecibidos.getString("apellido"));
        segundo.setText("Soy " + datosRecibidos.getString("genero") + " y nací en la fecha " + datosRecibidos.getString("fecha"));

        String mensaje = "Me gusta programar y mis lenguajes favoritos son: ";
        ArrayList<String> lista = datosRecibidos.getStringArrayList("seleccionados");

        if (datosRecibidos.getString("gusto").equalsIgnoreCase("Si")) {
            for (int i = 0; i < lista.size(); i++) {
                mensaje += lista.get(i) + " - ";
            }
            tercero.setText(mensaje);
        }

    }
}