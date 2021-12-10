package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LiveGameActivity extends AppCompatActivity {

    // for list of players
    DBHelper db;
    private static final String TAG = "LiveGameActivity";

    String gameName;
    ArrayList<String> playersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game);

        db = new DBHelper(this);

        // Get Specified Game
        gameName = getIntent().getStringExtra("game");
        playersList = getIntent().getStringArrayListExtra("playerList");

        // Get the listview
        ListView playerList = (ListView) findViewById(R.id.playerListLiveGame);
        // Adapt array list so it will work on list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playersList);
        playerList.setAdapter(arrayAdapter);


        TextView gameTitleOutput = (TextView) findViewById(R.id.gameTitleOutput);
        gameTitleOutput.setText("Now Playing " + gameName);
    }

    public void clickUseDice(View view) {
        startActivity(new Intent(LiveGameActivity.this, DiceActivity.class));
    }

    public void clickAddAnotherRound(View view) {
        //TODO: Add another round through LiveGamePresenter
    }

    public void clickCompleteGame(View view) {
        //TODO: Complete the game; send information to the DB Helper
        Boolean checkinsertdata = db.updateGameResultsData(gameName);
        if (checkinsertdata==true)
            Toast.makeText(LiveGameActivity.this, "Completed Game Saved", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(LiveGameActivity.this, "Error: Completed Game Not Saved", Toast.LENGTH_LONG).show();

        // Send user to back to Main
        startActivity(new Intent(LiveGameActivity.this, MainActivity.class));
    }


}