package com.example.danilo.appdebts;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.danilo.appdebts.Adapters.DebtsAdapter;
import com.example.danilo.appdebts.DAO.DebtsDAO;
import com.example.danilo.appdebts.database.Databasedets;

public class MainWindow extends AppCompatActivity {
    RecyclerView mListDebts;
    DebtsAdapter mDebtsAdapter;
    DebtsDAO mDebtsDAO;
    private ConstraintLayout mLayout;
    private SQLiteDatabase mConection;
    private Databasedets mDataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    mListDebts = findViewById(R.id.recycler_view_debts);
    mLayout = findViewById(R.id.layout);
    createConnection();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    mListDebts.setLayoutManager(linearLayoutManager);
    mDebtsAdapter = new DebtsAdapter(mDebtsDAO.listDebts());
    mListDebts.setAdapter(mDebtsAdapter);
    mListDebts.setHasFixedSize(true);



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


