public class Day51 {

    /*Question 1 -> Return two prime numbers
        -----------------------------------------------------
        Hard Accuracy: 44.55% Submissions: 78180 Points: 8 
        -----------------------------------------------------
        Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. 
        Merge them in sorted order without using any extra space. 
        Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
        Example 1:
        Input: 
        n = 4, arr1[] = [1 3 5 7] 
        m = 5, arr2[] = [0 2 6 8 9]
        Output: 
        arr1[] = [0 1 2 3]
        arr2[] = [5 6 7 8 9]
        Explanation:
        After merging the two 
        non-decreasing arrays, we get, 
        0 1 2 3 5 6 7 8 9.
    */

    public static int nextGap(int gap) {
        
        //It returns the ceil value of gap/2 or 0 if gap is 1.
        if(gap <= 1) return 0; 
        return (gap / 2) + (gap % 2); 
    }
    
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int i, j, gap = n + m;
        long tmp;
        
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            
            //Comparing elements in the first array itself with difference in 
    	    //index equal to the value of gap.
            for(i = 0; i + gap < n; i++){
                if(arr1[i] > arr1[i + gap]){
                    
                    //If element at ith index is greater than element at
    		        //(i+gap)th index, we swap them.
                    tmp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i+gap] = tmp;
                }
            }
            
            //Now comparing elements in both arrays with help of two pointers.
    		//The loop stops whenever any pointer exceeds the size of its array
            for(j = gap > n ? gap-n : 0 ; i < n&&j < m; i++, j++){
                
                //If element in the first array is greater than element in
    		    //second array, we swap them.
                if(arr1[i] > arr2[j]){
                    tmp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }
            
            if(j < m) {
                //At last, comparing elements in the second array itself with 
                //difference in index equal to the value of gap.
                for (j = 0; j + gap < m; j++){
                    
                    //If element at jth index is greater than element at
    		        //(j+gap)th index, we swap them.
                    if(arr2[j] > arr2[j + gap]){
                        tmp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = tmp;
                    }
                }
            }
        }
    }


    /* Question 2 ->  Nth Natural Number 
        -----------------------------------------------------
         Hard Accuracy: 41.17% Submissions: 33354 Points: 8 
        -----------------------------------------------------
        Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.
        Example 1:

        Input:
        N = 8
        Output:
        8
        Explanation:
        After removing natural numbers which contains
        digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
        and 8th number is 8.
    */

    public static long findNth(long N)
    {
        //Observe carefully, base of the given sequence after changes.
        /* logic
            1. It is known that, digits of base 2 numbers varies from 0 to 1. Similarly, digits of base 10 numbers varies from 0 to 9.
            2. Therefore, the digits of base 9 numbers will vary from 0 to 8.
            3. It can be observed that Nth number in base 9 is equal to Nth number after skipping numbers containing digit 9.
            4. So the task is reduced to find the base 9 equivalent of the number N.
        */
        
        long result = 0;
        long p = 1;
        while (N > 0) {
            result += (p * (N % 9));
            N = N / 9;
            p = p * 10;
        }
        return result;
    }

    /* Question 3 -> Find the largest number
        -----------------------------------------------------
        Medium Accuracy: 56.03% Submissions: 1836 Points: 4
        -----------------------------------------------------
        Given an integer N the task is to find the largest number which is smaller or equal to it 
        and has its digits in non-decreasing order.

        Examples 1:
        Input:
        N = 200
        Output:
        199
        Explanation:
        If the given number 
        is 200, the largest 
        number which is smaller 
        or equal to it having 
        digits in non decreasing 
        order is 199.
    */

    public static boolean check(String k){
        int n = k.length();
        for(int i = n-1; i > 0; i--){
            if(k.charAt(i) < k.charAt(i-1)){
                return false;
            }
        }
        return true;
    }

    public static int find(int N){
        // possible solution can be achived by Brute Force
        if(N<10){
            return N;
        }
        while(N>=10){
            String k = Integer.toString(N);
            if(check(k))
                return N;
            N--;
        }
        return N;
    }

    /* Question 4 -> Dyck Path 
        -----------------------------------------------------
        Medium Accuracy: 47.56% Submissions: 427 Points: 4 
        -----------------------------------------------------
        Consider a N x N grid with indexes of top left corner as (0, 0). Dyck path is a staircase walk from bottom left, 
        i.e., (N-1, 0) to top right, i.e., (0, N-1) that lies above the diagonal cells (or cells on line from bottom left to top right).
        The task is to count the number of Dyck Paths from (N-1, 0) to (0, N-1).
        Example 1:

        Input:
        N = 4
        Output:
        14 
        Explanation:
        Refer to the diagram in the link -> (https://bit.ly/3jQIYnM).
    */
 
    static Long dyckPaths(int N) {
        // The number of Dyck paths from (n-1, 0) to (0, n-1) can be given by the Catalan numberC(n).
        // Compute value of 2nCn
    	Long res = 1L;
    	for (int i = 0 ; i<N ; i++){
    		res *= (2*N - i);
    		res /= (i + 1);
    	}
    	// return 2nCn/(n+1)    	
    	return res/(N+1);
    }

    public static void main(String[] args) {
        
    }

    /* Result for today
        GeekForGeeks
        Overall Rank : 52088
        Monthly Rank : 32748
        Score - 239
    */
}
