package com.techelevator;

import java.util.*;

public class Inventory {

//    OrderPicker delivery = new OrderPicker();

    public TreeMap<String, Integer> inventory = new TreeMap<>();

    public TreeMap< String, Integer> getInventory() {
        return inventory;
    }

    public void renewInventory(String key) {
        inventory.put(key, 5);

    }

    public boolean dispenseItem(String userSelection) {
        int howManyLeft = inventory.get(userSelection);
        if (howManyLeft > 0) {
            howManyLeft--;
            inventory.put(userSelection, howManyLeft);
            return true;
        }
        else System.out.println("This item is SOLD OUT");
        return false;
    }


}
