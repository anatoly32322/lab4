package com.Things;

import com.Interfaces.IMeal;

public class Water implements IMeal {
    private int degree;
    private String name;
    public Water(String name, int degree){
        this.degree = degree;
        this.name = name;
    }

    public int getDegree() {
        return degree;
    }

    public void Heat(int x){
        degree = Math.min(degree + x, 100);
        if (degree == 100){
            name = "кипяток";
        }
    }
    public void Cool(int x) {
        degree = Math.max(degree - x, 1);
    }
    @Override
    public String getName(){
        return this.name;
    }
}
