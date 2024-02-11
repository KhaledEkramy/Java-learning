import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int numOfElements;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.items = (Item[]) new Object[1];
        this.numOfElements = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return this.numOfElements == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return this.numOfElements;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (numOfElements == items.length) {
            resize(2 * items.length);
        }
        if (isEmpty()) {
            this.items[0] = item;
            numOfElements++;
            return;
        }
        int randomIndex = StdRandom.uniformInt(numOfElements);
        Item temp = items[randomIndex];
        items[randomIndex] = item;
        items[numOfElements++] = temp;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (numOfElements == items.length / 4) {
            resize(items.length / 2);
        }
        int randomIndex = StdRandom.uniformInt(numOfElements);
        Item returnedData = items[randomIndex];
        items[randomIndex] = items[--numOfElements];
        items[numOfElements] = null;
        return returnedData;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, copy, 0, numOfElements);
        items = copy;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[StdRandom.uniformInt(numOfElements)];
    }

    // unit testing (required)
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>();
    }

    private class ListIterator<E> implements Iterator<E> {
        private int it;
        private final int[] randIdx;

        public ListIterator() {
            this.it = 0;
            this.randIdx = new int[numOfElements];
            for (int i = 0; i < numOfElements; i++) {
                this.randIdx[i] = i;
            }
            StdRandom.shuffle(randIdx);
        }

        @Override
        public boolean hasNext() {
            return it < numOfElements;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) items[randIdx[it++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue;

        queue = new RandomizedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        for (Integer element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();

        queue = new RandomizedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        queue = new RandomizedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());

        queue = new RandomizedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.sample());
    }
}
