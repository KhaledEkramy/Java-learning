/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package javafiles.priorityqueue;

/**
 *
 * @author Khaled
 */
public class PriorityQueue {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        priQue obj = new priQue(5) ;
        
        obj.remove() ;
        System.out.println("Before remove : ");
        obj.insPriQue(30);
        obj.insPriQue(20);
        obj.insPriQue(25);
        obj.insPriQue(10);
        obj.insPriQue(15);
        obj.insPriQue(5);
        System.out.println("After remove : ");
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        System.out.println(obj.remove());
    }
}
