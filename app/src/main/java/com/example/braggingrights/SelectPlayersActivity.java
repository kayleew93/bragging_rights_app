package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectPlayersActivity extends AppCompatActivity {

    // for list of players
    DBHelper db;
    ArrayList<String> playerArrayList;
    private static final String TAG = "SelectPlayersActivity";

    // Get info from intent
    String game = getIntent().getStringExtra("game");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_players);

        /*
        // Get the listview
        ListView playerList = (ListView) findViewById(R.id.playerListOutput2);
        // Get the nicknames from the database
        db = new DBHelper(this);
        playerArrayList = db.getPlayerNicknameList();
        // Adapt array list so it will work on list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerArrayList);
        playerList.setAdapter(arrayAdapter);
        */
    }

    public void clickSubmitPlayers(View view) {
        // Send user to Live Game Activity
        Intent i = new Intent(SelectPlayersActivity.this, LiveGameActivity.class);
        i.putExtra("name", game);
        i.putExtra("playerArray", playerArrayList);
        startActivity(i);
    }
}