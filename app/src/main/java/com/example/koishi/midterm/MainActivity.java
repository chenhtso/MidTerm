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
        Button button = findViewById(R.id.dialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

        }
    }
}
