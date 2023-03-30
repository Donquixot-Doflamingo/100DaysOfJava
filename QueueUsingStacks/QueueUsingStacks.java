package QueueUsingStacks;

import java.util.Stack;

public class QueueUsingStacks<T> {
    Stack<T> s1;
    Stack<T> s2;

    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public int size(){
        return s1.size();
    }

    public boolean isEmpty(){
        return s2.size() == 0;
    }

    // method 1`
    public void Cenqueue(T elem){
        while(!s1.empty()){
            s2.push(s1.pop());
        }

        s1.push(elem);

        while(!s2.empty()){
            s1.push(s2.pop());
        }
    }

    public T Cdequeue(){
        if(s1.empty()){
            System.out.println("Empty STack");
            System.exit(0);
        }
        return s1.pop(); 
    }

    // method 2
    public void enqueue(T elem){
        // while(!s1.empty()){
        //     s2.push(s1.pop());
        // }
        s1.push(elem);
        // while(!s2.empty()){
        //     s1.push(s2.pop());
        // }
    }

    public T dequeue(){

        if(s1.empty() && s2.empty()){
            System.out.println("Empty STack");
            System.exit(4040404);
        }
        
       if(s2.empty()){
           while(!s1.empty()){
                s2.push(s1.pop());
           }
       }

       return s2.pop(); 
    }

}
