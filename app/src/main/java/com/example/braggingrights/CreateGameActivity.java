package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

public class CreateGameActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    // Add DB info
    DBHelper db;
    // Spinner element
    Spinner gamesListSpinner;
    // variable for getting game
    String selectedGame;

    private static final String TAG = "CreateGameActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        // Spinner element
        gamesListSpinner = (Spinner) findViewById(R.id.listExistingGames);
        // Spinner click listener
        gamesListSpinner.setOnItemSelectedListener(this);
        // Loading spinner data from database
        loadSpinnerData();
    }

    /**
     * Function to load the spinner data from SQLite database
     * */
    private void loadSpinnerData() {
        // database handler
        db = new DBHelper(this);
        // Spinner Drop down elements
        ArrayList<String> gamesArrayList = db.getGamesList();
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gamesArrayList);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        gamesListSpinner.setAdapter(dataAdapter);
    }

    public void clickCreateNewGameTemplate(View view) {
        // Send user to Create Game Activity
        startActivity(new Intent(CreateGameActivity.this, AddNewGameTemplate.class));
    }

    public void clickStartGame(View view) {
        // Send user to Create Game Activity

        startActivity(new Intent(CreateGameActivity.this, CreateGameSelectPlayerActivity.class));
        //Intent intent = new Intent(CreateGameActivity.this, CreateGameSelectPlayerActivity.class);
        //intent.putExtra("name", selectedGame);
        //startActivity(intent);
    }

    // Get value of spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedGame = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}