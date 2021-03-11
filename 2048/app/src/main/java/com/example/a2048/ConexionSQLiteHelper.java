package com.example.a2048;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class ConexionSQLiteHelper extends SQLiteOpenHelper{

    /* ESTA CLASE ES BÁSICAMENTE LA QUE CREA LA BASE DE DATOS, Y LA QUE HACE EL "CREATE TABLE USUARIO", LLAMANDO AL STRING CON LA ESTRUCTURA DEL CREATE, DESDE LA CLASE UTILITIES */

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilities.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        onCreate(db);
    }
}
