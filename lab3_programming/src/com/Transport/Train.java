package com.Transport;

import com.Interfaces.ITrain;

public class Train implements ITrain {
    private String name;
    private TrainModels TrainModel;
    private Engine Engine = new Engine();
    public Train(String name, TrainModels TrainModel){
        this.name = name;
        this.TrainModel = TrainModel;
    }
    public class Engine{
        private boolean engineCondition;
        public Engine(){
            engineCondition = IsBroken();
        }
        private boolean IsBroken(){
            return (Math.random() > 0.5) ? true : false;
        }
        public void Repair(){
            System.out.println("*Поезд починен*");
            engineCondition = true;
        }
        public boolean getCondition(){
            if (engineCondition){
                System.out.println("*Двигатель в рабочем состоянии*");
            }
            else{
                System.out.println("*Двигатель сломан*");
            }
            return engineCondition;
        }
    }
    public Engine getEngine(){
        return this.Engine;
    }
    public String getName(){
        return name;
    }
    public TrainModels getTrainModel(){
        return TrainModel;
    }
    public void Start(){
        System.out.println("*Поезд поехал*");
    }
    public void Stop(){
        System.out.println("*Поезд остановился*");
    }
    public void Chu_Chu(){
        System.out.println("*Чух-Чух!*");
    }
}
