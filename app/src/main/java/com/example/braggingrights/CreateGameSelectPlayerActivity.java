package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CreateGameSelectPlayerActivity extends AppCompatActivity {

    // for list of players
    DBHelper db;
    ArrayList<String> playerArrayList;
    ArrayList<String> selectedPlayersArrayList = new ArrayList<String>();
    private static final String TAG = "LiveGameActivity";

    // Get Specified Game
    //String game = getIntent().getStringExtra("name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game_select_player);

        //Log.d(TAG, "Value of Game: " + game);

        // Get the listview
        ListView playerList = (ListView) findViewById(R.id.playerSelectListOutput);
        // Get the nicknames from the database
        db = new DBHelper(this);
        playerArrayList = db.getPlayerNicknameList();
        // Adapt array list so it will work on list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, playerArrayList);
        playerList.setAdapter(arrayAdapter);

        // Set an item click listener for the ListView
        playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SparseBooleanArray clickedItemPositions = playerList.getCheckedItemPositions();

                for(int index=0;index<clickedItemPositions.size();index++){
                    // Get the checked status of the current item
                    boolean checked = clickedItemPositions.valueAt(index);

                    if(checked){
                        // If the current item is checked
                        int key = clickedItemPositions.keyAt(index);
                        String name = (String) playerList.getItemAtPosition(key);

                        // Display the checked items on in the arraylist
                        selectedPlayersArrayList.add(name.toString());

                    }
                }
            }
        });

    }

    public void clickSubmitPlayers(View view) {
        // Send user to Create Game Activity
        //startActivity(new Intent(CreateGameSelectPlayerActivity.this, LiveGameActivity.class));
        Intent intent = new Intent(CreateGameSelectPlayerActivity.this, LiveGameActivity.class);
        //intent.putExtra("game", game);
        //intent.putExtra("playerList", selectedPlayersArrayList);
        startActivity(intent);
    }
}