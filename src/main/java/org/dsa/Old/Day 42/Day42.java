import java.util.Arrays;

public class Day42 {

    // question 1 
    // Rearrange an array with O(1) extra space -> Given an array arr[] of size N where every element is in the range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]].
    static void arrange(long arr[], int n)
    {
        int i = 0;
        
        //Increasing all values by (arr[arr[i]]%n)*n to store the new element.
        for(i = 0; i < n; i++)
         arr[(int)i]+=(arr[(int)arr[(int)i]]%n)*n;
        
        //Since we had multiplied each element with n.
        //We will divide by n too to get the new element at that 
        //position after rearranging.
        for(i = 0; i < n; i++)
            arr[(int)i] = arr[(int)i]/n;
    }

    // question 2
    // Max sum path in two arrays -> 
    /*
    Given two sorted arrays A and B of size M and N respectively. 
    Each array contains only distinct elements but may have some elements in common with the other array. 
    Find the maximum sum of a path from the beginning of any array to the end of any of the two arrays.
    We can switch from one array to another array only at the common elements.
    Note: Only one repeated value is considered in the valid path sum.
    */
    public static int maxPathSum(int ar1[], int ar2[])
    {
        int i = 0, j = 0;
		int result = 0, sum1 = 0, sum2 = 0;
		
		while(i < ar1.length && j<ar2.length)
		{
			if(ar1[i] < ar2[j])
			{
                sum1 += ar1[i++];
                System.out.println(sum1 + " sum1");
            }
				
			else if(ar1[i] > ar2[j])
			{
                sum2 += ar2[j++];
                System.out.println("sum2 " + sum2);
            }
				
			else
			{
                result += Math.max(sum1, sum2);
                System.out.println("result " + result);
				
				sum1 = 0; 
                sum2 = 0;
				
				while(i < ar1.length && j < ar2.length && ar1[i] == ar2[j])
				{
					result = result + ar1[i++];
                    System.out.println("result in while " + result);
					j++;
				}
			}
		}
		
		while(i < ar1.length)
			sum1 = sum1 + ar1[i++];
			
		while(j < ar2.length)
			sum2 = sum2 + ar2[j++];
			
		result += Math.max(sum1, sum2);
		
		return result;
    }

    // question 3
    //  Reverse words in a given string  ->  reverse the string without reversing its individual words. Words are separated by dots
    // S = i.like.this.program.very.much
    // Output: much.very.program.this.like.i
    static public String reverseWords(String str)
    {
        String revWord = "";
            int currentWordEnd = str.length();
            int i = str.length()-1;
            while(i>=0){
                if(str.charAt(i) == '.'){
                    revWord += str.substring(i+1, currentWordEnd) + ".";
                    currentWordEnd = i;
                }
                i--;
            }
            revWord += str.substring(i+1, currentWordEnd);
            return revWord;
    }
    
    // question 4
    // Run Length Encoding
    /* 
    Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
    eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
    You are required to complete the function encode that takes only one argument the string which 
    is to be encoded and returns the encoded string.
    */
    static public String encode(String str)
	{
          String des="";
		for(int i=0;i<str.length();i++)
		{
			des+=str.charAt(i);
			int c=1;
		
			while(i+1<str.length() && str.charAt(i) ==str.charAt(i+1))
			{
			c++;
			i++;
			}
			des+=c+"";
		}
		return des;
	}
    
    // question 5
    // Wave Array
    /*
    Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it
    In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5]
    n = 6
    arr[] = {2,4,7,8,9,10}
    Output: 4 2 8 7 10 9
    Explanation: Array elements after sorting it in wave form are 
    4 2 8 7 10 9.
    */
    public static void convertToWave(int arr[], int n){
        Arrays.sort(arr);
        for(int i = 0; i < n-1; i = i+2){
            if(arr[i] < arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }

    // question 6
    // Check if string is rotated by two places 
    /*
    Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
    Example 1:
    Input: a = amazon, b = azonam
    Output: 1
    Explanation: amazon can be rotated anti
    clockwise by two places, which will make
    it as azonam.
    */
    public static boolean isRotated(String str1, String str2)
    {
        
        if(str1.length() <= 2 || str2.length() <= 2)
            if(str1.equals(str2)) return true;
            else return false;
            
        if(str1.length() != str2.length()) return false;    
        
        int bt = 0;
	    int flag = 0;
	    char c1[] = str1.toCharArray();
	    char c2[] = str2.toCharArray();
        char ck[] = new char[c1.length];
        char ak[] = new char[c1.length]; 
	    
	    //storing anti-clockwise rotation of string by concatenating 
        //substring of size two from end to the starting of the string.
        for(int a=0; a<c1.length-2; a++){
            ck[a] = c1[a+2];
        }
        ck[c1.length-2] = c1[0];
	    ck[c1.length-1] = c1[1];
	    
	    //storing clockwise rotation of string by concatenating substring
        //of size two from beginning to the end of the string.
	    for(int a=2; a<c1.length; a++){
            ak[a] = c1[a-2];
        }
        ak[0] = c1[c1.length-2];
	    ak[1] = c1[c1.length-1];
        
        //checking if any of them is equal to string, we return true.
        for(int a=0; a<c1.length; a++){
            if(ck[a]!=c2[a]&&ak[a]!=c2[a]){
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            bt = 1;
            
        }
        flag = 0;
        
        if(bt == 1)
            return true;
        else
            return false;
        
    }

    // question 7
    // Third largest element
    // Suppose you have A[] = {1, 2, 3, 4, 5, 6, 7}, its output will be 5 because it is the 3 largest element in the array A.
    public static int thirdLargest(int a[], int n)
    {
	    if(a.length <= 2)
            return -1;
        
        int big1 = Math.max(a[0],a[1]);
		int big2 = Math.min(a[0],a[1]);
		int big3 = Integer.MIN_VALUE;

		for(int i=2;i<n;i++)
		{
			/*three way filtering */
			if(a[(int)i]>big3)
			{
				big3= a[(int)i];
			}
			if(a[(int)i]>big2)
			{
				big3 = big2;
				big2 = a[(int)i];
			}
			if(a[(int)i]>big1)
			{
				big2 = big1;
				big1 = a[(int)i];
			}
		}
		return big3;
	}
    public static void main(String[] args) {
        int [] a = {2,3,7,10,12};
        convertToWave(a, a.length);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
    }
}
