package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

            convertView = inflater.inflate(R.layout.menu_item, null);
        }

        if (menuItemsBookmark.size() > 0) {
            MenuItemBookmark itemBookmark = menuItemsBookmark.get(position);

            ImageView menuItemBookmarkImage = convertView.findViewById(R.id.menuItemImage);
            TextView menuItemBookmarkName = convertView.findViewById(R.id.menuItemName);
            TextView menuItemBookmarkPrice = convertView.findViewById(R.id.menuItemprice);

            menuItemBookmarkImage.setImageResource(itemBookmark.image);
            menuItemBookmarkName.setText(itemBookmark.name);
            menuItemBookmarkPrice.setText(itemBookmark.price + "₽/шт.");
        }


        return convertView;
    }
}
