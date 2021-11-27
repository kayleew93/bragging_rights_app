package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewStatsByGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats_by_game);
    }

    public void getGroupStats(View view) {
        //TODO: Create a spinner that can be populated by our games list
        //String selectedGame = mySpinner.getSelectedItem().toString();


        TextView textViewWinningStreak = findViewById(R.id.currentWinningStreakOutput);
        textViewWinningStreak.setText("Hello");

        TextView textViewLongestWinningStreak = findViewById(R.id.longestWinningStreakText);
        textViewLongestWinningStreak.setText("Hello");
    }

    // List of functions we can use:
    // calculateMaxGroupStreak()
    // calculateGroupPercentage()
}