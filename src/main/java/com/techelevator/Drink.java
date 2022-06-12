package com.techelevator;

public class Drink extends Item {

    public Drink(String name, String price, String code, String type) {
        super(name, price, code, type);
    }

    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }

}
