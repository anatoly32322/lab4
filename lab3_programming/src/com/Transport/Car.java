package com.Transport;

import com.Person;

public class Car {
    private int max_speed;
    private Person[] passangers = new Person[10];
    private int countOfPassangers = 0;
    private Boolean ride = false;
    public Car(int max_speed){
        this.max_speed = max_speed;
    }
    public void Go(){
        if (!ride)
            System.out.println("*Машина поехала*");
        else{
            System.out.println("*Машина уже едет*");
        }
    }
    public void Stop(){
        if (ride){
            System.out.println("*Машина остановилась*");
        }
        else{
            System.out.println("*Машина не едет*");
        }
    }
    public void AddPassanger(Person a){
        if (countOfPassangers == 10){
            System.out.println("*Больше в машину не влезет*");
            return;
        }
        passangers[countOfPassangers] = a;
        countOfPassangers++;
        System.out.println("*Объект " + a.getName() + " сел в машину*");
    }
}
