package com.example.a2048;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import android.util.Log;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import  android.view.View.OnTouchListener;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity{

    int tablero[][]=new int[4][4];
    ArrayList options=new ArrayList();
    int spawnX;
    int spawnY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillBoard(tablero);
        startGame(tablero);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.err.println(" "+tablero[i][j]+"");
            }
        }
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