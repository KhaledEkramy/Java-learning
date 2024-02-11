package org.example;
import java.io.Serializable;
public class Dog extends Animal implements Serializable{
    public Dog(String name){
        super(name) ;
    }
    @Override
    public void print(){
        System.out.println("Dog: " + super.getName());
    }

    @Override
    public String toString(){
        return "Dog name : " + super.getName() ;
    }
}
