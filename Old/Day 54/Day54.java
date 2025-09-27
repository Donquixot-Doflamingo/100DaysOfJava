import java.math.BigInteger;
import java.util.*;

public class Day54 {

    /* Question 1 -> Code: N Queens
        You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
        Input Format :
        Line 1 : Integer N
        Output Format :
        One Line for every board configuration. 
        Every line will have N*N board elements printed row wise and are separated by space
        Note : Don't print anything if there isn't any valid configuration.
        Constraints :
        1<=N<=10
        Sample Input 1:
        4
        Sample Output 1 :
        0 1 0 0
        0 0 0 1 
        1 0 0 0 
        0 0 1 0 

        0 0 1 0 
        1 0 0 0 
        0 0 0 1 
        0 1 0 0 
    */

    public static void placeQueen(int n){
        int board[][] = new int[n][n];
        placeQueen(board, n, 0);
    }

    public static void placeQueen(int board[][], int n, int row){
        if(row == n){
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        for(int j = 0; j < n; j++){
            if(isBoardSafe(board, row, j)){
                board[row][j] = 1;
                placeQueen(board, n, row+1);
                board[row][j] = 0;
            }
        }
    }

    public static boolean isBoardSafe(int board[][], int row,  int col){
        int n = board.length;

        for(int i = row - 1, j = col - 1; i>= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1) return false;
        }
        for(int i = row + 1, j = col + 1; i < n && j < n; i++, j++){
            if(board[i][j] == 1) return false;
        }
        for(int i = row - 1, j = col + 1; i>= 0 && j < n; i--, j++){
            if(board[i][j] == 1) return false;
        }

        for(int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--){
            if(board[i][j] == 1) return false;
        }

        for(int i = row - 1; i >= 0; i--){
            if(board[i][col] == 1) return false;
        }

        for(int i = row + 1; i < n; i++){
            if(board[i][col] == 1) return false;
        }

        return true;
    }

    /* Question 2 -> Sum of Big Integers 
        -----------------------------------------------------
        Easy Accuracy: 77.57% Submissions: 8067 Points: 2
        -----------------------------------------------------
        Given two positive integers X and Y. You have to add two integers and output their sum.
        Example 1:

        Input:
        X = 3, Y = 4
        Output:
        7
        Explanation:
        Sum of X and Y is 7
    */
    
    public static BigInteger add(BigInteger x, BigInteger y){
        return x.add(y);
    }

    /* Quesation 3 -> Geek and his Marks 
        -----------------------------------------------------
        Easy Accuracy: 67.34% Submissions: 7742 Points: 2
        -----------------------------------------------------
        There are N students in a class. Each student got arr[i] (1 <= i <= N) marks in mathematics exam. 
        Geek loves mathematics and he got X marks. Now geek is curious to know, 
        how many students in his class got marks greater than that of Geek's.

        Input Format: 
        The first line of the input contains a single integer T denoting the number of test cases. 
        The description of T test cases is as follows:

        The first line of each test case contains two space-separated integers N and X.
        The second line contains N space-separated positive integers representing array arr[ ].

        Output Format:
        In a new line, for each test case, print the count of students who got marks greater than X.

        Constraints:
        1 <= T <= 10
        1 <= N <= 100000
        1 <= arr[i], K <= 100000

        Example:

        Sample Input:
        2
        3 2
        4 1 3
        4 9
        4 8 1 2

        Sample Output:
        2
        0

        Explanation:
        Testcase 1: Students with marks 4 and 3 
        got higher marks than Geek who got 2 marks. 
    */

    public static void ObjectFunctionPractise() {
        Scanner s = new Scanner(System.in);
	
        // no of test cases
		int t = s.nextInt();
	
		while(t > 0){
            // no of inputs, value of x
		    int n = s.nextInt(), x = s.nextInt();
		    
		    int arr[] = new int[n];
		    
            //storing all the marks
		    for(int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		    }

            // counting the no of students having more marks
    		int count = 0;
    	    for(int i = 0; i < n; i++){
    	        if(arr[i] > x) count++;
    	    }

            // printing the no of students got more marks
		    System.out.print(count);

            t--;
		}
        s.close();
    }

    /*
        Today's Rank
        Overall Rank : 45919
        Monthly Rank : 29386
    */
    public static void main(String[] args) {
        // placeQueen(4);
        ObjectFunctionPractise();
    }
}
