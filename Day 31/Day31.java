public class Day31 {
    
    // 1. keypad dialer number combination
    // 23 -> ad ae af bd be bf cd ce cf
    public static String[] keypadCombo(int num){
        if(num == 0){
            String[] ans = {""};
            return ans;
        }
        String small[] = keypadCombo(num/10);
        String smallNumOutput[] = helper(num%10);
        String output[] = new String[small.length * smallNumOutput.length];
        int k = 0;
        for(int i = 0; i < small.length; i++){
            for(int j = 0; j <smallNumOutput.length; j++){
                output[k] = small[i] +  smallNumOutput[j];
                k++;
            }
        }
        return output;
    }

    // the function which will call the combinations
    public static String[] helper(int num){
        if(num <= 1 || num > 9){
            System.exit(0);
        }
        if(num == 2){
            String out[] = {"a","b","c"};
            return out;
        }
        else if(num == 3){
            String out []= {"d","e","f"};
            return out;
        }
        else if(num == 4){
            String out[] = {"g","h","i"};
            return out;        }
        else if(num == 5){
            String out[] = {"j","k","l"};
            return out;        }
        else if(num == 6){
            String out[] = {"m","n","o"};
            return out;
        }
        else if(num == 7){
            String out[] = {"p","q","r", "s"};
            return out;        }
        else if(num == 8){
            String out[] = {"t","u","v"};
            return out;        }
        else if(num == 9){
            String out[] = {"w","x","y","z"};
            return out;        }
        else{
            String out[] = {""};
            return out;
        }
    }

    // 2. printing the keypad combination of the number
    public static void keypad(int num, String out){
        if(num == 0){
            System.out.println(out);
            return;
        }
        String[] smallNumInput = helper(num%10);
        for(int i = 0; i < smallNumInput.length; i++){
            keypad(num/10, smallNumInput[i] + out);
        }   
    }

    // initialising the keypad function
    public static void keypad(int num){
        keypad(num,"");
    }

    // 3. return if the string starts with a, have bb or null after a, have a or null after bb  
    public static Boolean checkAnB(String str){
        if(str.length() == 0){
            return true;
        }
        if(str.charAt(0) == 'a'){
            if(str.substring(1).length() >1 && str.substring(1,3).equals("bb")){
                return checkAnB(str.substring(3));
            }
            else{
                return checkAnB(str.substring(1));
            }
        }
        return false;
    }

    // 4. print the no of ways a child can climb if climb 1, 2 or 3 steps at a time
    public static int staircase(int num){
        if(num < 0){
            return 0;
        }
        if(num == 0){
            return 1;
        }
        return staircase(num - 1) + staircase(num - 2) + staircase(num - 3);
    }
}
