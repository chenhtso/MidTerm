package com.example.koishi.midterm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Koishi on 11/3/2017.
 */

public class BusinessLogic {
    private String error;
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase DBForWrite;
    private SQLiteDatabase DBForRead;

    public BusinessLogic(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
        DBForRead = dataBaseHelper.getReadableDatabase();
        DBForWrite = dataBaseHelper.getWritableDatabase();
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
}


