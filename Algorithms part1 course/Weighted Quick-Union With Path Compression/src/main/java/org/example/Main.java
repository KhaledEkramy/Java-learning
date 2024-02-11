package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;

        System.out.println("Enter number of Items ") ;
        int N = input.nextInt();

        WeightedQUPC test = new WeightedQUPC(N);

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
        for(int i = 0 ; i < 5 ; i++){
            System.out.println("Enter the number to find the max connected element");
            int element = input.nextInt();
            System.out.println("The max element in the connection is " + test.find(element));
        }

//        System.out.println("Enter number of rows in the Grid");
//        int N = input.nextInt();
//        Percolation percolation = new Percolation(N);
//
//        while (!percolation.percolates()) {
//            int randomRow = (int) (Math.random() * N) + 1;  // Random row between 1 and N
//            int randomCol = (int) (Math.random() * N) + 1;  // Random col between 1 and N
//
//            if (!percolation.isOpen(randomRow, randomCol)) {
//                percolation.open(randomRow, randomCol);
//            }
//        }
//
//        // System percolates - print results
//        System.out.println("Number of open sites: " + percolation.numberOfOpenSites());
//        System.out.println("Does the system percolate? " + percolation.percolates());
    }
}