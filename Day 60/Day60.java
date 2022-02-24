import java.util.Scanner;

class doubleNode{
    Node<Integer> head;
    Node<Integer> tail;

    doubleNode(Node<Integer> head, Node<Integer> tail){
        this.head = head;
        this.tail = tail;
    }

    doubleNode(){
 
    }
}

public class Day60 {
    // PreRequisites
        // To print all the nodes in the linked list
        public static void printNodes(Node<Integer> head){
            while(head != null){
                System.out.print(head.data + " ");
                head = head.next;
            }
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
    
    /***************************************** Assignments of Linked List Part 1 ***************************************/

    /* Question 1 -> Print Linked List using Recursive  approach */
    public static void print(Node<Integer> head){
        if(head == null) return;
        System.out.print(head.data + " ");
        print(head.next);
    }

    /* Question 2 -> Insert node at a given position in Linked List using Recursive  approach */

    public static Node<Integer> insert(Node<Integer> head, int pos, int data){
        if(head == null || pos > 0) return head;

        if(pos == 0){
            Node<Integer> newNode = new Node<Integer>(data);
            newNode.next = head;
            return newNode;
        }

        head.next = insert(head, pos-1, data);
        return head;
    }

    /* Question 2 -> Delete node Recursively

            Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' 
            position in the linked list recursively.
            
            Note : Assume that the Indexing for the linked list always starts from 0.
            No need to print the list, it has already been taken care. Only return the new head to the list.
            
            input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
            Then the test cases follow.
            The first line of each test case or query contains the elements of the singly linked list separated 
            by a single space.
            The second line of input contains a single integer depicting the value of 'i'.
            
            Remember/Consider : While specifying the list elements for input, -1 indicates the end of the singly 
            linked list and hence, would never be a list element
            
            Output format : For each test case/query, print the elements of the updated singly linked list.
            Output for every test case will be printed in a seperate line.
            
            Constraints :
            1 <= t <= 10^2
            0 <= M <= 10^5
            Where M is the size of the singly linked list.
            0 <= i < M

            Time Limit:  1sec
            
            Sample Input 1 :
            1
            3 4 5 2 6 1 9 -1
            3
            Sample Output 1 :
            3 4 5 6 1 9
            
            Sample Input 2 :
            2
            30 -1
            0
            10 20 30 50 60 -1
            4
            Sample Output 2 :
            10 20 30 50  
        */
    
    public static Node<Integer> delete(Node<Integer> head, int pos){
        if(head == null) return head;

        if(pos == 0) return head.next;

        head.next = delete(head.next, pos-1);
        return head;
    }
    
    /* Question 3 -> Reverse LL (Recursive)

        Given a singly linked list of integers, reverse it using recursion and return the head to the modified list.
        Note : No need to print the list, it has already been taken care. Only return the new head to the list.
        
        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.
        The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
        
        Remember/Consider : While specifying the list elements for input, -1 indicates the end of the singly linked list 
        and hence, would never be a list element
        
        Output format : For each test case/query, print the elements of the updated singly linked list.
        Output for every test case will be printed in a seperate line.

        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^4
        Where M is the size of the singly linked list.

        Time Limit: 1sec
        
        Sample Input 1 :
        1
        1 2 3 4 5 6 7 8 -1
        Sample Output 1 :
        8 7 6 5 4 3 2 1
        
        Sample Input 2 :
        2
        10 -1
        10 20 30 40 50 -1
        Sample Output 2 :
        10 
        50 40 30 20 10  
    */
    
    // O(n^2) time complexity
    public static Node<Integer> reverseCodingNinja(Node<Integer> head){
        if(head == null || head.next == null) return head;
        Node<Integer> temp = reverseCodingNinja(head.next);
        Node<Integer> tail = temp;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return temp;
    }

    // using another class to solve this problem
    public static doubleNode reverseUsingClass(Node<Integer> head){
        doubleNode ans;
        if(head == null || head.next == null) { 
            ans = new doubleNode(head, head);
            return ans;
        }
        doubleNode temp = reverseUsingClass(head.next);
        temp.tail.next = head;
        head.next = null;
        ans = new doubleNode(temp.head, head);
        return ans;
    }

    public static Node<Integer> reverseWithClass(Node<Integer> head){
        doubleNode ans = reverseUsingClass(head);
        return ans.head;
    }

    public static Node<Integer> reverse(Node<Integer> head){
        if(head == null || head.next == null) return head;
        Node<Integer> temp = reverse(head.next);
        //one way
        // head.next.next = head;

        //second way
        Node<Integer> reversedTail = head.next;
        reversedTail.next = head;
        head.next = null;
        return temp;
    }
    

    public static void main(String[] args) {
        Node<Integer> head = takeLinkedListInput();
        printNodes(head);
        System.out.println();
        printNodes(reverse(head));
        
    }
}


