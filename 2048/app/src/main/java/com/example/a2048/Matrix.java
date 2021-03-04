package com.example.a2048;


public class Matrix{

    private int spawnEjeX;
    private int spawnEjeY;


    /* ------------------------ MOVIMIENTOS ------------------------ */

    public int HaciaArriba(int[][] tabla, int puntuacion){
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
                                puntuacion = puntuacion + tabla[k-1][j];
                            }
                        }
                    }
                    k--;
                }
            }
        }
        return puntuacion;
    }

    public int HaciaAbajo(int[][] tabla, int puntuacion){
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
                                puntuacion = puntuacion + tabla[k+1][j];
                            }
                        }
                    }
                    k++;
                }
            }
        }
        return puntuacion;
    }

    public int HaciaLaDerecha(int[][] tabla, int puntuacion){
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
                                puntuacion = puntuacion + tabla[i][k+1];
                            }
                        }
                    }
                    k++;
                }
            }
        }
        return puntuacion;
    }

    public int HaciaLaIzquierda(int[][] tabla, int puntuacion){
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
                                puntuacion = puntuacion + tabla[i][k-1];
                            }
                        }
                    }
                    k--;
                }
            }
        }
        return puntuacion;
    }

    /* ------------------------ MOVIMIENTOS END ------------------------ */

    public void fillBoard(int[][] tablero){
        for(int i=0; i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                tablero[i][j]=0;
            }
        }
    }

    public int existeMovimiento(int[][] tabla){
        int resultado=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                /* ------------------------ ESQUINAS START ------------------------ */

                // CASILLA 0 0 --SUPERIOR IZQUIERDA--
                if (i==0 && j==0){

                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                }

                // CASILLA 0 3 --SUPERIOR DERECHA--
                if (i==0 && j==3){

                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                }

                // CASILLA 3 0 --INFERIOR IZQUIERDA--
                if (i==3 && j==0){

                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                }

                // CASILLA 3 3 --INFERIOR DERECHA--
                if (i==0 && j==3){

                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                }
                /* ------------------------ ESQUINAS END ------------------------ */
                /* ------------------------ LATERALES START ------------------------ */

                // CASILLA 0 1 --SUPERIOR--
                if (i==0 && j==1){

                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                }
                // CASILLA 0 2 --SUPERIOR--
                if (i==0 && j==2){

                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                }

                // CASILLA 1 3 --DERECHA--
                if (i==1 && j==3){

                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                }
                // CASILLA 2 3 --DERECHA--
                if (i==2 && j==3){

                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                }

                // CASILLA 1 0 --IZQUIERDA--
                if (i==1 && j==0){

                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                }
                // CASILLA 2 0 --IZQUIERDA--
                if (i==2 && j==3){

                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA ABAJO */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                }

                // CASILLA 3 1 --INFERIOR--
                if (i==3 && j==1){

                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                }
                // CASILLA 3 2 --INFERIOR--
                if (i==3 && j==2){

                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                }
                /* ------------------------ LATERALES END ------------------------ */
                /* ------------------------ CENTRALES START ------------------------ */

                // CASILLA 1 1 --CENTRAL--
                if (i==1 && j==1){

                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA INFERIOR */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                }

                // CASILLA 1 2 --CENTRAL--
                if (i==1 && j==2){

                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA INFERIOR */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                }

                // CASILLA 2 1 --CENTRAL--
                if (i==2 && j==1){

                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA INFERIOR */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                }

                // CASILLA 2 2 --CENTRAL--
                if (i==2 && j==2){

                    /* CASILLA ARRIBA */
                    if (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0){
                        resultado++;
                    }
                    /* CASILLA DERECHA */
                    if (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0){
                        resultado++;
                    }
                    /* CASILLA INFERIOR */
                    if (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0){
                        resultado++;
                    }
                    /* CASILLA IZQUIERDA */
                    if (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0){
                        resultado++;
                    }
                }
                /* ------------------------ CENTRALES END ------------------------ */
            }

        }

        return resultado;
    }

    public int existeMovimientoHaciaArriba(int [][] tabla) {
        int resultado = 0;

        for (int j = 0; j < 4; j++) {
            for (int i = 3; i > 0 ; i--) {
                if (tabla[i][j] != 0 && (tabla[i][j]==tabla[i-1][j] || tabla[i-1][j]==0)){
                    resultado = resultado + 1;
                }
            }
        }
        return resultado;
    }

    public int existeMovimientoHaciaDerecha(int [][] tabla){
        int resultado = 0;

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabla[i][j] != 0 && (tabla[i][j]==tabla[i][j+1] || tabla[i][j+1]==0)){
                    resultado = resultado + 1;
                }
            }
        }
        return resultado;
    }

    public int existeMovimientoHaciaAbajo(int [][] tabla){
        int resultado = 0;

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i <= 2; i++) {
                if (tabla[i][j] != 0 && (tabla[i][j]==tabla[i+1][j] || tabla[i+1][j]==0)){
                    resultado = resultado + 1;
                }
            }
        }
        return resultado;
    }

    public int existeMovimientoHaciaIzquierda(int [][] tabla){
        int resultado = 0;

        for (int i = 0; i < 4 ; i++) {
            for (int j = 3; j > 0; j--) {
                if (tabla[i][j] != 0 && (tabla[i][j]==tabla[i][j-1] || tabla[i][j-1]==0)){
                    resultado = resultado + 1;
                }
            }
        }
        return resultado;
    }

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
