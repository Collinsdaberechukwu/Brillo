package com.brilloConnectionz;

public class ShopEntity {
    private int max_pancakes;
    private int max_pancake_per_customer;
    private int max_customers;
    private int max_slots;


    public ShopEntity() {
        this.max_pancakes = 12;
        this.max_pancake_per_customer = 5;
        this.max_customers = 3;
        this.max_slots = 5;
    }
    public int getMax_pancakes() {
        return max_pancakes;
    }

    public void setMax_pancakes(int max_pancakes) {
        this.max_pancakes = max_pancakes;
    }

    public int getMax_pancake_per_customer() {
        return max_pancake_per_customer;
    }

    public void setMax_pancake_per_customer(int max_pancake_per_customer) {
        this.max_pancake_per_customer = max_pancake_per_customer;
    }

    public int getMax_customers() {
        return max_customers;
    }

    public void setMax_customers(int max_customers) {
        this.max_customers = max_customers;
    }

    public int getMax_slots() {
        return max_slots;
    }

    public void setMax_slots(int max_slots) {
        this.max_slots = max_slots;
    }
}
