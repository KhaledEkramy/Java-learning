import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;

public class QuickSortAlgorithm {
    private static final int CUTTOF = 10 ;
    public static int swapping = 0 ;
    public static<T extends Comparable<T>> void sort(T[] arr){
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length-1);
    }
    private static<T extends Comparable<T>> void sort(T[] arr, int low, int high ){
//        if(low >= high) { //1- first improvement: replacing this condition with CUTTOF condition
//            return ;
//        }
////
        if(high <= CUTTOF + low -1){//Improve code with about 20% of the original one.
            insertionSort(arr,low,high);
            return;
        }
        int j = partition(arr, low, high);
        sort(arr,low,j-1);
        sort(arr, j+1, high);
    }
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high){
        int i = low, j = high+1;
        while(true){
            while(arr[++i].compareTo(arr[low]) < 0){
                if(i == high){
                    break;
                }
            }
            while(arr[--j].compareTo(arr[low]) > 0){
                if(j == low) {
                    break;
                }
            }
            if(j <= i)
                break;
            swap(arr, i, j);
            swapping++;
        }
        swap(arr, low, j);
        swapping++;
        return j ;
    }
    private static <T extends Comparable<T>> void insertionSort(T[] arr, int low, int high){
        for(int i = low ; i <= high; i++){
            int j = i ;
            while(j > 0 && arr[j].compareTo(arr[j-1]) < 0){
                swap(arr,j,j-1);
                j--;
            }
        }
    }
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j){
        T temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }

}
