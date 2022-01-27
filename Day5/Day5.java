package Day5;

import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the position of fibonacci series");
        int n = s.nextInt();

        //     *
        //     **
        //    ***
        //   ****
        for(int i=1; i<=n; i++){
            for(int space=1; space<=n-i; space++){
                System.out.print(" ");
            }
            for(int star=1; star<=i; star++){
                System.out.print("*");
            }
            System.out.println();
        }

        //   1
        //  12
        // 123
        //1234
        // for(int i=1; i<=n; i++){
        //    for(int space=1; space<=n-i; space++){
        //      System.out.print(" ");
        //      }
        //     for(int num=1; num<=i; num++){
        //       System.out.print(num);
        //      }
        //     System.out.println();
        // }

        // ****
        // ***
        // **
        // *
        // for(int i=1; i<=n; i++){
        //     for(int space=1; space<=n-i+1; space++){
        //         System.out.print("*");
        //     }
        //  System.out.println();
        // }

        // 4444
        // 333
        // 22
        // 1
        // for(int i=1; i<=n; i++){
        //     for(int space=1; space<=n-i+1; space++){
        //          System.out.print(n-i+1);
        //     }
        //  System.out.println();
        //     }

        //   1
        //  121
        // 12321
        //1234321
        // for(int i=1; i<=n; i++){
        //    for(int space=1; space<=n-i; space++){
        //      System.out.print(" ");
        //      }
        //     for(int num=1; num<=i; num++){
        //       System.out.print(num);
        //      }
        //      for(int num=i-1; num>=1; num--){
        //         System.out.print(num);
        //        }
        //     System.out.println();
        // }

        //   *
        //  ***
        // *****
        //*******
        // for(int i=1; i<=n; i++){
        //     for(int space=1; space<=n-i; space++){
        //      System.out.print(" ");
        //      }
        //     for(int num=1; num<=2*i -1; num++){
        //       System.out.print("*");
        //      }
        //      System.out.println();
        // }

        //   1
        //  232
        // 34543
        //4567654
        // for(int i=1; i<=n; i++){
        //   int p = i;
        //   for(int space=1; space<=n-i; space++){
        //     System.out.print(" ");
        //    }
        //    for(int num=1; num<=i ; num++){
        //      System.out.print(p);
        //       p++;
        //    }
            //1st option
        //    p--;
        //    for(int num=2; num<=i; num++){
        //        p--;
        //        System.out.print(p);
        //     }
        // 2nd option
        //      p = 2*i -2;
        //for(int num=2; num<=i; num++){
        //        p--;
        //        System.out.print(p);
        //     }
        //     System.out.println();
        //     }

        s.close();
    }
}