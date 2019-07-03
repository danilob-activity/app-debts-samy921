package com.example.danilo.appdebts.database;

import android.database.sqlite.SQLiteDatabase;

public class ScriptDLL {
    public static  String createTableCategory(){
        StringBuilder sql = new StringBuilder();
        sql.append("Create TABLE categoria (");
        sql.append(" id INTERGER NOT NULL PRIMARY KEY, ");
        sql.append(" tipo TEXT NOT NULL");
        sql.append(");");
        return sql.toString();
    }

    public static String createTableDividas(){
        StringBuilder sql = new StringBuilder();
        sql.append("Create TABLE dividas (");
        sql.append(" id integer PRIMARY KEY, ");
        sql.append(" cod_cat integer NOT NULL, ");
        sql.append(" valor Real not NULL, ");
        sql.append(" descricao text not NULL, ");
        sql.append(" data_vencimento date NOT NULL, ");
        sql.append(" data_pagamento date, ");
        sql.append(" FOREIGN KEY (cod_cat) REFERENCES categoria(id) ");
        sql.append(");");
        return sql.toString();
    }

    public static String getCategory(){
        return "select * from category";
    }
    public static String getDebts(){
        return "select * from debts";
    }


}
