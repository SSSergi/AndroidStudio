package com.example.a2048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    private TextView newGame;
    private TextView marcoScore;
    private TextView casilla;
    private GridLayout casillas;
    private Matrix matrix = new Matrix();
    private RegistroJugadas historial = new RegistroJugadas();

    private int puntuacion = 0;
    private int record;

    private ArrayList<int[][]> registroJugadas = new ArrayList<>();
    private int[][] tabla = new int[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        /* ------------------------ BOTÓN DE REINICIAR GAME ------------------------ */

        newGame = (TextView) findViewById(R.id.newGamebtn);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewGame=new Intent(Game.this, Game.class);
                startActivity(intentNewGame);
            }
        });


        /* ------------- CREAR TABLERO, LLENARLO DE 0 Y COLOCAR 2 PRIMERAS CASILLAS ------------- */
        matrix.fillBoard(tabla);
        matrix.startGame(tabla);
        mostrarTablero(tabla);
        historial.iniciarRegistro(tabla, registroJugadas);

        /* ------------------------ DETECTAR LA DIRECCIÓN DE DELIZAR ------------------------ */

        casillas=(GridLayout) findViewById(R.id.rejilla);
        casillas.setOnTouchListener(new OnSwipeTouchListener(Game.this){
            public void onSwipeTop(){
                if (matrix.existeMovimiento(tabla) != 0){
                    if (matrix.existeMovimientoHaciaArriba(tabla) != 0){
                        puntuacion = matrix.HaciaArriba(tabla, puntuacion);
                        matrix.spawn2(tabla);
                        mostrarTablero(tabla);
                        puntuar(puntuacion);
                        historial.registrarJugada(tabla, registroJugadas);
                        ganarGame(tabla);
                        perderGame(tabla);
                    }
                }
            }

            public void onSwipeRight() {
                if (matrix.existeMovimiento(tabla) != 0){
                    if (matrix.existeMovimientoHaciaDerecha(tabla) != 0){
                        puntuacion = matrix.HaciaLaDerecha(tabla, puntuacion);
                        matrix.spawn2(tabla);
                        mostrarTablero(tabla);
                        puntuar(puntuacion);
                        historial.registrarJugada(tabla, registroJugadas);
                        ganarGame(tabla);
                        perderGame(tabla);
                    }
                }
            }

            public void onSwipeLeft() {
                if (matrix.existeMovimiento(tabla) != 0){
                    if (matrix.existeMovimientoHaciaIzquierda(tabla) != 0){
                        puntuacion = matrix.HaciaLaIzquierda(tabla, puntuacion);
                        matrix.spawn2(tabla);
                        mostrarTablero(tabla);
                        puntuar(puntuacion);
                        historial.registrarJugada(tabla, registroJugadas);
                        ganarGame(tabla);
                        perderGame(tabla);
                    }
                }
            }

            public void onSwipeBottom() {
                if (matrix.existeMovimiento(tabla) != 0){
                    if (matrix.existeMovimientoHaciaAbajo(tabla) != 0){
                        puntuacion = matrix.HaciaAbajo(tabla, puntuacion);
                        matrix.spawn2(tabla);
                        mostrarTablero(tabla);
                        puntuar(puntuacion);
                        historial.registrarJugada(tabla, registroJugadas);
                        ganarGame(tabla);
                        perderGame(tabla);
                    }
                }
            }
        });
    }

    public void mostrarTablero(int[][] tablero){

        casilla=(TextView) findViewById(R.id.c1);
        casilla.setText(Integer.toString(tablero[0][0]));

        casilla=(TextView) findViewById(R.id.c2);
        casilla.setText(Integer.toString(tablero[0][1]));

        casilla=(TextView) findViewById(R.id.c3);
        casilla.setText(Integer.toString(tablero[0][2]));

        casilla=(TextView) findViewById(R.id.c4);
        casilla.setText(Integer.toString(tablero[0][3]));

        casilla=(TextView) findViewById(R.id.c5);
        casilla.setText(Integer.toString(tablero[1][0]));

        casilla=(TextView) findViewById(R.id.c6);
        casilla.setText(Integer.toString(tablero[1][1]));

        casilla=(TextView) findViewById(R.id.c7);
        casilla.setText(Integer.toString(tablero[1][2]));

        casilla=(TextView) findViewById(R.id.c8);
        casilla.setText(Integer.toString(tablero[1][3]));

        casilla=(TextView) findViewById(R.id.c9);
        casilla.setText(Integer.toString(tablero[2][0]));

        casilla=(TextView) findViewById(R.id.c10);
        casilla.setText(Integer.toString(tablero[2][1]));

        casilla=(TextView) findViewById(R.id.c11);
        casilla.setText(Integer.toString(tablero[2][2]));

        casilla=(TextView) findViewById(R.id.c12);
        casilla.setText(Integer.toString(tablero[2][3]));

        casilla=(TextView) findViewById(R.id.c13);
        casilla.setText(Integer.toString(tablero[3][0]));

        casilla=(TextView) findViewById(R.id.c14);
        casilla.setText(Integer.toString(tablero[3][1]));

        casilla=(TextView) findViewById(R.id.c15);
        casilla.setText(Integer.toString(tablero[3][2]));

        casilla=(TextView) findViewById(R.id.c16);
        casilla.setText(Integer.toString(tablero[3][3]));
    }

    public void puntuar(int puntos){
        marcoScore=(TextView) findViewById(R.id.score);
        marcoScore.setText(Integer.toString(puntos));
    }

    public void perderGame(int [][] tabla){
        if(matrix.comprobarVictoria(tabla) != 2048 && matrix.comprobarDerrota(tabla)==0 && matrix.existeMovimiento(tabla)==0){
            Intent LostGame = new Intent(Game.this, MainActivity.class);
            startActivity(LostGame);
            Toast toast = Toast.makeText(getApplicationContext(), "Perdiste Caratriste!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public  void ganarGame(int[][] tabla){
        if(matrix.comprobarVictoria(tabla)==2048){
            Intent WinGame = new Intent(Game.this, MainActivity.class);
            startActivity(WinGame);
            Toast toast = Toast.makeText(getApplicationContext(), "Venciste Alatriste!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
