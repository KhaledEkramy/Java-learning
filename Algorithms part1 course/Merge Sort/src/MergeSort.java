 public class MergeSort{
    private final static int cuttofInsertion = 7 ;
    public static <T extends Comparable<T>> void sort(T[] arr){
        Comparable[] aux = new Comparable[ arr.length] ;
        sort(arr, (T[])aux, 0, arr.length -1) ;
    }
    public static<T extends Comparable<T>> void sort(T[] arr, T[] aux, int low, int high) {
//        if(low >= high){
//            return ;
//        }
        if(high <= low + cuttofInsertion - 1){ //This is one of the improvments which replaced the previous three lines with efficient code.
            insertionSort(arr, low, high) ; //Merge sort is a complex algorithm for simple set of numbers so insertion sort is a good one for these.
            return ;
        }
        int mid = low + (high - low) / 2 ;
        sort(arr, aux, low, mid) ;
        sort(arr, aux, mid+1, high) ;

        if(arr[mid].compareTo(arr[mid+1]) < 0){ //second improvment: Stop if it's already sorted
            return;
        }

        merge(arr, aux, low, mid, high) ;
    }
    public static<T extends Comparable<T>> void merge(T[] arr, T[] aux, int low, int mid, int high){
        //Precondition to assert that the two needed merging parts already sorted
        assert isSorted(arr, low, mid);
        assert isSorted(arr, mid+1, high);

        //Coping elements to aux array from arr
        for (int k = low; k <= high; k++)
            aux[k] = arr[k];
        int i = low, j = mid+1;
        for (int k = low; k <= high; k++)
        {
            if(i > mid){
                arr[k] = aux[j++] ;
            }else if(j > high){
                arr[k] = aux[i++] ;
            }else if(aux[i].compareTo(aux[j]) < 0){
                arr[k] = aux[i++] ;
            }else{
                arr[k] = aux[j++] ;
            }
        }
        assert isSorted(arr, low, high) ; //Post condition to assert that the finally merged part become sorted
    }

    public static<T extends Comparable<T>> void insertionSort(T[] arr, int low, int high){
        for(int i = low+1 ;i <= high ;i++){
            int j = i ;
            while(j > low && arr[j].compareTo(arr[j-1]) < 0){
                swap(arr, j, j-1) ;
                j-- ;
            }
        }
    }
    private static<T extends Comparable<T>> boolean isSorted(T[] arr, int low, int high){
        for(int i = low+1; i <= high; i++){
            if(arr[i].compareTo(arr[i-1]) < 0){
                return false ;
            }
        }
        return true ;
    }
     private static <T extends Comparable<T>> void swap(T[] arr, int i , int j){
         T temp = arr[i] ;
         arr[i] = arr[j] ;
         arr[j] = temp ;
     }

}
