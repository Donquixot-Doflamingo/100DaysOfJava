import java.util.Arrays;

public class Day18 {

    public static void printArray(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " " );
        }
        System.out.println();
    }

    // Merge Sort array
        static long inversionCount(long arr[], long n)
        {
            long temp[] = new long[(int)n];
            //returning the count of inversions in the array.
            return _mergeSort(arr, temp, 0, n - 1); 
        }

        //Function to mergesort the array, which uses divide and conquer algorithm
        //on left and right halves of array for mergesort operation.
        static long _mergeSort(long arr[], long temp[], long left, long right)
        {
            long mid, inv_count = 0; 
            if (right > left) { 
                mid = (right + left) / 2;
                
                //Calling recursive function to sort left half of the array.
                inv_count = _mergeSort(arr, temp, left, mid);
                
                //Calling recursive function to sort right half of the array.
                inv_count += _mergeSort(arr, temp, mid + 1, right);
                
                //Calling merge function which sorts and merges both halves
                //of the array obtained after calling both recursive function.
                inv_count += merge(arr, temp, left, mid + 1, right); 
            } 
            //returning the count of inversions in the array.
            return inv_count; 
        }
    
        //Function to sort and merge two parts of array and return inversion count. 
        static long merge(long arr[], long temp[], long left,
        long mid, long right) 
        { 
            long i, j, k; 
            long inv_count = 0; 
            //i is pointer for left subarray.
            i = left;
            //j is pointer for right subarray.
            j = mid; 
            //k is index for resultant merged subarray.
            k = left; 
            
            //Using two pointers over the array which helps in storing the
            //smaller element and thus merging the subarray.
            while ((i <= mid - 1) && (j <= right)) {
                
                //Comparing element of the array at pointers i and j and accordingly
                //storing the smaller element and updating the pointers.
                if (arr[(int)i] <= arr[(int)j]) { 
                    temp[(int)k++] = arr[(int)i++]; 
                } 
                else { 
                    temp[(int)k++] = arr[(int)j++]; 
                    //Adding the inversions which is the number of elements which 
                    //are smaller than arr[j] in the left half of the array.
                    inv_count = inv_count + (mid - i); 
                } 
            } 
    
            //Copying the remaining elements of left subarray(if there are any) 
            //to temp.
            while (i <= mid - 1)  
                temp[(int)k++] = arr[(int)i++]; 
    
            //Copying the remaining elements of right subarray(if there are any)
            //to temp.
            while (j <= right) 
                temp[(int)k++] = arr[(int)j++]; 
    
            //Copying back the merged elements to original array.
            for (i = left; i <= right; i++) 
                arr[(int)i] = temp[(int)i]; 
    
            return inv_count; 
        }
        
    // find the unique no in the array -> O(n)
        // works for single unique element 
    public static void uniqueNum(int arr[]){
            int xor = 0;
            for(int i = 0; i < arr.length; i++){
                xor ^= arr[i];
            }
            System.out.println(xor);
        }
       
    // find the duplicate no in the array -> O(n)
        // only works for single duplicate and numbers 
        //from 0 to consecutive nums without sort   
    public static void duplicate(int arr[]){
            //calculating the sum of n natural nums
            int sum = (((arr.length - 2) * (arr.length - 1)) / 2);
            int sumOfAll = 0;
            // calculating the sum of all the elemnts
            for(int i = 0; i < arr.length;  i++){
                sumOfAll += arr[i];
            }
            // simply subtracting the extra element disturbing the formula
            int duplicate = sumOfAll - sum;
            System.out.println(duplicate);
        }
    
    //print the no of pairs which make the following sum
    //{6,-8,4,1,-6,2,-4,15} - > (-6,6), (-4,4) output -> 2
    
    public static int printSumPair(int arr[], int totalSum){
            Arrays.sort(arr);
            int i = 0, j = arr.length-1, sum = 0, count = 0;
            while(i < j){
                sum = arr[i] + arr[j];
                
                if(sum > totalSum){
                    j--;
                }
                else if(sum < totalSum){
                    i++;
                }
                else{
                    int iElement = arr[i], jElement = arr[j];
                    // if the elements on the right and left are same even after sort
                    if(iElement == jElement){
                        int totalElementFromStartToEnd = (j - i) + 1;
                        count += (totalElementFromStartToEnd * (totalElementFromStartToEnd-1))/2;
                        return count;
                    }
                    int iTemp = i + 1, jTemp = j - 1;
                    // if more same elEMENT ON LEFT
                    while( iTemp <= jTemp && arr[iTemp] == iElement){
                        iTemp++;
                    }
                    // if more same elEMENT ON RIGHT
                    while( jTemp >= iTemp && arr[jTemp] == jElement){
                        jTemp--;
                    } 
                    int iTempElement = (iTemp - i), jTempElement = (j - jTemp);
                    count += (iTempElement * jTempElement);
                    i = iTemp;
                    j = jTemp;
    
                }
            }
            return count;
        }

    //print the no of triplets which make the following sum
        
        public static int printSumTriples(int arr[], int totalSum){
            Arrays.sort(arr);
            int count = 0, n = arr.length;
            for(int i = 0; i < n; i++){
                int pairSum = totalSum - arr[i];
                int numPairs = printSumPair(arr,(i+1), (n-1), pairSum);
                count += numPairs;
            }
            return count;
        }

        //this function will calculate if 2 pairs = totalSum - 1 element
        public static int printSumPair(int arr[], int i, int j, int totalSum){
            int sum = 0, count = 0;
            while(i < j){
                sum = arr[i] + arr[j];
                
                if(sum > totalSum){
                    j--;
                }
                else if(sum < totalSum){
                    i++;
                }
                else{
                    int iElement = arr[i], jElement = arr[j];
                    // if the elements on the right and left are same even after sort
                    if(iElement == jElement){
                        int totalElementFromStartToEnd = (j - i) + 1;
                        count += (totalElementFromStartToEnd * (totalElementFromStartToEnd-1))/2;
                        return count;
                    }
                    int iTemp = i + 1, jTemp = j - 1;
                    // if more same elEMENT ON LEFT
                    while( iTemp <= jTemp && arr[iTemp] == iElement){
                        iTemp++;
                    }
                    // if more same elEMENT ON RIGHT
                    while( jTemp >= iTemp && arr[jTemp] == jElement){
                        jTemp--;
                    } 
                    int iTempElement = (iTemp - i), jTempElement = (j - jTemp);
                    count += (iTempElement * jTempElement);
                    i = iTemp;
                    j = jTemp;

                }
            }
            return count;
        }

    public static void main(String[] args)  {
        // int [] arr = {12, 34, 45, 8, 12, 6, 7, 14};
        // System.out.println(sumOfArrayRange());
    } 
}
