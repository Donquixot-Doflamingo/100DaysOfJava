import java.util.Scanner;

public class Day3{
    public static void main(String[] args)  {
        int n = 0;
        //Given a decimal number convert it into binary.

        int binary = 0, pow =1;
        while(n>0){
            int remainder = n%2;
                binary += remainder*pow; 
                pow *= 10;
            n = (n)/2;
        }
        System.out.println(binary);

        //Given a number N, find its square root.
        
        int output =0;
        while((output * output) <= n){
            output++;
        }
        System.out.println(output-1);

        // to check if the no are increasing or decrasing of increasing and decreasing but not increasing again
        boolean isDec = true;
        Scanner s = new Scanner(System.in);
        int prev = s.nextInt();
        int curr;
        int count = 2;
        while(count<=n){ 
        curr = s.nextInt();
            count++;
            if(curr == prev){
                System.out.println("false");
                return;
            }
            if(curr < prev){
                if(isDec==false){
                    System.out.println("false");
                    return;
                }
            }
            else{
                if(isDec==true){
                    isDec = false;
                }
            }
            prev = curr;
        }
        System.out.println("true");

        // WAP to check whenther a number is a palindrome or not
        int rev = 0;
        for(int i=n;i>0;){
            int last_num = i%10;
            i /= 10;
            rev = (rev * 10) + last_num;
        }
        if(rev == n){
            System.out.println("Number is a palindrone");
        }
        s.close();
    } 
}

class salaryCalculator {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your basic salary :");
        int basicSalary = s.nextInt();
        char category = s.next().charAt(0);
        int allow = 0;
        double da = (basicSalary*0.5), hra = (basicSalary*0.2), pf = (basicSalary*0.11);
        if(category == 'A'){
            allow = 1700;
        }
        else if(category == 'B'){
            allow = 1500;
        }
        else{
            allow = 1300;
        }
        double totalSalary = basicSalary + allow + hra + da -pf;
        System.out.println("Total salary : " + (int)totalSalary);
        s.close();
    }
}