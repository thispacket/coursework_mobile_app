package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

            menuItemImage.setImageResource(item.image);
            menuItemName.setText(item.name);
            menuItemPrice.setText(item.price + "₽/шт.");

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MenuItemAdapter", "onClick: " + item.name);
                    Intent intent = new Intent(context, MenuItemActivity.class);
                    intent.putExtra("image", item.image);
                    intent.putExtra("name", item.name);
                    intent.putExtra("price", item.price);
                    context.startActivity(intent);
                }
            });
        }


        return convertView;
    }
}
