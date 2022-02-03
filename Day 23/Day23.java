public class Day23 {
    // compressing the string
    // hharsh -> h2arsh
    public static void compressString(String str1){

        String answer = "";
        int frequecy = 1;
        answer += str1.charAt(0);

        for(int i = 1 ; i < str1.length(); ++i){
            if(str1.charAt(i) == str1.charAt(i-1)){
                ++frequecy;
            }
            else{
                if(frequecy>1){
                    answer += frequecy;
                    frequecy =1;
                }
                answer += str1.charAt(i);
            }
        }
        if(frequecy>1){
            answer += frequecy;
        }
        System.out.println(answer); 
    }

    // printing the smallest and the biggest number in the given 3 Strings
    public static void converter(String input1, String input2, String input3){
        // String ans = "";
        if(input1.length() == 0 || input2.length() == 0 || input3.length() == 0){
            return;
        }
        // for(int i = 0; i < str.length(); i++){
        //     char ch = str.charAt(i);
        //     if(Character.isLowerCase(ch)){
        //        str.replace(i, i + 1, ch, Character.toUpperCase(ch));
        //     }
        //     else if(Character.isUpperCase(ch)){
        //         str.replace(i, i + 1, ch, Character.toLowerCase(ch));
        //     }
        // }
        int i = input1.charAt(0) - '0';
        int j = input2.charAt(0) - '0';
        int k = input3.charAt(0) - '0';
        int min1 = Math.min(i, j);
        int min2 = Math.min(min1, k);
        System.out.print(min2);
        if(input1.length() == 1 || input2.length() == 1 || input3.length() == 1){
            return;
        }
        int l = input1.charAt(1) - '0';
        int m = input2.charAt(1) - '0';
        int n = input3.charAt(1) - '0';
        int max1 = Math.max(l, m);
        int max2 = Math.max(max1, n);
        System.out.print(max2);
        converter(input1.substring(2), input2.substring(2), input3.substring(2));
    
    }

    // to find the maximum num character in the string
    public static int MaxNumber(int num){
        int max = Integer.MIN_VALUE;
        for(int i = num; i > 1; i = num/10){
            int j = num % 10;
            if(max < j){
                max = j;
            }
            num = num/10;
        }
        return max;
    }

    // to find the minimum num character in the string
    public static int MinNumber(int num){
        int min = Integer.MAX_VALUE;
        for(int i = num; i > 0; i = num/10){
            int j = i % 10;
            if(min > j){
                min = j;
                
            }
            num = num / 10;
        }
        return min;
    }
}
