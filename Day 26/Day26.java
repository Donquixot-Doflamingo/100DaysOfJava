public class Day26 {
    // 1. store an array of all the indices of an specific element K
        public static int[] allIndex(int num[], int count, int find) {
            if (count == num.length) {
                int output[] = new int[0];
                return output;
            }
            int smallOutput[] = allIndex(num, count + 1, find);

            if(num[count] == find){
                int output[] = new int[smallOutput.length+1];
                output[0] = count;
                for(int i =0; i<smallOutput.length; i++){
                    output[i+1] = smallOutput[i];
                }
                return output;
            }
            else{
                return smallOutput;
            }
        }
        //function for initialising count
        public static int[] allIndex(int num[], int find){
            return allIndex(num, 0, find);
        }

    // 2. Multiplication with just addition or subtraction
    public static int multiply(int M, int N) {
        if (M == 0 || N == 0) {
            return 0;
        }
        return M + multiply(M, N-1);
    }

    // 3. counting zero in a number
    public static int noOfZero(int limit) {
        if (limit < 10){
            if (limit == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(limit % 10 == 0){
            return noOfZero(limit/10) + 1;
        }
        else{
            return noOfZero(limit/10);
        }
    }

    // 4. GeoSum 1 + 1/2 + 1/4 + 1/2^k
    public static double geoSum(int k){
        if(k==0){
            return 1;
        }
        return 1/Math.pow(2,k) + geoSum(k-1);
    }

    // 5. checking palindrone using recursion -> Approach 1
        public static Boolean palindrome(String k, int end, int start){
            if(start > end){
                return false;
            }
            if(k.charAt(end) == k.charAt(start)){
                palindrome(k, end-1,start+1);
                return true;
            }
            else{
                return false;
            }
        }
        //inistialising palindrome 
        public static Boolean palindrome(String k){
            return palindrome(k, k.length()-1, 0);
        }
   
    // 6. checking palindrone using recursion -> Approach 2
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

    public static void main(String[] args) {
        String str = "rhar";
        System.out.println(isPalindrome(str));

        
    }

}
