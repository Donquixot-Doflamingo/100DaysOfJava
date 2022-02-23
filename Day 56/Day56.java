

public class Day56 {
    /* Question 1 -> Segregate 0s and 1s
        -----------------------------------------------------
        Easy Accuracy: 59.27% Submissions: 29279 Points: 2
        -----------------------------------------------------
        Given an array of length N consisting of only 0s and 1s in random order. Modify the array to segregate 0s on left side and 1s on the right side of the array.

        Example 1:

        Input:
        N = 5
        arr[] = {0, 0, 1, 1, 0}
        Output: 0 0 0 1 1


        Example 2:

        Input:
        N = 4
        Arr[] = {1, 1, 1, 1}
        Output: 1 1 1 1
        Explanation: There are no 0 in the given array, 
        so the modified array is 1 1 1 1. 
    */
    
        /* Approach 1 -> Brute Force
            1) Count the number of 0s and save it in variable X.
            2) For the first X indexes, put 0. For the remaining indexes put 1. 
        */

        public static void segregate0and1(int[] arr, int n) {
            int elementZero = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] == 0){
                    elementZero++;
                }
            }
            for(int i = 0; i < n; i++){
                if(elementZero > 0){
                    arr[i] = 0;
                    elementZero--;
                }
                else{
                    arr[i] = 1;
                }
            }
        }
    
        /* Approach 2 -> 2 Pointers 
            An alternate approach is to traverse using two pointers.
        */
    
        public static void segregate0and1_PointerApprach(int[] arr, int n){
            int i = 0, j = n-1;
            while(i < j){
                if(arr[i] == 0) i++;
                else if(arr[j]== 1) j--;
                else if(arr[j] == 0){
                    arr[i] = 0;
                    i++;
                    arr[j] = 1;
                }
            }
        }
    
    // Question 2 -> sum of the array elements
    
        public static int sumElement(int arr[], int n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += arr[i];
            }
            return sum;
        }
    
    /* Question 3 -> Count the Zeros
            -----------------------------------------------------
            Easy Accuracy: 54.06% Submissions: 36012 Points: 2
            -----------------------------------------------------
            Given an array of size N consisting of only 0's and 1's. The array is sorted in such a manner that all the 1's are placed first and then they are followed by all the 0's. Find the count of all the 0's.
    
            Example 1:
    
            Input:
            N = 12
            Arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
            Output: 3
            Explanation: There are 3 0's in the given array.
    
    
            Example 2:
    
            Input:
            N = 5
            Arr[] = {0, 0, 0, 0, 0}
            Output: 5
            Explanation: There are 5 0's in the array.
        */
        
        /* Approach 1 -> Brute Force -> Start counting from the last till the first 1 interact */
            
            public static int countZeroes(int[] arr, int n) {
                int zeroCounter = 0;
                // if the fist element is also zero then the whole array is filled with 0 as it is sorted
                if(arr[0] == 0){
                    return n;
                }
                for(int i = n-1; i >= 0; i--){
                    if(arr[i] == 1)break;
                zeroCounter++;
                }
                return zeroCounter;
            }
    
        /* Approach 2 -> Use binary search to look for the first occurance of 0. */
            
        public static int firstZero(int arr[], int low, int high) {
                if (high >= low) {
                    int mid = low + (high - low) / 2;
        
                    // Check if mid element is first 0
                    if ((mid == 0 || arr[mid - 1] == 1) && arr[mid] == 0) 
                        return mid;
        
                    // If mid element is not 0
                    if (arr[mid] == 1) 
                        return firstZero(arr, (mid + 1), high);
        
                    // If mid element is 0, but not first 0
                    else
                        return firstZero(arr, low, (mid - 1));
                }
                return -1;
            }
    
        public static int countZeroes_BinarySearch(int arr[], int n) {
                // Find index of first zero in given array
                int first = firstZero(arr, 0, n - 1);
        
                // If 0 is not present at all, return 0
                if (first == -1) 
                    return 0;
        
                return (n - first);
        }

    /* Today's Rank
        Overall Rank : 44841
        Monthly Rank : 28273 
    */

/*
    ************************************************ LinkedList IN JAVA ****************************************************
*/

        // To create the linked list Nodes
        public static Node<Integer> createLinkedList(){
            Node<Integer> n1 = new Node<Integer>(3);
            Node<Integer> n2 = new Node<Integer>(33);
            Node<Integer> n3 = new Node<Integer>(333);
            Node<Integer> n4 = new Node<Integer>(3333);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;

            return n1;
        }

        // To print all the nodes in the linked list
        public static void printNodes(Node<Integer> head){
            while(head != null){
                System.out.println(head.data);
                head = head.next;
            }
        }
    

        public static void main(String[] args) {
        Node<Integer> head = createLinkedList();
        printNodes(head);
    }
    
}
