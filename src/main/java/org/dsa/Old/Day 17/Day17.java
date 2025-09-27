import java.util.Scanner;

public class Day17 {

    //taking the user input in array
    public static int[] takingInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = s.nextInt();
        int arr[] = new int [size];
        for(int i = 0; i<size; i++){
            System.out.println("Enter the element at" + i + " th index");
            arr[i] = s.nextInt();
        }
        s.close();
        return arr;
    }

    //just to print the array
    public static void printArray(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " " );
        }
        System.out.println();
    }

    /* Starting the task */

    //add two arrays considering array
    //{9,9,9,1,3,4} + {2,0,6,6} = 1 0 0 1 2 0 0 
    public static void addTwoArray(int arr1[], int arr2[]){
        int i = arr1.length-1;
        int j = arr2.length-1;
        int carry = 0;
        int k = Math.max(arr1.length, arr2.length);
        int arr3[] = new int[k+1];

        while(i >= 0 && j >= 0){
            int num = arr1[i] + arr2[j] + carry;
            arr3[k] = num%10;
            carry = num/10;

            i--;
            j--;
            k--;
        }

        while(i >= 0){
            int num = arr1[i] + carry;
            arr3[k] = num%10;
            carry = num/10;
            i--;
            k--;
        }

        while(j >= 0){
            int num = arr2[j] + carry;
            arr3[k] = num%10;
            carry = num/10;
            j--;
            k--;
        }
        arr3[0] = carry;
        
        printArray(arr3);
    }
    public static void main(String[] args)  {
        int arr[] = {9,9,9,1,3,4};
        int arr2[] = {2,0,6,6};
        addTwoArray(arr, arr2);
    }

    //{0, 1, 0, 2, 1, 2, 0, 1, 2, 0, 1, 1, 2, 2, 0, 0} 
    //output-> 0 0 0 0 0 0 1 1 1 1 1 2 2 2 2 2 
    public static void sortZeroOneTwo(int arr[]){
        int nextZero = 0, nextOne = arr.length -1, i = 0;
        while(i <= nextOne){
            if(arr[i] == 0){
                int temp = arr[nextZero];
                arr[nextZero] = arr[i];
                arr[i] = temp;
                i++;
                nextZero++;
            }
            else if(arr[i] == 2){
                int temp = arr[nextOne];
                arr[nextOne] = arr[i];
                arr[i] = temp;
                nextOne--;
            }
            else{
                i++;
            }
        }
        printArray(arr);
    }


    // selection sorting
    public static void selectionSort(int arr[]){
        for(int i = 0; i<arr.length-1; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for(int j = i; j<arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
            // for(int j = i+1; j<arr.length; j++){
            //     if(arr[i] > arr[j]){
            //         min = arr[i];
            //         arr[i] = arr[j];
            //         arr[j] = min;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
}

    // Bubble sorting
    public static void bubbleSort(int arr[]){
        for(int j = 0; j<arr.length-1; j++){
            for(int i = 0; i<arr.length-1-j; i++){
                if(arr[i] > arr[i+1]){
                    int min = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = min;
                }
            }
        }
        printArray(arr);
    }

    // Insertion Sorting
    public static void insertionSort(int arr[]){
        for(int i = 1; i<arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        printArray(arr);
    }

    // merge to sorted arrays and result should be sorted
    public static void mergerSortedArray(int arr[], int ay[]){
        int n = arr.length,m = ay.length,o = m + n;
        int array[] = new int[o];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m){
            if(arr[i] < ay[j]){
                array[k] = arr[i];
                k++;
                i++;
            }
            else{
                array[k] = ay[j];
                k++;
                j++;
            }
        }
        while(i < n){
            array[k] = arr[i];
            i++;
            k++;
        }
        while(j < m){
            array[k] = ay[j];
            j++;
            k++;
        }
        printArray(array);
    }

}
