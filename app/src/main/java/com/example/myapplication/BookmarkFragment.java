package com.example.myapplication;

import android.R.layout;
import android.annotation.SuppressLint;
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

import java.util.List;

public class BookmarkFragment extends Fragment {

    public final String[] namesArr = new String[] {"1", "2", "3", "4"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);

        ListView listView = view.findViewById(R.id.listViewItemBookmark);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), layout.simple_list_item_1, namesArr);
        listView.setAdapter(adapter);

        return view;
    }
}