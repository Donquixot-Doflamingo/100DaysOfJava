public class Day33 {
    /*
        Recursion 3 Assignment
    */

    // 1. return the elements which summ tills k
    public static void printSumTillK(int[] arr, int k, int start, int[] out){
        if(start == arr.length){
            if(k == 0){
                for(int i : out){
                    System.out.println(i + " ");
                }
                return;
            }
            else{
                return;
            }
        }
        
        int newOut[] = new int[out.length + 1];

        int i = 0;
        for(; i < out.length; i++){
            newOut[i] = out[i];
        } 
        newOut[i] = arr[start];
        printSumTillK(arr, k-arr[start], start+1, newOut);
        printSumTillK(arr, k, start+1, out);
    }
    // initialisation of printSumTillK
    public static void printSumTillK(int[] arr, int k){
        int[] out = new int[0];
        printSumTillK(arr, k, 0, out);
    }

    // 2. return the codes of the following string
    // "1123" -> aabc aaw alc kbc kw, where a = 1,b = 2 and on.
    public static String[] returnCodes(String str){
        if(str.length() == 0){
            String ans[] = {""};
            return ans;
        }

        int firstDigit = str.charAt(0) - '0';
        String result1[] = returnCodes(str.substring(1));
        String result2[] = new String[0];

        int firstTwoDigit = 0;
        if(str.length() >= 2){
            firstTwoDigit = ((str.charAt(0) - '0') * 10 + str.charAt(1) - '0');
            if(firstTwoDigit > 10 && firstTwoDigit <= 26){
                result2 = returnCodes(str.substring(2));
            }
        }

        String out[] = new String[result1.length + result2.length];
        int k = 0;
        for(String s : result1){
            char firstDigitChar = getChar(firstDigit);
            out[k] = firstDigitChar + s;
            k++;
        }

        for(String s : result2){
            char firstTwoDigitChar = getChar(firstTwoDigit);
            out[k] = firstTwoDigitChar + s;
            k++;
        }
        
        return out;
    }
    
    // converting int number to character
    public static char getChar(int n){
        return (char)(96 + n);
    }

    // 3. printing the codes of the following string
    // "1123" -> aabc aaw alc kbc kw, where a = 1,b = 2 and on.
    public static void printAllcodes(String str, String out){
        if(str.length() == 0){
            System.out.println(out);
            return;
        }
        int firstDigit = str.charAt(0) - '0';
        printAllcodes(str.substring(1), out + getChar(firstDigit));

        if(str.length() > 1){
            int firstTwoDigit = ((str.charAt(0) - '0') * 10 + (str.charAt(1) - '0'));
            if(firstTwoDigit >= 10 && firstTwoDigit <= 26){
                printAllcodes(str.substring(2), out + getChar(firstTwoDigit));
            }
        }
    }
    // initialising the printAllcodes
    public static void printAllcodes(String str){
        printAllcodes(str, "");
    }

    // 4. return the permutation of the input string
    // "abc" -> abc acb bac bca cab cba
    public static String[] returnPermutation(String str){
        if(str.length() == 0){
            String[] out = {""};
            return out;
        }
        
        String[] small = returnPermutation(str.substring(1));
        String[] out = new String[str.length() * small.length];

        int k = 0;
        for(int i = 0; i < small.length; i++){
            String currentString = small[i];
            for(int j = 0; j <= currentString.length(); j++){
                out[k] = currentString.substring(0, j) + str.charAt(0) + currentString.substring(j);
                k++;
            }
        }
        return out;
    }

    // 5. Print palindrome of a string using recursion
    public static Boolean isPalindrome(String k){
        if(k.length() <= 1){
            return true;
        }
        if(k.charAt(0) == k.charAt(k.length() - 1)){
            return isPalindrome(k.substring(1, k.length() - 1));
        }
        else{
            return false;
        }
    }
}
