public class LinkedListBasedStack<T>{
    private Node first ;
    public LinkedListBasedStack(){
        first = null;
    }
    private class Node{
        T data ;
        Node next ;
    }
    public void push(T data){
        Node oldFirst = first ;
        first = new Node();
        first.data = data ;
        first.next = oldFirst ;
    }

    public T pop(){
        T data = first.data ;
        first = first.next ;
        return data ;
    }
    public boolean isEmpty(){
        return this.first == null ;
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
