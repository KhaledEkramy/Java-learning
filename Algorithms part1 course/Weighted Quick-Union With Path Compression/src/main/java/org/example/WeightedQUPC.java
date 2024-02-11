package org.example;

public class WeightedQUPC {
    private int id[] ;
    private int size[] ;
    private int maxElement[] ;

    public WeightedQUPC(int N){
        this.id = new int[N];
        this.size = new int[N];
        this.maxElement = new int[N];
        for(int i = 0 ; i < N ; i++){
            this.id[i] = i ;
            this.size[i] = 1 ;
            this.maxElement[i] = i ;
        }
    }

    public int root(int element){
        while(element != this.id[element]){
            this.id[element] = this.id[this.id[element]] ;
            element = this.id[element] ;
        }
        return element ;
    }
    public int find(int element){
        return this.maxElement[root(element)];
    }
    public boolean connected(int p , int q){
        return root(p) == root(q) ;
    }
    public void union(int p , int q) {
        if (connected(p, q)) {
            return;
        }
        int rootP = root(p);
        int rootQ = root(q);
        if (this.size[rootP] < this.size[rootQ]) {
            this.id[rootP] = rootQ;
            this.size[rootQ] += this.size[rootP];
            this.maxElement[rootQ] = Math.max(this.maxElement[rootP], this.maxElement[rootQ]);
        }else{
            this.id[rootQ] = rootP ;
            this.size[rootP] += this.size[rootQ] ;
            this.maxElement[rootP] = Math.max(this.maxElement[rootP], this.maxElement[rootQ]);
        }
    }
}
