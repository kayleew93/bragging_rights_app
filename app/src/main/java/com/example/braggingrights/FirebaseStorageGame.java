package com.example.braggingrights;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseStorageGame {

    String name;
    int rounds;
    Boolean highWins;
    Boolean useDice;
    Float points;
    int gameId;

    public FirebaseStorageGame() {
    }

    public FirebaseStorageGame(String name, int rounds, Boolean highWins) {
        this.name = name;

    }
    /* Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlayerNickname() {
        return playerNickname;
    }

    public void setPlayerNickname(String playerNickname) {
        this.playerNickname = playerNickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String fullName) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTotalGames() { return totalGames; }

    public void setTotalGames(Integer totalGames) { this.totalGames = totalGames; }

    public Integer getGamesWon() { return gamesWon; }

    public void setGamesWon(Integer gamesWon) { this.gamesWon = gamesWon; }

     */

}
