class pair  {  
    long first, second;  
    public pair(long first, long second) {  
        this.first = first;  
        this.second = second;  
    }  
}

public class Day36{

    // 1. Made a simple game with number question for array using xor
    public static int[] game_with_number (int arr[], int n) {
        for(int i = 0; i < n-1; i++){
            arr[i] = arr[i] ^ arr[i+1];
        }
        return arr;
    }

    // 2. printing the largest number in the array
    public int largest(int arr[], int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    // 3. getting the min and max value of the array
    static pair getMinMax(long arr[], long n)  {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            if(min>arr[i])
            min = arr[i];
        }
        return (new pair(min,max));
    }

    // 4. converting string to lower case
    static String toLower(String S) {
        String convertedS = S.toLowerCase();
        return convertedS;
    }

    // 5. Made a simple game with number question for array using or
    public static int[] game_with_number_with_OR(int arr[], int n) {
        for(int i = 0; i < n-1; i++){
            arr[i] = arr[i] | arr[i+1];
        }
        return arr;
    }

    // 6. count the majority of R or G in a string
    static int RedOrGreen(int N, String S) {
        int countR = 0, countG = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == 'R'){
                countR++;
            }
            if(S.charAt(i) == 'G'){
                countG++;
            }
        }
        if(countR > countG){
                return countG;
            }
        return countR;
    }
    
    // 7. Finding the sum of all characters in the string "1234" etc.
    public static long findSum(String str){
        String temp = "0";
        int sum = 0;
  
        //iterating over the string.
        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
  
            //if current character is digit, we store it in a temporary string.
            if (Character.isDigit(ch))
                temp += ch;
  
            else 
            {
                //incrementing final sum by number stored in temporary string.
                sum += Integer.parseInt(temp);
                //making the temporary string empty again.
                temp = "0";
            }
        }
        //adding any number if it's present in temporary
    	//string to final sum and returning it.
        return sum + Integer.parseInt(temp);
    }

    public static void main(String[] args) {
        System.out.println(toLower("SDs")); 
    }
}
