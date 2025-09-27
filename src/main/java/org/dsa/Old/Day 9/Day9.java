import java.util.Scanner;

public class Day9 {
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
    //adding the elements in the array and giving sum
    public static int addingArrays(int arr[]){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    //telling the max elemnet in the array
    public static int maxElement(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(max < arr[i]){
            max = arr[i];
            }
        }
        return max;
    }

    //searching a specific element in the array
    public static void searchElement(int arr[]){
        Scanner s = new Scanner(System.in);
        int element = s.nextInt();
        for(int i = 0; i<arr.length; i++){
            if(element == arr[i]){
                System.out.println("The element is present at index -: " + i);
                }
        }
        System.out.println("The element is not present");
        s.close();
    }

    //populating a specific array in pattern
    //n = 6 --> {1,3,5,6,4,2}
    public static int[] PopulatorArray(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = s.nextInt();
        int arr[] = new int [size];
        int i = 0, j = size-1, num = 1;
        while(i<=j){
            arr[i] = num;
            i++;
            num++;
            if(i<j){
                arr[j]=num;
                j--;
                num++;
            }
            }
        s.close();
        return arr;
    }

    public static void main(String[] args) {
        
    }

}
