package com.example.braggingrights;

public class CreateGamePresenter {
    String name;
    int rounds;
    Boolean highWins;
    Boolean useDice;
    Float points;
    int gameId;

    public CreateGamePresenter() {
      highWins = true;
      useDice = true;
      rounds = 1;
    }

    public static void main(String[] args) {
        CreateGamePresenter game = new CreateGamePresenter();

    }

}
