public class Day49 {
    /* Question 1 -> Excel Sheet | Part - 2
        -------------------------------------------------
        Easy Accuracy: 61.33% Submissions: 2101 Points: 2
        -------------------------------------------------
        Given a string S that represents column title of an Excel sheet, find the number that represents that column.
        In excel A column is number 1, AA is 27 and so on.

        Example 1:

        Input:
        S = A
        Output: 1
    */

    public static int excelColumnNumber(String s) {
        int ans = 0;
        for(char ch: s.toCharArray()){
            ans *= 26;
            ans += ch - 'A' + 1;
        }
        return ans;
    }
    /* Question 2 -> Occurences of 2 as a digit
        -------------------------------------------------
        Medium Accuracy: 52.56% Submissions: 11096 Points: 4
        -------------------------------------------------
        Count the number of 2s as digit in all numbers from 0 to n.

        Input:
        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains the input integer n.

        Output:
        Print the count of the number of 2s as digit in all numbers from 0 to n.

        Constraints:
        1<=T<=100
        1<=N<=10^5

        Example:
        Input:
        2
        22
        100

        Output:
        6
        20
    */

    public static long count2s(long n){
        int count = 0;
        int len = String.valueOf(n).length();
        for (int digit = 0; digit < len; digit++)
        {
            count += count2sinRangeAtDigit(n, digit);
        }
        return count;
    }
    
    public static long count2sinRangeAtDigit(long n, long d){
        long powerOf10 = (int) Math.pow(10, d);
        long nextPowerOf10 = powerOf10 * 10;
        long right = n % powerOf10;
        
        long roundDown = n - n % nextPowerOf10;
        long roundUp = roundDown + nextPowerOf10;
        
        long digit = (n / powerOf10) % 10;
        
        if (digit < 2)
            return roundDown / 10;
        else if (digit == 2)
            return roundDown / 10 + right + 1;
        else 
            return roundUp / 10;
    }

    /* Question 3 ->  Break a number
        -------------------------------------------------
        Easy Accuracy: 73.67% Submissions: 2089 Points: 2 
        -------------------------------------------------
        Given a really large number N, break it into 3 whole numbers such that they sum up to the original number and 
        count number of ways to do so.

        Example 1:
        Input:
        N = 2
        Output:
        6
        Explanation:
        Possible ways to break the number:
        0 + 0 + 2 = 2 
        0 + 2 + 0 = 2
        2 + 0 + 0 = 2
        0 + 1 + 1 = 2
        1 + 1 + 0 = 2
        1 + 0 + 1 = 2
    */

    public static int waysToBreakNumber(int N){
        return ((N+1)*(N+2))/2;
    }

    /* Question 4 -> Yes XOR No
        -------------------------------------------------
        Medium Accuracy: 53.57% Submissions: 3757 Points: 4
        -------------------------------------------------
        You are given two arrays A[] and B[], each of size N, where each element Ai and Bj are distinct. 
        Let's consider an integer X is the count of all different pairs of Ai and Bj, 
        such that Ai XOR Bj is present in any of the two arrays. Return "Yes" (case-sensitive) if X is even, else return "No".
        Example 1:

        Input:
        N =  3
        A[] = {1, 5, 7}
        B[] = {2, 4, 8}
        Output:
        Yes
        Explanation:
        XOR(1,2)=3
        XOR(1,4) = 5 is present in A[]
        XOR(1,8) = 9
        XOR(5,2) = 7 is present in A[]
        XOR(5,4) = 1 is present in A[]
        XOR(5,8) = 13
        XOR(7,2) = 5 is present in A[]
        XOR(7,4) = 3
        XOR(7,8)=15
        Out of all these XOR operations, 
        5,7,1,5 are present, so count of X = 4 
        which is even. Hence the output is "Yes".
    */

    public static String yesXorNo(int N, Long[] A, Long[] B) {
        /*
            The Primary Thing to observe in this problem is that,
            a xor b = c
            then a xor c= b
            Also, b xor c = a

            So If whenever we xor any element from Array A and Array B.
            If its result C is present in the array.....Then surely, we would encounter xoring of a with c...and surely its result will also be present in the array.
            That would make its count even for sure...Basically, Xors occurs in Pairs, always.

            If the result of xoring is not present in the array.THen we dont need to worry, as then we are not counting that pair.
            So, Answer will always be a Yes, irrespective of the input.
        */
        return "Yes";
    }

    /* Question 5 -> Squares in N*N Chessboard
        -------------------------------------------------
        Easy Accuracy: 71.1% Submissions: 5179 Points: 2
        -------------------------------------------------
        Find total number of Squares in a N*N cheesboard.
       
        Example 1:
        Input:
        N = 1
        Output:
        1
        Explanation:
        A 1*1 chessboard has only 1 square.

        Example 2:
        Input:
        N = 2
        Output:
        5
        Explanation:
        A 2*2 chessboard has 5 squares.
        4 1*1 squares and a 2*2 square.
    */

    public static Long squaresInChessBoard(Long N) {
        Long ans = (N*(N+1)*(2*N+1))/6;
        
        return ans;
    }

    /* Result for today
        GeekForGeeks
        Overall Rank : 62625
        Monthly Rank : 39495
        Score - 193
    */
    public static void main(String[] args) {
       ;
        System.out.println( excelColumnNumber("AB"));
    }
}
