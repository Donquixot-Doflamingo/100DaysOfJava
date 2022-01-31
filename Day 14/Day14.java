public class Day14 {
    //question 13 Kadane's Algo [V.V.V.V.V IMP]
    public static int kadaneAlgo(int a[], int n){
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0,i=0;

        while(i < a.length){
            max_ending_here = max_ending_here + a[i];
            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
            }
            if(max_ending_here < 0){
                max_ending_here = 0;
            }
            i++;
        }
        return max_so_far;
    }

    // question 14  next permutation, rearrange the lexicographically next greater permutation
        public static void nextPermutation(int[] nums){
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            System.out.println(i);
            if (i >= 0) {
                int j = nums.length - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        // reverse swapping the array position
        public static void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // swapping the values
        public static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    // Question 15 Finding comman elements in two array

    public static void commonElements(int a[], int b[]) 
    {
        int n = a.length, m = b.length;
        Arrays.sort(a); //nlogn
        Arrays.sort(b); //mlogm
        for(int i = 0; i < n;){
            for(int j = 0; j < m;){
                if(a[i] == b[j]){
                    System.out.println(a[i]);
                    i++;
                    j++;
                }
                else if(a[i]<b[j]){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
    }

    // Question 16 Finding equilibrium of array

    public static int arrayEquilibrium(int a[]) {
        int n = a.length;
        int rightSum = 0, leftSum = 0;

        for(int i = 0; i < n;i++){
            rightSum += a[i];
        }
        for(int i = 0; i < n;i++){
            rightSum -= a[i];
            if(leftSum==rightSum){
                System.out.println(i);
                return i;
            }
            leftSum += a[i];
        }
        return -1;
    }

    // Question 17 Counting cubes in arr
    
    public static int countingCubes(){
        int count = 0;
        int arr[] = takingInput();
        for(int i = 0; i < arr.length; i++){
            int cubeRoot = (int)Math.round(Math.cbrt(arr[i]));
            if(cubeRoot * cubeRoot * cubeRoot == arr[i]){
                count++;
            }
        }
        return count;
    }

    // Question 18 Sum of array ranges

    public static int sumOfArrayRange(){
        int arr[] = takingInput();
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int sum = 0;
        for(int i = l-1; i < r; i++){
            sum += arr[i];
        }
        return sum;
    }

}
