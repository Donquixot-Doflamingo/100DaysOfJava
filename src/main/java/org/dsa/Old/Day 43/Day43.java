public class Day43 {

    /* Question 1 -> Quick Sort  */

    class QuickSort{
        //Function to sort an array using quick sort algorithm.
        static void quickSort(int arr[], int low, int high){
            if (low < high)
            {
                
                //pi is partitioning index, arr[pi] is now at right place.
                int pi = partition(arr, low, high);
                //Separately sorting elements before and after partitioning index.
                quickSort(arr, low, pi-1);
                quickSort(arr, pi+1, high);
            }
        }
        
        //Function that takes last element as pivot, places the pivot element at 
        //its correct position in sorted array, and places all smaller elements
        //to left of pivot and all greater elements to right of pivot.
        static int partition(int arr[], int low, int high){
            //Picking the pivot.
            int pivot = arr[high];
            //Index of smaller element and indicates the right position of 
            //pivot found so far.
            int i = (low-1); 
            for (int j=low; j<=high-1; j++)
            {
                //If current element is smaller than or equal to pivot we increment
                //the value of i and swap the values at ith and jth index.
                if (arr[j] <= pivot)
                {
                    i++;
                    //Swapping of values at ith and jth index.
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            //At last, swapping of value at ith and the last index which was
            //selected as pivot.
            int temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;
            
            //returning the partitioning index. 
            return i+1;
        } 
    }

    /* Question 2 -> Merge Sort  */

    class MergeSort{
    
    // Merges two subarrays of arr[].
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        void merge(int arr[], int l, int m, int r){
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;
    
            /* Create temp arrays */
            int L[] = new int [n1];
            int R[] = new int [n2];
    
            /*Copy data to temp arrays*/
            for (int i=0; i<n1; ++i)
                L[i] = arr[l + i];
            for (int j=0; j<n2; ++j)
                R[j] = arr[m + 1+ j];
    
    
            /* Merge the temp arrays */
    
            // Initial indexes of first and second subarrays
            int i = 0, j = 0;
    
            // Initial index of merged subarry array
            int k = l;
            while (i < n1 && j < n2)
            {
                if (L[i] <= R[j])
                {
                    arr[k] = L[i];
                    i++;
                }
                else
                {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
    
            /* Copy remaining elements of L[] if any */
            while (i < n1)
            {
                arr[k] = L[i];
                i++;
                k++;
            }
    
            /* Copy remaining elements of L[] if any */
            while (j < n2)
            {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
        
        //method for dividing the array into halves
        public void mergeSort(int arr[], int l, int r)
        {
           
            if (l < r)
            {
                int m = (l+r)/2;
                mergeSort(arr, l, m);
                mergeSort(arr , m+1, r);
                merge(arr, l, m, r);
            }
        }
    }    

    /* Question 3 -> Bubble Sort  */

    class BubbleSort{
        //Function to sort the array using bubble sort algorithm.
        public static void bubbleSort(int arr[], int n){
            int i, j;
            //Traversing over the array.
            for (i = 0; i < n-1; i++)  
            {
                //Last i elements are already in place so we do not include them.
                for (j = 0; j < n-i-1; j++)
                
                if(arr[j] > arr[j+1])
                    {
                        //Swapping, if the element at current index is greater 
                        // than the next element. 
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
            }
                
        }
    
    }

    /* Question 4 -> Insertion Sort  */

    class insertionSort {
        static void insert(int arr[],int i){
            int key = arr[i];
            int j = i-1;
            
            //We run a loop from j and keep shifting the array elements
            //towards right till the element at jth index is greater
            //than element at ith index(key).
            while(j>=0 && arr[j]>key)
            {
                //Shifting of array elements.
                arr[j+1] = arr[j];
                j=j-1;
            }
            //Then we just insert the current element(key) at (j+1)th index.
            arr[j+1]=key;
        }
        
        //Function to sort the array using insertion sort algorithm.
        public void insertionSortFunc(int arr[],int n)
            {
                int i;
                for(i=1;i<n;i++)
                    //Calling of insert function.
                    insert(arr,i);
        }
	
    }

    /* Question 5 -> Precise Fomat - Java 
        There are times when your answer is a floating point that contains undesired amount of digits after decimal. Here, we'll learn how to get a precise answer out of a floating number. You are given two floating numbers a and b. You need to output a/b and decimal precision of a/b upto 3 places after decimal point.
        Note: You may use System.out.format()

        Example 1:

        Input:
        5.43 2.653

        Output:
        2.046739 2.047 
    */

    static void printInFormat(float a, float b){
        //dividing a by b
        float result = a/b;
        
        //printing without formatting
        System.out.print(result + " ");
        
        //printing with formatting
        System.out.format("%.3f", result);
        
    }

    /* Question 6 -> Josephus problem 
        Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is 
        killed in circle in a fixed direction.
        The task is to choose the safe place in the circle so that when you perform these 
        operations starting from 1st place in the circle, you are the last one remaining and survive.

        Example 1:

        Input:
        n = 3 k = 2
        Output: 3
        Explanation: There are 3 persons so 
        skipping 1 person i.e 1st person 2nd 
        person will be killed. Thus the safe 
        position is 3.
    */

    public int josephus(int n, int k)
    {
      if (n == 1) //base case
        return 1;
      else
      /* The position returned by josephus(n - 1, k) is adjusted because the 
       recursive call josephus(n - 1, k) considers the original position  
       k%n + 1 as position 1 */
        return (josephus(n - 1, k) + k-1) % n + 1; //recursion
    }
}
