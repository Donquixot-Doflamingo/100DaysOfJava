public class Day24 {
    //find factorial
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    //find the power of a number
    public static int power(int base, int pow) {
        if (pow == 0) {
            return 1;
        }
        return base * power(base, pow - 1);
    }

    //print the numbers from 1 to n
    public static void printNumbers(int limit) {
        if (limit == 0) {
            return;
        }
        printNumbers(limit - 1);
        System.out.println(limit);
    }

    //print the no of digits in the number
    public static int noOfDigits(int limit) {
        if (limit == 0) {
            return 0;
        }
        int small = noOfDigits(limit / 10);
        return ++small;
    }

    // print the fibonacci nth element
    public static int fibonacci(int num) {

        if (num == 0 || num == 1) {
            return num;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}