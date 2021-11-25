package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewStatsByPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats_by_player);
    }

    public void getIndividualStats(View view) {
        //TODO: Create a spinner that can be populated by our individuals list
        //String selectedGame = mySpinner.getSelectedItem().toString();


        TextView textViewWinPercentage = findViewById(R.id.winToLossPercentageOutput);
        textViewWinPercentage.setText("Hello");

        TextView textViewTotalWins = findViewById(R.id.totalWinsOutput);
        textViewTotalWins.setText("Hello");
    }

    // List of functions we can use:
    // calculateIndividualPercentage()
    // calculateIndividualStreak()

}