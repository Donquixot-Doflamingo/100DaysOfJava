import java.util.Scanner;

// package Day 7;

public class Day7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no");
        //int n = s.nextInt();

        // A
        // BC
        // CDE
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

        // D
        // CD
        // BCD
        // ABCD
        // for(int i =1; i<=n; i++){
            
        //     for(int j = 1; j<=i ; j++){
        //         char jthChar = (char)('A' + n + j - i - 1);
        //         System.out.print(jthChar);
        //         }
        //     System.out.println();
        // }

        //  *
        // ***
        //*****
        // ***
        //  *
        // int n1 = n/2 + 1;
        // for(int i=1; i<=n1; i++){
        //         for(int space=1; space<=n1 - i; space++){
        //          System.out.print(" ");
        //          }
        //         for(int num=1; num<=2*i -1; num++){
        //           System.out.print("*");
        //          }
        //          System.out.println();
        //     }
        // int n2 = n - n1;
        // for(int i=n2; i>=1; i--){
        //     for(int space=1; space<=n2 - i + 1; space++){
        //      System.out.print(" ");
        //      }
        //     for(int num=1; num<=2*i -1; num++){
        //       System.out.print("*");
        //      }
        //      System.out.println();
        // }

        //      *
        //     *1*
        //    *121*
        //   *12321*
        //  *1234321*
        // *123454321*
        //  *1234321*
        //   *12321*
        //    *121*
        //     *1*
        //      *

        // for(int i=1; i<=n; i++){
        //     System.out.print(" ");
        // }
        // System.out.println("*");
        // for(int i=1; i<=n; i++){
        //     for(int space=1; space<=n-i; space++){
        //       System.out.print(" ");
        //      }
        //    System.out.print("*");
        //    for(int num=1; num<=i ; num++){
        //      System.out.print(num);
        //    }
        //    for(int num=2; num<=i ; num++){
        //     System.out.print(i-num +1); 
        //   }   System.out.print("*");
        //    System.out.println(); 
        // }
        // for(int i=n-1; i>=1; i--){ 
        //     for(int space=1; space<=n-i; space++){
        //         System.out.print(" ");
        //        }
        //        System.out.print("*");
        //        for(int num=1; num<=i ; num++){
        //          System.out.print(num);
        //        }
        //        for(int num=2; num<=i ; num++){
        //         System.out.print(i-num +1);
        //       }System.out.print("*");
        //        System.out.println();
        //     } 
        //     for(int i=1; i<=n; i++){
        //         System.out.print(" ");
        //     }
        //     System.out.println("*");

        // *
        // *1*
        // *121*
        // *12321*
        // *121*
        // *1*
        // *
        // System.out.println("*");
        // //first half
        // for(int i = 1; i<=n; i++){
        //     System.out.print("*");
        //     int j;
        //     for(j = 1;j <= i; j++){
        //         System.out.print(j);
        //     }
        //     for(j=j-2; j >= 1; j--){
        //         System.out.print(j);
        //     }
        //     System.out.println("*");
        // }
        // //second half
        // for(int i = 1; i<=n-1; i++){
        //     System.out.print("*");
        //     int j;
        //     for(j = 1;j <= n-i; j++){
        //         System.out.print(j);
        //     }
        //     for(j=j-2; j >= 1; j--){
        //         System.out.print(j);
        //     }
        //     System.out.println("*");
        // }
        // System.out.print("*");
        // System.out.println();
        
        //****
        // ****
        //  ****
        //   ****  
        // for(int i=1; i<=n; i++){
        //     for(int space=1; space<=i-1; space++){
        //         System.out.print(" ");
        //     }
        //     for(int star=1; star<=n; star++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
            
        // 1=1
        // 1+2=3
        // 1+2+3=6

        //my solution
        // for(int i=1; i<=n; i++){
        //     int sum = 0;
        //     for(int num=1; num<=i; num++){
        //         sum += num;
        //         if(i>1 && num<i){
        //             System.out.print(num + "+"); 
        //         }
        //         else{
        //             System.out.print(num);
        //         }
        //     }
        //     System.out.print("=" + sum); 
        //     System.out.println();
        // }

        // 2nd soluntion
        // for(int i=1; i<=n; i++){
        //     int sum = 0;
        //     for(int num=1; num<=i; num++){
        //         sum += num;
        //         System.out.print(num);
        //         if(num == i){
        //             System.out.print("="); 
        //         }
        //         else{
        //             System.out.print("+"); 
        //         }
        //     }
        //     System.out.print(sum); 
        //     System.out.println();
        // }

        //     13579
        //     35791
        //     57913
        //     79135
        //     91357

        //     for(int i =1; i<=n; i++){
        //     int p = 2*i -1;
        //     for(int j = n; j>0 ; j--){
        //         System.out.print(p);
        //         p += 2;
        //         if(p > (2 * n) -1){
        //             p=1;
        //         }
        //     }
        //     System.out.println();
        // }

        s.close();
    }
}
