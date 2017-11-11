package com.example.koishi.midterm;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BusinessLogic businessLogic;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        businessLogic = new BusinessLogic(this);
        initializeList();
        setEventHandlers();
    }

    @Override
    protected void onDestroy() {
        businessLogic.closeDataBase();
        super.onDestroy();
    }

    private void initializeList() {
        ListView listView = findViewById(R.id.characterList);
        Cursor cursor = businessLogic.getAllCharacters();

        String[] from = new String[]{
                CharacterTable.CharacterEntry.nameColumn,
                CharacterTable.CharacterEntry.sexColumn,
                CharacterTable.CharacterEntry.kingdomColumn,
                CharacterTable.CharacterEntry.birthAndDeathYearsColumn,
                CharacterTable.CharacterEntry.birthplaceColumn,
                CharacterTable.CharacterEntry.avatarColumn,
        };

        int[] to = new int[]{
                R.id.nameItem,
                R.id.sexItem,
                R.id.kingdomItem,
                R.id.birthAndDeathYearsItem,
                R.id.birthplaceItem,
                R.id.avatarItem,
        };

        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item_layout, cursor, from, to, 0);

        SimpleCursorAdapter.ViewBinder viewBinder = new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int i) {
                if (view.getId() == R.id.avatarItem) {
                    // 头像是第6列
                    byte[] image = cursor.getBlob(6);
                    ((ImageView) view).setImageBitmap(BitmapFactory.decodeByteArray(image, 0, image.length));
                    return true;
                }
                return false;
            }
        };

        simpleCursorAdapter.setViewBinder(viewBinder);
        listView.setAdapter(simpleCursorAdapter);
    }

    // 设置事件监听器
    private void setEventHandlers() {
        Button operationButton = findViewById(R.id.dialog);
        operationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        //TODO Reset Button
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            String operationType = data.getStringExtra("operationType");
            String name = data.getStringExtra(CharacterTable.CharacterEntry.nameColumn);

            boolean succeed = false;

            Cursor queryCursor = businessLogic.queryCharacter(name);
            boolean existed = queryCursor.moveToFirst();

            switch (operationType) {
                case "add": {
                    if (existed) {
                        succeed = false;
                        break;
                    }
                    succeed = businessLogic.addCharacter(data);
                    break;
                }
                case "delete": {
                    succeed = businessLogic.deleteCharacter(name);
                    break;
                }
                case "edit": {
                    succeed = businessLogic.editCharacter(name, data);
                    break;
                }
                case "query": {
                    succeed = existed;
                    break;
                }
            }

            if (succeed) {
                if (operationType.equals("query")) {
                    changeListView(queryCursor);
                } else {
                    changeListView(businessLogic.getAllCharacters());
                }

            } else {
                Toast.makeText(this, "操作失败！请检查输入参数是否无误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void changeListView(Cursor cursor) {
        simpleCursorAdapter.swapCursor(cursor);
        simpleCursorAdapter.notifyDataSetChanged();
    }


}
