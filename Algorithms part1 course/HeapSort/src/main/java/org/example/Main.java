package org.example;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 33, 7, 32, 9, 2, 1, 8, 3, 5, 7};
        HeapSort obj = new HeapSort();
        obj.sort(arr);
        for(int i = 0 ;i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}