package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.widget.ViewUtils;
import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("Range")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = view.findViewById(R.id.listViewItemsMain);
        ArrayList<MenuItem> menuItems = new ArrayList<>();

        DBHelper dbHelper = new DBHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.query(DBHelper.TABLE_MENU, null, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                int image = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_IMAGE));
                int price = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_PRICE));
                int rating = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_RATING));
                String description = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DESCRIPTION));
                int is_bookmark = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_IS_BOOKMARK));
                int is_paid = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_IS_PAID));

                menuItems.add(new MenuItem(image, price, name, description, is_bookmark, is_paid, rating, id));
            }
            while (cursor.moveToNext());
        }
        cursor.close();

        db.close();

        MenuItemAdapter adapter = new MenuItemAdapter(getActivity(), R.layout.menu_item, menuItems);

        listView.setAdapter(adapter);

        return view;
    }
}