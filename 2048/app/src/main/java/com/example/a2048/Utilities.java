package com.example.a2048;

public class Utilities {

    /* ESTA CLASE ES BÁSICAMENTE EL STRING DE "CREATE TABLE USUARIO", CON SUS RESPECTIVOS CAMPOS, QUE LUEGO LLAMAMOS EN LA CLASE CONEXIONSQL, PARA CREAR LA TABLA */
    public static final String TABLA_USUARIO = "usuario";
    public static final String USER_NAME = "userName";
    public static final String USER_ID = "userID";
    public static final String FINAL_SCORE = "finalScore";
    public static final String COUNTRY = "country";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE" +
            " "+TABLA_USUARIO +" ("+USER_NAME+" " +
            "TEXT, "+USER_ID+" INTEGER, "+COUNTRY+" TEXT, "+FINAL_SCORE+" INTEGER)";
}
