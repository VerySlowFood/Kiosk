package com.slowfood.kiosk.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.slowfood.kiosk.MainActivity;
import com.slowfood.kiosk.R;

public class MessageActivity extends AppCompatActivity {

    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        goBack = findViewById(R.id.goBack);

        goBack.setOnClickListener(view -> {
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });
    }
}