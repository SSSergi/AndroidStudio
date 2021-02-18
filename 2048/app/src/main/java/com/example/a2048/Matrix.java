package com.example.a2048;

import java.util.Scanner;

public class Matrix{

    private int spawnEjeX;
    private int spawnEjeY;

    // EN TEORÍA ESTOS DOS MÉTODOS direccion Y moverCasillas YA DEBERÍAN SER NECESARIOS
    /*
    public int direccion(){
        Scanner sc=new Scanner(System.in);
        System.err.println("Introduce una dirección:");
        int res=sc.nextInt();
        return res;
    }

    public void moverCasillas(int instruc, int[][] tablero){
        if(instruc==1){
            HaciaAbajo(tablero);
        }
        if(instruc==2){
            HaciaLaDerecha(tablero);
        }
        if(instruc==4){
            HaciaLaIzquierda(tablero);
        }
        if(instruc==5){
            System.exit(0);
        }
    }*/

    /* ------------------------ MOVIMIENTOS ------------------------ */

    public void HaciaArriba(int[][] tabla){
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                int k=i;
                while (k>=1){
                    if(tabla[k][j]!=0){
                        if(tabla[k-1][j]==0){
                            tabla[k-1][j]=tabla[k][j];
                            tabla[k][j]=0;
                        }else{
                            if(tabla[k][j]==tabla[k-1][j]){
                                tabla[k-1][j]=tabla[k-1][j]*2;
                                tabla[k][j]=0;
                            }
                        }
                    }
                    k--;
                }
            }
        }
    }

    public void HaciaAbajo(int[][] tabla){
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--){
                int k=i;
                while (k<=2){
                    if(tabla[k][j]!=0){
                        if(tabla[k+1][j]==0){
                            tabla[k+1][j]=tabla[k][j];
                            tabla[k][j]=0;
                        }else{
                            if(tabla[k][j] == tabla[k+1][j]){
                                tabla[k+1][j] = tabla[k+1][j]*2;
                                tabla[k][j] = 0;
                            }
                        }
                    }
                    k++;
                }
            }
        }
    }

    public void HaciaLaDerecha(int[][] tabla){
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >=0; j--) {
                int k=j;
                while (k<=2){
                    if(tabla[i][k]!=0){
                        if(tabla[i][k+1]==0){
                            tabla[i][k+1]=tabla[i][k];
                            tabla[i][k]=0;
                        }else{
                            if(tabla[i][k]==tabla[i][k+1]){
                                tabla[i][k+1]=tabla[i][k+1]*2;
                                tabla[i][k]=0;
                            }
                        }
                    }
                    k++;
                }
            }
        }
    }

    public void HaciaLaIzquierda(int[][] tabla){
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                int k=j;
                while (k>=1){
                    if(tabla[i][k]!=0){
                        if(tabla[i][k-1]==0){
                            tabla[i][k-1]=tabla[i][k];
                            tabla[i][k]=0;
                        }else{
                            if(tabla[i][k]==tabla[i][k-1]){
                                tabla[i][k-1]=tabla[i][k-1]*2;
                                tabla[i][k]=0;
                            }
                        }
                    }
                    k--;
                }
            }
        }
    }

    /* ------------------------ MOVIMIENTOS END ------------------------ */

    /*
    public void mostrarMatriz(int[][] tablero){
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length; j++){
                System.out.print(tablero[i][j]);
                System.out.print("  ");
            }
            if (i!=tablero.length-1) System.out.print("\t");
            System.out.println(" ");
        }
    }
    */

    public void fillBoard(int[][] tablero){
        for(int i=0; i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                tablero[i][j]=0;
            }
        }
    }

    /* ---------------------------- GENERAR 2 ----------------------------  */

    public int comprobarDerrota(int[][] tabla){
        int casillasLibres=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                if(tabla[i][j] == 0){
                    casillasLibres=casillasLibres+1;
                }
            }
        }
        return casillasLibres;
    }

    public int comprobarVictoria(int[][] tabla){
        int[] listaValores=new int [16];
        int maxNum=0;
        int k=0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                listaValores[k]=tabla[i][j];
                k++;
            }
        }
        for(int i=1;i < listaValores.length;i++){
            if(listaValores[i] > maxNum){
                maxNum = listaValores[i];
            }
        }
        return maxNum;
    }

    public int generatorX(){
        double x=Math.random()*(0-3)+3;
        long x2=Math.round(x);
        spawnEjeX=Math.toIntExact(x2);
        return spawnEjeX;
    }

    public int generatorY(){
        double y=Math.random()*(0-3)+3;
        long y2=Math.round(y);
        spawnEjeY=Math.toIntExact(y2);
        return spawnEjeY;
    }

    public void spawn2(int[][] tabla){
        int x=generatorX();
        int y=generatorY();

        if(tabla[x][y]==0){

            tabla[x][y]=2;

        }else if(tabla[x][y]!=0){

            spawn2(tabla);
        }
    }

    public void startGame(int[][] tabla){
        spawn2(tabla);
        spawn2(tabla);
    }
}
