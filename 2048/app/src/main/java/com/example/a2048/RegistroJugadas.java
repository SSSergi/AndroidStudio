package com.example.a2048;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class RegistroJugadas extends AppCompatActivity {

    public void registrarJugada(int[][] tabla, ArrayList<int[][]> jHistorial){

        for (int i = 3; i >= 0; i--) {
            if (i==2){
                jHistorial.add(3, jHistorial.get(2));
            }
            if (i == 1) {
                jHistorial.add(2, jHistorial.get(1));
            }
            if (i==0){
                jHistorial.add(1, jHistorial.get(0));
            }
        }
        jHistorial.add(0, tabla);
    }

    public void iniciarRegistro(int[][] tabla, ArrayList<int[][]> jHistorial){
        for (int i = 0; i < 4; i++) {
            jHistorial.add(tabla);
        }
    }
}
