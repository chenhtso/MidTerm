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
        setEventHandlers();
    }

    // 设置事件监听器获取用户输入
    private void setEventHandlers() {
        //TODO 检测操作的类型
        //TODO 根据操作类型调整输入框
        //TODO 获取用户输入
        //TODO 根据用户输入调整确认按钮
        //TODO 点击确认按钮要返回数据


        //TODO 输入合法性检查 组长负责
        //TODO 选择头像需要特殊处理 组长负责
    }
}
