public class Sorting{
    public static <T extends Comparable<T>> void selectionSort(T[] arr){ // The two key properties of the selection sort is: find the smallest element in the array then swap it with position i.
        int N = arr.length ;
        for(int i = 0 ; i < N-1 ; i++){
            int mnIdx = i ;
            for(int j = i+1 ; j < N ; j++) {
                if (arr[j].compareTo(arr[mnIdx]) < 0){
                    mnIdx = j ;
                }
            }
            swap(arr,i,mnIdx) ;
        }
    }
    public static <T extends Comparable<T>> void insertionSort(T[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            int j = i ;
            while(j > 0 && arr[j].compareTo(arr[j-1]) < 0){
                swap(arr , j , j-1) ;
                j-- ;
            }
        }
    }
    public static <T extends Comparable<T>> void shellSort(T[] arr){
        int N = arr.length ;
        int h = 1 ;
        while(h < N/3){
            h = 3*h+1 ;
        }
        while(h > 0){
            for(int i = h ; i < N ;i++){
                int j = i ;
                while(j >= h && arr[j].compareTo(arr[j-h])<0){
                    swap(arr, j, j-h) ;
                    j = j-h ;
                }
            }
            h = h/3 ;
        }
    }
    public static <T extends Comparable<T>> void shuffling(T[] arr){
        int[] shuffleArr = new int[arr.length];
        for(int i = 0 ; i < arr.length ;i++){
            int value = (int)(Math.random()*(arr.length+1)) ;
            shuffleArr[i] = value ;
        }
        int N = arr.length ;
        int h = 1 ;
        while(h < N/3){
            h = 3*h+1 ;
        }
        while(h > 0){
            for(int i = h ; i < N ;i++){
                int j = i ;
                while(j >= h && shuffleArr[j] - shuffleArr[j-h] <0){
                    swap(arr, j, j-h) ;
                    j = j-h ;
                }
            }
            h = h/3 ;
        }
    }
    public static <T extends Comparable<T>> void constShuffling(T[] arr){
        for(int i = 0 ; i < arr.length ;i++){
            int index = (int)(Math.random()*(i+1));
            swap(arr, index, i) ;
        }
    }
    public static <T extends Comparable<T>> void swap(T[] arr, int i , int j){
        T temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }

}
