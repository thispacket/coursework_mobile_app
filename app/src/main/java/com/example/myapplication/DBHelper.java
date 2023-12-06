package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "heart_townDB";
    public static final String TABLE_MENU = "menu";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_PRICE = "price";
    public static final String KEY_RATING = "rating";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IS_BOOKMARK = "is_bookmark";
    public static final String KEY_IS_PAID = "is_paid";




    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_MENU +
            "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " TEXT, " +
            KEY_IMAGE + " INTEGER, " +
            KEY_PRICE + " INTEGER, " +
            KEY_RATING + " INTEGER, " +
            KEY_DESCRIPTION + " TEXT, " +
            KEY_IS_BOOKMARK + " INTEGER, " +
            KEY_IS_PAID + " INTEGER)"
            );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        onCreate(sqLiteDatabase);
    }
}
