package com.slowfood.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.slowfood.kiosk.databinding.ActivityMainBinding;
import com.slowfood.kiosk.ui.OrderActivity;
import com.slowfood.kiosk.ui.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent i = new Intent(this, OrderActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });
    }
}