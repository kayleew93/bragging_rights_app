package com.example.braggingrights;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {

        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PlayerDetails (gamesWon int, gender int, name text, nickname text, phoneNumber int, totalGames int, playerId INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("CREATE TABLE GameTemplate (gameTemplateId INTEGER PRIMARY KEY AUTOINCREMENT, name text, numberRounds int, highScoreWins Boolean, needsDice Boolean)");
        db.execSQL("CREATE TABLE GameResults (gameResultsId INTEGER PRIMARY KEY AUTOINCREMENT, gameId int, FOREIGN KEY (gameId) REFERENCES GameDetails (gameId))");
        db.execSQL("CREATE TABLE PlayersList (gamePlayersListId INTEGER PRIMARY KEY AUTOINCREMENT, gameId int, playerId int, score int, win Boolean, FOREIGN KEY (gameId) REFERENCES GameResults (gameResultsId), FOREIGN KEY (playerId) REFERENCES PlayerDetails (playerId))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS PlayerDetails"));
        db.execSQL(("DROP TABLE IF EXISTS GameTemplate"));
        db.execSQL(("DROP TABLE IF EXISTS GameResults"));
        db.execSQL(("DROP TABLE IF EXISTS PlayersList"));
        onCreate(db);
    }

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

    public Boolean updateuserdata(String name, Integer totalGames, Integer gamesWon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("totalGames", totalGames);
        contentValues.put("gamesWon", gamesWon);
        Cursor cursor = db.rawQuery("Select * from PlayerDetails where name = ?", new String[] {name});
        if (cursor.getCount() >0) {
            long result = db.update("PlayerDetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getPlayerNicknameList() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select nickname, playerId from PlayerDetails", null);
        return cursor;
    }
}