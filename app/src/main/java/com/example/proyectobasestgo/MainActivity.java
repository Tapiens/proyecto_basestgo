package com.example.proyectobasestgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {


    private EditText user,pass;
    private TextView msj;
    private Button btn;
    private ProgressBar barra;
    private Administrador adm = new Administrador(); // Instancia del objeto administrador


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        btn = findViewById(R.id.btn);
        barra = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE); // maneja la visibilidad de un elemento
        barra.setVisibility(View.INVISIBLE);



        // ACCEDE DE UNA FRMA MAS DIRECTA
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Deberan correr mis tareas Asincrona
                new Task().execute();

            }
        });
    }
    // tarea asincrona:

    class Task extends AsyncTask<String, Void, String>
    {

        // este metodo sirve para configurar la tarea, donde se puede dar la configuracion inicial a mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);// SERA VISIBLE CUANDO COMINEZA LA TAREA ASINCRONA
        }

        //Es el encargado de procesar en segundo plano, nuestra tarea pesada
        @Override
        protected String doInBackground(String... strings) {

            try {
                for(int i=0; i <= 10; i++)
                {
                    Thread.sleep(500);

                }

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();

            }
            return null;
        }

        //Donde finaliza el proceso.(o tarea asincrona)

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim(); // trim = limita los espacios en blanco

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch(usuario)  // determina que sucede en cada caso
            {
                case "Tiare":
                    if(usuario.equals(userObj)&& contrasena.equals(passObj))
                    {
                        //se inicia session
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);

                    }
                    break;
                case "":
                    if (usuario.equals("")&& contrasena.equals(""))
                    {
                        // campos vacios
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacios porfavor intente nuevamente");
                    }
                    break;
                default:
                    if(!usuario.equals(userObj)&& !contrasena.equals(passObj))
                    {
                        // campos incorrectos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos incorrectos porfavor intente nuevamente");
                    }
                    break;
            }
        }
    }



    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // para abrir un sitio web
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }
    public void Discord(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // para abrir un sitio web
        i.setData(Uri.parse("https://www.discord.com/"));
        startActivity(i);

    }
    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // para abrir un sitio web
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);

    }
    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);

    }
}