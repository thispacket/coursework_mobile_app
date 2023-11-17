package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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

        while (menuItems.size() < 10) {
            menuItems.add(new MenuItem());
        }

        MenuItemAdapter adapter = new MenuItemAdapter(getActivity(), R.layout.menu_item, menuItems);

        listView.setAdapter(adapter);

        return view;
    }
}