package com.example.braggingrights;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomGeneratorPresenter {

    // Create a list of random numbers
     List<Integer> generateRandomNumberSet(Integer numberDice, Integer numberSides) {

         List<Integer> diceResultsList = new LinkedList<>();
        for (int i=1; i <= numberDice; i++){
            Random rand = new Random();
            diceResultsList.add(rand.nextInt((numberSides - 2) + 1) + 2);
         }
        return diceResultsList;

     }

}
