package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewStatsByGameActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    // Add DB info
    DBHelper db;
    // Spinner element
    Spinner gameStatsListSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats_by_game);

        // Spinner element
        gameStatsListSpinner = (Spinner) findViewById(R.id.gameStatsListSpinner);
        // Spinner click listener
        gameStatsListSpinner.setOnItemSelectedListener(this);
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
        ArrayList<String> playerNicknameArray = db.getGamesResultsList();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, playerNicknameArray);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        gameStatsListSpinner.setAdapter(dataAdapter);
    }

    public void getGroupStats(View view) {

        TextView textViewWinningStreak = findViewById(R.id.currentWinningStreakOutput);
        textViewWinningStreak.setText("Hello");

        TextView textViewLongestWinningStreak = findViewById(R.id.longestWinningStreakText);
        textViewLongestWinningStreak.setText("Hello");
    }

    // Gets value from the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // List of functions we can use:
    // calculateMaxGroupStreak()
    // calculateGroupPercentage()
}