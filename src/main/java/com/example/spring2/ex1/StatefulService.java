package com.example.spring2.ex1;

public class StatefulService {

    private int price;

    public void order(String name,int price){
        System.out.println("name = " + name+", price = "+price);
        this.price=price;
    }

    public int getPrice(){
        return price;
    }
}
