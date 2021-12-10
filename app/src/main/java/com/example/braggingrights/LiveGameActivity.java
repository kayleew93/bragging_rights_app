package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LiveGameActivity extends AppCompatActivity {

    // for list of players
    DBHelper db;
    ArrayList<String> playerArrayList;
    private static final String TAG = "LiveGameActivity";

    // Get Specified Game
    //String game = getIntent().getStringExtra("game");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game);

        // Get the listview
        ListView playerList = (ListView) findViewById(R.id.playerListLiveGame);
        // Get the nicknames from the database
        db = new DBHelper(this);
        playerArrayList = db.getPlayerNicknameList();
        // Adapt array list so it will work on list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerArrayList);
        playerList.setAdapter(arrayAdapter);

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