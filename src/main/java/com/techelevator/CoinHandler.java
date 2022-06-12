package com.techelevator;

public class CoinHandler {

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double addCredits(double amountToAdd) {
        this.balance = getBalance() + amountToAdd;
        System.out.println("$" + String.format("%.2f", balance));
        return balance;
    }

    public boolean deductCredits(double amountToDeduct) {
        if (amountToDeduct <= balance) {
            this.balance = getBalance() - amountToDeduct;
            return true;
        }
        else { System.out.println("INSUFFICIENT FUNDS");
        return false;
        }
    }

}