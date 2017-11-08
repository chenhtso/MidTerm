package com.example.koishi.midterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private BusinessLogic businessLogic;
    private DialogManager dialogManager;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeList();
        businessLogic = new BusinessLogic(this);
        dialogManager = new DialogManager(this);
    }

    @Override
    protected void onDestroy() {
        businessLogic.closeDataBase();
        super.onDestroy();
    }

    private void initializeList() {

    }

    // 设置事件监听器
    private void setEventHandlers() {

    }
}
