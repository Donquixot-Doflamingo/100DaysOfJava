public class Day41 {

    //question 1
    // Maximum Index -> The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.
    static int maxIndexDiff(int arr[], int n) { 
        if(n==1){
            return 0;
        }
        int RMax[] = new int[n]; 
        int LMin[] = new int[n]; 
        
        //Constructing LMin[] such that LMin[i] stores the minimum value 
        //from (arr[0], arr[1], ... arr[i]).
        LMin[0] = arr[0];
        for (int i = 1; i < n; ++i) 
            LMin[i] = Integer.min(arr[i], LMin[i - 1]);
            
        //Constructing RMax[] such that RMax[j] stores the maximum value 
        //from (arr[j], arr[j+1], ..arr[n-1]). 
        RMax[n - 1] = arr[n - 1]; 
        for (int j = n - 2; j >= 0; --j)
            RMax[j] = Integer.max(arr[j], RMax[j + 1]); 
            
        int i = 0, j = 0, maxDiff = -1; 
        //Traversing both arrays from left to right to find optimum j-i.
        //This process is similar to merge() of MergeSort.
        while (j < n && i < n) { 
            if (LMin[i] <= RMax[j]) { 
                //Updating the maximum difference.
                maxDiff = Integer.max(maxDiff, j - i); 
                j++; 
            } else
                i++;
        }
        //returning the maximum difference.
        return maxDiff; 
    }

    // question 2
    // Max sum in the configuration -> Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.
    public static int max_sum(int A[], int n)
    {
        int cum_sum = 0;
		for(int i=0;i<n;i++)
			cum_sum += A[i];
			
		int initial_val = 0;
		int max = 0;

		for(int i=0;i<n;i++)
		{
			initial_val += i*A[i];
			max = initial_val;
		}
		//System.out.println(initial_val);
		
		for(int i=1; i<n;i++)
		{
			
			int temp = initial_val - (cum_sum - A[i-1]) + A[i-1]*(n-1);
			//System.out.println(initial_val);
			initial_val = temp;
			//System.out.println(initial_val);
			if(temp > max)
			max = temp;
		}
		//System.out.println(max);
		return max;
    }
    public static void main(String[] args) {
        
    }
}