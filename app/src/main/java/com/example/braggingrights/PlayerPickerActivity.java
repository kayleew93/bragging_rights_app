package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PlayerPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_picker);

        // set spinner for the number of players
        Spinner mySpinnerNumPlayers = (Spinner) findViewById(R.id.spinnerNumberPlayers);

        ArrayAdapter<String> myAdapterNumPlayers = new ArrayAdapter<String>(PlayerPickerActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dicenumbers));
        myAdapterNumPlayers.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerNumPlayers.setAdapter(myAdapterNumPlayers);
    }
}