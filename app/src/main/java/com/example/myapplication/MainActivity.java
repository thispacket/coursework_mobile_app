package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button home, bookmark, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        int randomPrice = random.nextInt(200) * 5;

        int[] images = {R.drawable.pasta, R.drawable.beef, R.drawable.egg, R.drawable.noodle, R.drawable.spicy, R.drawable.vegan};
        String names = "Острая сезонная лапша";
        int[] prices = {randomPrice, randomPrice, randomPrice, randomPrice, randomPrice, randomPrice, randomPrice};
        int[] ratings = {0, 0, 0, 0, 0, 0, 0};
        int is_bookmarks = 0;
        int is_pays = 0;
        String description = "Vivamus molestie felis ut blandit blandit. Maecenas eleifend lectus vel pulvinar ultrices. Nam leo dui, volutpat a tempus commodo, mattis eu nisi. Vivamus varius imperdiet velit ac ornare. ";

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = db.query(DBHelper.TABLE_MENU, null, null, null, null, null, null);
        if (cursor.getCount() < 6) {
            for (int i = 0; i < 6; i++) {
                contentValues.put(DBHelper.KEY_NAME, names);
                contentValues.put(DBHelper.KEY_IMAGE, images[i]);
                contentValues.put(DBHelper.KEY_PRICE, prices[i]);
                contentValues.put(DBHelper.KEY_RATING, ratings[i]);
                contentValues.put(DBHelper.KEY_DESCRIPTION, description);
                contentValues.put(DBHelper.KEY_IS_BOOKMARK, is_bookmarks);
                contentValues.put(DBHelper.KEY_IS_PAID, is_pays);
                db.insert(DBHelper.TABLE_MENU, null, contentValues);
            }
        }


        db.close();


        home = findViewById(R.id.home_btn);
        bookmark = findViewById(R.id.bookmark_btn);
        logout = findViewById(R.id.logout_btn);

        MainFragment mainFragment = new MainFragment();
        BookmarkFragment bookmarkFragment = new BookmarkFragment();

        setViewFragment(mainFragment);

        bookmark.setOnClickListener(view -> setViewFragment(bookmarkFragment));
        home.setOnClickListener(view -> setViewFragment(mainFragment));
        logout.setOnClickListener(view -> {
            // TODO: Logout functionality here
        });
    }

    private void setViewFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.main_content, fragment)
                                   .addToBackStack(null)
                                   .commit();
    }
}