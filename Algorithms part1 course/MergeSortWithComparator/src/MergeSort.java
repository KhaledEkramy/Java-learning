import java.util.Comparator;

public class MergeSort{
    public static <T> void sort(T[] arr, Comparator comparator){
        T[] aux = (T[]) new Object[arr.length] ;
        sort(arr,aux,0,arr.length-1, comparator) ;
    }
    public static <T> void sort(T[] arr, T[] aux, int low, int high, Comparator comparator){
        if(low >= high){
            return ;
        }
        int mid = low + (high - low) / 2 ;
        sort(arr, aux, low, mid, comparator) ;
        sort(arr, aux, mid+1, high, comparator) ;
        merge(arr, aux, low, mid, high, comparator) ;
    }
    public static <T> void merge(T[] arr, T[] aux, int low , int mid, int high, Comparator comparator){
        for(int i = low; i <= high; i++){
            aux[i] = arr[i] ;
        }
        int leftPointer = low , rightPointer = mid + 1 ;
        for(int i = low; i <= high; i++){
            if(leftPointer > mid){
                arr[i] = aux[rightPointer++] ;
            }else if(rightPointer > high){
                arr[i] = aux[leftPointer++] ;
            }else if(comparator.compare(aux[rightPointer], aux[leftPointer]) < 0){
                arr[i] = aux[rightPointer++] ;
            }else{
                arr[i] = aux[leftPointer++] ;
            }
        }
    }
}
