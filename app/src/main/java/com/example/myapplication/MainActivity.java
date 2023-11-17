package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button home, bookmark, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.home_btn);
        bookmark = findViewById(R.id.bookmark_btn);
        logout = findViewById(R.id.logout_btn);

        MainFragment mainFragment = new MainFragment();
        BookmarkFragment bookmarkFragment = new BookmarkFragment();

        setViewFragment(mainFragment);

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setViewFragment(bookmarkFragment); }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setViewFragment(mainFragment); }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Logout functionality here
            }
        });
    }

    private void setViewFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.main_content, fragment)
                                   .addToBackStack(null)
                                   .commit();
    }
}