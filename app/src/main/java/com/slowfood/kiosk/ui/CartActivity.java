package com.slowfood.kiosk.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.slowfood.kiosk.R;

public class CartActivity extends AppCompatActivity {

    Button buy;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        buy = findViewById(R.id.buyButton);

        ListView listView = findViewById(R.id.selected);
        ProductAdapter adapter = new ProductAdapter(this, getLayoutInflater(), OrderActivity.selected);
        listView.setAdapter(adapter);

        TextView price = findViewById(R.id.price_text);
        price.setText(String.valueOf(OrderActivity.selected.stream().mapToInt(Product::getPrice).sum()));

        buy.setOnClickListener(view -> {
            OrderActivity.selected.clear();
            Intent i = new Intent(this, MessageActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });
    }
}