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
        db.execSQL("CREATE TABLE PlayerDetails (gamesWon int, gender int, name text, nickname text, phoneNumber int PRIMARY KEY, totalGames int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS PlayerDetails"));
        onCreate(db);
    }

    public Boolean insertuserdata(int gamesWon, int gender, String name, String nickname, int phoneNumber, int totalGames) {
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



    public Cursor getuserdata () {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from PlayerDetails where id=" + 1 + "", null);
        return cursor;
    }
}