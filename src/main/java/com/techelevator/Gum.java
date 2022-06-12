package com.techelevator;

public class Gum extends Item {
    public Gum(String name, String price, String code, String type) {
        super(name, price, code, type);
    }
    @Override
    public String getSound() {
        return "Chew Chew Yum!";
    }
}

