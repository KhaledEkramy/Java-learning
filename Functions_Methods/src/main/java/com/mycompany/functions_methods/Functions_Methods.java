package com.mycompany.functions_methods;

import java.util.Scanner;
import java.util.List ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Collection ;
import java.util.LinkedList ;
import java.util.Iterator ;
import java.util.HashMap ;
import java.util.Map ;
import java.lang.Iterable ;
public class Functions_Methods {
    public static void main(String[] args) {
//        int arr[] = {1, 3, 5, 5} ;
//        ArrayList<Integer> best = new ArrayList<Integer>() ;
//        best.add(3) ;
//        best.add(4) ;
        LinkedList linked = new LinkedList<Integer>() ;

        linked.addLast(1); ;
        linked.offer(2) ;
        linked.addLast(3) ;
        linked.addLast(5) ;
        Iterator iterator = linked.iterator() ;
        while(!linked.isEmpty()){
            System.out.println(linked.poll());
        }
//        Collections.addAll(best , 1,3,5,5) ;
//        for(int i = 0 ; i < best.size() ; i++){
//            best.remove(i);
//            System.out.println(i);
//        }
//        System.out.println(best.subList(0,2));
//        Integer x = 3 ;
//        best.remove(x) ;
//        System.out.println(best);
//        List list = new ArrayList<Integer>() ;
//        list.add(5) ;
//        list.add(10) ;
//        list.add(20) ;
//        list.add(1,3) ;// we cannot do this with
//        list.set(0,2) ;
//        list.remove(2) ;
//        for(var items : list){
//            System.out.println(items);
//        }
//        System.out.println(list.subList(0,3));
//        LinkedList list2 = new LinkedList<Integer>() ;
//        list2.addFirst(20);

    }
}
