package com.example.braggingrights;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LiveGameActivity extends AppCompatActivity {

    // for list of players
    ListView listView;
    DBHelper db;
    Cursor playerCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game);

        db = new DBHelper(this);
        playerCursor = db.getPlayerNicknameList();

        ListView playerList = (ListView) findViewById(R.id.playerListOutput);
        playerList.setAdapter((ListAdapter) playerCursor);

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