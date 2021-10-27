package com.slowfood.kiosk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.slowfood.kiosk.R;

public class CartActivity extends AppCompatActivity {

    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        buy = findViewById(R.id.buyButton);

        buy.setOnClickListener(view -> {
            Intent i = new Intent(this, MessageActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });
    }
}