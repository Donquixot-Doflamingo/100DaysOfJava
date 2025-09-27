public class Day27{
    // 1. print the sum of the elements present in the number
    public static int sumNoOfDigits(int num) {
        if (num < 10) {
            return num;
        }
        return (num%10) + sumNoOfDigits(num / 10);
    }
    
    // 2. remove a paricular character in he sring
    public static String remove(String str, char k){
        if(str.length() == 0){
            return str;
        }
        String ans = "";
        if(str.charAt(0) != k){
            ans = ans + str.charAt(0);
        }
        return ans + remove(str.substring(1), k);
    }

    // 3. replace a particular character in the string
    public static String replace(String str, char replace, char replacement){
        if(str.length() == 0){
            return str;
        }
        char ans;
        if(str.charAt(0) == replace){
            ans = replacement;
        }
        else{
            ans = str.charAt(0);
        }
        return ans + replace(str.substring(1), replace, replacement);
    }

    // 4. remove consecutive duplicate element from the string
    public static String removeDuplicate(String str){
        if(str.length() <= 1){
            return str;
        }
        if(str.charAt(0) == str.charAt(1)){
            return removeDuplicate(str.substring(1));
        }else{
            String small = removeDuplicate(str.substring(1));
            return str.charAt(0) + small;
        }
    }

    /*
        Recursion 2 -> Assignment
    */

    // 5. replace the pi with 3.14 in string, pipi12p -> 3.143.1412p
    public static String replacePi(String str){
        String output;
        if(str.length() <= 1){
            return str;
        }
        String small = replacePi(str.substring(1));
        if(str.charAt(0) == 'p' && small.charAt(0) == 'i'){
            output = "3.14" + small.substring(1);
        }
        else{
            output = str.charAt(0) + small;
        }
        return output;
    }
}