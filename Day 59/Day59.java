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

public class Day59 {
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

    /* Question 2 ->  AppendLastNToFirst

        You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' 
        nodes towards the front of the singly linked list and returns the new head to the list.

        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space. 
        The second line contains the integer value 'N'. It denotes the number of nodes to be moved from last to the 
        front of the singly linked list.
        
        Remember/Consider : While specifying the list elements for input, -1 indicates the end of the singly linked list 
        and hence, would never be a list element.
        
        Output format : For each test case/query, print the resulting singly linked list of integers in a row, 
        separated by a single space.
        Output for every test case will be printed in a seperate line.
        
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        0 <= N < M
        Time Limit: 1sec
        Where 'M' is the size of the singly linked list.

        Sample Input 1 :
        2
        1 2 3 4 5 -1
        3
        10 20 30 40 50 60 -1
        5
        Sample Output 1 :
        3 4 5 1 2
        20 30 40 50 60 10
        Sample Input 2 :
        1
        10 6 77 90 61 67 100  -1
        4
        Sample Output 2 :
        90 61 67 100 10 6 77 
        Explanation to Sample Input 2 : We have been required to move the last 4 nodes to the front of the list. 
        Here, "90->61->67->100" is the list which represents the last 4 nodes. When we move this list to the front 
        then the remaining part of the initial list which is, "10->6->77" is attached after 100. 
        Hence, the new list formed with an updated head pointing to 90.
    */

    public static Node<Integer> AppendLastNToFirst(Node<Integer> head, int n){
        if(head == null || n == 0) return head;

        Node<Integer> initialHead = head;
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        for(int i = 0; i < n; i++) fast = fast.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        Node<Integer> temp = slow.next;
        slow.next = null;
        fast.next = initialHead;
        head = temp;

        return head;
    }

    /* Question 3 -> Eliminate duplicates from LL

        You have been given a singly linked list of integers where the elements are sorted in ascending order. 
        Write a function that removes the consecutive duplicate values such that the given list only contains unique elements
        and returns the head to the updated list.
        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.

        The first and the only line of each test case or query contains the elements(in ascending order) of the singly linked list separated by a single space.
        
        Remember/Consider : While specifying the list elements for input, -1 indicates the end of the singly 
        linked list and hence, would never be a list element.
        
        Output format : For each test case/query, print the resulting singly linked list of integers in a row, 
        separated by a single space.
        Output for every test case will be printed in a seperate line.

        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Time Limit: 1sec
        Where 'M' is the size of the singly linked list.

        Sample Input 1 :
        1
        1 2 3 3 4 3 4 5 4 5 5 7 -1
        Sample Output 1 :
        1 2 3 4 3 4 5 4 5 7 
        Sample Input 2 :
        2
        10 20 30 40 50 -1
        10 10 10 10 -1
        Sample Output 2 :
        10 20 30 40 50
        10
    */
    
    public static void eliminateDuplicates(Node<Integer> head){
        if(head == null) return ;

        Node<Integer> current = head;

        while(current.next != null){
            if(current.data == current.next.data) current.next = current.next.next;

            else current = current.next;
        }
    }

    /* Question 4 -> Print Reverse LinkedList

        You have been given a singly linked list of integers. Write a function to print the list in a reverse order.
        To explain it further, you need to start printing the data from the tail and move towards the head of the list, 
        printing the head data at the end.
        
        Note : You can’t change any of the pointers in the linked list, just print it in the reverse order.
        
        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.

        The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
        
        Remember/Constraints : While specifying the list elements for input, -1 indicates the end of the singly 
        linked list and hence, would never be a list element.
        
        Output format : For each test case, print the singly linked list of integers in a reverse fashion, 
        in a row, separated by a single space.
        Output for every test case will be printed in a seperate line.

        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^3
        Time Limit: 1sec
        Where 'M' is the size of the singly linked list.

        Sample Input 1 :
        1
        1 2 3 4 5 -1
        Sample Output 1 :
        5 4 3 2 1
        Sample Input 2 :
        2
        1 2 3 -1
        10 20 30 40 50 -1
        Sample Output 2 :
        3 2 1
        50 40 30 20 10 
    */
    
    public static void printReverse(Node<Integer> head){
        if(head == null) return;
        printReverse(head.next);
        System.out.print(head.data + " ");
    }

    /* Question 5 -> Palindrome LinkedList

        You have been given a head to a singly linked list of integers. 
        Write a function check to whether the list given is a 'Palindrome' or not.
        
        Input format : The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.
        First and the only line of each test case or query contains the the elements of the singly linked list separated by 
        a single space.
        
        Remember/Consider : While specifying the list elements for input, -1 indicates the end of the singly 
        linked list and hence, would never be a list element.
        
        Output format : For each test case, the only line of output that print 'true' if the list is Palindrome 
        or 'false' otherwise.
        
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Time Limit: 1sec
        Where 'M' is the size of the singly linked list.

        Sample Input 1 :
        1
        9 2 3 3 2 9 -1
        Sample Output 1 :
        true
        
        Sample Input 2 :
        2
        0 2 3 2 5 -1
        -1
        Sample Output 2 :
        false
        true
        
        Explanation for the Sample Input 2 : For the first query, it is pretty intuitive that the the given list is not 
        a palindrome, hence the output is 'false'.
        For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'. 
    */
    
    public static boolean palindromeList(Node<Integer> head){
        if (head == null || head.next == null) return true;

        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<Integer> secondHead = slow.next;

        slow.next = null;
        secondHead = reverseLinkedList(secondHead) ;
        
        // compare two sublists now
        Node<Integer> firstSubList = secondHead;
        Node<Integer> secondSubList = head;

        while (firstSubList != null) {
            if (firstSubList.data != secondSubList.data) return false;
            firstSubList = firstSubList.next;
            secondSubList = secondSubList.next;
        }
        
        //Rejoin the two sublists to restore the input list to its original form
        firstSubList = head;
        secondSubList = reverseLinkedList(secondHead);

        while (firstSubList.next != null) firstSubList = firstSubList.next;
        
        firstSubList.next = secondSubList;
        return true;
    }

    private static Node<Integer> reverseLinkedList (Node<Integer> head){
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> fwd = null;

        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node<Integer> head = takeLinkedListInput();
        printNodes(head);
        System.out.println(palindromeList(head));
    }
}
