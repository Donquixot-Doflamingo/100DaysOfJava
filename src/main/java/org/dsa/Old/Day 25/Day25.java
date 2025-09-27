public class Day25 {
    // 1. check if the array is sorted 
    public static boolean checkSorted(int num[]) {
        if (num.length < 2) {
            return true;
        }
        if (num[0] > num[1]) {
            return false;
        }
        int small[] = new int[num.length - 1];
        for (int i = 1; i < num.length; i++) {
            small[i - 1] = num[i];
        }
        boolean smallest = checkSorted(small);
        return smallest;
    }

    // 2. check if the array is sorted with better sapce complexity 
        public static boolean checkBetterSorted(int num[], int count) {
            if (count >= num.length - 1) {
                return true;
            }
            if (num[count] > num[count + 1]) {
                return false;
            }
            return checkBetterSorted(num, ++count);
        }

        // now the person won't know what is the middle argument is for
        // we are making just a two argument function like below
        public static boolean checkBetterSorted(int num[]){
            return checkBetterSorted(num, 0);
        }
        // and now we can call just this function

    // 3. print the sum of the array
        public static int sum(int num[], int count) {
            if (count == num.length) {
                return 0;
            }
            return num[count] + sum(num, count + 1);
        }
        //similarly
        public static int sum(int num[]){
            return sum(num,0);
        }

    // 4. find the element in the array
        public static boolean findElement(int num[], int count, int find) {
            if (count == num.length) {
                return false;
            }
            if (num[count] == find) {
                System.out.println("found at element " + count);
                return true;
            }

            return findElement(num, count + 1, find);
        }
        //similarly
        public static boolean findElement(int num[], int find){
            return findElement(num, 0, find);
        }

    // 5. find the index of the element or return -1
        public static int firstIndex(int num[], int count, int find) {
            if (count == num.length) {
                return -1;
            }
            if (num[count] == find) {
                return count;
            }
            return firstIndex(num, count + 1, find);
        }
        //function for initialising count
        public static int firstIndex(int num[], int find){
            return firstIndex(num, 0, find);
        }

    // 6. Last Index of Number
        public static int lastIndex(int num[], int count, int find) {
            if (count == -1) {
                return -1;
            }
            if (num[count] == find) {
                return count;
            }
            return lastIndex(num, count - 1, find);
        }
        //function for initialising count
        public static int lastIndex(int num[], int find){
            return lastIndex(num, num.length-1, find);
        }
}
