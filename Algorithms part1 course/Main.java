public class Main {
    public static void main(String[] args) {
        LLRBBST<Character, Character> llrbbst = new LLRBBST<>();
        llrbbst.put('S', 'S');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        llrbbst.put('E', 'E');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        llrbbst.put('A', 'A');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        System.out.println("rank of A: " + llrbbst.rank('A') + "\t rank of E: " + llrbbst.rank('E'));
        llrbbst.put('R', 'R');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        llrbbst.put('C', 'C');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        llrbbst.put('H', 'H');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        System.out.println("After deleting H:");
        llrbbst.delete('H');
        System.out.println(llrbbst.size());
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        System.out.println("R rank: " + llrbbst.rank('R'));
        llrbbst.put('X', 'X');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        llrbbst.put('M', 'M');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());
        llrbbst.put('P', 'P');
        System.out.println(llrbbst.valueIterator().toString());
        System.out.println(llrbbst.size());

    }
}