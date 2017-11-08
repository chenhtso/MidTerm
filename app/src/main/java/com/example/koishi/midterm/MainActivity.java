package com.example.koishi.midterm;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private BusinessLogic businessLogic;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        businessLogic = new BusinessLogic(this);
        initializeList();
    }

    @Override
    protected void onDestroy() {
        businessLogic.closeDataBase();
        super.onDestroy();
    }

    private void initializeList() {
        Cursor cursor = businessLogic.getAllCharacters();

    }

    // 设置事件监听器
    private void setEventHandlers() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
