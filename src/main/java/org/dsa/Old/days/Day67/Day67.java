package org.dsa.Old.days.Day67;

import org.dsa.Old.datastructures.DynamicQueue.DynamicQueue;
import org.dsa.Old.datastructures.QueueLL.QueueLL;
import org.dsa.Old.datastructures.CircularQueue.CircularQueue;
import org.dsa.Old.datastructures.CircularQueue.QueueEmptyException;
import org.dsa.Old.datastructures.CircularQueue.QueueFullException;

public class Day67 {

    public static void circularQueue() throws QueueFullException, QueueEmptyException {
        // Checking Circular Queue
        CircularQueue q = new CircularQueue();

        int arr[] = {10, 20, 30, 40};

        for(int i : arr)
            q.enqueue(i);

        while(!q.isEmpty())
            System.out.println(q.dequeue());
    }

    public static void dynamicQueue() throws QueueEmptyException{
        // Checking Dynamic Queue
        DynamicQueue q = new DynamicQueue();

        int arr[] = {10, 20, 30, 40, 50, 60};

        for(int i : arr)
            q.enqueue(i);

        while(!q.isEmpty())
            System.out.println(q.dequeue());
    }

    public static void QueueLinkedList(){
        QueueLL<Integer> q = new QueueLL<Integer>();
        
        int arr[] = {10, 20, 30, 40, 50, 60};

        for(int i : arr)
            q.enqueue(i);

        while(!q.isEmpty())
            System.out.println(q.dequeue());
    }
    public static void main(String[] args) {
        try {
            dynamicQueue();
        } catch (QueueEmptyException e) {
            e.printStackTrace();
        }
    }
}
