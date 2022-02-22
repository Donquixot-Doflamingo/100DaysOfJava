public class Day48 {

    /* Question 1 -> Modular Multiplicative Inverse
        ---------------------------------------------------------
        Easy Accuracy: 48.28% Submissions: 41363 Points: 2
        ---------------------------------------------------------
        Given two integers ‘a’ and ‘m’. The task is to find the smallest modular multiplicative inverse of ‘a’ under modulo ‘m’.

        Example 1:

        Input:
        a = 3
        m = 11
        Output: 4
        Explanation: Since (4*3) mod 11 = 1, 4 
        is modulo inverse of 3. One might think,
        15 also as a valid output as "(15*3)
        mod 11"  is also 1, but 15 is not in 
        ring {0, 1, 2, ... 10}, so not valid.
     */

    public int modInverse(int a, int m){
        int value = -1;
        for(int i = 0; i < m; i++){
            int g = 0;
            g = (a*i)%m;
            if(g == 1){
               return i;
            }
        }
        return value;
    }

    /*  Question 2 ->  Three way partitioning
        ---------------------------------------------------------
        Easy Accuracy: 50.02% Submissions: 57939 Points: 2 
        ---------------------------------------------------------

        Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
            1) All elements smaller than a come first.
            2) All elements in range a to b come next.
            3) All elements greater than b appear in the end.
        The individual elements of three sets can appear in any order. You are required to return the modified array.

        Example 1:

        Input: 
        n = 5
        A[] = {1, 2, 3, 3, 4}
        [a, b] = [1, 2]
        Output: 1
        Explanation: One possible arrangement is:
        {1, 2, 3, 3, 4}. If you return a valid
        arrangement, output will be 1.
    */

    public void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public void threeWayPartition(int array[], int a, int b){   
        int low = 0,mid = 0,high=array.length-1;
        while(mid<=high){
            if(array[mid]<a){
                swap(array,low,mid);
                low++;
                mid++;
            }
            else{
                if(array[mid]>b){
                    swap(array,mid,high);
                    high--;
                }
                else{
                    mid++;
                }
            }
            
        }
    }

    /* Question 3 -> Spirally traversing a matrix
        ---------------------------------------------------------
        Medium Accuracy: 48.39% Submissions: 68136 Points: 4
        ---------------------------------------------------------
        Given a matrix of size r*c. Traverse the matrix in spiral form.
        Example 1:

        Input:
        r = 4, c = 4
        matrix[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15,16}}
        Output: 
        1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        Explanation:
    */

    static ArrayList<Integer> spirallyTraverse(int a[][], int m, int n)
    {
        ArrayList<Integer> List=new ArrayList<Integer>();
        int i;
        int k=0,l=0;
       
        while (k < m && l < n) {
           // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                List.add(a[k][i]);
            }
            k++;

           // Print the last column from the remaining
           // columns
            for (i = k; i < m; ++i) {
                List.add(a[i][n - 1]);
            }
            n--;
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    List.add(a[m - 1][i]);
                }
                m--;
            }

           // Print the first column from the remaining
           // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    List.add(a[i][l]);
                }
               l++;
            }
        }
        return List;
    }

    /* Question 4 -> Need Some Change
        ---------------------------------------------------------
        Easy Accuracy: 51.56% Submissions: 31280 Points: 2
        ---------------------------------------------------------
        Given an array arr of n positive integers. The task is to swap every ith element of the array with (i+2)th element.

        Note: When passing array to function, we basically pass the reference to the array. More details here. We'll learn more about pointers and references in upcoming module.

        Example:

        Input:
        n = 5
        arr[] = 1 2 3 4 5
        Output:
        3 4 5 2 1
        Explanation:
        Swapping 1 and 3, makes the array 3 2 1 4 5.
        Now, swapping 2 and 4, makes the array 
        3 4 1 2 5. Again,swapping 1 and 5, makes the 
        array 3 4 5 2 1.
    */

    public void swapElements(int[] arr, int n)
    {
        for(int i = 0; i+2 < n; i++){
            swap(arr, i, i+2);
        }
    }

    /* Question 5 -> Counting elements in two arrays 
        ---------------------------------------------------------
        Easy Accuracy: 47.9% Submissions: 28731 Points: 2
        ---------------------------------------------------------
        Given two unsorted arrays arr1[] and arr2[]. 
        They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].
        Example 1:

        Input:
        m = 6, n = 6
        arr1[] = {1,2,3,4,7,9}
        arr2[] = {0,1,2,1,1,4}
        Output: 4 5 5 6 6 6
        Explanation: Number of elements less than
        or equal to 1, 2, 3, 4, 7, and 9 in the
        second array are respectively 4,5,5,6,6,6
    */

    public static int binary_Search(int arr[], int l, int h, int x){
        while (l <= h)
        {
            int mid = (l+h) / 2;
 
            if (arr[mid] <= x)
                l = mid + 1;

            else
                h = mid - 1;    
        }
        return h;
    } 

    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n){
        ArrayList<Integer> res = new ArrayList<Integer> (0);
        Arrays.sort(arr2);
        
        for(int i = 0; i < m; i++)
        {
            int index = binary_Search(arr2, 0, n-1, arr1[i]);
            res.add (index + 1);
        }
        return res;
    }
    
    public static void main(String[] args) {
        
    }
}
