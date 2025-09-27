public class Day21 {
    //printing the substring of a given string 
    //pqrs -> p pq pqr pqrs q qr qrs r rs s - (1) 
    public static void printAllSubstring(String str){
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                System.out.print(str.substring(i, j+1)+" ");
            }
        }
    }

    //printing the substring of a given string 
    // pqrs -> p pq pqr pqrs q qr qrs r rs s - (2) 
    public static void printSubstring(String str){
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                for(int k = i; k <= j; k++){
                    System.out.print(str.charAt(k));
                }
                System.out.print(" ");
            }
        }
    }

    //printing the substring of a given string in following pattern  
    //pqrs -> p q r s pq qr rs pqr qrs pqrs
    public static void substring(String str){
        for(int i = 1; i <= str.length(); i++){
            for(int j = 0; j <= str.length()-i; j++){
                int k = i + j - 1;
                System.out.print(str.substring(j, k+1) + " ");
            }
        }
    }

    //print the reverse of the strings
    //pqrs abcd def -> srqp dcba fed 
    public static void reverseCharInWord(String str){
        String revWord = "";
        int currentWord = 0;
        int i = 0;
        for(; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                int currentWordEnd = i-1;
                String rev = "";
                for(int j = currentWord; j <= currentWordEnd; j++){
                    rev = str.charAt(j) + rev;
                }
                revWord += rev + " ";
                currentWord = i+1;
            }
        }
        int currentWordEnd = i-1;
                String rev = "";
                for(int j = currentWord; j <= currentWordEnd; j++){
                    rev = str.charAt(j) + rev;
                }
                revWord += rev + " ";
                currentWord = i+1;
        System.out.println(revWord);   
    }

    // reverse the word in the string
    //pqrs abcd def -> def abcd pqrs
    public static void reverseWord(String str){
        String revWord = "";
        int currentWordEnd = str.length();
        int i = str.length()-1;
        while(i>=0){
            if(str.charAt(i) == ' '){
                revWord += str.substring(i+1, currentWordEnd) + " ";
                currentWordEnd = i;
            }
            i--;
        }
        revWord += str.substring(i+1, currentWordEnd);
        System.out.println(revWord);   
    }
}
