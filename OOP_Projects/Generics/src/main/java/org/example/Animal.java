package org.example;
import java.io.Serializable;
public class Animal implements Serializable{
    private final String name ;
    public Animal(String name){
        this.name = name ;
    }
    public String getName(){
        return this.name ;
    }
    public void print(){
        System.out.println("Animal: " + name);
    }
}
