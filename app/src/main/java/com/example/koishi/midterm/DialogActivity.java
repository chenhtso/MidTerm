package com.example.koishi.midterm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Koishi on 11/8/2017.
 */

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
        final EditText mName = (EditText) findViewById(R.id.nameInput);
        final EditText mBirthAndDeathYears = (EditText) findViewById(R.id.birthAndDeathYearsInput);
        final EditText mBirthplace = (EditText) findViewById(R.id.birthplaceInput);
        final Spinner mSex = (Spinner) findViewById(R.id.sexInput);
        final Spinner mKingdom = (Spinner) findViewById(R.id.kingdomInput);
        final RadioGroup mCURDButtons = (RadioGroup) findViewById(R.id.CURDButtons);
        final RadioButton mAdd = (RadioButton) findViewById(R.id.add);
        final RadioButton mDelet = (RadioButton) findViewById(R.id.delete);
        final RadioButton mModify = (RadioButton) findViewById(R.id.modify);
        final RadioButton mQuery = (RadioButton) findViewById(R.id.query);
        final Button mUpload = (Button) findViewById(R.id.upload);
        final Button mConfirm = (Button) findViewById(R.id.confirm);

        mCURDButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                if (checkedID == mAdd.getId()) {
                    operationType = mAdd.getText().toString();
                }
                if (checkedID == mDelet.getId()) {
                    operationType = mDelet.getText().toString();
                    mBirthAndDeathYears.setInputType(InputType.TYPE_NULL);
                    mBirthplace.setInputType(InputType.TYPE_NULL);
                    
                }
                if (checkedID == mModify.getID()) {
                    operationType = mModify.getText().toString();
                }
                if (checkedID == mQuery.getID()) {
                    operationType = mQuery.getText().toString();
                    mBirthAndDeathYears.setInputType(InputType.TYPE_NULL);
                    mBirthplace.setInputType(InputType.TYPE_NULL);
                }
            }
        });

        name = mName.getText().toString();
        birthAndDeathYears = mBirthAndDeathYears.getText().toString();
        birthplace = mBirthplace.getText().toString();

        mSex.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] sexs = getResources().getStringArray(R.array.dialog_sex);
                sex = sexs[pos].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        mKingdom.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] kingdoms = getResources().getStringArray(R.array.dialog_kingdom);
                kingdom = kingdoms[pos].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });


        if (operationType == mModify.getText().toString() || operationType == mAdd.getText().toString()) {
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(sex) || TextUtils.isEmpty(kingdom) ||
                    TextUtils.isEmpty(birthplace) || TextUtils.isEmpty(birthAndDeathYears) ||
                    TextUtils.isEmpty(avatarPath)) {
                hasEmptyInput = false;
            } else hasEmptyInput = true;
        }
        else
        if (operationType == mDelet.getText().toString() || operationType == mQuery.getText().toString()) {
            if (TextUtils.isEmpty(name)) {
                hasEmptyInput = false;
            } else {
                hasEmptyInput = true;
                sex = "";
                kingdom = "";
                birthplace = "";
                birthAndDeathYears = "";
                avatarPath = "";
            }
        }

        if (hasEmptyInput == false) {
            mConfirm.setClickable(false);
            mConfirm.setEnabled(false);
        } else {
            mConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DialogActivity.this,MainActivity.class);
                    intent.putExtras("name",name);
                    intent.putExtras("sex",sex);
                    intent.putExtras("kingdom",kingdom);
                    intent.putExtras("birthAndDeathYears",birthAndDeathYears);
                    intent.putExtras("birthplace",birthplace);
                    intent.putExtras("avatarPath",avatarPath);
                    intent.putExtras("operationType",operationType);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }
