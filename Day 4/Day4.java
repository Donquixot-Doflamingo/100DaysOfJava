public class Day4 {
    public static void main(String[] args) {
        // print celcius value from n to N with interval of S
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the starting no");
        int entry = s.nextInt();
        System.out.println("Enter the ending no");
        int ending = s.nextInt();
        System.out.println("Enter the step no");
        int step = s.nextInt();
        for(int i = entry; i<=ending; i += step){
            System.out.println(i + " " + (int)((5.0/9)*(i - 32)));
        }

        //figure out if it is a member of fibonacci series or not.

        int a = 0, b=1 , c=1;
        for(int i = 0; i<10000 ; i++){
            c = a + b;
            a=b;
            b=c;
            if(c > n){
                System.out.println("false");
                break;
            }
            else if(c == n){
                System.out.println(i+2 +" true");
                break;
            }
        }
    }

}


class findFactors {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no");
        int number = s.nextInt();
        int i = 2;
        while(i<=number/2){
            if(number%i == 0){
                System.out.println("the factors of the num is " + i);
            }
            i++;
        }
        s.close();
    }
}

class multiplicationTable {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no table you want to see :");
        int table = s.nextInt();
        int multiplier = 1;
        while(multiplier<=10){
            System.out.println(table + " * " + multiplier + " = " + table*multiplier);
            multiplier++;
        }
        s.close();
    }
}

class oddEvenSum {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no");
        int number = s.nextInt();
        int evenSum = 0, oddSum = 0;
        while(number>0){
            int last = number%10;
            if(last%2 == 0){
                evenSum += last;
            }
            else{
                oddSum += last;   
            }  
            number /= 10; 
        }
        System.out.println(evenSum + " " + oddSum);
        s.close();
    }
}

