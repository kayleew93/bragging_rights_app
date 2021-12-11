package com.example.braggingrights;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {

        super(context, "Userdata.db", null, 1);
    }

    // Create the tables; populate the Game templates
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PlayerDetails (nickname text, gamesWon int, gender int, name text, phoneNumber int, totalGames int, playerId INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("CREATE TABLE GameTemplate (gameTemplateId INTEGER PRIMARY KEY AUTOINCREMENT, name text, numberRounds int, highScoreWins Boolean, needsDice Boolean)");
        db.execSQL("CREATE TABLE GameResults (date text, gameResultsId INTEGER PRIMARY KEY AUTOINCREMENT, gameName text, winnerName text)");
        //db.execSQL("CREATE TABLE PlayersList (gamePlayersListId INTEGER PRIMARY KEY AUTOINCREMENT, gameId int, playerId int, score int, win Boolean, FOREIGN KEY (gameId) REFERENCES GameResults (gameResultsId), FOREIGN KEY (playerId) REFERENCES PlayerDetails (playerId))");
        db.execSQL("INSERT INTO GameTemplate (name, numberRounds, highScoreWins, needsDice) VALUES ('Monopoly', 1, true, false)");
        db.execSQL("INSERT INTO GameTemplate (name, numberRounds, highScoreWins, needsDice) VALUES ('Yahtzee', 13, true, true)");
        db.execSQL("INSERT INTO GameTemplate (name, numberRounds, highScoreWins, needsDice) VALUES ('UNO', 1, true, false)");
        db.execSQL("INSERT INTO PlayerDetails (nickname, gamesWon, gender, name, phoneNumber, totalGames) VALUES ('Peter', 3, 0, 'Peter', 5555555558, 4)");
        db.execSQL("INSERT INTO PlayerDetails (nickname, gamesWon, gender, name, phoneNumber, totalGames) VALUES ('Lizbeth', 8, 1, 'Elizabeth', 5551113333, 10)");
        db.execSQL("INSERT INTO GameResults (date, gameName, winnerName) VALUES ('Fri Dec 10 20:35:13 MST 2021 - Monopoly', 'Monopoly', 'Pedro')");
        db.execSQL("INSERT INTO GameResults (date, gameName, winnerName) VALUES ('Sat Dec 11 13:22:04 MST 2021 - UNO', 'UNO', 'Lizbeth')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS PlayerDetails"));
        db.execSQL(("DROP TABLE IF EXISTS GameTemplate"));
        db.execSQL(("DROP TABLE IF EXISTS GameResults"));
        //db.execSQL(("DROP TABLE IF EXISTS PlayersList"));
        onCreate(db);
    }

    // Insert player details to the player details table
    public Boolean insertPlayerDetails(int gamesWon, int gender, String name, String nickname, int phoneNumber, int totalGames) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("nickname", nickname);
        contentValues.put("gender", gender);
        contentValues.put("phoneNumber", phoneNumber);
        contentValues.put("totalGames", totalGames);
        contentValues.put("gamesWon", gamesWon);
        long result = db.insert("PlayerDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Insert new game template to the game template table
    public Boolean insertNewGameTemplate(String name, int numberRounds, Boolean highScoreWins, Boolean needsDice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("numberRounds", numberRounds);
        contentValues.put("highScoreWins", highScoreWins);
        contentValues.put("needsDice", needsDice);
        long result = db.insert("GameTemplate", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Update information for a user
    public Boolean updateUserTotalGames(String nickname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // Get the total games played and add one
        String totalGames = getPlayerStatsTotalGames(nickname);
        int totalGamesInt = Integer.parseInt(totalGames);
        int totalGamesUpdated = totalGamesInt + 1;
        contentValues.put("totalGames", totalGamesUpdated);
        Cursor cursor = db.rawQuery("Select * from PlayerDetails where nickname = ?", new String[] {nickname});
        if (cursor.getCount() >0) {
            long result = db.update("PlayerDetails", contentValues, "nickname=?", new String[]{nickname});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean updateUserTotalWins(String nickname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // Get the total games played and add one
        String totalWins = getPlayerStatsGamesWon(nickname);
        int totalWinsInt = Integer.parseInt(totalWins);
        int totalWinsUpdated = totalWinsInt + 1;
        contentValues.put("gamesWon", totalWinsUpdated);
        Cursor cursor = db.rawQuery("Select * from PlayerDetails where nickname = ?", new String[] {nickname});
        if (cursor.getCount() >0) {
            long result = db.update("PlayerDetails", contentValues, "nickname=?", new String[]{nickname});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    // Insert into the games review table
    public Boolean insertGameResultsData(String gameName, String winnerName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // get the current time
        Date currentTime = Calendar.getInstance().getTime();
        contentValues.put("gameName", gameName);
        contentValues.put("winnerName", winnerName);
        contentValues.put("date", String.valueOf(currentTime) + " - " + gameName);
        long result = db.insert("GameResults", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Retrieves a list of player nicknames
    public ArrayList<String> getPlayerNicknameList() {
        ArrayList<String> playersArrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from PlayerDetails", null);
        if (cursor.moveToFirst()) {
            do {
                playersArrayList.add(new String(cursor.getString(0)));
            } while (cursor.moveToNext());
        }
        return playersArrayList;
    }

    // Retrieves the list of games
    public ArrayList<String> getGamesList() {
        ArrayList<String> gamesArrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from GameTemplate", null);
        if (cursor.moveToFirst()) {
            do {
                gamesArrayList.add(new String(cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        return gamesArrayList;
    }

    // Retrieves the list of games played
    public ArrayList<String> getGamesResultsList() {
        ArrayList<String> gamesArrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from GameResults", null);
        if (cursor.moveToFirst()) {
            do {
                gamesArrayList.add(new String(cursor.getString(0)));
            } while (cursor.moveToNext());
        }
        return gamesArrayList;
    }

    // Retrieves a list of data for a player
    public String getPlayerStatsGamesWon(String nickname) {
        String playerGamesWon = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select gamesWon from PlayerDetails WHERE nickname =?", new String[] {nickname});
        if (cursor.moveToFirst()) {
            do {
                playerGamesWon = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        return playerGamesWon;
    }

    // Retrieves a list of data for a player
    public String getPlayerStatsTotalGames(String nickname) {
        String playerStatsTotalGame = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select totalGames from PlayerDetails WHERE nickname =?", new String[] {nickname});
        if (cursor.moveToFirst()) {
            do {
                playerStatsTotalGame = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        return playerStatsTotalGame;
    }

    // Retrieves the name of a specific game
    public String getStatsGameName(String date) {
        String gameName = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select gameName from GameResults WHERE date =?", new String[] {date});
        if (cursor.moveToFirst()) {
            do {
                gameName = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        return gameName;
    }

    // Retrieves who won a specific game
    public String getStatsGameWinner(String date) {
        String gameWinner = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select winnerName from GameResults WHERE date =?", new String[] {date});
        if (cursor.moveToFirst()) {
            do {
                gameWinner = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        return gameWinner;
    }
}