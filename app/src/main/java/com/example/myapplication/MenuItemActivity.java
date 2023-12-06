package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuItemActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        ImageView backBtn = findViewById(R.id.back_btn);

        TextView price = findViewById(R.id.price);
        ImageView menuItemImage = findViewById(R.id.menu_item_image);
        TextView menuItemName = findViewById(R.id.menu_item_name);
        TextView menuItemDescription = findViewById(R.id.menu_item_description);
        TextView menuItemRating = findViewById(R.id.rating);

        String name = getIntent().getStringExtra("name");
        int image =  getIntent().getIntExtra("image", 0);
        int priceValue = getIntent().getIntExtra("price", 0);
        int rating = getIntent().getIntExtra("rating", 0);
        int is_bookmark = getIntent().getIntExtra("is_bookmark", 0);
        String description = getIntent().getStringExtra("description");

        menuItemName.setText(name);
        menuItemImage.setImageResource(image);
        price.setText(priceValue + "р/шт");
        menuItemDescription.setText(description);
        menuItemRating.setText(rating + "/5");

        backBtn.setOnClickListener(v -> finish());
    }
}