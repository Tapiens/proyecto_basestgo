package com.example.proyectobasestgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.data.SingleRefDataBufferIterator;

import database.AdminSQLiteOpenHelper;

public class Pedidos_act extends AppCompatActivity {

    private EditText codigo, nombre, monto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        codigo = findViewById(R.id.codigo);
        nombre = findViewById(R.id.nombre);
        monto = findViewById(R.id.monto);
    }

    public void añadirPedido(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Tapias", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cod = codigo.getText().toString();
        String nom = nombre.getText().toString();
        String mon = monto.getText().toString();

        if (!cod.isEmpty() && !nom.isEmpty() && !mon.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", cod);
            cont.put("nombre", nom);
            cont.put("monto", mon);

            db.insert("pedidos", null,cont);
            db.close();
            limpiar();
            Toast.makeText(getBaseContext(), "Has creado un pedido", Toast.LENGTH_SHORT).show();

        }
        else {

            Toast.makeText(getBaseContext(), "Los campos no pueden ir vacíos", Toast.LENGTH_SHORT).show();

        }

    }

    public void mostrarPedido(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Tapias", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cod = codigo.getText().toString();
        if (!cod.isEmpty())
        {
            Cursor file =
                    db.rawQuery("SELECT nombre, monto FROM pedidos WHERE codigo="+cod, null);
            if (file.moveToFirst())
            {
                nombre.setText(file.getString(0));
                monto.setText(file.getString(1));
            }
            else{
                Toast.makeText(getBaseContext(), "no hay pedido asociado", Toast.LENGTH_SHORT).show();
            }

        }
        else {

            Toast.makeText(getBaseContext(), "El código está vacío", Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminarPedido(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Tapias", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cod = codigo.getText().toString();

        if (!cod.isEmpty())
        {
            db.delete("pedidos", "codigo="+cod, null);
            db.close();
            limpiar();
            Toast.makeText(getBaseContext(), "El pedido "+cod+ " ha sido eliminado", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getBaseContext(), "Ingrese código por favor", Toast.LENGTH_SHORT).show();
        }

    }

    public void actualizarPedido(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Tapias", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cod = codigo.getText().toString();
        String nom = nombre.getText().toString();
        String mon = monto.getText().toString();

        if (!cod.isEmpty() && !nom.isEmpty() && !mon.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("nombre", nom);
            cont.put("monto", mon);

            db.update("pedidos", cont, "codigo="+cod, null);
            db.close();
            limpiar();
            Toast.makeText(getBaseContext(), "Se ha actualizado el pedido", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getBaseContext(), "Los campos no pueden ir vacíos", Toast.LENGTH_SHORT).show();
        }

    }

    //limpiar campos

    public void limpiar()
    {
        codigo.setText("");
        nombre.setText("");
        monto.setText("");
    }

}