package com.Things;

import com.Interfaces.IThing;

public class Cane implements IThing {
    private String name;
    private int price;
    public Cane(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getPrice() {
        return price;
    }
}
