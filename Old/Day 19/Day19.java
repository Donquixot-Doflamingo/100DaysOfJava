public class Day19 {
    public static void printArray(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " " );
        }
        System.out.println();
    }

    // rotate the array by d

        // rev the whole arr, then rev the n-d and d part -> approach 1
        // reversing the array
        public static void reverse(int arr[], int i, int j){
            while(i<j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // swapping the values
        public static void swap(int arr[], int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // dividing the array by d and n-d and reversing them
        public static void rotateArray(int arr[], int d){
            int n = arr.length-1;
            reverse(arr, 0, n);
            reverse(arr, 0, n-d);
            reverse(arr, n-d+1, d);
            printArray(arr);
        }
   
    // making a new array with d values
    // then, shifting values till d and pasting d in the end -> 2nd approach
    public static void RotateArray(int arr[], int d){
        int [] dArray = new int[d];
        for(int i = 0; i < dArray.length; i++){
            dArray[i] = arr[i];
        }
        for(int i = 0; i < arr.length-d; i++){
            arr[i] = arr[i+d];
        }
        for(int i = 0; i < d; i++){
            arr[arr.length-d+i] = dArray[i];
        }
        dArray = null;
    }
    
    // storing first element and then rotating the whole array 
    //and replacing end by first -> approach 3 - noobie O(n-1 * d)
    public static void rotate(int arr[], int d){
        int count = 0;
        while(count < d){
            int temp = arr[0];
            for(int i =0; i < arr.length-1; i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = temp;
            count++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        rotate(arr, 5);
        printArray(arr);
    }
}
