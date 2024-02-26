package org.example;

public class BinaryHeap {
    private int[] array;
    private int capacity;
    private int numOfExistedElements;
    public BinaryHeap(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
        this.numOfExistedElements = 0;
    }
    public void insert(int element){
        array[++numOfExistedElements] = element;
        swim(numOfExistedElements);
    }
    private void swim(int k){
        while(k > 1 && array[k] > array[k/2]){
            swap(k, k/2);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k <= numOfExistedElements){
            int j = 2*k;
            if(j < numOfExistedElements && array[j+1] > array[j]){
                j++;
            }
            if(array[k] > array[j]){
                break;
            }
            swap(j, k);
            k = j;
        }
    }
    public boolean isEmpty(){
        return this.numOfExistedElements == 0;
    }
    public int delMax(){
        int max = array[1];
        swap(1, numOfExistedElements--);
        sink(1);
//        array[numOfExistedElements+1]=null;
        return max;
    }
    public int delMin(){
        int min = array[numOfExistedElements--];
//        array[numOfExistedElements+1]=null;
        return min;
    }
    public int getNumOfExistedElements(){
        return this.numOfExistedElements;
    }
    private void swap(int i, int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("Array is empty!!");
        } else {
            recursivePrint(1);
        }
        System.out.println();
    }
    public void recursivePrint(int position){
        if(position > numOfExistedElements){
            return;
        }
        System.out.println(array[position] + "\t");
        recursivePrint(2*position);
        recursivePrint(2*position+1);

    }
}
