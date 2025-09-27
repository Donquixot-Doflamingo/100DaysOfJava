import java.util.Scanner;

public class Day11 {
        
    // find duplicate no in the array
    public static void findDuplicate(int arr[]){
        int duplicate=0;
        for(int i = 0; i<arr.length; i++){
            int j;
            for(j = 0; j<arr.length; j++){
                if(i != j){
                    if(arr[i] == arr[j]){
                        duplicate = arr[j];
                    }
                }
            }
        }
        System.out.println(duplicate);
    }

    //find the common element in the 2 given array
    public static void arrayIntersection(int arr[], int ay[]){
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<ay.length; j++){
                if(arr[i] == ay[j]){
                    System.out.println(arr[i]);
                    ay[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }

    //to print all the pairs in an array of the selected sum
    //6,3,4,6,1,7,2,6} --> (6,1) (3,4) (6,1) (1,6)
    public static void printPair(int arr[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the sum of the array");
        int sum = s.nextInt();
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                    break;
                }
            }
        }
        s.close();
    }

    //sort the array of zero and one
    //{1, 0, 1, 0, 1, 0, 0, 1} -> 0 0 0 0 1 1 1 1 
    public static void sortZeroOne(int arr[]){
        int nextZero = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                int temp = arr[nextZero];
                arr[nextZero] = arr[i];
                arr[i] = temp;
                nextZero++;
            }
            // with O(n^2)
            // for(int j = i+1; j<arr.length; j++){
            //     if(arr[i] > arr[j]){
            //         int temp = arr[i];
            //         arr[i] = arr[j];
            //         arr[j] = temp;
            //     }
            //     else{
            //         continue;
            //     }
            // }
        }
    }

    // printing triplets pair of array
    public static void printTripletPairs(int arr[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the sum of the array");
        int sum = s.nextInt();
        int noOFPairs = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = i + 1 ; j<arr.length; j++){
                for(int k = j + 1 ;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k] == sum){
                        noOFPairs++;
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " parirs-:  " + noOFPairs);
                    }
                }
            }
        }
        s.close();
    }

    //main 
    public static void main(String[] args)  {
        int arr[] = {1,2,3,4,5,6,7};
        printPair(arr);
    } 
}
