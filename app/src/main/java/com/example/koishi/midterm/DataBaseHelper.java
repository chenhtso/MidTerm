package com.example.koishi.midterm;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Koishi on 11/7/2017.
 */

public class DataBaseHelper extends SQLiteAssetHelper {
    private static final String DBName = "threeKingdoms.db";
    private static final int DBVersion = 1;
    private Context context;

    public DataBaseHelper(Context context) {
        super(context, DBName, null, DBVersion);
        this.context = context;
    }
}
