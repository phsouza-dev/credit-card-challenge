package models;

public class Purchase implements Comparable<Purchase> {
    private String description;
    private double amount;

    public Purchase(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return Double.valueOf(this.getAmount()).compareTo(Double.valueOf(purchase.getAmount()));
    }
}