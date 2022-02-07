public class Day30 {
    
    // 1. make a * when any double character appear
    public static String replaceDoubleChar(String str){
        if(str.length() <= 1){
            return str;
        }
        String output = replaceDoubleChar(str.substring(1));
        if(str.charAt(0) == str.charAt(1)){
            output = str.charAt(0) + "*" + str.charAt(1) + output.substring(1);
        }
        else{
            output = str.charAt(0) + output;
        }
        return output;
    }

    // 2. tower of hanoi 
    public static void towerOfHanoi(int num, char source, char auxillary, char destination){
        if(num == 0){
            return;
        }
        towerOfHanoi(num-1, source, destination, auxillary);
        System.out.println(source + " to " + destination);
        towerOfHanoi(num-1, auxillary, source, destination);
    }

    public static void towerOfHanoi(int num){
        towerOfHanoi(num, 'a', 'b', 'c');
    }

    /*
        recusrion part 3
    */

    // 3. return the subsequences of the string for eg xyz
    // x,y,z,xy,yz,xz, xyz, " "
    public static String[] subsequeStrings(String str){
        if(str.length() == 0){
            String ans[] = {""};
            return ans;
        }
        String small[] = subsequeStrings(str.substring(1));
        String ans[] = new String[2*small.length];
        int k = 0;
        for(int i = 0; i < small.length; i++){
            ans[k] = small[i];
            k++;
        }
        for(int i = 0; i < small.length; i++){
            ans[k] = str.charAt(0) + small[i];
            k++;
        }
        return ans;
    }

    // 4. printing the subsequence of the string
    //xy -> "" y x xy
    public static void subsequence(String str, String out){
        if(str.length() == 0){
            System.out.println(out);
            return;
        }
        // first by not including the first character
        subsequence(str.substring(1), out);
        // second by including the first character
        subsequence(str.substring(1), out + str.charAt(0));
    }

    // initialising the subsequence function
    public static void subsequence(String str){
        subsequence(str, "");
    }
}
