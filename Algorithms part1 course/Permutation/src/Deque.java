import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private class Node {
        Item data;
        Node next;
        Node previous;

        public Node() {
            this.data = null;
            this.next = null;
            this.previous = null;
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node();
        first.data = item;
        first.next = oldFirst;
        if (last == null) {
            last = first;
        } else {
            first.next.previous = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldLast = last;
        last = new Node();
        last.data = item;
        last.previous = oldLast;
        if (first == null) {
            first = last;
        } else {
            last.previous.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item returnedData = first.data;
        size--;
        if (isEmpty()) {
            first = last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        return returnedData;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item returnedData = last.data;
        size--;
        if (isEmpty()) {
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        return returnedData;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            Node current = first;

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item returnData = current.data;
                current = current.next;
                return returnData;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deq = new Deque<>();
        deq.addFirst(15);
        deq.addFirst(20);
        deq.addLast(25);
        for (var it : deq) {
            System.out.print(it.toString() + "\t");
        }
        System.out.println();
        System.out.println(deq.removeFirst());
        System.out.println(deq.removeLast());
        for (var it : deq) {
            System.out.print(it.toString() + "\t");
        }
        System.out.println();
        System.out.println(deq.removeFirst());
        System.out.println(deq.isEmpty());
    }
}
