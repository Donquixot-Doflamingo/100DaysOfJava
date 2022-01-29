import java.util.Scanner;

class funtionsAndScope {
    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of n");
        //int n = s.nextInt();
        int a =5;
        inc(a);
        System.out.println(a);
        s.close();
    }

    public static int inc(int a){
        a += 10;
        return a;
    }
}

class powerOfANumber {

    public static int Pow(int number, int power) {
        int answer = 1;
        while(power>0){
            answer *= number;
            power--;
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no");
        int number = s.nextInt();
        System.out.println("Enter the power");
        int power = s.nextInt();
        System.out.println( "the answer is : " + Pow(number, power)); 
        s.close();
    }

}

