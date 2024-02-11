public class ResizedStackArray <Item>{
    private Item[] Items ;
    private int N = 0 ;
    public ResizedStackArray(){
        Items = (Item[]) new Object[1] ;
    }
    public void resize(int capacity){
        Item[] copy = (Item[]) new Object[capacity] ;
        for(int i = 0 ; i < N ; i++){
            copy[i] = Items[i];
        }
        Items = copy;
    }

    public void push(Item item){
        if(N == Items.length){
            resize(2 * N) ;
        }
        Items[N++] = item ;
    }

    public Item pop(){
        if(N > 0 && N == Items.length / 4){
            resize(Items.length / 2);
        }
        Item item = Items[--N];
        Items[N] = null ;
        return item ;
    }

    public boolean isEmpty(){
        return N == 0 ;
    }
    public void print(){
        for(int i = 0 ; i < N ;i++){
            System.out.print(Items[i] + "\t");
        }
        System.out.println();
    }
}
