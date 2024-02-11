package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
                System.out.println("Enter number of rows in the Grid");
                int N = input.nextInt();
                Percolation percolation = new Percolation(N);

                while (!percolation.percolates()) {
                    int randomRow = (int) (Math.random() * N) + 1;  // Random row between 1 and N
                    int randomCol = (int) (Math.random() * N) + 1;  // Random col between 1 and N

                    if (!percolation.isOpen(randomRow, randomCol)) {
                        percolation.open(randomRow, randomCol);
                    }
                }

                // System percolates - print results
                System.out.println("Number of open sites: " + percolation.numberOfOpenSites());
                System.out.println("Does the system percolate? " + percolation.percolates());
                input.close();



    }
}