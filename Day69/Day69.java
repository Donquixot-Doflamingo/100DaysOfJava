package Day69;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day69 {

    /* Question 1 -> Reverse Queue
        You have been given a queue that can store integers as the data. You are required to write a function that reverses 
        the populated queue itself without using any other data structures.
        Example:

        Input Format:
        The first list of input contains an integer 't' denoting the number of test cases/queries to be run.
        Then the test cases follow.

        The first line input for each test case/query contains an integer N, denoting the total number of elements in the queue.

        The second line of input contains N integers separated by a single space, representing the order in which the 
        elements are enqueued into the queue.
        Output Format:
        For each test case/query, the only line of output prints the order in which the queue elements are dequeued, 
        all of them separated by a single space.

        Output for every test case/query will be printed on a new line. 
        Note:
        You are not required to print the expected output explicitly, it has already been taken care of. Just make 
        the changes in the input queue itself.
        Constraints:
        1 <= t <= 100
        1 <= N <= 10^4
        -2^31 <= data <= 2^31 - 1

        Time Limit: 1sec 
        Sample Input 1:
        1
        6
        1 2 3 4 5 10
        Note:
        Here, 1 is at the front and 10 is at the rear of the queue.
        Sample Output 1:
        10 5 4 3 2 1
        Sample Input 2:
        2
        5
        2 8 15 1 10
        3
        10 20 30
        Sample Output 2:
        10 1 15 8 2 
        30 20 10  
    */

    public static void ReverseQueue(Queue<Integer> q){
        if(q.size() <= 1){
            return;
        }

        int front = q.poll();
        ReverseQueue(q);
        q.add(front);
    }

    /* Question 2 -> Reverse the First K Elements in the Queue

        For a given queue containing all integer data, reverse the first K elements.
        You have been required to make the desired change in the input queue itself.
        Example:
        alt txt

        For the above input queue, if K = 4 then after reversing the first 4 elements, the queue will be updated as:
        alt txt

        Input Format :
        The first line of input would contain two integers N and K, separated by a single space. 
        They denote the total number of elements in the queue and the count with which the elements need to be reversed 
        respectively.

        The second line of input contains N integers separated by a single space, representing the order in which the 
        elements are enqueued into the queue.
        Output Format:
        The only line of output prints the updated order in which the queue elements are dequeued, all of them separated 
        by a single space. 
        
        Note:
        You are not required to print the expected output explicitly, it has already been taken care of. Just make the 
        changes in the input queue itself.

        Contraints :
        1 <= N <= 10^6
        1 <= K <= N
        -2^31 <= data <= 2^31 - 1

        Time Limit: 1sec
        Sample Input 1:
        5 3
        1 2 3 4 5
        Sample Output 1:
        3 2 1 4 5
        Sample Input 2:
        7 7
        3 4 2 5 6 7 8
        Sample Output 2:
        8 7 6 5 2 4 3 
    */

    public static Queue<Integer> reverseKElem(Queue<Integer> q, int k){
        if(q.isEmpty() || k > q.size())
            return q;

        if(k <= 0)
            return q;

        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < k; i++)
            s.push(q.poll());

        while (!s.isEmpty())
            q.add((s.pop()));

        for (int i = 0; i < q.size() - k; i++)
            q.add(q.poll());

        return q;
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int[] arr ={1,2,3,4,5};
        for(int i : arr){
            q.add(i);
        }
        // System.out.println(q);
        // ReverseQueue(q);
        System.out.println(q);
        reverseKElem(q,3);
        System.out.println(q);
    }
}
