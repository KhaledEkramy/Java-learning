import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ResizedQueueArray <T> implements Iterable<T>{
    private T[] items;
    private int N ;
    private int front ;
    private int rear;

    public Iterator<T> iterator(){ return new Iterator<T>(){
        private int numOfElements = N ;
        private int currentFront = front ;

        @Override
        public boolean hasNext(){
            return this.numOfElements != 0 ;
        }
        @Override
        public T next(){
            if (!hasNext()) {
                throw new NoSuchElementException("Queue is empty");
            }

            try {
                T data = items[currentFront];
                currentFront = (currentFront + 1) % items.length;
                numOfElements--;
                return data;
            } catch (NullPointerException e) {
                // Log or handle the exception appropriately
                throw new NoSuchElementException("Error retrieving element");
            }
        }
        };
    }
    public ResizedQueueArray(){
        this.items = (T[]) new Object[1] ;
        this.N = 0 ;
        this.front = -1 ;
        this.rear = -1 ;
    }

    public boolean isEmpty(){
        return this.N == 0;
    }
    public void enqueue(T data) {
        if (isEmpty()) {
            this.front = 0;
            this.rear = 0;
        } else {
            if (N == items.length) {
                resize(2 * items.length);
            }
            rear = (rear + 1) % items.length;  // Circular increment
        }
        this.items[rear] = data;
        N++ ;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("No more elements in the Queue!!");
            return null;
        }
        T tempData = this.items[front];
        front = (front + 1) % items.length;  // Circular increment
        if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }
        N-- ;
        return tempData;
    }

    public void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        int current = front;

        for (int i = 0; i < N; i++) {
            copy[i] = items[current];
            current = (current + 1) % items.length;  // Circular increment
        }

        items = copy;
        front = 0;
        rear = N - 1;
    }


    public void print(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int current = front ;
        for(int i = 0 ; i < N ; i++){
            System.out.print(items[current].toString() + "\t");
            current = (current+1) % (items.length) ;
        }
        System.out.println();
    }
}
