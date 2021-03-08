package com.example.a2048;

public class Utilities {

    public static final String TABLA_USUARIO = "usuario";
    public static final String USER_NAME = "userName";
    public static final String USER_ID = "userID";
    public static final String FINAL_SCORE = "finalScore";
    public static final String COUNTRY = "country";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE" +
            ""+TABLA_USUARIO +" ("+USER_NAME+" " +
            "TEXT, "+USER_ID+" INTEGER, "+FINAL_SCORE+" INTEGER, "+COUNTRY+" TEXT)";
}
