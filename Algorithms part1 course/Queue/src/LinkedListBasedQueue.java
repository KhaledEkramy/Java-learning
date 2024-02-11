import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListBasedQueue <T> implements Iterable<T>{
    private Node first ;
    private Node last ;
    public LinkedListBasedQueue(){
        this.first = null ;
    }
    private class Node{
        T data ;
        Node next ;
    }
    @Override
    public Iterator<T> iterator(){
        return new Iterator(){
            private Node current = first ;
            @Override
            public boolean hasNext(){
                return current != null ;
            }
            @Override
            public T next(){
                if(!hasNext()){
                    throw new NoSuchElementException("No existed elements in the Queue!!") ;
                }
                T data = current.data ;
                current = current.next ;
                return data ;
            }
        };
    }
    public boolean isEmpty(){
        return this.first == null ;
    }
    public void enqueue(T data){
        if(isEmpty()){
            first = new Node() ;
            first.data = data ;
            first.next = null ;
            last = first ;
            return ;
        }
        Node oldLast = last ;
        last = new Node() ;
        last.data = data ;
        last.next = null ;
        oldLast.next = last ;
    }

    public T dequeue(){
        if(isEmpty()) {
            return null;
        }
        T data = first.data ;
        first = first.next ;
        if(isEmpty()){
            this.last = null ;
        }
        return data ;
    }

    public void print(){
        Node current = first ;
        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.next ;
        }
        System.out.println();
    }
}
