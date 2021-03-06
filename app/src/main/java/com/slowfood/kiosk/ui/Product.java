package com.slowfood.kiosk.ui;

public class Product {
    private final int pictureId;
    private final String name;
    private final String description;
    private final int price;
    private final String foodId;

    public Product(int pictureId, String name, String description, int price, String foodId) {
        this.pictureId = pictureId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.foodId = foodId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getFoodId() {
        return foodId;
    }
}
