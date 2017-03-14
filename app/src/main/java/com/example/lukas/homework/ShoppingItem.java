package com.example.lukas.homework;


public class ShoppingItem {
    private String title;
    private String description;
    private int id = -1;

    public ShoppingItem(int id, String title, String description) {
        this(title, description);
        this.id = id;
    }

    public ShoppingItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}