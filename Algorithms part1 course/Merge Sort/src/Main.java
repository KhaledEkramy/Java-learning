import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"Khaled", "Ahmed", "Mohamed", "Ebrahim", "Emad", "Bahaa", "Ali", "Abdelfattah", "Nader", "Hassan", "Ziad", "Hany", "Nagy", "Karim"} ;
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr)); ;
        //////
        //Testing partially sorted array
        Integer[] arr2= {4,6,2,7,1,0, 9, 10, 11, 12} ;
        NonRecursiveMergeSort.sort(arr2) ;
        System.out.println(Arrays.toString(arr2));
        //////////
        //Testinng NonRecursiveMergeSort :
        Integer[] testArray = {78, 45, 23, 56, 90, 12, 67, 34, 89, 5, 72, 31, 17, 83, 49, 25, 60, 8, 41, 98,
                15, 79, 37, 63, 21, 94, 53, 28, 70, 3, 88, 46, 11, 66, 32, 18, 75, 42, 7, 54,
                87, 24, 58, 93, 39, 76, 2, 68, 35, 81, 47, 14, 61, 27, 64, 9, 74, 20, 96, 52,
                30, 65, 36, 80, 16, 73, 40, 6, 82, 19, 95, 50, 26, 59, 4, 77, 22, 55, 91, 38,
                84, 1, 57, 29, 85, 43, 10, 69, 33, 92, 48, 13, 71, 44, 86, 62, 99, 74, 98};
        NonRecursiveMergeSort.sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}