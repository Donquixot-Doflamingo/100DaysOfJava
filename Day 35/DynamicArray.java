// 1. Custom Dynamic array class
public class DynamicArray {
    private int data[];
    private int nextElement;
    
    // initialising a simple array of size 5
    public DynamicArray(){
        data = new int[5];
        nextElement = 0;
    }

    // returning the size of the array
    public int size(){
        return data.length;
    }

    // returing if the array is empty or false
    public boolean isEmpty(){
        return nextElement == 0;
    }

    // to get the element at specific input
    public int get(int i){
        if(i >= data.length){
            // throw error
            return -1;
        }
        return data[i];
    }

    // give a specific value to a specific index
    public void set(int i, int value){
        if(i >= nextElement){
            // throw error
            System.out.println("error out of bounds");
            return;
        }
        data[i] = value;
    }

    // add the elements and calls doubleCapacity if the array size reached
    public void add(int element){
        if(nextElement == data.length){
            doubleCapacity();
        }
        data[nextElement] = element;
        nextElement++;
    }

    public void addAt(int index, int element){
        if(index >= data.length){
            doubleCapacity();
            addAt(index, element);
        }
        data[index] = element;
    }

    // redifine the size of the array
    private void doubleCapacity() {
        int temp[] = data;
        data =  new int[temp.length * 2];
        for(int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
    }

    // return and remove the last element in the array
    public int removeLast(){
        if(nextElement == 0){
            return -1;
        }
        int temp = data[nextElement -1];
        data[nextElement -1] = 0;
        nextElement--;
        return temp;
    }
}
