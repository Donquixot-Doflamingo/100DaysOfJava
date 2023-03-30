import java.util.*;

public class Day38 {

    // question 1
    // Multiply two strings -> Given two numbers as stings s1 and s2. Calculate their Product.
    // "22" * "3" = "66"
    public static String multiplyStrings(String num1,String num2)
    {
        // return String.valueOf((new BigInteger(s1)).multiply(new BigInteger(s2)));
          int nn=1,mm=1;  
          if(num1.charAt(0)=='-')
              nn=-1; 
          if(num2.charAt(0)=='-')
              mm=-1; 
          
            int mul= nn*mm;
            int n1 = num1.length();
            int n2 = num2.length();
            if (n1 == 0 || n2 == 0)     return "0";
 
            // will keep the result number in ArrayList in reverse order
           
            int result[] = new int[n1 + n2];
            for(int ii = 0 ;ii<n1 + n2;ii++)
                result[ii] = 0;
 
            int i_n1 = 0; // index by num1
            int i_n2 = 0; // index by num2
 
            // go from right to left by num1
            for (int i = n1 - 1; i >= 0; i--)
            {
                if(num1.charAt(i)=='-')
                  continue;
                int carrier = 0;
                int no1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                i_n2 = 0;
                
                // go from right to left by num2
               
                for (int j = n2 - 1; j >= 0; j--)
                {
                    //System.out.println(j);
                    if(num2.charAt(j)=='-')
                      continue;
                  int no2 = Integer.parseInt(String.valueOf(num2.charAt(j))); 
                    
 
                    int sum = no1 * no2 + result[i_n1 + i_n2] + carrier;
                    
                    carrier = sum / 10;
                    result[i_n1 + i_n2] = sum % 10;
                    
                    i_n2++;
                }
                // store carrier in next cell
                if (carrier > 0)
                {
                    result[i_n1 + i_n2] += carrier;
                }
 
                i_n1++;
            }
   
            int i = n1 + n2 - 1;
            while (i>=0 && result[i] == 0) i--;
 
            // if all were '0's - means either both or one of num1 or num2 were '0'
            if(i == -1) return "0";
 
            // generate the result string
            StringBuffer s = new StringBuffer("");
            StringBuffer p = new StringBuffer("");
            
            while (i >= 0)
                {
                    s.append( Integer.toString(result[i] ) );
                    i--;
                }
            if(mul==-1)
            { 
                p.append("-"); 
                p.append(s); 
                
            }
            else
              p.append(s);
            
            return p.toString();
    }

    // question 2
    //Your task  is to implement the function atoi. The function takes a string(str) as argument and converts
    // it to an integer and returns it.
    public static int atoi(String str) {
        int str2 = 0;
        boolean mul = false;
        int i = 0;
        if(str.charAt(0) == '-'){
            mul = true;
            i++;
            System.out.println(" -  encountered" + i);
        }
        for( i = (mul == true ? 1 : 0); i < str.length(); i++){
            int j = str.charAt(i) - '0';
            if(j < 0 || j > 9){
                return -1;
            }
            System.out.println(j);
            str2 = str2*10 + j ;   
        }

        str2 = str2 * (mul == true ? -1 : 1);
        return str2;
        //code here.
    }
    
    // question 3
    // finding square root of a number
    public static long floorSqrt(long x)
	 {
        // way 1
        // long i = 1 ;
        // while (i * i <= x){
        //     i += 1;
        // }
        // return i - 1;
        // way 2
        // base case
		if(x == 0 || x == 1)
        return x;
        
        long start = 1, end = x, ans = 0;
    
        // binary search to find square root of a number
        while(start <= end)
        {
            long mid = (start + end)/2;

            // if mid*mid == x, then mid is the required element
            if(mid*mid == x)
            return mid;
            
            // if mid*mid < x, then iterate for upper half
            if(mid*mid < x)
            {
                start = mid+1;
                ans = mid;
            }
            // else, iterate for lower half
            else
                end = mid - 1;
        }
        return ans;
	 }
    
    // question 4
     // return true if the String is in an IP address (format)
    public static Set<String> allnums;

    public static boolean isValid(String s) {
        allnums = new HashSet<>();
        // allowed segments
        for (int i = 0; i < 256; i++) {
            allnums.add(String.valueOf(i));
        }

        int dots = 0;
        // counting dots
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') dots++;
        }
        if (dots != 3) return false;
        
        // split according to positions of '.'
        String[] nums = s.split("\\.");
        if (nums.length != 4) return false;

        for (String x : nums) {
            if (!allnums.contains(x)) return false;
        }
        return true;
    }
     public static void main(String[] args) {
        System.out.println(floorSqrt(4));
        
    }
}
