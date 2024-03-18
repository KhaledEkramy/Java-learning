import java.util.ArrayList;
import java.util.List;

public class LLRBBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        private final Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int count;
        public Node(Key key, Value value, boolean color, int count){
            this.count = count;
            this.key= key;
            this.value = value;
            this.color = RED;
        }
    }
    private Value get(Key key){
        if(root == null)
            return null;
        Node current = root;
        while(current != null){
            int cmp = key.compareTo(current.key);
            if(cmp < 0)
                current = current.left;
            else if(cmp > 0)
                current = current.right;
            else
                return current.value;
        }
        return null;
    }
    private boolean isRed(Node x){
        if(x == null)
            return false;
        return x.color == RED;
    }
    private Node rotateLeft(Node h){
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;

        h.count = 1 + size(h.left) + size(h.right);
        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }
    private Node rotateRight(Node h){
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;

        h.count = 1 + size(h.left) + size(h.right);
        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }
    private void flipColors(Node h){
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }
    private Node put(Node current, Key key, Value value){
        if(current == null)
            return new Node(key, value, RED, 1);
        int cmp = key.compareTo(current.key);
        if(cmp < 0)
            current.left = put(current.left, key, value);
        else if(cmp > 0)
            current.right = put(current.right, key, value);
        else
            current.value = value;

        if(isRed(current.right) && !isRed(current.left))
            current = rotateLeft(current);
        if(isRed(current.left) && isRed(current.left.left))
            current = rotateRight(current);
        if(isRed(current.left) && isRed(current.right))
            flipColors(current);
        current.count = 1 + size(current.left) + size(current.right);
        return current;
    }

    public Value getMin(){
        if(root == null){
            return null;
        }
        Node current = getMin(root);
        return current.value;
    }
    private Node getMin(Node current){
        if(current == null)
            return null;
        if(current.left == null)
            return current;
        return getMin(current.left);
    }
    public Value getMax(){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.value;
    }
    public Value floor(Key key){
        Node current = floor(root, key);
        if(current == null){
            return null;
        }
        return current.value;
    }
    private Node floor(Node current, Key key){
        if(current == null){
            return null;
        }
        int cmp = key.compareTo(current.key);
        if(cmp == 0)
            return current;
        if(cmp < 0)
            return floor(current.left, key);
        Node test = floor(current.right, key);
        if(test != null)
            return test;
        return current;
    }
    public Value ceil(Key key){
        Node result = ceil(root, key);
        if(result == null){
            return null;
        }
        return result.value;
    }
    private Node ceil(Node current, Key key){
        if(current == null)
            return null;
        int cmp = key.compareTo(current.key);
        if(cmp == 0){
            return current;
        }
        if(cmp > 0)
            return ceil(current.right, key);

        Node test = ceil(current.left, key);
        if(test != null){
            return test;
        }
        return current;
    }

    public int size(){
        return size(root);
    }
    private int size(Node current){
        if(current == null)
            return 0;
        else
            return current.count;
    }
    public int rank(Key key){
        return rank(key, root);
    }
    private int rank(Key key, Node current){
        if(current == null)
            return 0;
        int cmp = key.compareTo(current.key);
        if(cmp < 0)
            return rank(key, current.left);
        if(cmp > 0)
            return 1 + rank(key, current.left) + rank(key, current.right);
        else
            return size(current.left);
    }
    public void deleteMin() {// recursive
        if(root == null)
            return;
        root = deleteMin(root);
    }
    private Node deleteMin(Node current) {
        if (current == null)
            return null;

        if (current.left == null)
            return current.right;

        current.left = deleteMin(current.left);
        current.count = 1 + size(current.left) + size(current.right);

        return current;
    }

    public void deleteMax(){//recursive
        if(root == null)
            return;
        root = deleteMax(root);
    }
    private Node deleteMax(Node current){
        if(current.right == null)
            return current.left;
        current.right = deleteMax(current.right);
        current.count = 1 + size(current.left) + size(current.right);
        return current;
    }
//    public void deleteMin(){// not recursive
//        if(root == null)
//            return;
//        if(root.left == null){
//            root = root.right;
//            return;
//        }
//        Node previous = root, current = root.left;
//        while(current.left != null){
//            previous = current;
//            current = current.left;
//        }
//        previous.count--;
//        if(current.right != null){
//            previous.left = current.right;
//        }else{
//            previous.left = null;
//        }
//    }

    public void delete(Key key){
        root = delete(root, key);
    }
    private Node delete(Node current, Key key){
        if(current == null)
            return null;
        int cmp = key.compareTo(current.key);

        if(cmp < 0)
            current.left = delete(current.left, key);

        else if(cmp > 0)
            current.right = delete(current.right, key);

        else{
            if(current.right == null)
                return current.left;
            if(current.left == null)
                return current.right;

            Node successor = getMin(current.right);
            successor.right = deleteMin(current.right);
            successor.left = current.left;
            current = successor;
        }
        current.count = 1 + size(current.left) + size(current.right);
        return current;
    }
    public Iterable<Key> keyIterator(){
        List<Key> list = new ArrayList<>();
        inorderKeys(root, list);
        return list;
    }
    private void inorderKeys(Node current, List<Key> list){
        if(current == null)
            return;
        inorderKeys(current.left, list);
        list.add(current.key);
        inorderKeys(current.right, list);
    }
    public Iterable<Value> valueIterator(){
        List<Value> list = new ArrayList<>();
        inorderValues(root, list);
        return list;
    }
    private void inorderValues(Node current, List<Value> list){
        if(current == null)
            return;
        inorderValues(current.left, list);
        list.add(current.value);
        inorderValues(current.right, list);
    }

}