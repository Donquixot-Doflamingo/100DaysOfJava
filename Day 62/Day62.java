import java.util.*;

public class Day62 {
    
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
            Node<Integer> n5 = new Node<Integer>(101);
            Node<Integer> n6 = new Node<Integer>(121);
            Node<Integer> n7 = new Node<Integer>(141);
            Node<Integer> n8 = new Node<Integer>(161);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            n5.next = n6;
            n6.next = n7;
            n7.next = n8;
    
            return n1;
        }
    
        /***************************************** Assignment of Linked List Part 2 ***************************************/

    /* Question 1 -> Find a node in LL (recursive)

        Given a singly linked list of integers and an integer n, find and return the index for the first occurrence of 'n' in the linked list. -1 otherwise.
        Follow a recursive approach to solve this.
        Note :
        Assume that the Indexing for the linked list always starts from 0.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space.

        The second line of input contains a single integer depicting the value of 'n'.
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output format :
        For each test case/query, print the elements of the updated singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where M is the size of the singly linked list.

        Time Limit:  1sec
        Sample Input 1 :
        1
        3 4 5 2 6 1 9 -1
        100
        Sample Output 1 :
        -1
        Sample Input 2 :
        2
        10 20010 30 400 600 -1
        20010
        100 200 300 400 9000 -34 -1
        -34
        Sample Output 2 :
        1
        5
    */

    public static int returnIndexOfElement(Node<Integer> head, int num){
        if(head == null) return -1;
        if(head.data.equals(num)) return 0;
        int small = returnIndexOfElement(head.next, num);
        if(small == -1) return -1;
        return small+1;
    }

    /* Question 2 -> Even after Odd LinkedList

        For a given singly linked list of integers, arrange the elements such that all the even numbers are placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.
        Note :
        No need to print the list, it has already been taken care. Only return the new head to the list.
        Input format:
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space. 
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output format:
        For each test case/query, print the elements of the updated singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where M is the size of the singly linked list.

        Time Limit: 1sec
        Sample Input 1 :
        1
        1 4 5 2 -1
        Sample Output 1 :
        1 5 4 2 
        Sample Input 2 :
        2
        1 11 3 6 8 0 9 -1
        10 20 30 40 -1
        Sample Output 2 :
        1 11 3 9 6 8 0
        10 20 30 40 
    */

    public static Node<Integer> evenAfterOdd(Node<Integer> head){
        
        if (head == null) {
            return head;
        }

        Node<Integer> oddH = null, oddT = null, evenH = null, evenT = null;

        while(head != null){

            if(head.data % 2 == 0) {
                if(evenH == null) {
                    evenH = head;
                    evenT = head;
                }
                else {
                    evenT.next = head;
                    evenT = evenT.next;
                }
            }
            else{
                if(oddH == null) {
                    oddH = head;
                    oddT = head;
                }
                else {
                    oddT.next = head;
                    oddT = oddT.next;
                }
            }
            head = head.next;
        }

        if(oddH == null) return evenH;
        else oddT.next = evenH;

        if(evenH != null) evenT.next = null;

        return oddH;
        
    }

    /* Question 3 -> Delete every N nodes

        You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list.
        To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
        Note :
        No need to print the list, it has already been taken care. Only return the new head to the list.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space.

        The second line of input contains two integer values 'M,' and 'N,' respectively. A single space will separate them.
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output format :
        For each test case/query, print the elements of the updated singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= P <= 10^5
        Where P is the size of the singly linked list.
        0 <= M <= 10^5
        0 <= N <= 10^5 

        Time Limit: 1sec
        Sample Input 1 :
        1
        1 2 3 4 5 6 7 8 -1
        2 2
        Sample Output 1 :
        1 2 5 6
        Sample Input 2 :
        2
        10 20 30 40 50 60 -1
        0 1
        1 2 3 4 5 6 7 8 -1
        2 3
        Sample Output 2 :
        1 2 6 7
        Explanation of Sample Input 2 :
        For the first query, we delete one node after every zero elements hence removing all the items of the list. 
        Therefore, nothing got printed.

        For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7. 
    */

    public static Node<Integer> deleteNNode(Node<Integer> head, int times, int index){
        if(index == 0 || head == null) return null;

        if(times == 0) return head;

        Node<Integer> currNode = head;
        Node<Integer> temp = null;

        while(currNode != null){
            int take = 0, skip = 0;
            while(currNode != null && take < index){
                if(temp == null) temp = currNode;
                else{
                    temp.next = currNode;
                    temp = currNode;
                }
                currNode = currNode.next;
                take++;
            }

            while(currNode != null && skip < times){
                currNode = currNode.next;
                skip++;
            }
        }

        if(temp != null) temp.next = null;

        return head;
    }
    
    /* Question 4 -> Swap two Nodes of LL

        You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' 
        Swap the nodes that are present at the 'i-th' and 'j-th' positions.
        Note :
        Remember, the nodes themselves must be swapped and not the datas.

        No need to print the list, it has already been taken care. Only return the new head to the list.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
        Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space.

        The second line of input contains two integer values 'i,' and 'j,' respectively. A single space will separate them.
        Remember/consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, 
        would never be a list element
        Output format :
        For each test case/query, print the elements of the updated singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where M is the size of the singly linked list.
        0 <= i < M
        0 <= j < M

        Time Limit: 1sec
        Sample Input 1 :
        1
        3 4 5 2 6 1 9 -1
        3 4
        Sample Output 1 :
        3 4 5 6 2 1 9 
        Sample Input 2 :
        2
        10 20 30 40 -1
        1 2
        70 80 90 25 65 85 90 -1
        0 6
        Sample Output 2 :
        10 30 20 40 
        90 80 90 25 65 85 70  
    */

    public static Node<Integer> swapNodes (Node<Integer> head, int i, int j) {
        if(i == j) return head;

        Node<Integer> currentNode = head, prev = null;
        Node<Integer> firstNode = null, secondNode = null, firstNodePrev = null, secondNodePrev = null;

        int pos = 0;

        while(currentNode != null){
            if(pos == i){
                firstNodePrev = prev;
                firstNode = currentNode;
            } else if(pos == j){
                secondNodePrev = prev;
                secondNode = currentNode;
            }
            prev = currentNode;
            currentNode = currentNode.next;
            pos++;
        }

        if(firstNodePrev != null) firstNodePrev.next = secondNode;
        else head = secondNode;

        if(secondNodePrev != null) secondNodePrev.next = firstNode;
        else head = firstNode;

        Node<Integer> currentfirstNode = secondNode.next;
        secondNode.next = firstNode.next;
        firstNode.next = currentfirstNode;

        return head;
    }

    /* Question 5 -> kReverse

        Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.
        'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.
        Example :
        Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

        For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

        For k = 3, you should return: 3 -> 2 -> 1 -> 4 -> 5
        Note :
        No need to print the list, it has already been taken care. Only return the new head to the list.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space.

        The second line of input contains a single integer depicting the value of 'k'.
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output format :
        For each test case/query, print the elements of the updated singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where M is the size of the singly linked list.
        0 <= k <= M

        Time Limit:  1sec
        Sample Input 1 :
        1
        1 2 3 4 5 6 7 8 9 10 -1
        4
        Sample Output 1 :
        4 3 2 1 8 7 6 5 10 9
        Sample Input 2 :
        2
        1 2 3 4 5 -1
        0
        10 20 30 40 -1
        4
        Sample Output 2 :
        1 2 3 4 5 
        40 30 20 10  
    */

    public static Node<Integer> kReverse(Node<Integer> head, int k){
        if(k == 0 || k==1) return head;

        Node<Integer> current = head;
        Node<Integer> fwd = null;
        Node<Integer> prev = null;

        int count = 0;

        while(count < k && current != null){
            fwd = current.next;
            current.next = prev;
            prev = current;
            current = fwd;
            count++;
        }

        if(fwd != null) head.next = kReverse(fwd, k);

        return prev;
    }

    /* Question 6 -> Bubble Sort (Iterative) LinkedList

        Given a singly linked list of integers, sort it using 'Bubble Sort.'
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
    
    public static int length(Node<Integer> head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }

    public static Node<Integer> bubbleSort(Node<Integer> head){
        int n = length(head);

        for(int i = 0; i < (n - 1); i++){
            Node<Integer> prev = null;
            Node<Integer> curr = head;

            for(int j = 0; j < (n - i - 1); j++){
                if(curr.data <= curr.next.data){
                    prev = curr;
                    curr = curr.next;
                }
                else{
                    if(prev == null){
                        Node<Integer> fwd = curr.next;
                        head = head.next;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    }
                    else{
                        Node<Integer> fwd = curr.next;
                        prev.next = fwd;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    }
                }
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        Node<Integer> head = takeLinkedListInput();
        printNodes(bubbleSort(head));
    }
}