public class Day22 {
    //check permutation of string
    public static void checkPermutation(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("false as unequal length"); 
            return;
        }

        int count[] = new int[256];

        for(int i = 0 ; i < 256; ++i){
            count[i] = 0;
        }

        for(int i = 0 ; i < str1.length(); i++){
            char ch = str1.charAt(i);
            ++count[ch];
        }
        
        for(int i = 0 ; i < str1.length(); i++){
            char ch = str2.charAt(i);
            --count[ch];
        }

        for(int i = 0 ; i < 256; ++i){
            if(count[i] != 0){
                System.out.println("false as no same element"); 
                return;
            }
        }
        System.out.println("true"); 
    }

    // remove extra characters in the strings
    //abcdecc -> abcdec
    public static void removeDuplicate(String str){
        int n = str.length();
        if(n == 0){
            System.out.println("no strings"); 
            return;
        }

        String finalstr = "";
        int i = 0;
        while(i < n){
            char ch = str.charAt(i);
            int j = i + 1;
            while(j < n && str.charAt(j) == ch){
                j++;
            }
            finalstr += ch;
            i = j;
        }
        System.out.println(finalstr);
    }

    //remove a particular character in the string
    public static void removeChar(String str, char s){
    
        int n = str.length();
        String finalstr = "";
        

        for(int i = 0; i < n; i++){
            if(str.charAt(i) != s){
                finalstr += str.charAt(i);
            }
        }
        System.out.println(finalstr);
    }

    // printing the highest occuring character
    public static void countFrequency(String str1){

        int count[] = new int[256];
        int frequecy = Integer.MIN_VALUE;

        for(int i = 0 ; i < str1.length(); i++){
            count[str1.charAt(i)]++;
            frequecy = Math.max(frequecy, count[str1.charAt(i)]);
        }
        char answer = '\0';

        for(int i = 0 ; i < str1.length(); i++){
            if(count[str1.charAt(i)] == frequecy){
                answer = str1.charAt(i);
                break;
             }
        }
        System.out.println("answer-: " + answer + " frequency-: " + frequecy); 
    }
}

