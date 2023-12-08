package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MenuItemBookmarkAdapter extends ArrayAdapter<MenuItemBookmark> {

    private Context context;
    private ArrayList<MenuItemBookmark> menuItemsBookmark;
    public MenuItemBookmarkAdapter(@NonNull Context context, int resource, @NonNull List<MenuItemBookmark> objects) {
        super(context, resource, objects);

        this.context = context;
        this.menuItemsBookmark = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.menu_item_bookmark, null);
        }

        if (menuItemsBookmark.size() > 0) {
            MenuItemBookmark itemBookmark = menuItemsBookmark.get(position);

            ImageView menuItemBookmarkImage = convertView.findViewById(R.id.menuItemImage);
            TextView menuItemBookmarkName = convertView.findViewById(R.id.menuItemName);
            TextView menuItemBookmarkPrice = convertView.findViewById(R.id.menuItemprice);
            ImageButton menuItemBookmarkTrash = convertView.findViewById(R.id.trash_icon_item);

            menuItemBookmarkImage.setImageResource(itemBookmark.image);
            menuItemBookmarkName.setText(itemBookmark.name);
            menuItemBookmarkPrice.setText(itemBookmark.price + "₽/шт.");

            menuItemBookmarkTrash.setOnClickListener(view -> {
                DBHelper dbHelper = new DBHelper(context);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper.KEY_IS_BOOKMARK, 0);
                db.update(DBHelper.TABLE_MENU, contentValues, DBHelper.KEY_ID + " = ?", new String[]{String.valueOf(itemBookmark.id)});

                menuItemsBookmark.remove(position);
                db.close();
            });


            convertView.setOnClickListener(view -> {
                Intent intent = new Intent(context, MenuItemActivity.class);
                intent.putExtra("image", itemBookmark.image);
                intent.putExtra("name", itemBookmark.name);
                intent.putExtra("price", itemBookmark.price);
                intent.putExtra("description", itemBookmark.description);
                intent.putExtra("is_bookmark", itemBookmark.is_bookmark);
                intent.putExtra("is_paid", itemBookmark.is_paid);
                intent.putExtra("rating", itemBookmark.rating);
                context.startActivity(intent);
            });
        }


        return convertView;
    }
}
