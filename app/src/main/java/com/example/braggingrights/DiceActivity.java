package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Collections;
import java.util.List;

public class DiceActivity extends AppCompatActivity {

    // Set the variables
    EditText numberSides, numberDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        // Get the variables by ID
        numberDice = findViewById(R.id.numberDiceInput);
        numberSides = findViewById(R.id.numberSidesInput);

    }

    public void generateDiceList(View view) {

        // Convert variables to int
        String numberDiceString = numberDice.getText().toString();
        int numberDiceInt = Integer.parseInt(numberDiceString);
        String numberSidesString = numberSides.getText().toString();
        int numberSidesInt = Integer.parseInt(numberSidesString);

        // send user-selected values to generate the numbers to a list
        RandomGeneratorPresenter generatorPresenter = new RandomGeneratorPresenter();
        List diceValues = generatorPresenter.generateRandomNumberSet(numberDiceInt, numberSidesInt);

        // output the list for viewers
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Collections.singletonList(diceValues.toString()));
        ListView diceResults = (ListView) this.findViewById(R.id.diceResultsListOutput);
        diceResults.setAdapter(arrayAdapter);
    }
}