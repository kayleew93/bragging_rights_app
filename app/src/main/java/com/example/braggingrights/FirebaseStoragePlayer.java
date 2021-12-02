package com.example.braggingrights;

public class FirebaseStoragePlayer {

    String fullName, playerNickname, phoneNumber;
    Integer totalGames, gamesWon;

    public FirebaseStoragePlayer() {
    }

    public FirebaseStoragePlayer(String fullName, String playerNickname, String phoneNumber, Integer totalGames, Integer gamesWon) {
        this.fullName = fullName;
        this.playerNickname = playerNickname;
        this.phoneNumber = phoneNumber;
        this.totalGames = totalGames;
        this.gamesWon = gamesWon;
    }

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

}
