package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MenuItemActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        ImageView backBtn = findViewById(R.id.back_btn);

        ImageView bookmarkBtn = findViewById(R.id.bookmark_btn);
        ImageView bookmarkBtnAdd = findViewById(R.id.bookmark_btn_add);

        TextView price = findViewById(R.id.price);
        ImageView menuItemImage = findViewById(R.id.menu_item_image);
        TextView menuItemName = findViewById(R.id.menu_item_name);
        TextView menuItemDescription = findViewById(R.id.menu_item_description);
        TextView menuItemRating = findViewById(R.id.rating);

        String name = getIntent().getStringExtra("name");
        int image =  getIntent().getIntExtra("image", 0);
        int priceValue = getIntent().getIntExtra("price", 0);
        int rating = getIntent().getIntExtra("rating", 0);
        AtomicInteger is_bookmark = new AtomicInteger(getIntent().getIntExtra("is_bookmark", 0));
        String description = getIntent().getStringExtra("description");

        if (is_bookmark.get() == 1) {
            bookmarkBtn.setImageResource(R.drawable.bookmark_icon_active);
            bookmarkBtnAdd.setImageResource(R.drawable.bookmark_icon_active);
        }

        SQLiteDatabase db = new DBHelper(this).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        bookmarkBtnAdd.setOnClickListener(v -> {
            if (is_bookmark.get() == 0) {
                contentValues.put(DBHelper.KEY_IS_BOOKMARK, 1);
                db.update(DBHelper.TABLE_MENU, contentValues, DBHelper.KEY_ID + " = ?", new String[]{String.valueOf(getIntent().getIntExtra("id", 0))});
                bookmarkBtn.setImageResource(R.drawable.bookmark_icon_active);
                bookmarkBtnAdd.setImageResource(R.drawable.bookmark_icon_active);
                is_bookmark.set(1);
                db.close();
            } else {
                bookmarkBtn.setImageResource(R.drawable.bookmark_icon);
                bookmarkBtnAdd.setImageResource(R.drawable.bookmark_icon);
                is_bookmark.set(0);
            }
        });

        menuItemName.setText(name);
        menuItemImage.setImageResource(image);
        price.setText(priceValue + "р/шт");
        menuItemDescription.setText(description);
        menuItemRating.setText(rating + "/5");

        backBtn.setOnClickListener(v -> finish());
    }
}