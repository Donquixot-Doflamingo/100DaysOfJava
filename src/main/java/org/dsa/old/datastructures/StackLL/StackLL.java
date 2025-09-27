package org.dsa.old.datastructures.StackLL;

import org.dsa.old.datastructures.LinkedList.Node;
import org.dsa.old.datastructures.Stack.StackEmptyException;

public class StackLL<T> {
    private Node<T> head;
    private int size;

    public StackLL(){
        head = null;
        size = 0;
    }

    public T pop() throws StackEmptyException {
        if(head == null){
            throw new StackEmptyException();
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public void push(T i) {
        Node<T> newNode = new Node<T>(i);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T top() throws StackEmptyException {
        if(head == null){
            throw new StackEmptyException();
        }
        return head.data;
    }
}
