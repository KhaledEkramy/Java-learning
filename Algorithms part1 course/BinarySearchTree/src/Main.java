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
        bst.deleteMin();
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());

        bst.deleteMin();
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());
        bst.deleteMin();
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());
        bst.deleteMin();
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());
        bst.put(4, "Bola");
        System.out.println(bst.valueIterator().toString());
        System.out.println(bst.size());
    }
}