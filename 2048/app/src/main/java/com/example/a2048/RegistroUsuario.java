package com.example.a2048;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.a2048.Utilities.TABLA_USUARIO;


public class RegistroUsuario extends AppCompatActivity {

    /* ESTA CLASE SE USA PARA INTRODUCIR DATOS EN LA DATABASE, PARA ELLO COGE EL CONTENIDO DE LOS EDITTEXT, Y LOS ENVÍA A SUS RESPECTIVOS CAMPOS EN LA TABLA DE USUARIOS */

    EditText userName;
    EditText userID;
    EditText country;

    Game g = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_usuario_activity);

        userName = (EditText) findViewById(R.id.name_ID);
        userID = (EditText) findViewById(R.id.IDUser_ID);
        country = (EditText) findViewById(R.id.country_ID);
    }

    public void onClick(View view){
        int puntuacion = g.puntuacion;
        registrarUsuarios(puntuacion);
    }

    public void registrarUsuarios(int puntuacion){

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        int idUser = Integer.parseInt(userID.getText().toString());

        values.put(Utilities.USER_NAME, userName.getText().toString());
        values.put(Utilities.USER_ID, idUser);
        values.put(Utilities.COUNTRY, country.getText().toString());
        values.put(Utilities.FINAL_SCORE, puntuacion);
        db.insert(Utilities.TABLA_USUARIO, null, values);
    }
}
