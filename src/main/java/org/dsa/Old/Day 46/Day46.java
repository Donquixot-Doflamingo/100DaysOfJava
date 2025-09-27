public class Day46 {
    /* Question 1 -> Case-specific Sorting of Strings 
        ---------------------------------------------------------
        Medium Accuracy: 57.47% Submissions: 15655 Points: 4
        ---------------------------------------------------------
        Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase 
        and lowercase letters separately such that if the ith place in the original string had an Uppercase character 
        then it should not have a lowercase character after being sorted and vice versa.
        Example 1:

        Input:
        N = 12
        S = defRTSersUXI
        Output: deeIRSfrsTUX
        Explanation: Sorted form of given string
        with the same case of character as that
        in original string is deeIRSfrsTUX
    */

    public static String caseSort(String str)
    {

        char[] mixChArr = str.toCharArray();
        
        int lIdx = 0;
        int uIdx = 0;
        
        //counting number of lowercase and uppercase characters.
        for (char ch: mixChArr) 
        {
            if (Character.isUpperCase(ch))
                uIdx++;
            else
                lIdx++;
        }
        
        int upperSize = uIdx;
        int lowerSize = lIdx;
        
        char[] lowerChArr = new char[lowerSize];
        char[] upperChArr = new char[upperSize];
        
        lIdx = 0;
        uIdx = 0;
        
        //storing uppercase and lowercase characters in two separate lists.
        for (char ch: mixChArr) 
        {
            if (Character.isUpperCase(ch))
                upperChArr[uIdx++] = ch;
            else
                lowerChArr[lIdx++] = ch;
        };

        //sorting both the lists.
        Arrays.sort(upperChArr);
        Arrays.sort(lowerChArr);
        
        lIdx = 0;
        uIdx = 0;
        
        //iterating over the given string.
        for (int mIdx = 0; mIdx < mixChArr.length; mIdx++) 
        {
            //if current character is in uppercase then we pick character from  
		    //the list containing uppercase characters and add it to result.
            if (Character.isUpperCase(mixChArr[mIdx])) 
            {
                mixChArr[mIdx] = upperChArr[uIdx++];
            }
            
            //else we pick the character from the sorted list  
		    //containing lowercase characters and add it to result.
            else
            {
                mixChArr[mIdx] = lowerChArr[lIdx++];
            }
        }
        String rtnStr = new String(mixChArr);
        //returning the result.
        return rtnStr;
    }

    /* Question 2 -> Anagram
        ---------------------------------------------------------
        Easy Accuracy: 50.99% Submissions: 53660 Points: 2
        ---------------------------------------------------------
        Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, “act” and “tac” are an anagram of each other.

        Example 1:

        Input:
        a = geeksforgeeks, b = forgeeksgeeks
        Output: YES
        Explanation: Both the string have same characters with same frequency. So, both are anagrams.
    */

    public static boolean isAnagram(String s1,String s2)
    {
        int h1[]=new int[26];
        Arrays.fill(h1,0);

        int i;
        
        //an array of size 26, to store count of characters.
        if(s1.length()!=s2.length())
        {
            return false;
        }
        
        //storing count of each character in first string.
        for(i=0;i<s1.length();i++)
        {
            h1[s1.charAt(i)-'a']++;
        }
        
        //decrementing the count of characters encountered in the second string.
        for(i=0;i<s2.length();i++)
        {
            h1[s2.charAt(i)-'a']--;
        }
        
        //iterating over the array in which we stored the count initially 
        //to check if count at every index is equal to 0 or not.
        //count 0 indicates that number of characters in both strings are same.
        for(i=0;i<26;i++)
        {
            if(h1[i]!=0)
            {
                return false;
            }
        }
        //returning the result.
        return true;
    }

    /* Question 3 -> Count Odd Even 
        ---------------------------------------------------------
        Easy Accuracy: 48.87% Submissions: 36771 Points: 2
        ---------------------------------------------------------
        Given an array A[] of N elements. The task is to count number of even and odd elements in the array.

        Example:

        Input:
        N = 5
        A[] = 1 2 3 4 5
        Output:
        3 2
        Explanation:
        There are 3 odd elements (1, 3, 5)
        and 2 even elements (2 and 4).
    */
    
    public void countOddEven(int[] arr, int n)
    {
        int odd = 0, even = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 == 0){
                even++;
            }
            else
                odd++;
        }
       System.out.println(odd+" "+even);
    }

    /* Question 4 -> N trailing zeroes in factorials
        -------------------------------------------------
        Medium Accuracy: 35.91% Submissions: 638 Points: 4
        -------------------------------------------------
        Given an integer n, find the number of positive integers whose factorial ends with n zeros.
        Example 1:

        Input:
        N = 1
        Output: 5
        Explanation:
        5! = 120, 6! = 720, 7! = 5040, 
        8! = 40320 and 9! = 362880.
        
        Example 2:
        Input:
        N = 5
        Output: 0
    */

    int trailingZeroes(int n){
        int cnt = 0;
        while (n > 0) {
            n /= 5;
            cnt += n;
        }
        return cnt;
    }

    int binarySearch(int n){
        int low = 0;
        double high = 1e9d; 

        while (low < high) {
            int mid = (int)(low + high) / 2;
            int count = trailingZeroes(mid);
            if (count < n)
                low = mid + 1;
            else
                high = mid;
        }

        int ans = 0;
        while (trailingZeroes(low) == n) {
            ans ++;
            low++;
        }
        return ans;
    }

    int countZeroes(int n)
    {
        return binarySearch(n);
    }

    /* Question 5 -> Find maximum number
        ----------------------------------------------------- 
        Easy Accuracy: 78.96% Submissions: 3164 Points: 2 
        ----------------------------------------------------- 
        Given a number N, write a program to find a maximum number that can be formed using all of the digits of this number.
        Note: The given number can be very large, so the input is taken as a String.
        Example 1:
        Input:
        N = "38293367"
        Output:
        98763332 
        Explanation:
        98763332 is the largest number that
        can be formed by rearranging the
        digits of N.

        Example 2:
        Input:
        N = "1203465"
        Output:
        6543210
        Explanation:
        6543210 is the largest number that
        can be formed by rearranging the
        digits of N.
    */

    public static String findMax(String N) {
        int[] freq = new int[10];
        Arrays.fill(freq,0);     // Initializing frequency of all digits as 0.
        
        for(int i=0 ; i<N.length() ; i++)
            freq[N.charAt(i)-'0']++;    // Incrementing the count of digits upon visiting
            
        String ans = "";
        for(int i=9 ; i>=0 ; i--)
        {
            for(int j=0 ; j<freq[i] ; j++)
                ans+=((char)(i+'0'));     // Finally add all the digits to the final string from 9 to 0.
        }
        
        return ans;
    }

}
