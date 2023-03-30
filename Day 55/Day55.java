import java.util.*;

public class Day55 {

//      ********************************************** Linked List Part 1 IN JAVA **************************************************

/*
    ************************************************ ArrayList IN JAVA ****************************************************
*/

    // practicing the basic funtions of the arrayList in the java
        public static void ArrayListExample(){
        
        ArrayList<Integer> arr = new ArrayList<>();
        // add element to the arr
        arr.add(30);
        arr.add(300);
        // add element to the arr at a particular index
        arr.add(1,50);
        arr.add(1,500);
        arr.add(1,500);
        arr.add(1,500);
        // to get the size of the arr
        System.out.println(arr.size());
        // to get the element at the particular index of the arr
        System.out.println(arr.get(2));
        // to print the arr
        System.out.println(arr);
        // removing the element from index
        arr.remove(2);
        System.out.println(arr);
        // removing the element from value
        Integer j = 500;
        arr.remove(j);
        System.out.println(arr);
        // replacing the value at a given index
        arr.set(1, 5000);
        System.out.println(arr);
        // printing values using, for loop
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        // printing values using, forEach loop
        for(int i : arr){
            System.out.println(i);
        }
    }

    // Question 1 -> To remove only the consecutive occurences
        public static ArrayList<Integer> removeConsecutiveDuplicates(int[] arr){
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                result.add(arr[i]);
            }
        }
        return result;
    }

    // Question 2 -> To print only the uniue elements in the array
        public static ArrayList<Integer> onlyUniqueElements(int[] arr){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(arr);
        result.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                result.add(arr[i]);
            }
        }
        return result;
    }
    
    /* Question 3 -> ArrayList Operation 
        -----------------------------------------------------
        Easy Accuracy: 55.45% Submissions: 17479 Points: 2
        -----------------------------------------------------
        Given an ArrayList of N lowercase characters. The task is to count frequency of elements in the list.

        Note: use add() to append element in the list and contains() to check an element is present or not in the list and collections.frequency() to find the frequency of the element in the list.

        Input Format:
        First line of testcase contains T, number of testcases. For each testcase, first line contains number of queries Q. Each query may be any one of the two type:
        1. "i" with "c" : insert the element "c" into the ArrayList
        2. "f" with "c": find the frequency of "c" in the ArrayList.

        Output Format:
        For each testcase, output the frequency of elements. Print "Not Present" if element is not present in the list else its frequency in new line for every query.

        Your Task:
        Your task is to complete the functions insert() and freq() which are used to insert and find frequency of element respectively.

        Constraints:
        1 <= T <= 100
        1 <= N <= 105
        1 <= Q <= 102

        Example:
        Input:
        2 - Test cases
        6 - no of operations prformed
        i g i e i e i k i s f e - operations
        4 - no of operations prformed
        i c i p i p f f - operations

        Output:
        2 
        Not Present

        Explanation:
        Testcase 1: Inserting g, e, e, k, s into the list. Frequency of e is 2 in the list.
        Testcase 2: Inserting c, p, p into the list. Frequency of f is 0 in the list.
    */

        public static void insert(ArrayList<Character> clist, char c){
            clist.add(c);
        }
        
        // Function to count frequency of element
        public static void freq(ArrayList<Character> clist, char c){
        if(clist.contains(c))
        System.out.println(Collections.frequency(clist,c));
        else
        System.out.println("Not Present");
    }

    /* Today's Rank
        Overall Rank : 45519
        Monthly Rank : 28686
    */

    public static void main(String[] args) {
        // ArrayListExample();
        int arr[] = {10, 20, 20, 30, 10, 10, 10, 30, 30, 20};
        System.out.println(removeConsecutiveDuplicates(arr));
        System.out.println(onlyUniqueElements(arr));
    }
}
