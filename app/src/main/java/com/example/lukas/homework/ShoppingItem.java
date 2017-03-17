package com.example.lukas.homework;


import java.io.Serializable;

public class ShoppingItem implements Serializable {
    private String title;
    private String description;



    private double price;
    private String photoUrl = "http://viralka.pl/wp-content/uploads/2015/05/okladka.jpg";
    private int id = -1;

    public ShoppingItem(int id, String title, String description, double price, String photoUrl) {
        this(title, description, price, photoUrl);
        this.id = id;
    }

    public ShoppingItem(String title, String description, double price, String photoUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.photoUrl = photoUrl;
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

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}