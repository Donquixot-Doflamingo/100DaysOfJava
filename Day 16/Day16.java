import java.util.Scanner;

public class Day16 {
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

        
    // binary search algorithm
    public static void binarySearch(int arr[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting no");
        int find = sc.nextInt();
        int s = 0, e = arr.length -1 ,mid = 0;
        while(s<=e){
            mid = (e + s)/2;
            if(arr[mid] < find){
                s = mid + 1;
            }
            else if(arr[mid] > find){
                e = mid - 1;
            }
            else{
                System.out.println(mid);
                sc.close();
                return;
            }
        }
        sc.close();
        System.out.println("Item is not present");
    }

    //required to push all the zeros in the left of the array. O[N^2]
    public static void pushZeroRight(int arr[]){
        for(int i = 0; i<arr.length; i++){
            for(int j =0; j< arr.length-1; j++){
                if(arr[j] == 0){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr);
    }

    //required to push all the zeros in the left of the array. O[N^1]
    public static void pushZeroesRight(int arr[]){
        int nonZero = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[nonZero];
                arr[nonZero] = temp;
                nonZero++;
            }
            
        }
        printArray(arr);
    }

    // to rotate an array too some extent
        // to swap elements
        public static void swap(int arr[], int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

        // reverse an array
        public static void reverse(int arr[], int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

        // rotate the required amount 
        public static void roatate(int arr[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the sum of the array");
        int d = s.nextInt();

        if( d >= arr.length && arr.length != 0){
            d %= arr.length;
        }

        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, arr.length - d - 1);
        reverse(arr, arr.length - d, arr.length - 1);
        s.close();
    }

    //finding the second max elemnet in the array
    public static int secondMaxElement(int arr[]){
        int max = arr[0],secondMax = Integer.MIN_VALUE;
        for(int i = 1; i<arr.length; i++){
            if(max < arr[i]){
                secondMax = max;
                max = arr[i];
            }
            else if(secondMax < arr[i] && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    //finding the degree of the rotated array
    public static int checkRotation(int arr[]){
        int checkValue = 0;
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
            checkValue++;
            }
        }
        return checkValue;
    }

    
}