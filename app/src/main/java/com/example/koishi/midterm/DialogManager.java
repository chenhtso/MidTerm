package com.example.koishi.midterm;


import android.content.Context;
import android.view.LayoutInflater;

/**
 * Created by Koishi on 11/8/2017.
 */

public class DialogManager {
    private Context context;
    private LayoutInflater layoutInflater;

    public DialogManager(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public UserInput showDialogAndGetUserInput(int layoutResId) {
        UserInput userInput = new UserInput();
        return userInput;
    }

    public class UserInput {

    }
}
