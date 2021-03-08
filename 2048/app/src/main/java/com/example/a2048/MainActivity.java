package com.example.a2048;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView start;
    private TextView newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        start = (TextView) findViewById(R.id.startBut);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGame=new Intent(MainActivity.this, Game.class);
                startActivity(intentGame);
            }
        });

        newUser = (TextView) findViewById(R.id.NewUser);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreatePlayer = new Intent(MainActivity.this, RegistroUsuario.class);
                startActivity(intentCreatePlayer);
            }
        });
    }
}