public class Day47 {
    
    /* Question 1 -> Amicable Pair
        -----------------------------------------------------
         Easy Accuracy: 62.59% Submissions: 1663 Points: 2 
        -----------------------------------------------------
        Amicable numbers are two different numbers so related that the sum of the proper divisors of each is equal to the other number. 
        (A proper divisor of a number is a positive factor of that number other than the number itself. 
        Given two Numbers A and B, find whether they are Amicable Numbers or not. Print 1 if they are Amicable else 0.
        Example 1:
        Input:
        A = 220 , B = 284
        Output:
        1
        Explanation:
        Proper divisors of 220 are 1, 2,
        4, 5, 10, 11, 20, 22, 44, 55 and 110.
        Sum of these is 284. Proper divisors
        of 284 are 1, 2, 4, 71 and 142
        with sum 220.
    */

    public static int isAmicable(int A , int B) {
        int sumForB = 0, sumForA = 0;
        for(int i = 1; i <= A/2; i++){
            int divisible = (A % i == 0) ? i : 0 ;
            sumForB += divisible;
        }
        for(int i = 1; i <= B/2; i++){
            int divisible = (B % i == 0) ? i : 0 ;
            sumForA += divisible;
        }
        return (sumForA == A && sumForB == B) ? 1 : 0;
    }

    // lesscomplexity

    static long divsum(int n)
    {
        long result = 0;
        for (int i = 2; i <= (int)Math.sqrt(n); i++)
        {
            if (n % i == 0)
            {
                if (i == (n / i))
                    result += i;
                else
                    result += (i + n/i);
            }
        }
        return (result + 1);
    }
    
    static int isAmicableRe(int A , int B) {
        
        // If and only if sum of proper divisors of A is equal to B 
        // and sum of Proper divisors of B is equal to A, we return 1.
        if(A!=B && divsum(A)==B && divsum(B)==A)    
            return 1;
        else
            return 0;
    }

    /* Question 2 -> Reverse Coding 
        -----------------------------------------------------
        Easy Accuracy: 66.33% Submissions: 2677 Points: 2
        -----------------------------------------------------
        Sherlock Being tired with the usual coding rounds started growing his interest towards reverse coding when he won 
        the event in his college symposium. He wondered if his friend has the brain to quickly identify the pattern and verify 
        if his inputs are correct or not. From the example portion given below, where you will be given a number(n) and its output m,
        Using this find the pattern. Your task is that from the pattern you identified above, You have to tell if for the given 
        n whether the given m is the correct answer or not.

        Example to identify the pattern :
        Input                            Output
        10                                 55
        20                                 210
        5                                   15
        0                                    0
        1                                    1
        2                                    3

        Example 1:
        Input:
        n = 10, m = 55 
        Output:
        1
        Explanation:
        It follows the given pattern.
    */

    public static int revCoding(int n, int m) {
        int sum = (n*(n+1))/2;   // Computing (n*(n+1))/2
        
        if(m == sum)
            return 1;
        else
            return 0;
    }

    /* Question 3 ->  Find sum of divisors 
        -----------------------------------------------------
        Easy Accuracy: 63.77% Submissions: 2043 Points: 2 
        -----------------------------------------------------
    */

    public static long integralRoot(int N, int K){
        return (long)(Math.pow(N + 1, K) - Math.pow(N, K));
    }

}
