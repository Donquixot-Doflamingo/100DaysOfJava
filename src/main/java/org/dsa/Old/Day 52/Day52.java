import java.util.*;

public class Day52 {

    /*Question 1 -> Java 1-d and 2-d Array 
        -----------------------------------------------------
        Basic Accuracy: 72.23% Submissions: 7375 Points: 1
        -----------------------------------------------------
        Given a integer n. We have n*n values of a 2-d array, and  n values of 1-d array. Task is to find the sum of the left diagonal values of the 2-d array and the max element of the 1-d array and print them with space in between.

        Example 1:

        â€‹Input : arr[][] = {{1,2,3}, {4,5,6}, {7, 8,9}} and N = 3
        brr[] = {3, 6, 9}
        Output : 15 9
        Explanation:
        1 2 3
        4 5 6
        7 8 9
        So, this sum of left diagonal (1+ 5 + 9) = 15
        The maximum element in an array brr is 9
        So, will return {15, 9} as an answer. 
    */

    public static ArrayList<Integer> array(int a[][], int b[], int n){
        int diagnalSum = 0, max = Integer.MIN_VALUE;
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(max < b[i]){
                max = b[i];
            }
        }
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(i == j){
                    diagnalSum += a[i][j];
                }
            }
        }
        out.add(diagnalSum);
        out.add(max);
        return out;
    }

    /* Question 2 -> Closing bracket index
        -----------------------------------------------------
        Easy Accuracy: 66.74% Submissions: 6980 Points: 2 
        -----------------------------------------------------
        Given a string with brackets ('[' and ']') and the index of an opening bracket. 
        Find the index of the corresponding closing bracket.
        Example 1:

        Input:
        S = "[ABC[23]][89]"
        pos = 0
        Output: 8
        Explanation: [ABC[23]][89]
        The closing bracket corresponding to the
        opening bracket at index 0 is at index 8.

        â€‹Example 2:
        Input: 
        S = "ABC[58]"
        pos = 3
        Output: 6
        Explanation: ABC[58]
        The closing bracket corresponding to the
        opening bracket at index 3 is at index 6.
    */

    public static int closing(String s, int pos){
        int n = s.length(), openBrace = 0, closeBrace = 0;
        for(int i = pos; i < n; i++){
            if(s.charAt(i) == '[')
                openBrace++;
            if(s.charAt(i) == ']')
                closeBrace++;
            if(closeBrace == openBrace)
                return i;
        }
        return -1;
    }

    /* Question 3 -> Common Subsequence OldP
        -----------------------------------------------------
         Easy Accuracy: 68.59% Submissions: 2627 Points: 2 
        -----------------------------------------------------
        Given two strings S1 and S2 print whether they contain any common subsequence (non empty) or not.
        NOTE: Print 1 if they have a common subsequence (non empty) else 0.

        Example 1:

        Input: S1 = "ABEF" , S2 = "CADE"
        Output: 1
        Explanation: "A", "E", "AE" are in 
        both S1 and S2.

        Example 2:

        Input: S1 = "ABCDE" , S2 = "FGHIJ"
        Output: 0
        Explanation: There is no common
        subsequences
    */

    public static int commonSubseq(String S1, String S2){
        for(int i=0;i<S1.length();i++)
            if(S2.contains(String.valueOf(S1.charAt(i))))
            return 1;
        return 0;
    }

    /* Question 4 -> Longest Even Length Substring
        -----------------------------------------------------
        Medium Accuracy: 49.99% Submissions: 15119 Points: 4
        -----------------------------------------------------
        For given string ‘str’ of digits, find length of the longest substring of ‘str’, 
        such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
        Input:
        The first line of input contains an integer T denoting the number of test cases. 
        The description of T test cases follows. Each test case contains a string string of length N.

        Output:
        Print length of the longest substring of length 2k such that sum of left k elements is equal to 
        right k elements and if there is no such substring print 0.
        
        Constraints:
        1 ≤ T ≤ 100
        1 ≤ N ≤ 100

        Example:

        Input:
        2
        000000
        1234123

        Output:
        6
        4  
    */

    public static int findLength(String str){
        int n = str.length();
        int maxlen = 0; 
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j += 2){  
                int length = j - i + 1;
                int leftsum = 0, rightsum = 0;
                for (int k = 0; k < length/2; k++){
                    leftsum += (str.charAt(i + k) - '0');
                    rightsum += (str.charAt(i + k + length/2) - '0');
                }
                if (leftsum == rightsum && maxlen < length)
                       maxlen = length;
            }
        }
        return maxlen;
    }

    /* Question 5 ->  Print N-bit binary numbers having more 1s than 0s 
        -----------------------------------------------------
         Medium Accuracy: 77.92% Submissions: 4470 Points: 4 
        -----------------------------------------------------
        Given a positive integer N, the task is to find all the N bit binary numbers having more than 
        or equal 1’s than 0’s for any prefix of the number.
        Example 1:
        Input:  N = 2
        Output: 11 10
        Explanation: 11 and 10 have more than 
        or equal 1's than 0's

        Example 2:
        Input:  N = 3
        Output: 111 110 101
        Explanation: 111, 110 and 101 have more 
        than or equal 1's than 0's
    */

    public static ArrayList<String> NBitBinary(int N) {
        ArrayList<String> out = new ArrayList<String>();
        String s = "";
        NBitBinaryUtil(s, 0, N, out);
        return out;
    }

    public static void NBitBinaryUtil(String number, int extraOnes, int remainingPlaces, ArrayList<String> ans){
		if (remainingPlaces == 0){
			ans.add(number);
			return;
		}
		NBitBinaryUtil(number + "1", extraOnes + 1, remainingPlaces - 1, ans);
		if (0 < extraOnes) 
			NBitBinaryUtil(number + "0", extraOnes - 1, remainingPlaces - 1, ans); 
	}

    /* Question 6 -> Numbers with one absolute difference
        ----------------------------------------------------- 
        Hard Accuracy: 58.64% Submissions: 667 Points: 8
        -----------------------------------------------------
        Given a number N. The task is to return all the numbers less than or equal to N in increasing order, 
        with the fact that absolute difference between any adjacent digits of number should be 1.
        
        Example 1:
        Input: N = 20
        Output: 10 12
        Explanation: Diff between 1 and 0 and
        Diff between 1 and 2 is one.

        Example 2:
        Input:
        N = 9
        Output: -1
        Explanation: No such number exist. 
    */

    public static ArrayList<Long> absDifOne(long N){
        ArrayList<Long> out = new ArrayList<Long>();
        if(N<=9){
            out.add(-1L);
            return out;
        }
        for(long i = 10; i <= N; i++){
            String num = Long.toString(i);
            int num1 = num.charAt(0) - '0';
            int num2 = num.charAt(1) - '0';

            if(num1 - num2 == 1 || num1 - num2 == -1){
                out.add(i);
            }
        }
        return out;
    }
    // fails for the time taken case, expected approch is BFS and queue, haven't covered that topic yet and then come back to the question

    /* Question 7 -> Ugly Numbers
        -----------------------------------------------------
        Hard Accuracy: 50.0% Submissions: 17358 Points: 8
        ----------------------------------------------------- 
        Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
        The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. 
        By convention, 1 is included. Write a program to find Nth Ugly Number.

        Example 1:
        Input:
        N = 10
        Output: 12
        Explanation: 10th ugly number is 12.

        Example 2:
        Input:
        N = 4
        Output: 4
        Explanation: 4th ugly number is 4. 
    */

    public static long getNthUglyNo(int n) {
        long ugly[] = new long[n]; // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        long next_multiple_of_2 = 2;
        long next_multiple_of_3 = 3;
        long next_multiple_of_5 = 5;
        long next_ugly_no = 1;
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_2,Math.min(next_multiple_of_3, next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2) {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3) {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5) {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        }
        return next_ugly_no;
    }

    /* Question 8 ->  Rohan's Love for Matrix 
        -----------------------------------------------------
        Hard Accuracy: 50.32% Submissions: 414 Points: 8
        -----------------------------------------------------
        Rohan has a special love for the matrices especially for the first element of the matrix. 
        Being good at Mathematics, he also loves to solve the different problem on the matrices. 
        So one day he started to multiply the matrix with the original matrix.  
        The elements of the original matrix are given by a00=1 , a01=1, a10=1, a11=0.
        Given the power of the matrix, n calculate the an and return the a10 element mod 1000000007.

        Example 1:
        Input: n = 3
        Output: 2 
        Explanation: Take the cube of the original matrix 
        i.e a3 and the first element(a10) is 2.

        Example 2:
        Input: n = 4
        Output: 3
        Explanation: Take the cube of the original matrix
        i.e a4 and the first element(a10) is 3.
    */

    static final int M = 1000000007; // modulo 
    public static int firstElement(int n) {
        // Use prime number concept.
        int a = 0, b = 1, c, i; 
        if( n == 0)
            return a; 

        for(i = 2; i <= n; i++){ 
            c = (a + b)%M; 
            a = b%M; 
            b = c%M; 
        } 
        return b%M;
    }
    /* Result for today
        GeekForGeeks
        Overall Rank : 46838
        Monthly Rank : 29338
        Score - 268
     */

    /* End of October - 
        GeekForGeeks
        Questions solved -: 94
        Monthlty score -: 241
        Monthly rank -: 29338
     */
}
