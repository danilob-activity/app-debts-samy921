package com.example.danilo.appdebts;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.danilo.appdebts.Classes.Category;
import com.example.danilo.appdebts.DAO.CategoryDAO;
import com.example.danilo.appdebts.database.Databasedets;
import com.example.danilo.appdebts.database.ScriptDLL;

public class TelaInicial extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private Databasedets mDataHelper;
    private ConstraintLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        mLayout = findViewById(R.id.layout);

        createConnection();
        CategoryDAO categoryDAO = new CategoryDAO(mConection);
        Category category = categoryDAO.getCategory(5);
        category.setType("Energia");
        categoryDAO.alter(category);
        categoryDAO.remove(7);
        categoryDAO.remove(8);
        categoryDAO.remove(9);
    }


    private void createConnection() {
        try {
            mDataHelper = new Databasedets(this);
            mConection = mDataHelper.getWritableDatabase();
            Snackbar.make(mLayout, R.string.sucess_conection, Snackbar.LENGTH_LONG).show();
        } catch (SQLException e) {
            Snackbar.make(mLayout, e.toString(), Snackbar.LENGTH_LONG).show();
        }
    }
}
