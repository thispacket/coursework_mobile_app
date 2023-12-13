package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Button payBtn = findViewById(R.id.pay_btn);
        Button backBtn = findViewById(R.id.back_btn);

        ImageView nameCheckedIcon = findViewById(R.id.name_checked_icon);
        ImageView cardNumberCheckedIcon = findViewById(R.id.number_checked_icon);
        ImageView dateCheckedIcon = findViewById(R.id.date_checked_icon);
        ImageView cvvCheckedIcon = findViewById(R.id.cvv_checked_icon);

        nameCheckedIcon.setImageResource(0);
        cardNumberCheckedIcon.setImageResource(0);
        dateCheckedIcon.setImageResource(0);
        cvvCheckedIcon.setImageResource(0);

        EditText nameInput = findViewById(R.id.name_input);
        EditText cardNumberInput = findViewById(R.id.card_number_input);
        EditText dateInput = findViewById(R.id.date_input);
        EditText cvvInput = findViewById(R.id.cvv_input);
        TextView totalPrice = findViewById(R.id.total_price);


        totalPrice.setText(getIntent().getIntExtra("price", 0) + "₽");

        nameInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (nameInput.getText().toString().equals("")) nameCheckedIcon.setImageResource(R.drawable.error_icon);
            else nameCheckedIcon.setImageResource(R.drawable.correct_icon);
        });

        cardNumberInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && cardNumberInput.getText().toString().equals("")) cardNumberCheckedIcon.setImageResource(R.drawable.error_icon);
            else cardNumberCheckedIcon.setImageResource(R.drawable.correct_icon);
        });

        dateInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && dateInput.getText().toString().equals("")) dateCheckedIcon.setImageResource(R.drawable.error_icon);
            else dateCheckedIcon.setImageResource(R.drawable.correct_icon);
        });

        cvvInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && cvvInput.getText().toString().equals("")) cvvCheckedIcon.setImageResource(R.drawable.error_icon);
            else cvvCheckedIcon.setImageResource(R.drawable.correct_icon);
        });

        payBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentActivity.this, LoadingActivity.class);
            startActivity(intent);
        });

        backBtn.setOnClickListener(v -> {
            finish();
        });
    }
}