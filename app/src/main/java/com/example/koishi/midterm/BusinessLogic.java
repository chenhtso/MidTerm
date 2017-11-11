package com.example.koishi.midterm;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.Objects;


class BusinessLogic {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    BusinessLogic(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
    }


    boolean addCharacter(Intent data) {
        ContentValues contentValues = fromIntentDataToContentValues(data);
        long result = database.insert(CharacterTable.tableName, null, contentValues);
        return result != -1;
    }

    boolean deleteCharacter(String name) {
        String selection = CharacterTable.CharacterEntry.nameColumn + " = '" + name + "'";
        database.delete(CharacterTable.tableName, selection, null);
        return true;
    }

    boolean editCharacter(String name, Intent data) {
        String selection = CharacterTable.CharacterEntry.nameColumn + " = '" + name + "'";
        ContentValues contentValues = fromIntentDataToContentValues(data);
        database.update(CharacterTable.tableName, contentValues, selection, null);
        return true;
    }

    Cursor queryCharacter(String name) {
        String selection = CharacterTable.CharacterEntry.nameColumn + " = '" + name + "'";
        return database.query(CharacterTable.tableName, null, selection, null, null, null, null);
    }

    Cursor getAllCharacters() {
        return database.rawQuery("select Name as _id, * from " + CharacterTable.tableName, null);
    }

    void closeDataBase() {
        dataBaseHelper.close();
    }

    private ContentValues fromIntentDataToContentValues(Intent data) {
        ContentValues contentValues = new ContentValues();

        String[] columns = new String[]{
                CharacterTable.CharacterEntry.nameColumn,
                CharacterTable.CharacterEntry.sexColumn,
                CharacterTable.CharacterEntry.kingdomColumn,
                CharacterTable.CharacterEntry.birthAndDeathYearsColumn,
                CharacterTable.CharacterEntry.birthplaceColumn,
                CharacterTable.CharacterEntry.avatarColumn,
        };

        for (String column : columns) {
            String parameter = data.getStringExtra(column);
            if (parameter != null) {
                if (column.equals(CharacterTable.CharacterEntry.avatarColumn)) {
                    Bitmap bitmap = BitmapFactory.decodeFile(parameter);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] blob = byteArrayOutputStream.toByteArray();
                    contentValues.put(column, blob);
                } else {
                    contentValues.put(column, parameter);
                }
            }
        }

        return contentValues;
    }
}


