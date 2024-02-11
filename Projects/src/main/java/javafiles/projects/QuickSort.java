/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafiles.projects;

/**
 *
 * @author Khaled
 */
public class QuickSort {
    private int[]arr ;
    private int numSwaps ;
    private int numCopies ;
    
    public QuickSort(int arr[]){
        this.arr = arr ;
        this.numCopies = 0 ;
        this.numSwaps = 0 ;
    }
    
    public void quickSort(String pivotType){
        recQuickSort(0 , arr.length - 1, pivotType  ) ;
    }
    
    public void recQuickSort(int low , int high, String pivotType){
        if(low >= high)
            return ;
        int pivotIndex = choosePivot(low , high, pivotType) ;
        int leftPointer = partition( low ,  high , pivotIndex) ;
        
        recQuickSort(low, leftPointer -1, pivotType ) ;
        recQuickSort( leftPointer +1 , high, pivotType) ;
        
    }
    
    public int choosePivot(int low , int high , String pivotType){
        switch(pivotType){
            case "first" :
                return low ;
            case "last" :
                return high ;
            case "random" :
                return (int)(Math.random()*(high - low + 1) - low) ;
            case "median" :
            {
                int mid = (high + low ) /2 ;
                
                if(arr[low] > arr[mid]){
                    swap(low, mid) ;
                    numSwaps++ ;
                }
                else if(arr[low] > arr[high]){
                    swap(low, high) ;
                    numSwaps++ ;
                }
                else if(arr[mid] > arr[high]){
                    swap(mid, high)  ;
                    numSwaps++ ;
                }
                
                swap(mid , high -1 ) ;
                numSwaps++ ;
                return (high -1) ;
                
            }
            
            default : {
                System.out.println("Invalid pivot type!!");
                return high ;
            }
        }
    }
    
    public int partition(int low , int high , int pivotIndex){
        swap(pivotIndex , high) ;
        numSwaps++ ;
        int pivot = high ;
        
        int leftPointer = low ;
        int rightPointer = high ;
        
        while(leftPointer < rightPointer ){
            
            while(leftPointer < rightPointer && arr[leftPointer] <= arr[pivot])
                leftPointer++ ;
            while(arr[rightPointer] >= arr[pivot] && leftPointer < rightPointer)
                rightPointer-- ;
            
            swap(leftPointer , rightPointer) ;
            numSwaps++ ;
            
            numCopies++ ;
        }
        
        swap(leftPointer , pivot) ;
        numSwaps++ ;
        return leftPointer ;
    }
    
    public void swap(int index1 , int index2){
        int temp = arr[index1] ;
        arr[index1] = arr[index2] ;
        arr[index2] = temp ;
    }
}

