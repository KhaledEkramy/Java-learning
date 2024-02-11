package org.example;
import java.io.Serializable;
public class GenericAnimalPrinter <T extends Animal & Serializable> { // Generic Animal Printer. // Is called a bounded Generic. // T extends Animal means that T must be a subclass of Animal or Animal itself.
    // Note that T extends Animal & Serializable means that T must be a subclass of Animal and must implement Serializable.
    // in the previous order of words, Class must come first and then Interface.
    T animal ;
    public GenericAnimalPrinter(T animal){
        this.animal = animal ;
    }
    public void print(){
        animal.print();
    }

}
