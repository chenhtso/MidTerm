package com.example.koishi.midterm;

import android.provider.BaseColumns;


final class CharacterTable {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private CharacterTable() {
    }

    static final String tableName = "Character";

    /* Inner class that defines the table contents */
    static class CharacterEntry implements BaseColumns {

        static final String avatarColumn = "Avatar";
        static final String nameColumn = "Name";
        static final String sexColumn = "Sex";
        static final String kingdomColumn = "Kingdom";
        static final String birthAndDeathYearsColumn = "BirthAndDeathYears";
        static final String birthplaceColumn = "Birthplace";
    }
}

