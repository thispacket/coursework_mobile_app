package com.example.myapplication;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {

    private Context context;
    private ArrayList<MenuItem> items;

    public MenuItemAdapter(@NonNull Context context, int resource, @NonNull List<MenuItem> objects) {
        super(context, resource, objects);

        this.context = context;
        this.items = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.menu_item, null);
        }

        if (items.size() > 0) {
            MenuItem item = items.get(position);

            ImageView menuItemImage = convertView.findViewById(R.id.menuItemImage);
            TextView menuItemName = convertView.findViewById(R.id.menuItemName);
            TextView menuItemPrice = convertView.findViewById(R.id.menuItemprice);
            ImageButton menuItemBookmark = convertView.findViewById(R.id.bookmark_icon_item);

            menuItemImage.setImageResource(item.image);
            menuItemName.setText(item.name);
            menuItemPrice.setText(item.price + "₽/шт.");

            if (item.is_bookmark == 1) {
                menuItemBookmark.setImageResource(R.drawable.bookmark_icon_active);
            }

            SQLiteDatabase db = new DBHelper(context).getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            menuItemBookmark.setOnClickListener(view -> {
                if (item.is_bookmark == 0) {
                    item.is_bookmark = 1;
                    contentValues.put(DBHelper.KEY_IS_BOOKMARK, item.is_bookmark);
                    db.update(DBHelper.TABLE_MENU, contentValues, DBHelper.KEY_ID + " = ?", new String[]{String.valueOf(item.id)});
                    menuItemBookmark.setImageResource(R.drawable.bookmark_icon_active);
                    db.close();
                } else {
                    item.is_bookmark = 0;
                    contentValues.put(DBHelper.KEY_IS_BOOKMARK, item.is_bookmark);
                    db.update(DBHelper.TABLE_MENU, contentValues, DBHelper.KEY_ID + " = ?", new String[]{String.valueOf(item.id)});
                    menuItemBookmark.setImageResource(R.drawable.bookmark_icon);
                }
            });

            convertView.setOnClickListener(view -> {
                Intent intent = new Intent(context, MenuItemActivity.class);
                intent.putExtra("id", item.id);
                intent.putExtra("image", item.image);
                intent.putExtra("name", item.name);
                intent.putExtra("price", item.price);
                intent.putExtra("description", item.description);
                intent.putExtra("is_bookmark", item.is_bookmark);
                intent.putExtra("is_paid", item.is_paid);
                intent.putExtra("rating", item.rating);
                context.startActivity(intent);
            });
        }


        return convertView;
    }
}
