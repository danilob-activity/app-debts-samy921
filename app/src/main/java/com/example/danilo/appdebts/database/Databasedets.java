package com.example.danilo.appdebts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasedets extends SQLiteOpenHelper {

    private static final String DB_NAME = "debts.db";
    private static final int DB_VERSION = 1;

    public Databasedets(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public Databasedets(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptDLL.createTableCategory());
        db.execSQL(ScriptDLL.createTableDividas());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
