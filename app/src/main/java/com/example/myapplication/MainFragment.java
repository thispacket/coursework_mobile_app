package com.example.myapplication;

import android.content.Intent;
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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = view.findViewById(R.id.listViewItemsMain);
        ArrayList<MenuItem> menuItems = new ArrayList<>();


        Random random = new Random();
        int randomPrice = random.nextInt(200) * 5;

        menuItems.add(new MenuItem(R.drawable.noodles, randomPrice, "Noodles"));
        menuItems.add(new MenuItem(R.drawable.beef, randomPrice, "Beef"));
        menuItems.add(new MenuItem(R.drawable.omelette_noodle, randomPrice, "Omelette noodle"));
        menuItems.add(new MenuItem(R.drawable.egg, randomPrice, "Egg"));
        menuItems.add(new MenuItem(R.drawable.pasta, randomPrice, "Pasta"));
        menuItems.add(new MenuItem(R.drawable.vegan_noodle, randomPrice, "Vegan noodle"));

        MenuItemAdapter adapter = new MenuItemAdapter(getActivity(), R.layout.menu_item, menuItems);

        listView.setAdapter(adapter);

        return view;
    }
}