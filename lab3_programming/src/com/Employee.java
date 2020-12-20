package com;

import com.Things.Ticket;

public class Employee extends Person {
    private Ticket ticket;
    public Employee(String name, Ticket ticket){
        super(name);
        this.ticket = ticket;
    }
    @Override
    public void CalmDownSE(Person a){
        System.out.println("*Объект " + getName() + " успокаивает объект " + a.getName() + '*');
    }
    @Override
    public void CheckForTicket(Person a){
        System.out.println("*Объект " + getName() + " просит продемонстрировать билет объекта " + a.getName() + '*');
        if (a.getTicket() == null){
            System.out.println("*Объект " + getName() + " просит объекта " + a.getName() + " купить билет*");
            if (a.getWallet().getSum() < ticket.getPrice()) {
                System.out.println("*Объект " + getName() + " просит объекта " + a.getName() + " выйти из поезда*");
                a.GetOutFromTheTrain();
            }
            else {
                a.getWallet().subtract(ticket.getPrice());
            }
        }
    }
}
