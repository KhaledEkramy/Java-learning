import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 6, 2, 8, 3, 9, 4, 7, 5, 10, 11, 16, 12, 18, 13, 19, 14, 17, 15, 20,
                21, 26, 22, 28, 23, 29, 24, 27, 25, 30, 31, 36, 32, 38, 33, 39, 34, 37, 35, 40,
                41, 46, 42, 48, 43, 49, 44, 47, 45, 50, 51, 56, 52, 58, 53, 59, 54, 57, 55, 60,
                61, 66, 62, 68, 63, 69, 64, 67, 65, 70, 71, 76, 72, 78, 73, 79, 74, 77, 75, 80,
                81, 86, 82, 88, 83, 89, 84, 87, 85, 90, 91, 96, 92, 98, 93, 99, 94, 97, 95, 100};
        QuickSortAlgorithm.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(QuickSortAlgorithm.swapping);

        String[] names = {
                "Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Charlotte", "William", "Sophia",
                "James", "Amelia", "Benjamin", "Isabella", "Lucas", "Mia", "Henry", "Evelyn", "Alexander", "Harper",
                "Mason", "Camila", "Michael", "Abigail", "Ethan", "Ella", "Daniel", "Emily", "Jacob", "Scarlett",
                "Logan", "Madison", "Jackson", "Luna", "Sebastian", "Grace", "Aiden", "Chloe", "Matthew", "Penelope",
                "Samuel", "Layla", "David", "Riley", "Joseph", "Zoey", "Carter", "Nora", "Owen", "Lily"
        };
        QuickSortAlgorithm.sort(names);
        System.out.println(Arrays.toString(names));
    }
}