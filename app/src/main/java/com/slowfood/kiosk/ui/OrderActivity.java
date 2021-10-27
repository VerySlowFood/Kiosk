package com.slowfood.kiosk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.slowfood.kiosk.R;

public class OrderActivity extends AppCompatActivity {

    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        confirm = findViewById(R.id.confirm_button);

        confirm.setOnClickListener(view -> {
            Intent i = new Intent(this, CartActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });
    }
}