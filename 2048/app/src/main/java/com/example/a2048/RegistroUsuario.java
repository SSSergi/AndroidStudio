package com.example.a2048;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;


public class RegistroUsuario extends AppCompatActivity {

    EditText userName, userID, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_usuario_activity);

        userName = (EditText) findViewById(R.id.name_ID);
        userID = (EditText) findViewById(R.id.IDUser_ID);
        country = (EditText) findViewById(R.id.country_ID);;
    }

    public void onClick(View view){
        registrarUsuarios();
    }

    public void registrarUsuarios(){

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilities.USER_NAME, userName.getText().toString());
        values.put(Utilities.USER_ID, userID.getText().toString());
        values.put(Utilities.COUNTRY, country.getText().toString());

        Long idResultante = db.insert(Utilities.TABLA_USUARIO, Utilities.USER_ID, values);

        Toast.makeText(getApplicationContext(), "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
    }
}
