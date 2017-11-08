package com.example.koishi.midterm;

import android.provider.BaseColumns;

/**
 * Created by Koishi on 11/7/2017.
 */

public final class CharacterTable {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private CharacterTable() {
    }

    public static final String tableName = "Character";

    /* Inner class that defines the table contents */
    public static class CharacterEntry implements BaseColumns {

        public static final String avatarColumn = "Avatar";
        public static final String nameColumn = "Name";
        public static final String sexColumn = "Sex";
        public static final String kingdomColumn = "Kingdom";
        public static final String birthAndDeathYearsColumn = "BirthAndDeathYears";
        public static final String birthplace = "Birthplace";
    }
}

