package org.example;

public class QuickUnionUF {
    private int id[] ;
    QuickUnionUF(int N){
        this.id = new int[N] ;
        for(int i = 0 ; i < N ; i++){
            this.id[i] = i ;
        }
    }

    private int root(int element){
        int index = element ;
        while(index != id[index]){
            index = id[index] ;
        }
        return index ;
    }

    public boolean connected(int p , int q){
        return root(p) == root(q) ;
    }

    public void union(int p , int q){
        int pRoot = root(p) ;
        int qRoot = root(q) ;
        id[pRoot] = qRoot ;
    }
}
