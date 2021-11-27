package com.example.braggingrights;

public class StatisticsPresenter {
    float percentage;
    float maxStreak;
    float groupStreak;
    float groupPercentage;

    float calculateIndividualPercentage() {
        //TODO: calculate individual wins
        // Get individual stats from cloud

        //int individualWins = getStatsFromCloud(playerId);
        //int individualLosses = getStatsFromCloud(playerId);
        //percentage = individualWins / individualLosses * 100;
        return percentage;
    }

    float calculateIndividualStreak() {
        //TODO: calculate individual winning streak
        return maxStreak;
    }

    float calculateMaxGroupStreak(String game) {
        //TODO: calculate group winning streak
        return groupStreak;
    }

    float calculateGroupPercentage(String game) {
        //TODO: calculate wins by group players
        return groupPercentage;
    }




}
