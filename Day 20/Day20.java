public class Day20 {
    
    //print no of chars in strings
    public static void printCharOfStrings(String str){
        for(int i=0; i<str.length(); i++){
            System.out.println(str.charAt(i));

        }
    }

    // count the no of words in strings
    public static void printNoOfWords(String str){
        int noOfWords = 0;
        for(int i=0; i<str.length(); i++){
            if(str.length() == 0){
                System.out.println(noOfWords);
            }
            else if(str.charAt(i) == ' '){
                ++noOfWords;
            }
        }
        System.out.println(noOfWords+1);
    }

    //print the reverse of the strings
    public static void reverseString(String str){
        String rev = "";
        // for(int i = str.length() - 1 ; i >= 0; i--){
        //     rev += str.charAt(i);
        // }
        //or we can do this
        for(int i = 0; i < str.length(); i++){
            rev = str.charAt(i) + rev;
        }
        System.out.println(rev);   
    }

    //check if the string is palindrome
    public static void palindromeString(String str){
        for(int i = 0, j = str.length() - 1; i < j; i++,j--){
            if(str.charAt(j) != str.charAt(i)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}