package com.example.koishi.midterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private BusinessLogic businessLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        businessLogic = new BusinessLogic(this);
    }

    // 设置事件监听器
    private void setEventHandlers() {

    }
}
