public class Day28 {
    // Merger Sort in java
    // recursion to divide the array until it become 2 elements for compare
    public static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = (si+ei)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, ei);
    }

    //to check the each element of the two arrays we have to merger
    public static void merge(int[] arr, int si, int ei){
        int size = ei - si +1;
        int mid = (si+ei)/2;
        int[] out = new int[size];
        int i = si, j = mid + 1, k = 0;
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                out[k] = arr[i];
                i++;
                k++;
            }
            else{
                out[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i <= mid){
            out[k] = arr[i];
            i++;
            k++;
        }
        while(j <= ei){
            out[k] = arr[j];
            j++;
            k++;
        }
        for(int l = 0; l < out.length; l++){
            arr[l+si] = out[l];
        }
        out = null;
    }
    
    // initialise the mergesort and print the array
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    // removing the x from a given string
    public static String removeX(String str){
        if(str.length() == 0){
            return str;
        }
        if(str.charAt(0) == 'x'){
            return removeX(str.substring(1));
        }
        return str.charAt(0) + removeX(str.substring(1));
    }

}
