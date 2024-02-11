/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafiles.priorityqueue;

/**
 *
 * @author Khaled
 */
public class priQue {
    private int maxSize ;
    private int arr[] ;
    private int nItems ;
    
    public priQue(int max) {
        this.maxSize = max ;
        this.arr = new int[maxSize] ;
        this.nItems = 0 ;
    }
    
    public boolean isEmpty(){
        return nItems == 0 ;
    }
    
    public boolean isFull(){
        return nItems == maxSize ;
    }
    
    public void insPriQue(int item){
        if(isEmpty())
            arr[nItems++] = item ;
        else if(isFull())
                System.out.println("Array is already full !!");
        else{
            int i = 0 ;
            for (i = nItems -1; i >= 0;i--) {
                if(item > arr[i])
                    arr[i+1] = arr[i] ;
                else
                    break ;
            }
            arr[i+1] = item ;
            nItems++ ;
        }
    }
    
    public int remove(){
        if(isEmpty()){
            System.out.println("Array is already Empty !!");
            return -1;
        }else{
            
            return arr[--nItems] ;
        }
    }
    
    public int peek(){
        return arr[nItems -1] ;
    }
    
    
    
    
    
    
    
    
}
