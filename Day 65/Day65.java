import java.util.Stack;

public class Day65 {

    // ********************************** Assignment of Stack ***************************************

    /* Question 1 -> Check redundant brackets

        For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
        A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
        Example:
        Expression: (a+b)+c
        Since there are no needless brackets, hence, the output must be 'false'.

        Expression: ((a+b))
        The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
        Note:
        You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
        Input Format :
        The first and the only line of input contains a string expression, without any spaces in between.
        Output Format :
        The first and the only line of output will print either 'true' or 'false'(without the quotes) denoting whether the input expression contains redundant brackets or not.
        Note:
        You are not required to print the expected result. It has already been taken care of.
        Constraints:
        0 <= N <= 10^6
        Where N is the length of the expression.

        Time Limit: 1 second
        Sample Input 1:
        a+(b)+c 
        Sample Output 1:
        true
        Explanation:
        The expression can be reduced to a+b+c. Hence, the brackets are redundant.
        Sample Input 2:
        (a+b)
        Sample Output 2:
        false 
    */

    public static boolean redundant(String s){

        Stack<Character> bracs = new Stack<Character>();

        for(char i : s.toCharArray()){
            if(i != ')')
                bracs.push(i);
    
            else if(i == ')'){

                boolean hasOperator = false;

                while(!bracs.isEmpty() && bracs.peek() != '('){
                    bracs.pop();
                    hasOperator = true;
                }

                if(!hasOperator)
                    return true;

                if(!bracs.isEmpty())
                    bracs.pop();
            }
        }

        return false;
    
    }

    /* Question 2 -> Stock Span

        Afzal has been working with an organization called 'Money Traders' for the past few years. The organization is into 
        the money trading business. His manager assigned him a task. For a given array/list of stock's prices for N days, 
        find the stock's span for each day. The span of the stock's price today is defined as the maximum number of 
        consecutive days(starting from today and going backwards) for which the price of the stock was less than today's price.
        
        For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85], then the stock spans will 
        be [1, 1, 1, 2, 1, 4, 6].
        
        Explanation:
        On the sixth day when the price of the stock was 75, the span came out to be 4, because the last 4 prices
        (including the current price of 75) were less than the current or the sixth day's price.

        Similarly, we can deduce the remaining results.
        Afzal has to return an array/list of spans corresponding to each day's stock's price. Help him to achieve the task.
        Input Format:
        The first line of input contains an integer N, denoting the total number of days.

        The second line of input contains the stock prices of each day. A single space will separate them.
        Output Format:
        The only line of output will print the span for each day's stock price. A single space will separate them.
        Note:
        You are not required to print the expected output explicitly. It has already been taken care of. 
        Constraints:
        0 <= N <= 10^7
        1 <= X <= 10^9
        Where X denotes the stock's price for a day.

        Time Limit: 1 second
        Sample Input 1:
        4
        10 10 10 10
        Sample Output 1:
        1 1 1 1 
        Sample Input 2:
        8
        60 70 80 100 90 75 80 120
        Sample Output 2:
        1 2 3 4 1 1 2 8  
    */

    public static int[] stockSpan(int[] price){
        Stack<Integer> stack = new Stack<Integer>();
        int n = price.length;

        int[] out = new int[n];

        stack.push(0);
        out[0] = 1;

        for(int i = 1; i < n; ++i){
            while(!stack.isEmpty() && price[stack.peek()] < price[i])
                stack.pop();

            if(stack.isEmpty())
                out[i] = i + 1;
            
            else 
                out[i] = i - stack.peek();

            stack.push(i);
        }
        return out;
    }

    /* Question 3 -> Minimum bracket Reversal

        For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to 
        make the expression balanced. The expression will only contain curly brackets.
        If the expression can't be balanced, return -1.
        Example:
        Expression: {{{{
        If we reverse the second and the fourth opening brackets, the whole expression will get balanced. 
        Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

        Expression: {{{
        In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket 
        and hence will not be able to make the expression balanced and the output will be -1.
        Input Format :
        The first and the only line of input contains a string expression, without any spaces in between.
        Output Format :
        The only line of output will print the number of reversals required to balance the whole expression. Prints -1, otherwise.
        Note:
        You don't have to print anything. It has already been taken care of.
        Constraints:
        0 <= N <= 10^6
        Where N is the length of the expression.

        Time Limit: 1sec
        Sample Input 1:
        {{{
        Sample Output 1:
        -1
        Sample Input 2:
        {{{{}}
        Sample Output 2:
        1 
    */

    public static int minBracketReversal(String bracs){
        int n = bracs.length();
        if(n == 0)
            return 1;
        if(n % 2 != 0)
            return -1;
        
        Stack<Character> stack = new Stack<Character>();

        // removing the balance pairs
        for(int i = 0; i < n; i++){
            Character c = bracs.charAt(i);
            if(c == '{'){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && (c == '{'))
                    stack.pop();
                else
                    stack.push(c);
            }
        }

        int count = 0;

        // left with only unbalanced pairs
        
        while(!stack.isEmpty()){
            char a = stack.pop();
            char b = stack.pop();
            // as }{ will require 2 reversal to get balance
            if(a != b)
                count += 2;
            else
             count++;
        }
                return count;
    }

    public static void main(String[] args){
        // Stack<Integer> s = new Stack<Integer>();
        // s.push(1);
        // s.push(11);
        // s.push(111);
        // s.push(1111);
        // System.out.println(s);
        // System.out.println(redundant("(a+b)()(a+b)"));
        // int[] price = {10, 10, 10, 10};
        // int arr[] = stockSpan(price);
        // for(int i = 0; i < arr.length; i++){
        //     System.out.println(arr[i]);
        // }
        System.out.println(minBracketReversal("}{}{"));
    }
}