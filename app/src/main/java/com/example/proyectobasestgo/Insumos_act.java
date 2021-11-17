package com.example.proyectobasestgo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    public RatingBar calificar;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);

        //recibe extras

        Bundle bun= getIntent().getExtras(); // recibe los valores del bundle
        String[] listado = bun.getStringArray("insumos");// recibo el listado para su referencia

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString();
        int resultado = 0;

        for(int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(in.getInsumos()[i]))
            {
                resultado = in.getPrecios()[i];
                calificar.setRating(i);
                break;
            }

        }
        result.setText("La opcion es: "+opcion + "\n Su precio es: "+ resultado);

    }
}

