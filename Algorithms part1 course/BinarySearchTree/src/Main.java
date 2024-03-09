public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(1,"Khaled");
        bst.put(1, "Ahmed");
        bst.put(6, "Mohamed");
        bst.put(2, "Hassan");
        bst.put(3, "Ali");
        bst.put(8, "Ebrahim");
        System.out.println(bst.valueIterator().toString());
    }
}