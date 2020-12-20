package com.Things;

import com.Interfaces.IThing;

public class Ticket implements IThing {
    private String name;
    private int price;
    public Ticket(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public String getName() {
        return name;
    }
}
