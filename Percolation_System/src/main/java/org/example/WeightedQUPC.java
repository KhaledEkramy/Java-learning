package org.example;
public class WeightedQUPC {
    private int id[];
    private int size[];
    private int maxElem[];
    public WeightedQUPC(int N){
        this.id = new int[N] ;
        this.size = new int[N] ;
        this.maxElem = new int[N] ;
        for(int i = 0 ; i < N ; i++){
            this.id[i] = i ;
            this.size[i] = 1 ;
            this.maxElem[i] = i ;
        }
    }
    public int find(int num){ // to find the max element in connected component {1, 2, 3 } = 3
        return maxElem[root(num)] ;
    }
    private int root(int element){
        while(element != id[element]){
            id[element] = id[id[element]] ;
            element = id[element] ;
        }
        return element ;
    }

    public boolean connected(int p , int q){
        return root(p) == root(q) ;
    }

    public void union(int p , int q){
        int pRoot = root(p) ;
        int qRoot = root(q) ;
        if(pRoot == qRoot){return;}
        if(size[pRoot] > size[qRoot]){
            id[qRoot] = pRoot ;
            size[pRoot] += size[qRoot] ;
            maxElem[pRoot] = Math.max(maxElem[pRoot] , maxElem[qRoot]) ;
        }else{
            id[pRoot] = qRoot ;
            size[qRoot] += size[pRoot] ;
            maxElem[qRoot] = Math.max(maxElem[pRoot] , maxElem[qRoot]) ;
        }

    }
}

