import java.util.*;

public class Day50{

    /* Question 1 -> Rank of Matrix 
        -----------------------------------------------------
        Medium Accuracy: 61.77% Submissions: 3343 Points: 4
        -----------------------------------------------------
        Write a program to find the rank of a 3x3 Matrix.

        Input: The first line contains an integer 'T' denoting the total number of test cases. Each test case consists of 3 lines and each line consists of 3 integers. First 3 lines denotes a matrix of whose rank is to be determined.  
        Output: Rank of the matrix is displayed in one line.
        Constraints:

        1 <=T<= 100

        -100 <=N<= 100
        Example:

        Input: 

        2
        10 20 10
        -20 -30 10
        30 50 0
        2 4 3
        1 0 9
        9 6 8

        Output:

        2
        3
    */

    public static void rankOfMatrix(){
        Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int zcount=0;	
	   for(int i=0;i<t;i++){
	       
	       int[][] A = new int[3][3];
	        for(int j=0;j<3;j++){
	           
	            for(int k=0;k<3;k++){
	                A[j][k]=sc.nextInt();
	                if(A[j][k]==0){
	                   zcount++;
	                }
	               
	            }
	        }
	        if(zcount==9){
	            System.out.println(0);
	        }
    	   else{
    	       int det=0;
    	       int det2cnt = 0;
    	       det += A[0][0]*((A[1][1]*A[2][2])-(A[1][2]*A[2][1]));
    	       det += -1*A[0][1]*((A[1][0]*A[2][2])-(A[1][2]*A[2][0]));
    	       det += A[0][2]*((A[1][0]*A[2][1])-(A[1][1]*A[2][0]));
    	       
    	        if((A[0][0]*A[1][1])-(A[0][1]*A[1][0])==0){
    	           det2cnt++;
    	       }
    	        if((A[0][1]*A[1][2])-(A[0][2]*A[1][1])==0){
    	           det2cnt++;
    	       }
    	        if((A[0][0]*A[1][2])-(A[0][2]*A[1][0])==0){
    	           det2cnt++;
    	       }
    	        if((A[1][0]*A[2][1])-(A[1][1]*A[2][0])==0){
    	           det2cnt++;
    	       }
    	        if((A[1][1]*A[2][2])-(A[1][2]*A[2][1])==0){
    	           det2cnt++;
    	       }
    	        if((A[1][0]*A[2][2])-(A[1][2]*A[2][0])==0){
    	           det2cnt++;
    	       }
    	        if((A[2][0]*A[0][1])-(A[2][1]*A[0][0])==0){
    	           det2cnt++;
    	       }
    	        if((A[2][1]*A[0][2])-(A[2][2]*A[0][1])==0){
    	           det2cnt++;
    	       }
    	        if((A[2][0]*A[0][2])-(A[2][2]*A[0][0])==0){
    	           det2cnt++;
    	       }
    	       if(det==0){
    	           if(det2cnt==9){
    	              System.out.println(1);
    	           }
    	           else{
    	               System.out.println(2);
    	           }
    	       }
    	       else{
    	          System.out.println(3);
    	       }
	       
	        }
	   }
       sc.close();
    }

    /* Question 2 -> Assign Mice Holes 
        -----------------------------------------------------
        Easy Accuracy: 73.79% Submissions: 1715 Points: 2 
        -----------------------------------------------------
        Given, N Mice and N holes are placed in a straight line. Each hole can accommodate only 1 mouse.
        A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x -1. 
        Any of these moves consumes 1 minute. Write a program to assign mice to holes so that the time when the last 
        mouse gets inside a hole is minimized.
        Note: Arrays M and H are the positions of the N mice and holes.

        Example 1:

        Input:
        N = 3
        M = {4, -4, 2}
        H = {4, 0, 5}
        Output:
        4
        Explanation:
        If we assign mouse at 1st index to
        the hole at 1st, mouse at 2nd index
        to the hole at 2nd and the third to
        the hole at third. Then, the maximum
        time taken will be by the 2nd mouse,
        i.e. 4-0 = 4 minutes.
    */

