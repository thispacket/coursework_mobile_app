package com.example.myapplication;

public class MenuItemBookmark {
    public int image, price, rating, is_bookmark, is_paid, id;
    public String name, description;

    public MenuItemBookmark(int image, int price, String name,  String description,  int is_bookmark, int is_paid, int rating, int id) {
        this.image = image;
        this.price = price;
        this.name = name;
        this.description = description;
        this.is_bookmark = is_bookmark;
        this.is_paid = is_paid;
        this.rating = rating;
        this.id = id;
    }
}
