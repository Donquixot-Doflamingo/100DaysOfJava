import java.util.Stack;

public class Day64 {
    // using java collection framework for Stack
    void checkingOutOperations(){
        Stack<Integer> stack = new Stack<>();

        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.size());

        System.out.println("New Stack");
    }

    void initilisingStack(){
        Stack<Integer> stack2 = new Stack<>();

        int arr[] = {1,2,3,4,5};
        
        for(int elem : arr){
            stack2.push(elem);
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }
    }
    
    /*  Question 1 -> Brackets Balanced

        For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. 
        Brackets are said to be balanced if the bracket which opens last, closes first.
        
        Example:
        Expression: (()())
        Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence 
        the output will be, 'true'. You need to return a boolean value indicating whether the expression is balanced or not.
        
        Note:
        The input expression will not contain spaces in between.
        Input Format:
        The first and the only line of input contains a string expression without any spaces in between.
        Output Format:
        The only line of output prints 'true' or 'false'.
        
        Note:
        You don't have to print anything explicitly. It has been taken care of. Just implement the function. 
        Constraints:
        1 <= N <= 10^7
        Where N is the length of the expression.

        Time Limit: 1sec
        Sample Input 1 :
        (()()())
        Sample Output 1 :
        true
        Sample Input 2 :
        ()()(()
        Sample Output 2 :
        false
        Explanation to Sample Input 2:
        The initial two pairs of brackets are balanced. But when you see, the opening bracket at the fourth index 
        doesn't have its corresponding closing bracket which makes it imbalanced and in turn, making the whole
        expression imbalanced. Hence the output prints 'false'.
    */

    static boolean isBalanced(String s){
        Stack<Character> braces = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
                braces.push(s.charAt(i));

            else if(s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')'){
                if(braces.isEmpty())
                    return false;

                if(braces.peek() == '(' && s.charAt(i) == ')' || braces.peek() == '[' && s.charAt(i) == ']' || braces.peek() == '{' && s.charAt(i) == '}')
                    System.out.println(braces.pop());
                else
                    return false;
            }
        }
        if(!braces.isEmpty())
            return false;
        return true;
    }
    
    /* Question 2 -> Reverse Stack

        You have been given two stacks that can store integers as the data. Out of the two given stacks, one is populated and the other one is empty. You are required to write a function that reverses the populated stack using the one which is empty.
        For Example:
        Alt txt

        Input Format :
        The first line of input contains an integer N, denoting the total number of elements in the stack.

        The second line of input contains N integers separated by a single space, representing the order in which the elements are pushed into the stack.
        Output Format:
        The only line of output prints the order in which the stack elements are popped, all of them separated by a single space. 
        Note:
        You are not required to print the expected output explicitly, it has already been taken care of. Just make the changes in the input stack itself.
        Constraints:
        1 <= N <= 10^3
        -2^31 <= data <= 2^31 - 1

        Time Limit: 1sec 
        Sample Input 1:
        6
        1 2 3 4 5 10
        Note:
        Here, 10 is at the top of the stack.
        Sample Output 1:
        1 2 3 4 5 10
        Note:
        Here, 1 is at the top of the stack.
        Sample Input 2:
        5
        2 8 15 1 10
        Sample Output 2:
        2 8 15 1 10 
    */
    
    static void reverseStack(Stack<Integer> input, Stack<Integer> helper){
        if(input.size() <= 1){
            return;
        }

        int lastElem = input.pop();

        reverseStack(input, helper);

        while(!input.isEmpty()){
            helper.push(input.pop());
        }

        input.push(lastElem);

        while(!helper.isEmpty()){
            input.push(helper.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> a = new Stack<Integer>();
        Stack<Integer> helper = new Stack<Integer>();
        a.push(1);
        a.push(2);
        a.push(3);
        System.out.println(a);
        reverseStack(a,helper);
        System.out.println(a);
    }
}
