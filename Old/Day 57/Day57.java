import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        // this isn't required cause the defult value of any reference is null
        // next = null;
    }
}

public class Day57 {
    
    // To create the linked list Nodes -> 3 4 5 2 6 1 9 -1
    public static Node<Integer> createLinkedList(){
        Node<Integer> n1 = new Node<Integer>(11);
        Node<Integer> n2 = new Node<Integer>(4);
        Node<Integer> n3 = new Node<Integer>(5);
        Node<Integer> n4 = new Node<Integer>(2);
        Node<Integer> n5 = new Node<Integer>(6);
        Node<Integer> n6 = new Node<Integer>(1);
        Node<Integer> n7 = new Node<Integer>(9);
        Node<Integer> n8 = new Node<Integer>(-1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        return n1;
    }

    // To print all the nodes in the linked list
    public static void printNodes(Node<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // incrementing the first node
    public static void incrementFirstNode(Node<Integer> head){
        head.data++;
    }

    // incrementing all the nodes
    public static void increment(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp.data++;
            temp = temp.next;
        }
    }

    /* Question 1 -> Length Of LL
        For a given singly linked list of integers, find and return its length. Do it using an iterative method.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        First and the only line of each test case or query contains elements of the singly linked list separated by a single space. 
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
        Output format :
        For each test case, print the length of the linked list.

        Output for every test case will be printed in a separate line.
        Constraints :
        1 <= t <= 10^2
        0 <= N <= 10^5
        Time Limit: 1 sec
        Sample Input 1 :
        1
        3 4 5 2 6 1 9 -1
        Sample Output 1 :
        7
        Sample Input 2 :
        2
        10 76 39 -3 2 9 -23 9 -1
        -1
        Sample Output 2 :
        8
        0 
    */

    public static int Lengthif1(Node<Integer> head){
        int count = 0;
        Node<Integer> temp = head;
        while(temp != null && temp.data != -1){
            count++;
            temp = temp.next;
        }
        return count;
    }

    /* Question 2 -> Print ith Node
        For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.
        
        Note : Assume that the Indexing for the singly linked list always starts from 0.

        If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
        
        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space.

        The second line contains the value of 'i'. It denotes the position in the given singly linked list.
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, 
        would never be a list element.
        
        Output format : For each test case, print the node data at the 'i-th' position of the linked list(if exists).
        Output for every test case will be printed in a seperate line.

        Constraints :
        1 <= t <= 10^2
        0 <= N <= 10^5
        i  >= 0
        Time Limit: 1sec

        Sample Input 1 :
        1
        3 4 5 2 6 1 9 -1
        3
        Sample Output 1 :
        2
        Sample Input 2 :
        2
        3 4 5 2 6 1 9 -1
        0
        9 8 4 0 7 8 -1
        3
        Sample Output 2 :
        3
        0 
    */

    public static void elementAtI(Node<Integer> head, int i){
        Node<Integer> temp = head;
        // while(temp != null && temp.data != -1){
        //     count++;
        //     if(count == i){
        //         System.out.println(temp.data);
        //     }
        //     temp = temp.next;
        // }
        while(temp != null && i > 0 && temp.data != -1){
            temp = temp.next;
            i--;
        }
        if(temp != null){
            System.out.println(temp.data);
        }
    }

    // to take input from the user of the LL - O(n^2)
    public static Node<Integer> takeInput(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null;
        while(data != -1){
            Node<Integer> currentNode = new Node<Integer>(data);
            // check if it is the first node and make it head
            if(head == null){
                head = currentNode;
            }
            else{
                // make a tail node and make a connection with head
                Node<Integer> tail = head;
                // if there are more than 2 nodes in list
                while(tail.next != null){
                    tail = tail.next;
                }
                // now tail will refer to last node so connect current node with last node of the list
                tail.next = currentNode;
            }
            // continue taking values until-1 encounters
            data = s.nextInt();
        }
        s.close();
        return head;
    }

    // to take input from the user of the LL - O(n)
    public static Node<Integer> takeLinkedListInput(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null, tail = null;
        while(data != -1){
            Node<Integer> currentNode = new Node<Integer>(data);
            // check if it is the first node and make it head
            if(head == null){
                head = currentNode;
                tail = currentNode; // updating tail also
            }
            else{
                tail.next = currentNode;
                tail = currentNode; //  tail = tail.next 
            }
            data = s.nextInt();
        }
        s.close();
        return head;
    }
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printNodes(head);
    }
}
