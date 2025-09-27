package CircularQueue;

public class CircularQueue {

    private int[] data; 
    private int front;
    private int rear;
    private int size;

    public CircularQueue(){
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public CircularQueue(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public int rear() throws QueueEmptyException {
        if(isEmpty())
            throw new QueueEmptyException();
        return data[rear];
    }

    public int front() throws QueueEmptyException {
        if(isEmpty())
            throw new QueueEmptyException();
        return data[front];
    }

    public void enqueue(int i) throws QueueFullException {
        if(size == data.length)
            throw new QueueFullException();
        if(isEmpty()){
            front = 0;
        }
        // rear++;
        // if(rear == data.length)
        //     rear = 0;
        rear = (rear + 1) % data.length;
        size++;
        data[rear] = i;
    }

    public int dequeue() throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException();
        }
        int a = data[front];
        // front++;
        // if(front == data.length)
        //     front = 0;
        front = (front + 1) % data.length;
        size--;
        if(size == 0){
            front = -1;
            rear = -1;
        }
        return a;
    }

    public void printQueue() throws QueueEmptyException{
        if(isEmpty())
            throw new QueueEmptyException();
        int i = front;
        int j = rear;
        System.out.println("printing queue");
        while(i <= j){
            System.out.println(data[i]);
            i++;
        }
    }
    
}