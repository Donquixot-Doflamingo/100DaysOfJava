public class Day39 {

    //question 1
    // Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array. 
    public static int equilibriumPoint(long arr[], int n) {    
    // 1) Initialize leftsum  as 0.
    int leftSum = 0, sum = 0;
    // 2) Get the total sum of the array as sum.
    for(int i = 0; i < arr.length; i++){
        sum += arr[i];
    }
    // 3) Iterate through the array and for each index i, do following.
    for(int i = 0; i < arr.length; i++){
        // a)  Update sum to get the right sum. 
            // sum = sum - arr[i]
        sum -= arr[i];
        // b) If leftsum is equal to sum, then return current index.
        if(leftSum == sum){
            return i;
        }
        //    c) Else, update left sum.
        else{
            // leftsum = leftsum + arr[i]
            leftSum += arr[i];
        }
            
    }    
    // 4)  If we come out of loop without returning then there is no equilibrium index return -1.
    return -1;   
    }
        
    // question 2
    // Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. First array has one element extra added in between. Find the index of the extra element.
    public static int findExtra(int a[], int b[], int n) {
        for(int i=0; i<n-1;i++){
            if(a[i]!=b[i])
                return i;
        }
        return n-1;        
    }

    // question 3
    // trapping water
    public static long trappingWater(int arr[], int n) { 
       // left[i] contains height of tallest bar to the 
        // left of ith bar including itself.
        int left[] = new int[n];
        
        // right[i] contains height of tallest bar to 
        // the right of ith bar including itself.
        int right[] = new int[n];
        
        // Storing values of tallest bar from first index till ith index.
        left[0] = arr[0];
        for (int i = 1;i < n;i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        
        // Storing values of tallest bar from last index till ith index.
        right[n - 1] = arr[n - 1];
        for(int i = n - 2;i >= 0;i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        
        
        // Storing the result by choosing the minimum of heights of tallest bar to
        // the right and left of the bar at current index and also subtracting the
        // value of current index to get water accumulated at current index.
        long water = 0;
        for (int i = 1;i < n - 1;i++) {
            water += Math.max(0, Math.min(left[i], right[i]) - arr[i]);
        }
        // returning the result.
        return water;
    } 

    // question 4
    //You are given an integer N. You need to convert all zeroes of N to 5. 
    public static int convert0To5Rec(int num) {
        // Base case for recursion termination
        if (num == 0) return 0;

        // Extract the last digit and change it if needed
        int digit = num % 10;
        if (digit == 0) digit = 5;

        // Convert remaining digits and append the last digit
        return convert0To5Rec(num / 10) * 10 + digit;
    }

    // It handles 0 and calls convert0To5Rec() for other numbers
    public static int convertFive(int num) {
        if (num == 0)
            return 5;
        else
            return convert0To5Rec(num);
    }

    // question 5
    // Rotate the array to the left (counter-clockwise direction) by D steps
    //Function to reverse any part of the array.
    static void rvereseArray(int arr[], int start, int end) 
    { 
        int temp; 

        while (start < end) { 
            //Swapping values at start index and end index.
            temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp;
            //Updating the values of start and end.
            start++; 
            end--; 
        } 
    }
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        //First reversing d elements from starting index.
        rvereseArray(arr, 0, d-1);
        //Then reversing the last n-d elements.
        rvereseArray(arr, d, n - 1); 
        //Finally, reversing the whole array.
        rvereseArray(arr, 0, n - 1); 
    }
    public static void main(String[] args) {
        
    }
}

