package com.example.koishi.midterm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class DialogActivity extends AppCompatActivity {
    // 表格内容， 分别为姓名、性别、势力、生卒年份、籍贯、头像文件的路径
    private String name;
    private String sex;
    private String kingdom;
    private String birthAndDeathYears;
    private String birthplace;
    private String avatarPath;

    // 记录操作的类型，是增删改查中的哪一种
    private String operationType;
    // 记录是否有空的用户输入
    private boolean hasEmptyInput;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        setFinishOnTouchOutside(false);
        setEventHandlers();
    }

    // 设置事件监听器获取用户输入
    private void setEventHandlers() {

    }
}
