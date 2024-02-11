import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr= {1, 2, 6, 2, 1, 6, 3} ;
//        Sorting.shuffling(arr);
//        System.out.println(Arrays.toString(arr));
        /////////////////////////////////////////
//        Sorting.selectionSort(arr);
//        Sorting.insertionSort(arr) ;
        ///////////////////////////
        /*
        System.out.println(Arrays.toString(arr));
        Sorting.shellSort(arr) ;
        System.out.println(Arrays.toString(arr));
         */
        ///////////////////////////////////////////
        Sorting.constShuffling(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}