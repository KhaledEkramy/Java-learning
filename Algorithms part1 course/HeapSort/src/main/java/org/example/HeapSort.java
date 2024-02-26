package org.example;

public class HeapSort {
    private int size;
    private int[] arr;
    public void sort(int[] arr){
        this.size = arr.length;
        this.arr = arr;
        bottomUp();
        while(size > 1){
            swap(1, size--);
            sink(1);
        }
    }
    private void swim(int[] arr, int k){
        while(k > 1 && !less(k, k/2)) {
            swap(k, k / 2);
            k=k/2;
        }
    }
    private void bottomUp(){
        for(int i = size/2; i >= 1; i--){
            sink(i);
        }
    }
    private void sink(int k){
        while(2*k <= size){
            int j = 2*k;

            if(j < size && less(j,j+1))
                j++;
            if(less(j, k)){
                break;
            }
            swap(j, k);
            k = j;
        }
    }
    private void swap(int i, int j){
        i--;
        j--;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private boolean less(int i, int j){
        i--;
        j--;
        return arr[i] < arr[j];
    }

}
