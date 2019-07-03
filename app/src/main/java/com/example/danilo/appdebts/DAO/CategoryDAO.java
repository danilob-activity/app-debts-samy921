package com.example.danilo.appdebts.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danilo.appdebts.Classes.Category;
import com.example.danilo.appdebts.database.ScriptDLL;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private SQLiteDatabase mConnection;

        public CategoryDAO(SQLiteDatabase conection){
            mConnection = conection;
        }

        public void insert(Category category) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("tipo", category.mType);
            mConnection.insertOrThrow("categoria", null, contentValues);
            Log.d("CategoryDAO", "Inserção realizada com sucesso!");
        }

        public void remove(int id){
            String[] params = new String[1];
            params[0] = String.valueOf(id);
            mConnection.delete("categoria", "id = ?", params);
        }

        public void alter(Category cat){
            ContentValues contentValues = new ContentValues();
            contentValues.put("tipo", cat.getType());
            String[] params = new String[1];
            params[0] = String.valueOf(cat.getId());
            mConnection.update("categoria", contentValues, "id = ?", params);
        }

        public List<Category> listCategories() {
            List<Category> mCategories = new ArrayList<Category>();
            Cursor result = mConnection.rawQuery(ScriptDLL.getCategory(), null);
            if (result.getCount()>0) {
                result.moveToFirst();
                do {
                    Category cat = new Category();
                    cat.setId(result.getInt(result.getColumnIndexOrThrow("id")));
                    cat.setType(result.getString(result.getColumnIndexOrThrow("tipo")));
                    mCategories.add(cat);
                    Log.d("CategoryDAO", "Listando: " + cat.getId() + " - " + cat.getType());
                } while (result.moveToNext());
                result.close();
            }
            return mCategories;
        }

        public Category getCategory(int id){

            Category cat = new Category();
            String[] params = new String[1];
            params[0] = String.valueOf(id);
            Cursor result = mConnection.rawQuery("Select * from categoria where id = 1",params);

            if(result.getCount()>0){
                result.moveToFirst();
                cat.setId(result.getInt(result.getColumnIndexOrThrow("id")));
                cat.setType(result.getString(result.getColumnIndexOrThrow("tipo")));
                result.close();
                return cat;
            }

            return null;

        }

}
