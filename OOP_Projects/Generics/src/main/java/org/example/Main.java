package org.example;

import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        GenericPrinter<String> StringPrinter = new GenericPrinter<>("Hello world");
        StringPrinter.print();
        Double pi = Math.round(Math.PI * 100.0) / 100.0 ;
        GenericPrinter<Double> doublePrinter = new GenericPrinter<>(pi);
        doublePrinter.print();

        GenericAnimalPrinter<Cat> catPrinter = new GenericAnimalPrinter<>(new Cat("cat")); // Generic Animal Printer only supports Animal or its subclasses.
        GenericAnimalPrinter<Dog> dogPrinter = new GenericAnimalPrinter<>(new Dog("dog"));
        GenericAnimalPrinter<Animal> animalPrinter = new GenericAnimalPrinter<>(new Animal("animal"));
        catPrinter.print();
        dogPrinter.print();
        print("Generic Cat Method");
        printDoubleGeneric("T", "V");
        List<Cat> list = new ArrayList<Cat>();
        list.add(new Cat("cat1")) ;
        list.add(new Cat("cat2")) ;
        printBoundedGenericList(list);


    }
    //Generic Mathod:
    public static <T> void print(T t){
        System.out.println(t + " Generic Method");
    }

    public static <T,V> void printDoubleGeneric(T t, V v){
        System.out.println(t + " " + v + " Double Generic Method");
    }

    public static void printGenericList(List<?> myList){ // ? is called the wildcard method
        System.out.println(myList.toString() + " Generic List");
    }

    public static  void printBoundedGenericList(List<? extends Animal> myList){ // ? wildcard method with bounded parameters.
        System.out.println(myList.toString() + " Bounded Generic List");
    }

}