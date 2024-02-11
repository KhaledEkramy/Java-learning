/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package javafiles.projects;

/**
 *
 * @author Khaled
 */
public class Projects {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        int arr[] = {1, 4, 2, 6, -1, 3, 23 , 32 } ;
        
        QuickSort obj = new QuickSort(arr) ;
        
        obj.quickSort("last");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
