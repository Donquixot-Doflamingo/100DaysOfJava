import java.util.Scanner;

public class Day10 {

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

    // {1,2,3,4,5,6}
    // (1,2) (1,3) (1,4) (1,5) (1,6) (2,3) (2,4) (2,5) (2,6) (3,4)
    // (3,5) (3,6) (4,5) (4,6) (5,6)
    //to print all the pairs as above

    public static void printAllPairs(int arr[]){
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                System.out.println("(" + arr[i] + "," + arr[j] + ")");
            }
        }
    }

    //printing the reverse of an array
    public static void reverseArray(int arr[]){
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        printArray(arr);
    }

        //printing the reverse of an array
        //123456 --> 214365
    public static void swapAlternate(int arr[]){
        for(int i = 0; i<arr.length -1; i +=2){

            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        printArray(arr);
    }

    // to find the unique no in array using xor complexity O(n)
    //limitation can only find one unique value
    public static void findUniqueUsingXOR(int arr[]){
        int answer = 0;
        for(int i = 0; i<arr.length; i++){
         answer = answer^arr[i];
        }
        System.out.println(answer);
    }

    //finding unique no in array using complexity O(n^2)
    public static void findUnique(int arr[]){
        for(int i = 0; i<arr.length; i++){
            int j;
            for(j = 0; j<arr.length; j++){
                if(i != j){
                    if(arr[i] == arr[j]){
                        break;
                    }
                }
            }
            if(j == arr.length){
                System.out.println(arr[i]);
            }
        }
    } 
}
