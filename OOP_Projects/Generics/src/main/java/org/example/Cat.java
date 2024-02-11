package org.example;
import java.io.Serializable;
public class Cat extends Animal implements Serializable{
    public Cat(String name){
        super(name);
    }
    @Override
    public void print(){
        System.out.println("Cat: " + super.getName());
    }

    @Override
    public String toString(){
        return "Cat name : " + super.getName() ;
    }
}
