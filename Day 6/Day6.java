import java.util.Scanner;

// package Day6;

public class Day6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the position of fibonacci series");
        int n = s.nextInt();
        
        // *****
        // *****
        // *****
        // *****
        // for(int i =1; i<=n; i++){
        //     for(int j = 1; j<=n ; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // 1111
        // 2222
        // 3333
        // 4444
        // for(int i =1; i<=n; i++){
        //     for(int j = 1; j<=n ; j++){
        //         System.out.print(i);
        //     }
        //     System.out.println();
        // }

        // 1234
        // 1234
        // 1234
        // 1234
        // for(int i =1; i<=n; i++){
        //     for(int j = 1; j<=n ; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // 4321
        // 4321
        // 4321
        // 4321
        // for(int i =1; i<=n; i++){
        //     for(int j = 1; j<=n ; j++){
        //         System.out.print(n-j+1);
        //     }
        //     System.out.println();
        // }

        // 4444
        // 4444
        // 4444
        // 4444
        // for(int i =1; i<=n; i++){
        //     for(int j = 1; j<=n ; j++){
        //         System.out.print(n);
        //     }
        //     System.out.println();
        // }

        // 1
        // 12
        // 123
        // for(int i = 1; i<=n; i++){
        //     for(int j = 1; j<=i ; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
        // 1
        // 23
        // 345
        // 4567
        // int p =1;
        // for(int i = 1; i<=n; i++){
        //     p=i;
        //     for(int j = 1; j<=i ; j++){ 
                               
        //         System.out.print(p);
        //         p++;
        //     }
            
        //     System.out.println();
        // }

        // 1
        // 23
        // 456
        // 78910

        // int p =1;
        // for(int i = 1; i<=n; i++){
        //     for(int j = 1; j<=i ; j++){ 

        //         System.out.print(p);
        //         p++;
        //     }

        //     System.out.println();
        //     }

        // 1
        // 22
        // 333
        // 4444
        // for(int i = 1; i<=n; i++){
        //     for(int j = 1; j<=i ; j++){ 
                               
        //         System.out.print(i);
        //     }
            
        //     System.out.println();
        // }
    
        // 1
        // 21
        // 321
        // 4321
        // for(int i = 1; i<=n; i++){
        //     for(int j = 1; j<=i ; j++){             
        //         System.out.print(i-j+1);
        //      }
        //     for(int j = i; j>=1 ; j--){             
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // ABCD
        // ABCD
        // ABCD
        // ABCD
        // for(int i =1; i<=n; i++){
        //         for(int j = 1; j<=n ; j++){
        //             char jthChar = (char)('A' + j -1);
        //             System.out.print(jthChar);
        //         }
        //         System.out.println();
        //     }

        // A
        // BB
        // CCC
        // DDDD
        // for(int i =1; i<=n; i++){
        //             for(int j = 1; j<=i ; j++){
        //                 char ithChar = (char)('A' + i -1);
        //                 System.out.print(ithChar);
        //             }
        //             System.out.println();
        // }

        // ABCD
        // BCDE
        // CDEF
        // DEFG
        // for(int i =1; i<=n; i++){
        //     char p = (char)('A' + i -1);
        //     for(int j = 1; j<=i ; j++){
        //          char ithChar = (char)('A' + i -1);
        //           System.out.print(p);
        //           p++;
        //          }
        //     System.out.println();
        // }
            s.close();
    }
}
