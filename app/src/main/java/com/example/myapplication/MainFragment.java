package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        String[] namesArr = new BookmarkFragment().namesArr;

        ListView listView = view.findViewById(R.id.listViewItemsMain);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                                                          android.R.layout.simple_expandable_list_item_1,
                                                          namesArr);
        listView.setAdapter(adapter);

        return view;
    }
}