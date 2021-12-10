package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewStatsByPlayerActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    // Add DB info
    DBHelper db;
    // Spinner element
    Spinner playerStatsListSpinner;
    String selectedPlayer;

    private static final String TAG = "ViewStatsByPlayerActivity";

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

        // Connect to database and get information on the selected player
        db = new DBHelper(this);

        // Get the total number of games won and total games
        String playerGamesWon = db.getPlayerStatsGamesWon(selectedPlayer);
        String playerTotalGames = db.getPlayerStatsTotalGames(selectedPlayer);
        int playerGamesWonINT = Integer.parseInt(playerGamesWon);
        int playerTotalGamesINT = Integer.parseInt(playerTotalGames);

        // Calculate win percentage for player
        double playerGamesWonDouble = playerGamesWonINT;
        double playerTotalGamesDouble = playerTotalGamesINT;
        double playerWinPercentage = playerGamesWonDouble / playerTotalGamesDouble * 100;

        TextView textViewWinPercentage = findViewById(R.id.winToLossPercentageOutput);
        textViewWinPercentage.setText(playerWinPercentage + "%");

        TextView textViewTotalWins = findViewById(R.id.totalWinsOutput);
        textViewTotalWins.setText(playerGamesWon);

        TextView textViewTotalGamesPlayed = findViewById(R.id.totalGamesOutput);
        textViewTotalGamesPlayed.setText(playerTotalGames);
    }

    // Get value of spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedPlayer = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // List of functions we can use:
    // calculateIndividualPercentage()
    // calculateIndividualStreak()

}