package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LiveGameActivity extends AppCompatActivity {

    // for list of players
    DBHelper db;
    ArrayList<String> playerArrayList;
    private static final String TAG = "LiveGameActivity";

    String gameName;
    ArrayList<String> playersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game);

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
    }


}