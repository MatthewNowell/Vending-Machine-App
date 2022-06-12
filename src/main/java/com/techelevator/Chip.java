package com.techelevator;

public class Chip extends Item {

    public Chip(String name, String price, String code, String type) {
        super(name, price, code, type);
    }
    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }

}
