package Stack;

public class Stack {

    private int data[];
    private int topIndex;

    public Stack(){
        data = new int[10];
        topIndex = -1;
    }

    public Stack(int size){
        data = new int[size];
        topIndex = -1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public int size() {
        return topIndex+1;
    }

    public void push(int i) throws StackFullException {
        if(topIndex == data.length - 1){
            //throws exception
            // 1 way StackFullException e = new StackFullException();
            // throw e;
            // throw new StackFullException();
            doubleCapacity();
        }
        data[++topIndex] = i;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        for(int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
    }

    public int pop() throws StackEmptyException {
        int poppedElement = top();
        topIndex--;
        return poppedElement;
    }

    public void printStack() throws StackEmptyException{
        while(!isEmpty()){
            System.out.println(pop());
        }
    }

    public int top() throws StackEmptyException {
        if(topIndex == - 1){
            //throws exception
            // 1 way StackFullException e = new StackFullException();
            // throw e;
            throw new StackEmptyException();
        }
        return data[topIndex];
    }
    
}
