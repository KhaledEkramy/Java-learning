package org.example;

public class Main {
    public static void main(String[] args) {
        BinaryHeap obj = new BinaryHeap(10);
        System.out.println(obj.isEmpty());
        obj.insert(10);
        obj.insert(20);
        obj.insert(15);
        obj.print();
        System.out.println(obj.isEmpty());
        System.out.println(obj.delMax());
        System.out.println("Hello world");
        obj.insert(7);
        System.out.println(obj.delMin());
        System.out.println("==============");
        obj.insert(5);
        obj.insert(2);
        obj.insert(23);
        obj.print();
    }
}