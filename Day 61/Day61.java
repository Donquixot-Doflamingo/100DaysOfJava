import java.util.*;

public class Day61 {

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
    
        public static Node<Integer> createLinkedList(){
            Node<Integer> n1 = new Node<Integer>(2);
            Node<Integer> n2 = new Node<Integer>(4);
            Node<Integer> n3 = new Node<Integer>(6);
            Node<Integer> n4 = new Node<Integer>(8);
            Node<Integer> n5 = new Node<Integer>(10);
            Node<Integer> n6 = new Node<Integer>(12);
            Node<Integer> n7 = new Node<Integer>(14);
            Node<Integer> n8 = new Node<Integer>(16);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            n5.next = n6;
            n6.next = n7;
            n7.next = n8;
    
            return n1;
        }
    /***************************************** Questions of Linked List Part 2 ***************************************/

    /* Question 1 -> Mid Point Linked List

        For a given singly linked list of integers, find and return the node present at the middle of the list.
        Note :
        If the length of the singly linked list is even, then return the first middle node.

        Example: Consider, 10 -> 20 -> 30 -> 40 is the given list, then the nodes present at the middle with respective data values are, 20 and 30. We return the first node with data 20.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space. 
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output Format :
        For each test case/query, print the data value of the node at the middle of the given list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5 
        Where M is the size of the singly linked list.

        Time Limit: 1sec
        Sample Input 1 :
        1
        1 2 3 4 5 -1
        Sample Output 1 :
        3
        Sample Input 2 :
        2 
        -1
        1 2 3 4 -1
        Sample Output 2 :
        2
    */
    
    public static Node<Integer> midPointOfLL(Node<Integer> head){
        if(head == null) return head;
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* Question 2 -> Merge Two Sorted LL

        You have been given two sorted(in ascending order) singly linked lists of integers.
        Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.
        Note :
        Try solving this in O(1) auxiliary space.

        No need to print the list, it has already been taken care.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first line of each test case or query contains the elements of the first sorted singly linked list separated by a single space. 

        The second line of the input contains the elements of the second sorted singly linked list separated by a single space. 
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output :
        For each test case/query, print the resulting sorted singly linked list, separated by a single space.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t = 10^2
        0 <= N <= 10 ^ 4
        0 <= M <= 10 ^ 4
        Where N and M denote the sizes of the singly linked lists. 

        Time Limit: 1sec
        Sample Input 1 :
        1
        2 5 8 12 -1
        3 6 9 -1
        Sample Output 1 :
        2 3 5 6 8 9 12 
        Sample Input 2 :
        2
        2 5 8 12 -1
        3 6 9 -1
        10 40 60 60 80 -1
        10 20 30 40 50 60 90 100 -1
        Sample Output 2 :
        2 3 5 6 8 9 12 
        10 10 20 30 40 40 50 60 60 60 80 90 100
    */
    
    public static Node<Integer> mergeTwoSortedLL(Node<Integer> t1, Node<Integer> t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        Node<Integer> head = null, tail = null;
        if(t1.data>t2.data) {
            head = t2;
            t2 = t2.next;
        }
        else {
            head = t1;
            t1 = t1.next;
        }

        tail = head;
        //1 3 5 7 9 11 13 15 -1

        while(t2 != null && t1 != null){
            if(t1.data < t2.data){
                tail.next = t1;
                t1 = t1.next;
            }
            else{
                tail.next = t2;
                t2 = t2.next;
            }
            tail = tail.next;
        }

        if(t1 != null) tail.next = t1;
        else tail.next = t2;

        return head;
    }

    /* Question 2 -> Merge Sort LL

        Given a singly linked list of integers, sort it using 'Merge Sort.'
        Note :
        No need to print the list, it has already been taken care. Only return the new head to the list.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output format :
        For each test case/query, print the elements of the sorted singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where M is the size of the singly linked list.

        Time Limit: 1sec
        Sample Input 1 :
        1
        10 9 8 7 6 5 4 3 -1
        Sample Output 1 :
        3 4 5 6 7 8 9 10 
        Sample Output 2 :
        2
        -1
        10 -5 9 90 5 67 1 89 -1
        Sample Output 2 :
        -5 1 5 9 10 67 89 90  
    */
    
    public static Node<Integer> mergeSort(Node<Integer> head){
        if(head == null || head.next == null) return head;

        // split the list into two parts using mid point
        Node<Integer>  mid = midPointOfLL(head);
        Node<Integer> part1Head = head, part2Head = mid.next;
        mid.next = null;

        // performing spliting on two half lists
        part1Head = mergeSort(part1Head);
        part2Head = mergeSort(part2Head);

        // merging the two lists
        head = mergeTwoSortedLL(part1Head, part2Head);

        return head;

    }

    // Using collection of java for LL

    public static void collection(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(1, 15);
        list.set(2, 25);
        list.addFirst(5);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        list.remove();
        list.remove(2);
        System.out.println(list);
    }
    
    public static void main(String[] args) {
        // Node<Integer> head = takeLinkedListInput();
        // head = mergeSort(head);
        // printNodes(head);
        collection();
    }
}
