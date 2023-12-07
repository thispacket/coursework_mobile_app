package com.example.myapplication;

import android.R.layout;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookmarkFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);

        ListView listView = view.findViewById(R.id.listViewItemBookmark);
        ArrayList<MenuItemBookmark> menuItemsBookmark = new ArrayList<>();

        DBHelper dbHelper = new DBHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = db.query(DBHelper.TABLE_MENU, null, "is_bookmark = 1", null, null, null, null, null);
        if (cursor.moveToFirst() && cursor.getCount() > 0) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                int image = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_IMAGE));
                int price = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_PRICE));
                int rating = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_RATING));
                String description = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DESCRIPTION));
                int is_bookmark = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_IS_BOOKMARK));
                int is_paid = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_IS_PAID));

                menuItemsBookmark.add(new MenuItemBookmark(image, price, name, description, is_bookmark, is_paid, rating, id));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        MenuItemBookmarkAdapter adapter = new MenuItemBookmarkAdapter(getActivity(), R.layout.menu_item_bookmark, menuItemsBookmark);

        listView.setAdapter(adapter);

        return view;
    }
}