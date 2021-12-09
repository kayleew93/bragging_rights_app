package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewStatsByPlayerActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    // Add DB info
    DBHelper db;
    // Spinner element
    Spinner playerStatsListSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats_by_player);

        // Spinner element
        playerStatsListSpinner = (Spinner) findViewById(R.id.playerStatsListSpinner);
        // Spinner click listener
        playerStatsListSpinner.setOnItemSelectedListener(this);
        // Loading spinner data from database
        loadSpinnerData();
    }

    /**
     * Function to load the spinner data from SQLite database
     * */
    private void loadSpinnerData() {
        // database handler
        db = new DBHelper(this);
        // Spinner Drop down elements
        ArrayList<String> playerNicknameArray = db.getPlayerNicknameList();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, playerNicknameArray);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        playerStatsListSpinner.setAdapter(dataAdapter);
    }

    // Get stats by individual
    public void getIndividualStats(View view) {

        TextView textViewWinPercentage = findViewById(R.id.winToLossPercentageOutput);
        textViewWinPercentage.setText("Hello");

        TextView textViewTotalWins = findViewById(R.id.totalWinsOutput);
        textViewTotalWins.setText("Hello");
    }

    // Get value of spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // List of functions we can use:
    // calculateIndividualPercentage()
    // calculateIndividualStreak()

}