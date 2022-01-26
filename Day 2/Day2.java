import java.util.Scanner;

public class Day2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = s.nextInt();

        // fibonacci series
        int a = 0, b=1 , c;
        for(int i = 0; i<n ; i++){
                c = a + b;
                a=b;
                b=c;
        }
        System.out.println("answer is: " + a);

        //to print all the prime numbers between 2 and N(user input)
        for(int i=2;i<=n;i++){
            boolean isprime = true; 
            for(int j= 2; j<i; j++){
                if(i%j == 0){
                    isprime=false;
                    break;
                }
            }
            if(isprime){
                System.out.println(i);
            }
        } 
        
        // sum or product till 1 to n witch choice c
        
        // int c = s.nextInt();
        // int result;
        // if(c==1){
        //     result =0;
        //     for(int i=1;i<=n;i++){
        //         result += i;
        //     }
        // }
        // else if(c==2){
        //     result =1;
        //     for(int i=1;i<=n;i++){
        //         result *= i;
        //     }
        // }
        // else{
        //     System.out.println("-1");
        //     return;
        // }
        // System.out.println(result);

        // Write a program to print first x terms of the series 3N + 2 which are not multiples of 4.

        int N = 1;
        for(int i=1;i<=n;){
            int num = (3*N) + 2;
            if(N % 4 != 0){
                System.out.println(num);
                i++;
            } 
            N++;
        }

        //Write a program to generate the reverse of a given number N.

        // int rev = 0;
        // for(int i=n;i>0;){
        //     int last_num = i%10;
        //     i /= 10;
        //     rev = (rev * 10) + last_num;
        // }
        // System.out.println(rev);

        //Given a binary number convert it into decimal.
        
        // int decimal_num=0, pow =1;
        // while(n>0){
        //     int last = n%10;
        //     decimal_num += last*pow;
        //     pow *= 2;
        //     n /= 10;
        // }
        // System.out.println(decimal_num);
        s.close();
    }
}