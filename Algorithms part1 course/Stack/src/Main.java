public class Main {
    public static void main(String[] args) {
        LinkedListBasedStack<String> str = new LinkedListBasedStack<>();
        str.push("Hello");
        str.push("World");
        str.push("Java");
        str.print();
        System.out.println(str.pop());
        System.out.println(str.pop());
        str.print();
        LinkedListBasedStack<Integer> in = new LinkedListBasedStack<>();
        in.push(5);
        in.push(6);
        in.push(6);
        in.push(7);
        System.out.println("====================================");
        in.print();
        System.out.println(in.pop());
        in.print();
        ///////////////////////////

//         Testing ResizedStackArray

        ResizedStackArray<String> newStr = new ResizedStackArray<>();
        newStr.push("Hello");
        newStr.push("World");
        newStr.push("Java");
        newStr.print();
        System.out.println(newStr.pop());
        System.out.println(newStr.pop());
        newStr.print();
    }
}