package com.example.braggingrights;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LiveGameActivity extends AppCompatActivity {

    // for list of players
    ListView listView;
    DBHelper db;
    ArrayList<String> playerArrayList;
    private static final String TAG = "LiveGameActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game);

        // Get the listview
        ListView playerList = (ListView) findViewById(R.id.playerListOutput);

        // Get the nicknames from the database
        db = new DBHelper(this);
        playerArrayList = db.getPlayerNicknameList();
        // Adapt array list so it will work on list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerArrayList);
        playerList.setAdapter(arrayAdapter);


        Log.d(TAG, "playerList list" + playerArrayList);
    }

    public void clickUseDice(View view) {
        startActivity(new Intent(LiveGameActivity.this, DiceActivity.class));
    }

    public void clickAddAnotherRound(View view) {
        //TODO: Add another round through LiveGamePresenter
    }

    public void clickCompleteGame(View view) {
        //TODO: Complete the game through LiveGamePresenter
    }


}