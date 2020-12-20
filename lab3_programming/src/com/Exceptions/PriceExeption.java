package com.Exceptions;

public class PriceExeption extends RuntimeException {
    public PriceExeption(){
        super();
    }
    public PriceExeption(String message){
        super(message);
    }
}
