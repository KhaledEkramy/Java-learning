public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(2, "Hassan");
        bst.put(1, "Khaled");
        bst.put(3, "Ali");
        bst.put(6, "Mohamed");
        bst.put(8, "Ebrahim");
        bst.put(1, "Ahmed");
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());
        bst.delete(6);
        bst.delete(8);
//        bst.delete(1);
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());
        bst.delete(6);
        bst.delete(3);
        bst.delete(1);
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());
    }
}