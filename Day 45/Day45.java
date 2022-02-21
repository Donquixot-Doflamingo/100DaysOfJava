public class Day45 {

    /* Question 1 -> Multiply two polynomials
        -----------------------------------------------------
        Easy Accuracy: 83.76% Submissions: 3895 Points: 2
        -----------------------------------------------------
        Given two polynomials represented by two arrays that contains the coefficients of poynomials, returns the polynomial in form of array formed after multiplication of given polynomials.


        Example 1:

        Input:
        M = 4, N = 3
        Arr1 = {1 , 0, 3, 2}
        Arr2 = {2, 0, 4}
        Output: {2, 0, 10, 4, 12, 8}
        Explaination: 
        First polynomial: 
        1 + 0x1 + 3x2 + 2x3
        Second polynomial: 
        2 + 0x1 + 4x2
        Product polynomial:
        2 + 0x1 + 10x2 + 4x3 + 12x4 + 8x5
    */

    public static int[] polyMultiply(int Arr1[], int Arr2[], int M, int N) {
        int arr[] = new int[M+N -1];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                arr[i+j]=arr[i+j]+Arr1[i]*Arr2[j];
                        
            }
        }
        return arr;
    }

    /* Question 2 -> Number of paths
        ---------------------------------------------------------
        Easy Accuracy: 57.18% Submissions: 16806 Points: 2
        ---------------------------------------------------------
        The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the 
        constraints that from each cell you can either move to right or down.
        Example 1:

        Input:
        M = 3 and N = 3
        Output: 6
        Explanation:
        Let the given input 3*3 matrix is filled 
        as such:
        A B C
        D E F
        G H I
        The possible paths which exists to reach 
        'I' from 'A' following above conditions 
        are as follows:ABCFI, ABEHI, ADGHI, ADEFI, 
        ADEHI, ABEFI
    */
    
    public static long numberOfPathsRecusrion(int m, int n) {
        if(m == 1 || n == 1)return 1;
        return  numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
    }

    public static long numberOfPaths(int m, int n) {
        long path = 1; 
        for (int i = n; i < (m + n - 1); i++) { 
            path *= i; 
            path /= (i - n + 1); 
        } 
        return path; 
    }

    /* Question 3 -> Remove Duplicates
        ---------------------------------------------------------
        Easy Accuracy: 55.08% Submissions: 26179 Points: 2
        ---------------------------------------------------------
        Given a string without spaces, the task is to remove duplicates from it.

        Note: The original order of characters must be kept the same. 

        Example 1:

        Input: S = "zvvo"
        Output: "zvo"
        Explanation: Only keep the first
        occurrence
    */

    String removeDups(String S) {
        int arr[] = new int [26];
        int n = S.length();
        String new_str = "";
        
        for(int i=0 ; i<n ; i++){
         if(arr[S.charAt(i) - 'a'] == 0){
          arr[S.charAt(i) - 'a']++;
          new_str += S.charAt(i);
         }
        }
        return new_str;
    }

    /* Question 4 -> Sum of Array Elements
        ---------------------------------------------------------
        Easy Accuracy: 61.02% Submissions: 40228 Points: 2
        ---------------------------------------------------------
        Given an integer array arr of size n, you need to sum the elements of arr.

        Example 1:

        Input:
        n = 3
        arr[] = {3 2 1}
        Output: 6

        Example 2:

        Input:
        n = 4
        arr[] = {1 2 3 4}
        Output: 10
    */

    public static int sumElement(int arr[], int n)
    {
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        return sum;
    }

    /* Question 5 -> Tom and Jerry
        ---------------------------------------------------------
        Easy Accuracy: 75.03% Submissions: 5178 Points: 2
        ---------------------------------------------------------
        Tom and Jerry being bored in this pandemic, decides to play a game. Given an integer N. On each player’s turn, that player makes a move by subtracting a divisor of current N (which is less than N) from current N, thus forming a new N for the next turn. The player who does not have any divisor left to subtract loses the game.

        The game begins with Tom playing the first move. Both Tom and Jerry play optimally. The task is to determine who wins the game. Return 1 if Tom wins, else return 0.

        Example 1:

        Input:
        N = 2
        Output:
        1
        Explanation:
        Tom subtracts 1 from N to make N = 1.
        Now, Jerry isn't left with any possible
        turn so Tom wins the game, and therefore
        the Output is 1.
    */

    public static int numsGame(int N) {
        if(N % 2 == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {
        
    }
}
