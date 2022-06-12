package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OrderPicker {

    // create Map object corresponding to input file
// scan file lines and split the strings

    private String filePath = "vendingmachine.csv";
    private File inputFile = new File(filePath);

    private TreeMap<String, Item> stockOrderMap = new TreeMap<>();

    public TreeMap<String, Item> getStockOrderMap() {
        return stockOrderMap;
    }

    public OrderPicker() {

    Scanner scanner = null;

        try {
            scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {

                String inputLine = scanner.nextLine();
                String[] arrSplit = inputLine.split("\\|");

                if (arrSplit[3].equals("Chip")) {
                    Chip chip = new Chip(arrSplit[1], arrSplit[2], arrSplit[0], arrSplit[3]);
                    stockOrderMap.put(arrSplit[0], chip);
                }
                else if (arrSplit[3].equals("Gum")) {
                    Gum gum = new Gum(arrSplit[1], arrSplit[2], arrSplit[0], arrSplit[3]);
                    stockOrderMap.put(arrSplit[0], gum);
                }
                else if (arrSplit[3].equals("Drink")) {
                    Drink drink = new Drink(arrSplit[1], arrSplit[2], arrSplit[0], arrSplit[3]);
                    stockOrderMap.put(arrSplit[0], drink);
                }
                else if (arrSplit[3].equals("Candy")) {
                    Candy candy = new Candy(arrSplit[1], arrSplit[2], arrSplit[0], arrSplit[3]);
                    stockOrderMap.put(arrSplit[0], candy);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        assert scanner != null;
        scanner.close();
    }

}
