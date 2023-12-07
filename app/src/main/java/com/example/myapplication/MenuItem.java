package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MenuItem extends Activity {
    public int image, price, rating, is_bookmark, is_paid, id;
    public String name, description;

    public MenuItem(int image, int price, String name,  String description, int is_bookmark, int is_paid, int rating, int id) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.name = name;
        this.description = description;
        this.is_bookmark = is_bookmark;
        this.is_paid = is_paid;
        this.rating = rating;
    }




}
