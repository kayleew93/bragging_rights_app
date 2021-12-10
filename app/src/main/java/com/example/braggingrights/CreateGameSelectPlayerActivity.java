package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CreateGameSelectPlayerActivity extends AppCompatActivity {

    // for list of players
    DBHelper db;
    ArrayList<String> playerArrayList;
    private static final String TAG = "LiveGameActivity";

    // Get Specified Game
    //String game = getIntent().getStringExtra("game");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game_select_player);

        // Get the listview
        ListView playerList = (ListView) findViewById(R.id.playerSelectListOutput);
        // Get the nicknames from the database
        db = new DBHelper(this);
        playerArrayList = db.getPlayerNicknameList();
        // Adapt array list so it will work on list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerArrayList);
        playerList.setAdapter(arrayAdapter);

    }

    public void clickSubmitPlayers(View view) {
        // Send user to Create Game Activity
        startActivity(new Intent(CreateGameSelectPlayerActivity.this, LiveGameActivity.class));
        //Intent intent = new Intent(CreateGameActivity.this, SelectPlayersActivity.class);
        //intent.putExtra("name", selectedGame);
        //startActivity(intent);
    }
}