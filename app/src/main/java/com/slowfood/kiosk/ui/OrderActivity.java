package com.slowfood.kiosk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.slowfood.kiosk.R;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private Button confirm;
    private ListView listView;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        confirm = findViewById(R.id.confirm_button);

        initializeProducts();
        listView = findViewById(R.id.products);
        ProductAdapter adapter = new ProductAdapter(this, getLayoutInflater(), products);
        listView.setAdapter(adapter);


        confirm.setOnClickListener(view -> {
            Intent i = new Intent(this, CartActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });
    }

    public void initializeProducts(){
        products = new ArrayList<>(7);
        products.add(new Product(R.drawable.dllllllllllllllllllllllllllll, "치킨버거", "맘스터치 치킨버거", 4000, 1));
        products.add(new Product(R.drawable.img, "햄버거", "햄버거", 3500, 2));
        products.add(new Product(R.drawable.img_1, "햄버거 세트", "맥도날드 햄버거 세트", 7500, 3));
        products.add(new Product(R.drawable.img_2, "치즈버거", "맥도날드 치즈버거", 8000, 4));
        products.add(new Product(R.drawable.img_3, "콜라", "코카콜라", 1000, 5));
    }
}