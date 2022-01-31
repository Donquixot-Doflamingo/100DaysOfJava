public class Day15 {
    //taking the user input in array
    public static int[][] takingInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int row = s.nextInt();
        System.out.println("Enter the size of the array");
        int cols = s.nextInt();
        int arr[][] = new int [row][cols];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<cols; j++){
                System.out.println("Enter the element at" + i + " th row " + j + " th col ");
                arr[i][j] = s.nextInt();
            }
        }
        s.close();
        return arr;
    }

    //just to print the array
    public static void printArray(int arr[][]){
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                System.out.print(+ arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //print the sum of elements in each row
    public static void rowSum(int arr[][]){
        for(int i = 0; i<arr.length; i++){
            int sum = 0;
            for(int j = 0; j<arr[i].length; j++){
                sum+= arr[i][j];
            }
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    //print the maximum sum of elements in columns
    public static void colsSum(int arr[][]){
        int max = Integer.MIN_VALUE, num = 0;
        for(int j = 0; j<arr[0].length; j++){
            int sumElement = 0;
            for(int i = 0; i<arr.length; i++){
                sumElement+= arr[i][j];
            }
            num = j;
            if(max < sumElement){
                max = sumElement;
            }
        }
        System.out.println("column is " + num + " " + max);
    }

    // print the boundry and diagnal sum of an NxN array
    public static int boundSum(int arr[][], int dimension){
        int totalsSum = 0;
        int n = dimension-1;
        for(int i = 1; i<n; i++){
            totalsSum += arr[i][0];
            totalsSum += arr[0][i];
            totalsSum += arr[n][i];
            totalsSum += arr[i][n];
        }
        return totalsSum;
    }
    
    public static int diagnalSum(int arr[][], int dimension){
        int totalsSum = 0;
        int n = dimension-1;
        for(int i = 0; i<dimension; i++){
            totalsSum += arr[i][i];
            totalsSum += arr[i][n-i];
        }
        if((n+1)%2 != 0){
            totalsSum -= arr[n/2][n/2];
        }
        totalsSum =  boundSum(arr, dimension) + totalsSum;
        return totalsSum;
    }

    // Print Like a Wave
    public static void printWave(int arr[][]){
        int cols = arr[0].length, row = arr.length, j =0;
        while(j < cols){
            if(j % 2 == 0){
                for(int i = 0; i<row; i++){
                    System.out.println(arr[i][j]);
                }
            }else{
                for(int i = row-1; i >= 0; i--){
                    System.out.println(arr[i][j]);
                }
            }
            j++;
        }
    }
    
    //Spiral Print
    public static void printSpiral(int arr[][]){
        int count = 0, re = arr.length,rs = 0,ce = arr[0].length,cs = 0;
        int numOfElements = arr.length*arr[0].length, i;
        while(count < numOfElements){
            for(i = cs;count < numOfElements && i < ce; i++){
                System.out.println(arr[rs][i]);
                count++;
            }
            rs++;
            for(i = rs; count < numOfElements && i < re; i++){
                System.out.println(arr[i][ce-1]);
                count++;
            }
            ce--;
            for(i = ce-1; count < numOfElements && i >= cs; i--){
                System.out.println(arr[re-1][i]);
                count++;
            }
            re--;
            for(i = re-1; count < numOfElements && i >= rs; i--){
                System.out.println(arr[i][cs]);
                count++;
            }
            cs++; 
        }
    }
    public static void main(String[] args)  {
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSpiral(arr);
    } 
}
