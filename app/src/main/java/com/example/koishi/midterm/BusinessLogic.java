package com.example.koishi.midterm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Koishi on 11/3/2017.
 */

public class BusinessLogic {
    private String error;
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public BusinessLogic(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
    }


    // 增删改查的四个方法 成功返回true， 不成功返回false，并设置失败原因
    public boolean addCharacter() {
        return false;
    }

    public boolean deleteCharacter() {

        return false;
    }

    public boolean editCharacter() {

        return false;
    }

    public boolean queryCharacter() {

        return false;
    }

    public Cursor getAllCharacters() {
        return database.rawQuery("select Name as _id, * from " + CharacterTable.tableName, null);
    }

    public void closeDataBase() {
        dataBaseHelper.close();
    }
}


