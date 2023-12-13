package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button payBtn = findViewById(R.id.pay_btn);

        payBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentActivity.this, LoadingActivity.class);
            startActivity(intent);
        });
    }
}