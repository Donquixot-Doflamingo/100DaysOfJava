public class Day32 {
    
    // 1. do binary search using recursion
    public static int binaryRecursion(int[] arr, int x, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == x){
            return mid;
        }
        else if(arr[mid] > x){
            return binaryRecursion(arr, x, start, mid-1);
        } 
        else{
            return binaryRecursion(arr, x, mid+1, end);
        }
    }
    // initialising the array
    public static int binaryRecursion(int arr[], int x){
        return binaryRecursion(arr, x, 0, arr.length-1);
    }

    // 2. returning the subsequence of the array
    // {1,2,3} -> [null],3, 2, 2 3, 1, 1 3, 1 2, 1 2 3
    public static int[][] subsequenceArray(int[] arr, int start){
        if(start == arr.length){
            int[][] out = new int[1][0];
            return out;
        }
        
        int[][] small = subsequenceArray(arr, start+1);
        int[][] out = new int[2*small.length][];

        int k = 0;
        for(int i = 0; i < small.length; i++){
            out[k] = new int[small[i].length];
            for(int j = 0; j < small[i].length; j++){
                out[k][j] = small[i][j];
            }
            k++;
        }
        for(int i = 0; i < small.length; i++){
            out[k] = new int[small[i].length + 1];
            out[k][0] = arr[start];
            for(int j = 1; j <= small[i].length; j++){
                out[k][j] = small[i][j-1];
            }
            k++;
        }
        return out;
    }
    //initialising subsequenceArray
    public static int[][] subsequenceArray(int[] arr){
        return subsequenceArray(arr, 0);
    }

    // 3. printing the subsequences of the array
    public static void printSubsequenceArray(int[] arr, int start, int[] out){
        if(start == arr.length){
            for(int i : out){
                System.out.println(i + " ");
            }
            System.out.println();
            return ;
        }
        
        int newOut[] = new int[out.length + 1];
        int i = 0;
        for(; i < out.length; i++){
            newOut[i] = out[i];
        } 
        newOut[i] = arr[start];
        printSubsequenceArray(arr, start+1, out);
        printSubsequenceArray(arr, start+1, newOut);
        
    }
    // initialising the print Subsequence array
    public static void printSubsequenceArray(int[] arr){
        int out[] = new int[0];
        printSubsequenceArray(arr,0,out);
    }

    // 4. return the elements which summ tills k
    public static int[][] sumTillK(int[] arr, int k, int start){
        if(start == arr.length){
            if(k == 0){
                return new int[1][0];
            }
            else{
                return new int[0][0];
            }
        }
        
        int temp1[][] = sumTillK(arr, k, start+1); 
        int temp2[][] = sumTillK(arr, k-arr[start], start+1);

        int out[][] = new int[temp1.length + temp2.length][];

        int index = 0;
        for(int i = 0; i < temp1.length; i++){
            out[index++] = temp1[i];
        }

        for(int i = 0; i < temp2.length; i++){
            out[index] = new int[temp2[i].length + 1];
            out[index][0] = arr[start];
            for(int j = 0; j < temp2[i].length; j++){
                out[index][j+1] = temp2[i][j]; 
            }
            index++;
        }
        return out;
    }
    // initialisation of sumTillK
    public static int[][] sumTillK(int[] arr, int k){
        return sumTillK(arr, k, 0);
    }
}
