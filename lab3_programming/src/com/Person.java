package com;

import com.Interfaces.IMeal;
import com.Interfaces.IPerson;
import com.Interfaces.IRunnable;
import com.Interfaces.IThing;
import com.Things.Cane;
import com.Things.Pillow;
import com.Things.Ticket;
import com.Things.Wallet;
import com.Transport.Train;

import java.util.Objects;

public class Person implements IPerson {
    private int HP = 100;
    private String name = null;
    private PersonProperties[] properties = {null};
    private Wallet wallet = new Wallet(0);
    private Ticket ticket = null;
    private Cane cane = null;
    private Boolean health = true;
    public Person(String name){
        this.name = name;
    }
    public Person(String name, int wallet){
        this.name = name;
        this.wallet.add(wallet);
    }
    public Person(String name, int wallet, Cane cane){
        this.name = name;
        this.wallet.add(wallet);
        this.cane = cane;
    }
    public Person(String name, PersonProperties[] properties){
        this.name = name;
        this.properties = properties;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public Boolean getHealth() { return health; }
    public Wallet getWallet() {
        return wallet;
    }
    public void CalmDownSE(Person a){}
    public void CheckForTicket(Person a){}
    public PersonProperties[] getProperties(){
        return properties;
    }
    public String getPropertiesString() {
        String a = "";
        for(int i = 0; i < properties.length; i++){
            a += (i == properties.length - 1)?(properties[i].getProperties()):(properties[i].getProperties() + ", ");
        }
        return a;
    }
    public Cane getCane() { return cane; }
    public String getName(){
        return name;
    }
    public boolean BuyTicket(Ticket a){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return false;
        }
        if (wallet.getSum() < a.getPrice()){
            System.out.println("Объект " + name + " не может позволить себе купить билет стоимостью " + a.getPrice());
            return true;
        }
        wallet.subtract(a.getPrice());
        System.out.println("*Объект " + name + " покупает билеты по цене " + a.getPrice() + "*");
        System.out.println("*Общая сумма на руках у объекта " + name + " теперь составляет " + wallet.getSum() + '*');
        ticket = a;
        return false;
    }
    public void Run(){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        Start(new IRunnable(){
            public void Run(){
                System.out.println("*Объект " + name + " бежит*");
            }
        });
    }
    private void Start(IRunnable a){
        a.Run();
    }
    public void GetOnTheTrain(Train a){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        System.out.println("*Объект " + name + " садится на поезд " + a.getTrainModel().getName() + '*');
    }
    public void Kick(Person a, IThing b){
        double rand = Math.random();
        if (rand < 0.2) {
            System.out.println("*Объект " + this.name + " ударил объект " + a.getName() + " предметом " + b.getName() + " по голове*");
            this.HP -= 60;
        }
        else if(rand < 0.5){
            System.out.println("*Объект " + this.name + " ударил объект " + a.getName() + " предметом " + b.getName() + " по ногам*");
            this.HP -= 20;
        }
        else {
            System.out.println("*Объект " + this.name + " ударил объект " + a.getName() + " предметом " + b.getName() + " по телу*");
            this.HP -= 40;
        }
        if (this.HP <= 0){
            System.out.println("*Объект " + a.getName() + " теряет сознание*");
            health = false;
        }
    }
    public void Regale(Person a, IMeal b){
        System.out.println("*Объект " + getName() + " угостил объект " + a.getName() + " объектом " + b.getName() + "*");
    }
    public void GetOutFromTheTrain(){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        System.out.println("*Объект " + name + " выходит из поезда*");
    }
    public void GetNervous() {
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        System.out.println("*Объект " + name + " начинает нервничать*"); }
    public void CalmDown(){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        System.out.println("*Объект " + name + " успокаивается*");
    }
    public void Sleep(Pillow a){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        System.out.println("*Объект " + name + " ложится на подушку с свойствами:" + a.getPropertiesString() + " - и пытаяется заснуть*");
        if (a.getConvenience() > 50) {
            System.out.println("*Объект " + name + " наелся и спит*");
        }
        else {
            System.out.println("*Объект " + name + " не может заснуть*");
        }
    }
    public boolean TryToFind(IThing a){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return false;
        }
        System.out.println("*Объект " + name + " пытается найти объект " + a.getName() + "*");
        if (Math.random() < 0.5){
            System.out.println("*Объект " + name + " нашёл объект " + a.getName() + "*");
            return true;
        }
        else{
            System.out.println("*Объект " + name + " не нашёл объект " + a.getName() + "*");
            return false;
        }
    }
    public void PickUpCane(Cane a){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        cane = a;
    }
    public boolean TryToSpeak(Person a){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return false;
        }
        System.out.println("*Объект " + name + " пытается завести разговор с объектом " + a.getName() + ", имеющим свойства:" + a.getPropertiesString() + '*');
        boolean flag = true;
        for (PersonProperties b : a.getProperties()){
            if (b.getProperties() == PersonProperties.RUDE.getProperties()){
                flag = false;
            }
            if (b.getProperties() == PersonProperties.TACITURN.getProperties() && Math.random() <= 0.5){
                flag = false;
            }
        }
        if (flag){
            System.out.println("*Объект " + name + " успешно завёл разговор с объектом " + a.getName() + '*');
        }
        else{
            System.out.println("*Объект " + name + " не смог завести разговор с объектом " + a.getName() + '*');
        }
        return flag;
    }
    public void Speak(Person a){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        System.out.println("*Объект " + name + " разговаривает с объектом " + a.getName() + '*');
    }
    public void Speak(String topic){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return;
        }
        System.out.println(name + ": " + topic + '.');
    }
    public boolean Think(String topic){
        if (!getHealth()){
            System.out.println("*Объект " + this.name + " не в сознании*");
            return false;
        }
        System.out.println("*Объект " + name + " рассуждает над тем, что " + topic + '*');
        if (Math.random() <= 0.7){
            System.out.println("*Объект " + name + " понял, что он прав*");
            return true;
        }
        System.out.println("*Объект " + name + " так ни к чему и не пришёл*");
        return false;
    }
    @Override
    public String toString(){
        return getClass() + "{name='" + name + "', properties=" + getPropertiesString() + ", wallet=" + getWallet().getSum() + ", ticket=" + getTicket().getName() +"}";
    }

    @Override
    public boolean equals(Object a){
        if (this == a) {
            return true;
        }
        if (!(a instanceof Person)){
            return false;
        }
        Person person = (Person)a;
        return (getName() == person.getName()) && (getTicket() == person.getTicket()) && (getWallet() == person.getWallet()) && (getPropertiesString() == person.getPropertiesString());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getName(), getPropertiesString(), getWallet(), getTicket());
    }
}
