package Day_66;

import Queue.Queue;
import Queue.QueueEmptyException;
import Queue.QueueFullException;

public class Day66 {

    // print n fibonacci series
    static void prntNFibonacci(int n) throws QueueFullException, QueueEmptyException{
        Queue q = new Queue();
        q.enqueue(0);
        q.enqueue(1);
        for(int i = 0; i < n; i++){
            int a = q.dequeue();
            int b = q.dequeue();
            q.enqueue(b);
            q.enqueue(a + b);
            System.out.println(a);
        }
    }
    
    public static void main(String[] args) throws QueueEmptyException, QueueFullException {
    /* Queue basic operations
        Queue q = new Queue();
        q.enqueue(6);
        q.enqueue(68);
        q.enqueue(6810);
        q.printQueue();
        System.out.println("Dequeue in process");
        System.out.println(q.dequeue());
        q.printQueue();
        System.out.println("front printed");
        System.out.println(q.front());
        System.out.println("rear printed");
        System.out.println(q.rear());
        System.out.println(q.isEmpty());
        System.out.println("size of queue");
        System.out.println(q.size());
    */
        prntNFibonacci(10);
    }
}
