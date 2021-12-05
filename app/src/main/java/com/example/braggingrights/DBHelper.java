package com.example.braggingrights;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PlayerDetails (user_id INTEGER PRIMARY KEY, name VARCHAR(50) NOT NULL, nickname VARCHAR(50) NOT NULL, gender INT NOT NULL, image INT, totalGames INT, gamesWons INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("drop Table if exists PlayerDetails"));
    }

    public Boolean insertuserdata(String name, String nickname, Integer gender, Integer image, Integer totalGames, Integer gamesWon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("nickname", nickname);
        contentValues.put("gender", image);
        contentValues.put("totalGames", totalGames);
        contentValues.put("gamesWon", gamesWon);
        long result = db.insert("PlayerDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    };

    public Boolean updateuserdata(String name, String nickname, Integer gender, Integer image, Integer totalGames, Integer gamesWon) {
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
    };



    public Cursor getuserdata () {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from PlayerDetails", null);
        return cursor;
    }
}