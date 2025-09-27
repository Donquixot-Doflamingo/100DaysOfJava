public class Day44 {

    // question 1 -> Parenthesis Checker
    /*
        Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
        For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.

        Example 1:
        Input:
        {([])}
        Output: 
        true
        Explanation: { ( [ ] ) }. Same colored brackets can form balaced pairs, with 0 number of unbalanced bracket.
    */

    static boolean ispar(String x)
    {
        int n = x.length();
        int brackL = 0, curlyBrackL = 0, squareBrackL = 0;
        int brackR = 0, curlyBracR = 0, squareBrackR = 0;
        for(int i = 0; i < n; i++){
                if(x.charAt(i) == '(')
                    brackL++;
                
                else if(x.charAt(i) == ')')
                    brackR++;
                
                else  if(x.charAt(i) == '{')
                    curlyBrackL++;
                
                else if(x.charAt(i) == '}')
                    curlyBracR++;
                    
                else  if(x.charAt(i) == '[')
                    squareBrackL++;

                else if(x.charAt(i) == ']')
                    squareBrackR++;
                    
            }
        if(brackL == brackR && curlyBrackL == curlyBracR && squareBrackL == squareBrackR)
            return true;
        else
            return false;
    }

    // question 2 -> Sorted subsequence of size 3
    /*
        Given an array A of N integers, find any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k.
        Example 1:
        Input:
        N = 5
        A[] = {1,2,1,1,3}
        Output: 1
        Explanation: a sub-sequence 1 2 3 exist.
    */

    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        int max = n - 1;
        int min = 0;
        int i = 0;

        int[] smaller = new int[n];
        smaller[0] = -1; // first entry will always be -1
        for (i = 1; i < n; i++) {
            if (arr.get(i) <= arr.get(min)) {
                min = i;
                smaller[i] = -1;
            } else
                smaller[i] = min;
        }

        int[] greater = new int[n];
        greater[n - 1] = -1; // last entry will always be -1
        for (i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= arr.get(max)) {
                max = i;
                greater[i] = -1;
            } else
                greater[i] = max;
        }
        ArrayList<Integer> r = new ArrayList<Integer>();

        for (i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {

                r.add(arr.get(smaller[i]));
                r.add(arr.get(i));
                r.add(arr.get(greater[i]));
                return r;
            }
        }

        return r;
    }
    //question 3 -> Count ways to N'th Stair(Order does not matter)
    /*
        There are N stairs, and a person standing at the bottom wants to reach the top. 
        The person can climb either 1 stair or 2 stairs at a time. 
        Count the number of ways, the person can reach the top (order does not matter).
        Note: Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same.

        Example 1:

        Input:
        N = 4
        Output: 3
        Explanation: You can reach 4th stair in
        3 ways.
        3 possible ways are:
        1, 1, 1, 1
        1, 1, 2
        2, 2 
    */

    Long countWays(int m)
    {
        Long res[] = new Long[m+1];
        
        //base cases
        res[0] = 1L; 
        res[1] = 1L;
        
        //storing number of ways to reach the ith index as 
        //number of ways to reach (i-2)th index +1.
        for (int i = 2; i <= m; i++)  
            res[i] = (res[i-2] + 1);
      
        //returning the result.
        return res[m];
    } 

    // question 4 -> Palindrome string
    
    /*
        Given a string S, check if it is palindrome or not.

        Example 1:

        Input: S = "abba"
        Output: 1
        Explanation: S is a palindrome
    */
    int isPalindrome(String k) {
        if(k.length() <= 1)
            return 1;
            
        if(k.charAt(0) == k.charAt(k.length() - 1))
            return isPalindrome(k.substring(1, k.length() - 1));
            
        else
            return 0;
        }
    public static void main(String[] args) {
        
    }
}
