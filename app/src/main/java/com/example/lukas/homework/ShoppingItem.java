package com.example.lukas.homework;


import java.io.Serializable;

public class ShoppingItem implements Serializable {
    private String title;
    private String description;
    private String photoUrl = "http://viralka.pl/wp-content/uploads/2015/05/okladka.jpg";
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
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}