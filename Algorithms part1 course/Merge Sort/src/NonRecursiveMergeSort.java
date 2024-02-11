public class NonRecursiveMergeSort {
    private static final int cuttofInsertion = 7 ;
    public static <T extends Comparable<T>> void sort(T[] arr){
        Comparable[] aux = new Comparable[ arr.length] ;
        int size = arr.length ;
        for(int len = 1; len < size ; len *= 2){
            for(int low = 0; low < size-len; low += (len*2)){
                int high = Math.min((low + len + len -1),size-1) ;
                merge(arr, (T[])aux, low,low + len -1, high);
            }
        }
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
