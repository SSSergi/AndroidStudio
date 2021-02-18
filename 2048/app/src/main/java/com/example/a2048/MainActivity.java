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

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private GridLayout casilla;
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

        /* ------------------------ DETECTAR LA DIRECCIÓN DE DELIZAR ------------------------ */

        casilla=(GridLayout) findViewById(R.id.rejilla);
        casilla.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
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

    /*--CON ESTE MÉTODO LLENO LA MATRIZ DE CEROS, PARA QUE PUEDA OPERAR CON MÁS FACILIDAD QUE NO CON NULLS--*/

    public void fillBoard(int[][] tablero){
        for (int i=0; i<4; i++){
            for (int j=0; j<4;j++){
                tablero[i][j]=0;
            }
        }
    }
    
    /*------------------------------------------------------------------------------------------------------*/

    /*---- GENERADORES DE COORDENADAS ALEATORIOS ----*/
    public int generateX(){
        double x = Math.random()*(0-3)+3;
        long x2 = Math.round(x);
        spawnX = Math.toIntExact(x2);
        spawnY = Math.toIntExact(x2);
        return spawnX;
    }

    public int generateY(){
        double y = Math.random()*(0-3)+3;
        long y2 = Math.round(y);
        spawnY = Math.toIntExact(y2);
        return spawnY;
    }
    /*------------------------------------------------*/


    public void addNumber(int[][] tabla){
        boolean stop=false;
        while (stop==false){
            int x=generateX();
            int y=generateY();
            if (tabla[x][y]==0){
                tabla[x][y]=2;
                stop = true;
            }
            break;
        }
    }

    public void startGame(int[][] tabla){
        addNumber(tabla);
        addNumber(tabla);
    }
}