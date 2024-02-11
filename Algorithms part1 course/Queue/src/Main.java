import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        LinkedListBasedQueue<String> llbq = new LinkedListBasedQueue<>();
//        llbq.enqueue("Hello");
//        llbq.enqueue("World");
//        llbq.enqueue("Java");
//        llbq.print();
//        System.out.println(llbq.dequeue());
//        System.out.println(llbq.dequeue());
//        llbq.print();
        ////////////////////////////
        ResizedQueueArray<Integer> queue = new ResizedQueueArray<>();

        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Print the initial queue
        System.out.println("Initial Queue:");
        queue.print();  // Expected output: 10 20 30

        // Dequeue elements
        System.out.println("Dequeued Element: " + queue.dequeue());  // Expected output: 10
        System.out.println("Dequeued Element: " + queue.dequeue());  // Expected output: 20

        // Print the modified queue
        System.out.println("Modified Queue:");
        queue.print();  // Expected output: 30

        // Enqueue more elements to trigger resizing
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        // Print the final resized queue
        System.out.println("Resized Queue:");
        queue.print();  // Expected output: 30 40 50 60
        Iterator<Integer> iterator = queue.iterator() ;
        for(var it : queue){
            System.out.println(it.toString());
        }
        queue.print();
    }
}