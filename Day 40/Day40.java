import java.util.*;

public class Day40 {
    
    //question 1
    // Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
    public static void sort012(int a[], int n){
        int low = 0, high = n-1, mid = 0;
        while(mid <= high){
            if(a[mid]==0) {
                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            } else if(a[mid]==1) {
                mid++;
            } else {
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }
    }

    // question 2
    // You are given an array arr[] of N integers including 0.
    
    /*
        arr[] = {1,2,3,4,5}
        Output: 6
        Explanation: Smallest positive missing 
        number is 6.

        arr[] = {0,-10,1,3,-20}
        Output: 2
        Explanation: Smallest positive missing 
        number is 2.
    */ 
    
    //Function that puts all non-positive (0 and negative) numbers on left 
    //side of arr[] and return count of such numbers.
    static int segregate (int arr[], int size)
    {
        int j = 0, i;
        for(i = 0; i < size; i++)
        {
           if (arr[i] <= 0)  
           {
               int temp;
               //changing the position of negative numbers and 0.
               temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               //incrementing count of non-positive integers.
               j++;  
           }
        } 
        return j;
    }
    
    // Finding the smallest positive missing number in an array 
    //that contains only positive integers.
    static int findMissingPositive(int arr[], int size)
    {
        int i;
        //marking arr[i] as visited by making arr[arr[i] - 1] negative. 
        //note that 1 is subtracted because indexing starts from 0 and 
        //positive numbers start from 1.
        for(i = 0; i < size; i++)
        {
            if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
            arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }
        
        for(i = 0; i < size; i++)
        {
            if (arr[i] > 0)
            {
                //returning the first index where value is positive.
                // 1 is added because indexing starts from 0.
                return i+1;
            }
        }
        return size+1;
    }
    
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        //first separating positive and negative numbers. 
        int shift = segregate (arr, size);
        
        int arr2[] = new int[size-shift];
        int j=0;
        //shifting the array to access only positive part.
        for(int i=shift;i<(size);i++)
        {
            arr2[j] = arr[i];
            j++;
        }
        
        //calling function to find result and returning it.
        return findMissingPositive(arr2, j);
    }

    // question 3
    // Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.  
    static ArrayList<Integer> leaders(int arr[], int n){
        
        int maxEle = arr[n-1];
        
        ArrayList<Integer> res = new ArrayList<>();
        
        //We start traversing the array from last element.
        for(int i=n-1; i>=0; i--) {
            
            //Comparing the current element with the maximum element stored. 
            //If current element is greater than max, we add the element.
		    if(arr[i] >= maxEle){
		        //Updating the maximum element.
		        maxEle = arr[i];
		        //Storing the current element in arraylist for leaders.
		        res.add(maxEle);
		    }
		}
		//Reversing the arraylist.
		Collections.reverse(res);
		//returning the arraylist.
        return res;
    }

    // question 4
    // Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
    void swap(int arr[], int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
    
    int randomPartition(int arr[], int l, int r){
        int n = r-l+1;
        Random rd = new Random();
        int pivot = rd.nextInt(n);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }
    
    int kthSmallest(int arr[], int l, int r, int k)
    {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1)
        {
            // find a position for random partition
            int pos = randomPartition(arr, l, r);
            
            // if this pos gives the kth smallest element, then return
            if (pos-l == k-1)
                return arr[pos];
                
            // else recurse for the left and right half accordingly
            if (pos-l > k-1)  
                return kthSmallest(arr, l, pos-1, k);
            return kthSmallest(arr, pos+1, r, k-pos+l-1);
        }
    
        return Integer.MAX_VALUE;
    }
    
    int partition(int arr[], int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    // question 5
    // Union of two arrays can be defined as the common and distinct elements in the two arrays.
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        int i = 0, j = 0; 
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        //Using two pointers i and j over the two arrays which helps
        //in storing the smaller element.
        while (i < n && j < m) 
        { 
            //Updating the pointer i until we have identical 
            //elements at consecutive position in arr1.
            while(  i+1<n  &&  arr1[i]==arr1[i+1]  )
                i++;
                
            //Updating the pointer j until we have identical 
            //elements at consecutive position in arr2.
            while(  j+1<m  &&  arr2[j]==arr2[j+1]  )
                j++;
                
            //Comparing element of the arrays arr1 and arr2 at pointers
            //i and j and accordingly storing the smaller element
            //and updating the pointers.
            if (arr1[i] < arr2[j]) 
                ans.add(arr1[i++]);
          
            else if (arr2[j] < arr1[i]) 
                ans.add(arr2[j++]);
                
            else
            {
                //If arr1[i] is same as arr2[j], we update both pointers.
                ans.add(arr2[j++]);
                i++;
            }
        } 
        
        //Storing the remaining elements of first array (if there are any).
        while(i < n)
        {
            //Updating the pointer i until we have identical 
            //elements at consecutive position in arr1.
            while(  i+1<n  &&  arr1[i]==arr1[i+1]  )
                i++;
            
            //Storing the elements.
            ans.add(arr1[i++]);
        }
        //Storing the remaining elements of second array (if there are any).
        while(j < m)
        {
            //Updating the pointer j until we have identical 
            //elements at consecutive position in arr2.
            while(  j+1<m  &&  arr2[j]==arr2[j+1]  )
                j++;
            
            //Storing the elements.
            ans.add(arr2[j++]);
        }
        
        //returning the list containing the union of the two arrays. 
        return ans;   
        }
    
    public static void main(String[] args) {
        
    }
}