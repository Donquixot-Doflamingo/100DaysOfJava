package QueueLL;

import CircularQueue.QueueEmptyException;
import Node.Node;

public class QueueLL<T> {
    private Node<T> front;
    private Node<T> rear;
    int size;

    public QueueLL(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T elem){
        Node<T> newNode = new Node<T>(elem);

        size++;

        if(rear == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode; // rear = rear.next
        }
    }

    public T front(){
        if(front == null){
            try {
                throw new QueueEmptyException();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
        return front.data;
    }

    public T rear(){
        if(front == null){
            try {
                throw new QueueEmptyException();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
        return rear.data;
    }
    
    public T dequeue(){
        if(front == null){
            try {
                throw new QueueEmptyException();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
        T temp = front.data;
        front = front.next; 
        if(front == null)
            rear = null;
        size--;
        return temp;
    }
}
