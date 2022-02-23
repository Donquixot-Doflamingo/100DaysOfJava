import java.util.*;

public class Day58 {

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

    /* Question 1 -> Insert Node In LL
        You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'
        Write a function to add a node to the list with the 'data' at the specified position, 'pos.'
        Note : Assume that the Indexing for the singly linked list always starts from 0. If the position is greater than the 
        length of the singly linked list, you should return the same linked list without any change.

        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow. The first line of each test case or query contains the elements of the linked list 
        separated by a single space. 

        The second line contains the two integer values of 'data' and 'pos' separated by a single space, respectively
        Reminder/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, 
        would never be a list element.
        
        Output format :
        For each test case, print the resulting singly linked list of integers in a row, separated by a single space. 
        Output for every test case will be printed in a seperate line.
        
        Constraints :
        1 <= t <= 10^2
        0 <= N <= 10^5
        pos >= 0
        Time Limit: 1sec
        
        Sample Input 1 :
        1
        3 4 5 2 6 1 9 -1
        3 100
        
        Sample Output 1 :
        3 4 5 100 2 6 1 9
        
        Sample Input 2 :
        2
        3 4 5 2 6 1 9 -1
        0 20
        10 98 7 66 8 -1
        5 99
        
        Sample Output 2 :
        20 3 4 5 2 6 1 9
        10 98 7 66 8 99  
    */
    
    public static Node<Integer> InsertNodes(Node<Integer> head){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt(), pos = s.nextInt();
        s.close();
        Node<Integer> newNode = new Node<Integer>(data);
        if(pos == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node<Integer> temp = head;
        int currPos = 0;

        while( temp != null && currPos < (pos-1)){
            temp = temp.next;
            currPos++;
        }

        if(temp == null) return head;

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }


    /* Question 2 -> Delete Node In LL

        You have been given a linked list of integers. Your task is to write a function that deletes a node from a given 
        position, 'pos'.
        
        Note : Assume that the Indexing for the linked list always starts from 0.

        If the position is greater than or equal to the length of the linked list, 
        you should return the same linked list without any change.

        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.
        The first line of each test case or query contains the elements of the linked list separated by a single space. 

        The second line of each test case contains the integer value of 'pos'. It denotes the position in the linked list from where the node has to be deleted.
        
        Remember/Consider : While specifying the list elements for input, -1 indicates the end of the singly linked list 
        and hence, would never be a list element
        
        Output format : For each test case/query, print the resulting linked list of integers in a row, separated 
        by a single space.

        Output for every test case will be printed in a separate line.
        You don't need to print explicitly, it has been taken care of.
        
        Constraints :
        1 <= t <= 10^2
        0 <= N <= 10^5
        pos >= 0
        Time Limit: 1sec
        Where 'N' is the size of the singly linked list.
        
        Sample Input 1 :
        1 
        3 4 5 2 6 1 9 -1
        3
        Sample Output 1 :
        3 4 5 6 1 9
        Sample Input 2 :
        2
        3 4 5 2 6 1 9 -1
        0
        10 20 30 40 50 60 -1
        7
        Sample Output 2 :
        4 5 2 6 1 9
        10 20 30 40 50 60 
    */
    
    public static Node<Integer> DeleteNode(Node<Integer> head, int pos){
        Scanner s = new Scanner(System.in);
        // int pos = s.nextInt();
        s.close();
        if(head == null){
            return head;
        }
        if(pos == 0){
            return head.next;
        }

        Node<Integer> temp = head;
        int currPos = 0;

        while(temp != null && currPos < (pos-1)){
            temp = temp.next;
            currPos++;
        }

        if(temp == null || temp.next == null) {
            return head;
        }
        temp.next = temp.next.next;

        return head;
    }
    
    /***************************************** Assignments of Linked List Part 1 ***************************************/

    /* Question 1 -> Find a Node in Linked List

        You have been given a singly linked list of integers. 
        Write a function that returns the index/position of an integer data denoted by 'N' (if it exists). Return -1 otherwise.
        
        Note : Assume that the Indexing for the singly linked list always starts from 0.
        
        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space. 

        The second line contains the integer value 'N'. It denotes the data to be searched in the given singly linked list.
        
        Remember/Consider : While specifying the list elements for input, -1 indicates the end of the singly linked list 
        and hence, would never be a list element.
        Output format : For each test case/query, return the index/position of 'N' in the singly linked list. Return -1, otherwise.
        Output for every test case will be printed in a separate line.
        
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where 'M' is the size of the singly linked list.

        Time Limit: 1 sec
        Sample Input 1 :
        2
        3 4 5 2 6 1 9 -1
        5
        10 20 30 40 50 60 70 -1
        6
        Sample Output 1 :
        2
        -1
        Sample Input 2 :
        1
        3 4 5 2 6 1 9 -1
        6
        Sample Output 2 :
        4
        Explanation for Sample Input 2 : For the given singly linked list, considering the indices starting from 0, 
        progressing in a left to right manner with a jump of 1, then the N = 6 appears at position 4. 
    */
    
    public static int SearchNode(Node<Integer> head, int x){
        if(head == null){
            return -1;
        }
        
        int count = 0;
        while(head != null){
            if(head.data.equals(x)) return count;
            head = head.next;
            count++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Node<Integer> head = takeLinkedListInput();
        printNodes(head);
        System.out.println();
        int v = SearchNode(head, 1);
        System.out.println(v);
    }
}
