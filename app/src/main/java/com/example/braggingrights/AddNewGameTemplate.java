package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class AddNewGameTemplate extends AppCompatActivity {

    DBHelper db;
    EditText name, numberRounds;
    Switch needsDice, highScoreWins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_game_template);

        db = new DBHelper(this);
        // hooks all xml elements in activity_create_local_player.xml
        name = findViewById(R.id.editGameName);
        numberRounds = findViewById(R.id.selectNumberRounds);
        needsDice = findViewById(R.id.needsDice);
        highScoreWins = findViewById(R.id.isHighScoreWins);

    }
    public void cancelTemplate(View view) {
        startActivity(new Intent(AddNewGameTemplate.this, CreateGameActivity.class));
    }

    // Function to add a new template
    public void clickAddNewTemplate(View view) {

        // convert variables to strings to send to database
        String nameTXT = name.getText().toString();
        String numberRoundsTXT = numberRounds.getText().toString();
        int numberRoundsINT = Integer.parseInt(numberRoundsTXT);

        //TODO: Figure out how to get updated switch value
        String highScoreWinsTXT = highScoreWins.getText().toString();
        Boolean highScoreWinsBool = Boolean.parseBoolean(highScoreWinsTXT);
        String needsDiceTXT = needsDice.getText().toString();
        Boolean needsDiceBool = Boolean.parseBoolean(needsDiceTXT);

        // insert the data, give a toast for success or failure
        Boolean checkinsertdata = db.insertNewGameTemplate(nameTXT, numberRoundsINT, highScoreWinsBool, needsDiceBool);
        if (checkinsertdata==true) {
            Toast.makeText(AddNewGameTemplate.this, "New Game Template Submitted", Toast.LENGTH_LONG).show();
            startActivity(new Intent(AddNewGameTemplate.this, CreateGameActivity.class)); }
        else {
            Toast.makeText(AddNewGameTemplate.this, "Error: Game template not inserted", Toast.LENGTH_LONG).show();}
    }

    // Function to go back to previous activity
    public void clickCancel(View view) {
        startActivity(new Intent(AddNewGameTemplate.this, CreateGameActivity.class));
    }
}

