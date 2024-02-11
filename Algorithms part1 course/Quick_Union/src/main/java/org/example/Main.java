package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;

        System.out.println("Enter number of Items ") ;
        int N = input.nextInt();

        QuickUnionUF test = new QuickUnionUF(N);

        System.out.println("Enter number of queries : ");
        int queries = input.nextInt() ;
        while(queries-- > 0){
            System.out.println("Enter query : ") ;
            int p = input.nextInt();
            int q = input.nextInt();
            if(!test.connected(p,q)){
                test.union(p,q);
                System.out.println("Connecting " + p + " to " + q);
            }else{
                System.out.println(p + " and " + q + " are already connected");
            }
        }

    }
}