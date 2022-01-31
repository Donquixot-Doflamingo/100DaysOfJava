import java.util.*;

public class Day12 {
/*
 Prerequisite
*/

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

    /*********************************************** */
    
    //question - 1-: printing the reverse of an array
    public static void reversArray(int arr[]){
        
        int i = 0,j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        printArray(arr);
    }

    // question 2 & 3 print the max and min till Kth element in the array
    public static void maxminElement(int arr[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int k = s.nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        if(k > arr.length){
            System.out.println("exceding the limit of array");
        }

        for(int i = 0; i<k; i++){
            if(max < arr[i]){
            max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
            s.close();
        }
        System.out.println("Max element -: " + max + "\n Min element -: " + min);
    }

    //question 4 sort 0 , 1, 2
    public static void sortOnesAndTwo(int arr[]){
        
        int i = 0;
        int nextZero = 0, nextTwo = arr.length-1;

        while(i<=nextTwo){
            if(arr[i] == 0){
                int temp = arr[nextZero];
                arr[nextZero] = arr[i];
                arr[i] = temp;
                nextZero++;
                i++;
            }else if(arr[i] == 2){
                int temp = arr[nextTwo];
                arr[nextTwo] = arr[i];
                arr[i] = temp;
                nextTwo--;
            }
            else{
                i++;
            }
        }
        printArray(arr);
    }

    //question 5 Move negative elements to side
    public static void sidelineNegative(int arr[]){
        
        int i = 0;
        int nextNegetive = 0;

        while(i < arr.length){
            if(arr[i] < 0){
                int temp = arr[nextNegetive];
                arr[nextNegetive] = arr[i];
                arr[i] = temp;
                nextNegetive++;
            }
            i++;
        }
        printArray(arr);
    } 

    //question 6 do union of two arrays
    public static int doUnion(int a[], int n, int b[], int m) 
    {
       HashSet<Integer> s =new HashSet<>();
        	for(int i = 0;i<n;i++){
                s.add(a[i]);	
            }      	       
        	 for(int i = 0;i<m;i++){
                s.add(b[i]);
             }
        	  return s.size();
    }

    
}
