package org.example;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Create an empty priority queue
        OrderedPriorityQueue<Integer> queue = new OrderedPriorityQueue<>();

        queue.insert(10);
        queue.print();
        queue.delMin();
        System.out.println(queue.isEmpty());
        System.out.println(queue.delMax());
    }
}