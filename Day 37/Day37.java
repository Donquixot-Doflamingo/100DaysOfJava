import java.util.ArrayList;

public class Day37 {
    //Question 1
    /*
    An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists).
    Given an array arr[] of size N, find the index of any one of its peak elements.
    Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0. 
    */
    public int peakElement(int[] arr,int n){
		return peakElementUtil(arr,0,n-1,n);
	}
	
	// recursive binary search to find the peak element
	public static int peakElementUtil(int[] arr,int low,int high,int n){
		
		// calculating mid
		int mid=(low+high)>>1;
		
		// if mid is last or first index with first element
        // greater than next.
        // Also, check if mid element is greater than mid - 1 and mid+1
		if ((mid == 0 || arr[mid-1] <= arr[mid]) &&(mid == n-1 || arr[mid+1] <= arr[mid]))
			return mid;
		
		// If mid is other than 0, then check if mid element is less than prev.
        // If so, then recurse for lower half
		else if(mid>0&&arr[mid-1]>arr[mid])
			return peakElementUtil(arr,low,mid-1,n);
			
		// else recurse for the upper half
		else
			return peakElementUtil(arr,mid+1,high,n);
	}

    //question 2
    // Find duplicates in an array 
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        int flag = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) > 1) {
                ans.add(i);
                flag = 1;
            }
        }
        if (flag == 0) ans.add(-1);
        return ans;
    }

    // question 3
    // Find the last index where 0 occurred with LogN
    int transitionPoint(int arr[], int n) {
        if (arr[0] == 1) {
            return 0;
        }
        // Initialise lower and upper bounnds
        int lb = 0, ub = n - 1;

        // Perform Binary search
        while (lb <= ub) {
            // Find mid
            int mid = (lb + ub) / 2;

            // update lower_bound if mid contains 0
            if (arr[mid] == 0) lb = mid + 1;

            // If mid contains 1
            else if (arr[mid] == 1) {
                // Check if it is the left most 1
                // Return mid, if yes
                if (arr[mid - 1] == 0) return mid;

                // Else update upper_bound
                ub = mid - 1;
            }
        }
        return -1;
    }

    // question 4
    //Remove duplicate elements from sorted Array
    int remove_duplicate(int A[],int N){
        int i=0;
        for(int j=1; j<N; j++)
        {
            if(A[j]!=A[i])
            {
                i++;
                A[i] = A[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        
    }
}
