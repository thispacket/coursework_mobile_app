package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ResultPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_payment);

        Button backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ResultPaymentActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}