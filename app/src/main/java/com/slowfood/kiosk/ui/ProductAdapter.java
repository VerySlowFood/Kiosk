package com.slowfood.kiosk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.slowfood.kiosk.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    public final Context context;
    public final LayoutInflater inflater;
    public final ArrayList<Product> products;

    public ProductAdapter(Context context, LayoutInflater inflater, ArrayList<Product> products) {
        this.context = context;
        this.inflater = inflater;
        this.products = products;
    }


    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.product_layout, null);

        ImageView imageView = view.findViewById(R.id.food_photo);
        TextView foodName = view.findViewById(R.id.food_name);
        TextView description = view.findViewById(R.id.description);
        TextView foodPrice = view.findViewById(R.id.food_price);
        TextView foodId = view.findViewById(R.id.food_id);

        Product product = products.get(position);
        view.setOnClickListener(clicked -> {
            if(OrderActivity.INSTANCE != null){
                OrderActivity.selected.add(product);
                OrderActivity.INSTANCE.updateCount();
            }
        });

        imageView.setImageResource(product.getPictureId());
        foodName.setText(product.getName());
        description.setText(product.getDescription());
        foodPrice.setText(String.valueOf(product.getPrice()));
        foodId.setText(product.getFoodId());

        return view;
    }
}
