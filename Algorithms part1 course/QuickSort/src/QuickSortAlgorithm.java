import edu.princeton.cs.algs4.StdRandom;
public class QuickSortAlgorithm {
    public static int swapping = 0 ;
    public static void sort(int[] arr){
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length-1);
    }
    private static void sort(int[] arr, int low, int high ){
        if(low >= high) {
            return ;
        }
        int j = partition(arr, low, high);
        sort(arr,low,j-1);
        sort(arr, j+1, high);
    }
    private static int partition(int[] arr, int low, int high){
        int i = low, j = high+1;
        while(true){
            while(arr[++i] < arr[low]){
                if(i == high){
                    break;
                }
            }
            while(arr[--j] > arr[low]){
                if(j == low) {
                    break;
                }
            }
            if(i >= j)
                break;
            swap(arr, i, j);
            swapping++;
        }
        swap(arr, low, j);
        swapping++;
        return j ;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    public static void shuffling(int[] arr){
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
                    swapping++;
                    j = j-h ;
                }
            }
            h = h/3 ;
        }
    }
}
