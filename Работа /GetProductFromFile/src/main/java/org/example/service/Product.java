package org.example.service;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private static final long serialVersionUID = -3536693998646060163L;
    private long code;
    private String name;

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String type;
    private boolean isDiscount;
    private ArrayList<String> ingredients;
    private double price;

    // геттеры и сеттеры для полей

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }
}