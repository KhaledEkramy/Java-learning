package org.example;

import java.util.NoSuchElementException;

public class OrderedPriorityQueue <E extends Comparable<E>>{
    private int size;
    private Node first;
    private Node last;
    public OrderedPriorityQueue(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }
    private class Node{
        E item;
        public Node(E item){
            this.item = item;
            this.next=this.previous=null;
        }
        Node next;
        Node previous;
    }
    public void insert(E newItem){
        if(newItem == null){
            throw new IllegalArgumentException("Inserted value shouldn't be null!!");
        }
        Node temp = new Node(newItem);
        if(size == 0){
            first=last=temp;
        }else if(newItem.compareTo(first.item) < 0){
            temp.next = first;
            first.previous = temp;
            first = temp;
        }else{
            Node current = first;
            while(current.next != null && current.next.item.compareTo(newItem) < 0){
                current = current.next;
            }
            temp.next = current.next;
            if(current.next != null){
                current.next.previous = temp;
            }
            current.next = temp;
            temp.previous = current;
            if(temp.next == null){
                last = temp;
            }
        }
        size++;
    }
    public E delMax(){
        if(last == null){
            throw new NoSuchElementException("No such elements remaining in the queue");
        }
        E temp = last.item;
        last = last.previous;
        if(last == null){
            first = null;
        }else{
            last.next = null;
        }
        size--;
        return temp;
    }
    public E delMin(){
        if(size == 0){
            throw new NoSuchElementException("No Elements in teh Priority Queue");
        }
        E temp = first.item;
        first = first.next;
        if(first == null){
            last = null;
        }else{
            first.previous = null;
        }
        size--;
        return temp;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public E getMax(){
        if(size == 0){
            throw new NoSuchElementException("No such elements in the queue");
        }
        return last.item;
    }
    public E getMin(){
        if(size == 0){
            throw new NoSuchElementException("No such elements in the queue");
        }
        return first.item;
    }
    public int getSize(){
        return this.size;
    }
    public void print(){
        Node current = last;
        while(current != null){
            System.out.println(current.item.toString());
            current = current.previous;
        }
        System.out.println("==========================");
    }
}
