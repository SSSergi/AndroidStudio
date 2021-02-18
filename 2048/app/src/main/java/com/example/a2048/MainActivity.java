package com.example.a2048;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import  android.view.View.OnTouchListener;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private TextView casilla;
    private GridLayout casillas;
    private GestureDetector gesto;

    private int tablero[][]=new int[4][4];
    private ArrayList options=new ArrayList();
    private int spawnX;
    private int spawnY;

    private Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrix.fillBoard(tablero);

        matrix.startGame(tablero);

        mostrarTablero(tablero);

        /* ------------------------ DETECTAR LA DIRECCIÓN DE DELIZAR ------------------------ */
        casillas=(GridLayout) findViewById(R.id.rejilla);
        casillas.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop(){
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
                matrix.HaciaArriba(tablero);
            }
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                matrix.HaciaLaDerecha(tablero);
            }
            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                matrix.HaciaLaIzquierda(tablero);
            }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                matrix.HaciaAbajo(tablero);
            }
        });
    }

    public void mostrarTablero(int[][] tablero, String[] listaIds){
        String [] listaIds = new String[]{ "c1", "c2", "c3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14", "C15", "C16" };
        int cIndex=0;
        casillas=(GridLayout) findViewById(R.id.rejilla);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int k=0;
                int valor = tablero[i][j];
                casilla=(TextView) findViewById(R.id.listaIds);
                casilla.setText(valor);
                k = k + 1;
            }
        }
        int valor = tablero[0][0];
        casilla=(TextView) findViewById(R.id.c1);
        casilla.setText(valor);
    }
}