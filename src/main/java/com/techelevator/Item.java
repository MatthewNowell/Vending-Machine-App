package com.techelevator;

public abstract class Item implements Purchasable, Transactional {
    private String name;
    private String code;
    private String price;
    private String type;
    private String sound;


    public Item(String name, String price, String code, String type) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;

    }

    public String toString() {
        return getCode() + " " + getName() + " " + getPrice();
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public String getCode() {
        return code;
    }

    public String getPrice() {
        return price;
    }

    public int getPriceInPennies() {
        price = price.replace(".", "");
        return Integer.parseInt(price);
    }

    public String getType() {
        return type;
    }



    }

