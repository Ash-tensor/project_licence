package com.example.projectlicence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "AdventurerDB", null, 1);
//          "AdventurerDB" >> 생성할 DB의 이름
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Adventurer(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, level INTEGER, grade TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}