package com.techelevator;

import com.techelevator.view.Menu;

import java.util.*;

public class VendingMachine {

    private CoinHandler coinHandler = new CoinHandler();
    private OrderPicker orderPicker = new OrderPicker();
    private Inventory inventory = new Inventory();

   Scanner scanner = new Scanner(System.in);

   public VendingMachine() {
       for (String key : orderPicker.getStockOrderMap().keySet()) {
           inventory.renewInventory(key);
       }
   }


   public void purchase() {
        System.out.println("Your current balance is $" + coinHandler.getBalance());
        System.out.println("Please enter a whole dollar amount to add to your purchasing balance.");
        String moneyInput = scanner.nextLine();
        double moneyInDub = Double.parseDouble(moneyInput);
        coinHandler.addCredits(moneyInDub);
        pickItem();
    }

    public void pickItem() {
        System.out.println("Wow, so many snacks. Choose your tasty morsels");
        TreeMap<String, Item> stockMap = orderPicker.getStockOrderMap();

        String code = scanner.nextLine();
        if (stockMap.get(code) != null) {
            Item chosenItem = stockMap.get(code);
//            System.out.println(Double.parseDouble(chosenItem.getPrice()));
            if (coinHandler.deductCredits(Double.parseDouble(chosenItem.getPrice()))) {
                inventory.dispenseItem(code);
                System.out.println(chosenItem.getSound());
                System.out.println("You have purchased a " + chosenItem.getName() + " for $" + chosenItem.getPrice());
                System.out.println("Your remaining balance is $" + String.format("%.2f", coinHandler.getBalance()));
//               String.format("%.2f", balance))
            }

        } else System.out.println("impossible choice");

    }

    public void displayItems() {
        TreeMap<String, Item> stockMap = orderPicker.getStockOrderMap();
        for (String key : stockMap.keySet()) {
            System.out.println(stockMap.get(key));
        }
    }

    public void giveChangeInShekels() {

//     get a working equivalent to the dollar balance in pennies
       double coinPurse = coinHandler.getBalance() * 100;

        int nickels = 0;
        int dimes = 0;
        int quarters = 0;

        int nickelVal = 5;
        int dimeVal = 10;
        int quarterVal = 25;

//      Cheat the customer out of his fraction of a penny
        while (coinPurse > 1) {

            if (coinPurse >= quarterVal) {
                quarters++;
                coinPurse -= quarterVal;
            } else if (coinPurse >= dimeVal) {
                dimes++;
                coinPurse -= dimeVal;
            } else if (coinPurse >= nickelVal) {
                nickels++;
                coinPurse -= nickelVal;
            }
        }

//      clear the vending machine balance and dispense change
        coinHandler.setBalance(0);
        System.out.println("Here is your change: " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels.");
    }





// dump interface options into here to integrate everything





}
