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
    String selectedGame;

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
        ArrayList<String> gamesResultsList = db.getGamesResultsList();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gamesResultsList);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        gameStatsListSpinner.setAdapter(dataAdapter);
    }

    public void getGroupStats(View view) {

        // Connect to database and get information on the selected player
        db = new DBHelper(this);

        // Get the total number of games won and total games
        String gameName = db.getStatsGameName(selectedGame);
        String winnerName = db.getStatsGameWinner(selectedGame);

        TextView gameNameView = findViewById(R.id.gameNameView);
        gameNameView.setText(gameName);

        TextView winnerNameView = findViewById(R.id.winnerNameView);
        winnerNameView.setText(winnerName);

    }

    // Gets value from the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedGame = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}