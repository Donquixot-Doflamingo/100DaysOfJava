public class Day13 {
    //question 7 rotate the array by one position in clock-wise direction
    public static int[] rotateArray(int a[]){
        int temp=0, n= a.length;

        temp = a[n-1];
        for(int i=n-1;i>0;i--)
        {
            a[i]=a[i-1];
        }
        a[0]=temp;
        return a;
    }

    //question 8 print the max value in the subarray
    public static int maxSubArray(int a[]){
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0,i=0;

        while(i < a.length){
            max_ending_here = max_ending_here + a[i];
            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
            }
            if(max_ending_here < 0){
                max_ending_here = 0;
            }
            i++;
        }
        return max_so_far;
    }

     //question 9 print the difference between the high and low while working with k
     public static int maxDifference(int arr[], int n, int k){
        
        Arrays.sort(arr);
        printArray(arr);
        int ans = arr[n-1] - arr[0];
        
        for(int i = 0; i < n-1; i++) {
        if(arr[i+1] < k) {
            continue;
        }
            int currMin = Math.min(arr[i+1]-k, arr[0]+k);
            int currMax = Math.max(arr[i]+k, arr[n-1]-k);
            ans = Math.min(ans, currMax-currMin);
        }
        
        return ans;
    }

    // question 10 print the maximum no of jumps can be made
    public static int minimumNumJumps(int a[]){
        int count = 0;
        for(int i = 0; i < a.length-1;i+=a[i]){
            count++;
        }
        return count;
    }

    // question 11 find duplicate in an array of N+1 
    public static int duplicateElement(int[] nums){
        int i=1;
        Arrays.sort(nums);
        while(i < nums.length){
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
            i++;
        }
        return -1;
    }

    // question 12 Merge 2 sorted arrays without using Extra space
    public static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
    
    public static void merge(int arr1[], int arr2[], int n, int m) {
        int i, j, gap = n + m, tmp;
         for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
             for (i = 0; i + gap < n; i++) {
                 if (arr1[i] > arr1[i + gap]) {
                     tmp = arr1[i];
                     arr1[i] = arr1[i + gap];
                     arr1[i + gap] = tmp;
                 }
             }
 
             for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
                 if (arr1[i] > arr2[j]) {
                     tmp = arr1[i];
                     arr1[i] = arr2[j];
                     arr2[j] = tmp;
                 }
             }
 
             if (j < m) {
                 for (j = 0; j + gap < m; j++) {
                     if (arr2[j] > arr2[j + gap]) {
                         tmp = arr2[j];
                         arr2[j] = arr2[j + gap];
                         arr2[j + gap] = tmp;
                     }
                 }
             }
         }
     }

}
