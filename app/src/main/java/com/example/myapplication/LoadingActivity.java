package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        ImageView success = findViewById(R.id.success);
        Handler handler = new Handler();

        ConstraintLayout constraintLayout = findViewById(R.id.loading_background);
        handler.postDelayed(() -> {
            progressBar.setIndeterminateTintList(getResources().getColorStateList(R.color.green));

            handler.postDelayed(() -> {
                success.setVisibility(ImageView.VISIBLE);
                progressBar.setVisibility(ProgressBar.INVISIBLE);

                handler.postDelayed(() -> {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.green));

                    handler.postDelayed(() -> {
                        Intent intent = new Intent(LoadingActivity.this, ResultPaymentActivity.class);
                        startActivity(intent);
                    }, 10);
                }, 500);

            }, 1000);

        }, 2000);
    }
}