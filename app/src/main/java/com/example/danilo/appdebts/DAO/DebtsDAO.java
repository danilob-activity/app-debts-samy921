package com.example.danilo.appdebts.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danilo.appdebts.Classes.Debts;
import com.example.danilo.appdebts.database.ScriptDLL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 28/06/19.
 */

public class DebtsDAO {
    private SQLiteDatabase mConnection;

    public DebtsDAO(SQLiteDatabase conection){
        mConnection = conection;
    }

    public void insert(Debts debts) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("valor", debts.getValue());
        mConnection.insertOrThrow("debts", null, contentValues);
        Log.d("DebtsDAO", "Inserção realizada com sucesso!");
    }

    public void remove(int id){
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        mConnection.delete("dividas", "id = ?", params);
    }

    public void alter(Debts debts){
        ContentValues contentValues = new ContentValues();
        contentValues.put("valor", getDebts(1).getValue());
        String[] params = new String[1];
        params[0] = String.valueOf(debts.getId(1));
        mConnection.update("dividas", contentValues, "id = ?", params);
    }

    public List<Debts> listDebts() {
        List<Debts> mDebts = new ArrayList<Debts>();
        Cursor result = mConnection.rawQuery(ScriptDLL.getCategory(), null);
        if (result.getCount()>0) {
            result.moveToFirst();

            CategoryDAO categoryDAO = new CategoryDAO(mConnection);

            do {
                Debts deb = new Debts();
                deb.setCategory(categoryDAO.getCategory(result.getInt(result.getColumnIndexOrThrow("cod_cat"))));
                deb.setId(result.getLong(result.getColumnIndexOrThrow("id")));
                deb.setValue(result.getFloat(result.getColumnIndexOrThrow("valor")));
                deb.setPayDate(result.getString(result.getColumnIndexOrThrow("data_vencimento")));
                deb.setPaymentDate(result.getString(result.getColumnIndexOrThrow("data_pagamento")));
                mDebts.add(deb);
                Log.d("DividasDAO", "Listando: "
                        + deb.getId(1) +
                        " - " + deb.getValue() +
                        " - " + deb.getPayDate() +
                        " - " + deb.getPaymentDate() +
                        " - " + deb.getCategory());
            } while (result.moveToNext());
            result.close();
        }
        return mDebts;
    }

    public Debts getDebts(int id){
        Debts deb = new Debts();
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        Cursor result = mConnection.rawQuery("Select * from debts where id=1",params);
        if(result.getCount()>0){
            result.moveToFirst();
            deb.setId(result.getInt(result.getColumnIndexOrThrow("id")));
            deb.setValue(result.getFloat(result.getColumnIndexOrThrow("valor")));
            result.close();
            return deb;
        }
        return null;
    }
}