    public static int assignMiceHoles(int N , int[] M , int[] H) {
        Arrays.sort(M); 
        Arrays.sort(H);
        
        int ans = -1;
        
        /* finding max difference between ith mice and hole */
        for(int i=0 ; i<N ; i++)
            ans = Math.max(ans,Math.abs(M[i]-H[i]));

        return ans;
    }

    /* Question 3 -> Form a number divisible by 3 using array digits
        ----------------------------------------------------- 
        Easy Accuracy: 55.7% Submissions: 19653 Points: 2
        -----------------------------------------------------
        Given an array arr of integers of length N, the task is to find whether it’s possible to construct an integer using all the digits of these numbers such that it would be divisible by 3. If it is possible then print “1” and if not print “0”.

        Example 1:

        Input: N = 3
        arr = {40, 50, 90}
        Output: 1
        Explaination: One such number is 405900.
        Example 2:

        Input: N = 2
        arr = {1, 4}
        Output: 0
        Explaination: The numbers we can form 
        are 14 and 41. But neither of them are 
        divisible by 3.
    */

    public static int isPossible(int N, int arr[]) {
        int rem = 0;
         for (int i = 0; i < N; i++) rem = (rem + arr[i]) % 3;
         return (rem == 0) ? 1 : 0;
     }

    /* Question 4 -> Check if the number is balanced
        ----------------------------------------------------- 
        Easy Accuracy: 61.3% Submissions: 10666 Points: 2 
        ----------------------------------------------------- 
        Given an integer N which has odd number of digits, find whether the given number is a balanced or not.
        An odd digit number is called a balanced number if the sum of all digits to the left of the middle digit 
        and the sum of all digits to the right of the middle digit is equal.

        Example 1:
        Input:
        N = 1234006
        Output: 1 
        Explanation: Total number of digits in
        N = 7. Middle digit is 4. LHS = 1+2+3 = 6
        and RHS = 0+0+6 = 6. LHS is equal to RHS. 

        Example 2:
        Input:
        N = 12345
        Output: 0
        Explanation: LHS = 1+2 = 3 and RHS = 4+5
        = 9. LHS and RHS are not equal.
    */

     public static Boolean balancedNumber(String N){ 
        int n = N.length();
        int mid = n/2; 
        int leftSum = 0, rightSum = 0;
        
        for(int i = 0; i < mid; i++){
            int num = N.charAt(i) - '0';
            leftSum += num;
        }
        for(int i = mid+1; i < n; i++){
            int num = N.charAt(i) - '0';
            rightSum += num;
        }

        return (leftSum == rightSum) ? true : false;  
     }

    /* Question 5 -> Matchsticks game 
        ----------------------------------------------------- 
        Medium Accuracy: 70.8% Submissions: 2132 Points: 4 
        ----------------------------------------------------- 
        Two friends, A and B, are playing the game of matchsticks. In this game, a group of N matchsticks is placed on the table. The players can pick any number of matchsticks from 1 to 4 (both inclusive) during their chance. The player who takes the last match stick wins the game. If A starts first, how many matchsticks should he pick such that he is guaranteed to win the game or determine if it's impossible for him to win.
        Note : Consider both A and B play the game optimally.
        Example 1:

        Input:
        N = 48
        Output:
        3
        Explanation:
        Player A is guaranteed a win if he
        picks 3 matchsticks first.

        Example 2:

        Input:
        N = 15
        Output:
        -1
        Explanation:
        Player A is guaranteed a loss no matter
        how many matches he picks at first.
    */

    public static int matchGame(Long N) {
        if(N % 5 == 0){
            return -1;
        }
        long returnValue = N % 5;
        return (int)returnValue;
    }

    /* Result for today
        GeekForGeeks
        Overall Rank : 58227
        Monthly Rank : 36641
        Score - 211
    */

    public static void main(String[] args) {
        
    }
}