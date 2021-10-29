package com.slowfood.kiosk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.slowfood.kiosk.R;

import java.util.ArrayList;
import java.util.HashSet;

public class OrderActivity extends AppCompatActivity {

    public static ArrayList<Product> products;
    public static ArrayList<Product> selected = new ArrayList<>();
    public static OrderActivity INSTANCE = null;
    static {
        products = new ArrayList<>(7);
        products.add(new Product(R.drawable.dllllllllllllllllllllllllllll, "치킨버거", "맘스터치 치킨버거", 4000, 1));
        products.add(new Product(R.drawable.img, "햄버거", "햄버거", 3500, 2));
        products.add(new Product(R.drawable.img_1, "햄버거 세트", "맥도날드 햄버거 세트", 7500, 3));
        products.add(new Product(R.drawable.img_2, "치즈버거", "맥도날드 치즈버거", 8000, 4));
        products.add(new Product(R.drawable.img_3, "콜라", "코카콜라", 1000, 5));
    }

    public void updateCount() {
        TextView items = findViewById(R.id.item_count);
        items.setText(String.valueOf(selected.size()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Button confirm = findViewById(R.id.confirm_button);

        ListView listView = findViewById(R.id.products);
        ProductAdapter adapter = new ProductAdapter(this, getLayoutInflater(), products);
        listView.setAdapter(adapter);

        confirm.setOnClickListener(view -> order());
        INSTANCE = this;
    }

    private void order(){
        Intent i = new Intent(this, CartActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        INSTANCE = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_X)order();
        return super.onKeyDown(keyCode, event);
    }
}