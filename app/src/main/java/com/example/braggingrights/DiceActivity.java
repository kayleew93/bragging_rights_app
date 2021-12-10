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

    EditText numberSides, numberDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        numberDice = findViewById(R.id.numberDiceInput);
        numberSides = findViewById(R.id.numberSidesInput);

        /*
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
        */
    }

    public void generateDiceList(View view) {
        /*
        Spinner mySpinnerDice = (Spinner) findViewById(R.id.spinnerNumberDice);
        Integer spinnerNumberDice = (Integer) mySpinnerDice.getSelectedItem();

        Spinner mySpinnerSides = (Spinner) findViewById(R.id.spinnerNumberDice);
        Integer spinnerNumberSides = (Integer) mySpinnerSides.getSelectedItem();
        */
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