package com.example.proyectobasestgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private VideoView video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw);

        //obtener ruta del video

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);

        video.setVideoURI(uri);



        //controles para el video

        MediaController media = new MediaController(this);
        video.setMediaController(media);
    }

    public void Task(View view)
    {
        try {
            for (int i=0; i<=10;i++)
            {
                Thread.sleep(500);
                Toast.makeText(this,"Este es un gran proceso",Toast.LENGTH_SHORT).show();

            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();

        }

    }
    public void Insumos(View view)
    {
        Intent i =new Intent(this,Insumos_act.class);
        Bundle bun = new Bundle(); // es necesario para enviar arreglos
        bun.putStringArray("insumos", in.getInsumos()); // relleno en bundle, recibe referencia y el arreglo
        i.putExtras(bun);
        startActivity(i);
    }
     public void Pedidos(View view)
     {
         Intent i = new Intent(this, Pedidos_act.class);
         startActivity(i);
     }
}