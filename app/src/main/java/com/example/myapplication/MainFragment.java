package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.widget.ViewUtils;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainFragment extends Fragment implements AdapterView.OnItemClickListener {
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

        menuItems.add(new MenuItem(R.drawable.noodles, random.nextInt(200) * 5, "Noodles"));
        menuItems.add(new MenuItem(R.drawable.beef, random.nextInt(200) * 5, "Beef"));
        menuItems.add(new MenuItem(R.drawable.omelette_noodle, random.nextInt(200) * 5, "Omelette noodle"));
        menuItems.add(new MenuItem(R.drawable.egg, random.nextInt(200) * 5, "Egg"));
        menuItems.add(new MenuItem(R.drawable.pasta, random.nextInt(200) * 5, "Pasta"));
        menuItems.add(new MenuItem(R.drawable.vegan_noodle, random.nextInt(200) * 5, "Vegan noodle"));

        MenuItemAdapter adapter = new MenuItemAdapter(getActivity(), R.layout.menu_item, menuItems);

        listView.setAdapter(adapter);


        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //
    }
}