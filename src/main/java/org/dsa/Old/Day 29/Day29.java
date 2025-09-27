public class Day29 {
    //QuickSort in Java

    // dividing arrays by selecting pivot
    public static void quickSort(int[] arr, int si, int ei){
        // base case
        if(si >= ei){
            return;
        }
        int pivotPos = partition(arr, si, ei);
        // dividing the arrays by elements before pivot and after pivot respectiely
        quickSort(arr, si, pivotPos-1);
        quickSort(arr, pivotPos+1, ei);
    }

    //the sorting of arrays and shifting elements by fixing pivot left<=pivot and pivot<right
    public static int partition(int[] arr, int si, int ei){
        int pivot = arr[si], count = 0;
        //finding the right place for pivot
        for(int i = si+1; i <= ei; i++){
            if(arr[i] <= pivot){
                count++;
            }
        }
        int pivotPos = si + count;
        // swapping initial with realpivot position
        swap(arr, pivotPos, si);
        int i = si, j = ei;
        // arranging elements by fixing pivot left<=pivot and pivot<right
        while(i < pivotPos && j > pivotPos){
            if(arr[i] <= pivot && i < pivotPos){
                i++;
            }
            else if(arr[j] > pivot){
                j--;
            }
            else{
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotPos;
    }

    // swap function
    public static void swap(int[] arr, int s, int p){
        int temp = arr[s];
        arr[s] = arr[p];
        arr[p] = temp;
    }

    // initialising for user
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    // String to integer conversion
    public static int converter(String str){
        int len = str.length();
        if(len == 0){
            return 0;
        }
        int small = converter(str.substring(0, len - 1));
        int nextDigit = str.charAt(len-1) - '0';
        return small*10 + nextDigit;
    }

}
