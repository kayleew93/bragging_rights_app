package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        // I am Santiago
        // set spinner for the number of dice
        Spinner mySpinnerNumDice = (Spinner) findViewById(R.id.spinnerNumberDice);

        ArrayAdapter<String> myAdapterNumDice = new ArrayAdapter<String>(DiceActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dicenumbers));
        myAdapterNumDice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerNumDice.setAdapter(myAdapterNumDice);

        // set spinner for the number of sides the dice have
        Spinner mySpinnerNumSides = (Spinner) findViewById(R.id.spinnerNumberSides);

        ArrayAdapter<String> myAdapterNumSides = new ArrayAdapter<String>(DiceActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sidesnumbers));
        myAdapterNumSides.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerNumSides.setAdapter(myAdapterNumSides);
    }

    public void generateNumber(View view) {

    }
}