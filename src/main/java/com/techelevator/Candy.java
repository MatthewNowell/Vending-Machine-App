package com.techelevator;

public class Candy extends Item {

    public Candy(String name, String price, String code, String type) {
        super(name, price, code, type);
    }

    @Override
    public String getSound() {
        return "Munch Munch Yum!";
    }
}

