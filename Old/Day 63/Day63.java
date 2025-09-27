import Stack.Stack;
import StackLL.StackLL;

public class Day63 {

    public static void main(String[] args) throws Exception{
        // Stack Implementation using Array
        Stack newStack = new Stack(100);
        /* Stack Operations
            // System.out.println(newStack.isEmpty());
            // newStack.push(10);
            // System.out.println(newStack.size());
            // newStack.push(10);
            // newStack.push(30);
            // newStack.push(20);
            // System.out.println(newStack.pop());
            // System.out.println(newStack.top());
            // System.out.println();
        */
        
        int arr[] = {1,2,3,4,5};

        for(int i = 0; i < arr.length; i++){
            newStack.push(arr[i]);
        }
        // newStack.printStack();
        while(!newStack.isEmpty()){
            System.out.println(newStack.pop());
        }
        

        // Stack Implementation using LinkedList

        StackLL<Integer> s = new StackLL<Integer>();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        s.push(20);
        s.push(21);
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}// 9310848836
