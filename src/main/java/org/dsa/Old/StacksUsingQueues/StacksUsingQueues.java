package StacksUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StacksUsingQueues<T>{

    Queue<T> q1;
    Queue<T> q2;

    public StacksUsingQueues(){
        q1 = new LinkedList<T>();
        q2 = new LinkedList<T>();
    }

    // method 1

    public void Cpush(T elem){
        if(q1.isEmpty()){
            q1.add(elem);
        }
        else{
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(elem);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }
    }

    public T Cpop(){
        if(q1.isEmpty()){
            System.out.println("Empty Queue");
            System.exit(4040404);
        }
        T elem = q1.remove();
        return elem;
    }

    // method 2

    public void push(T elem){
        q1.add(elem);   
    }

    public T pop(){
        if(q1.isEmpty() && q2.isEmpty()){
            System.out.println("Empty STack");
            System.exit(4040404);
        }

        if(q2.isEmpty()){
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
        }
        
        return q1.remove();
    }

}