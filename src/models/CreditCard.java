package models;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> purchases;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.purchases = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public boolean setPurchase(Purchase purchase) {
        if (purchase.getAmount() > this.balance) {
            return false;
        }

        this.balance -= purchase.getAmount();
        purchases.add(purchase);
        return true;
    }
}