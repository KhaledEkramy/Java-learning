import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int count;
        public Node(Key key, Value val, int count){
            this.key = key;
            this.val = val;
        }
    }
    public void put(Key key){
        root = put(root, key, (Value)key);
    }
    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    public Node put(Node current, Key key, Value val){
        if(current == null){
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(current.key);
        if(cmp < 0){
            current.left = put(current.left, key, val);
        }else if(cmp > 0){
            current.right = put(current.right, key, val);
        }else{
            current.val = val;
        }
        current.count = 1 + size(current.left) + size(current.right);
        return current;
    }
    public Value get(Key key){
        Node current = root;
        while(current != null){
            int cmp = key.compareTo(current.key);
            if(cmp < 0){
                current = current.left;
            }else if(cmp > 0){
                current = current.right;
            }else{
                return current.val;
            }
        }
        return null;
    }
    public Value getMin(){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.val;
    }
    public Value getMax(){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.val;
    }
    public Value floor(Key key){
        Node current = floor(root, key);
        if(current == null){
            return null;
        }
        return current.val;
    }
    public Node floor(Node current, Key key){
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

    public int size(){
        return size(root);
    }
    public int size(Node current){
        if(current == null)
            return 0;
        else
            return current.count;
    }
    public int rank(Key key){
        return rank(key, root);
    }
    public int rank(Key key, Node current){
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
        list.add(current.val);
        inorderValues(current.right, list);
    }
}