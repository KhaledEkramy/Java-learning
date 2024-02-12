import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[12];
        students[0] = new Student("Carl", 331, 20);
        students[1] = new Student("Bob", 632, 21);
        students[2] = new Student("Mohamed", 345, 19);
        students[3] = new Student("Ebrahim", 363, 22);
        students[4] = new Student("Khaled", 134, 20);
        students[5] = new Student("Ahmed", 634, 23);
        students[10] = new Student("Ahmed", 637, 24);
        students[11] = new Student("Ahmed", 633, 23);
        students[6] = new Student("Naeem", 134, 19);
        students[7] = new Student("Hassan", 108, 21);
        students[8] = new Student("Ian", 242, 22);
        students[9] = new Student("Bahaa", 227, 20);
        System.out.println(Arrays.toString(students));
        MergeSort.sort(students,Student.BY_NAME);
        System.out.println(Arrays.toString(students));
        MergeSort.sort(students, Student.BY_AGE);
        System.out.println(Arrays.toString(students));
        MergeSort.sort(students, Student.BY_ID);
        System.out.println(Arrays.toString(students));
    }
}