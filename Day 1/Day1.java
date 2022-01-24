public class Day1{

    static int roofTopsOfBuildings(int arr[], int n){
        // as the first roof will always be visible
        int count = 1;
        int currMax = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > currMax) { // || arr[i] == currMax
                count++;
                currMax = arr[i];
            }
        }

        return count;
    }

    // public static void main(String[] args){
    
    //     String str = "Hello World";

    // for prime numbers
    // Scanner sc = new Scanner(System.in);
    //  int n = sc.nextInt();

    //  boolean isPrime = true;
    //  for(int i = 2; i<n;i++) {
    //      if(n%i == 0){
    //          isPrime = false;
    //          break;
    //      }
    //  }
    //  System.out.println("isPrime " + isPrime);

    // guessing random number game
    // Scanner sc = new Scanner(System.in);
    // int mynum = (int)(Math.random()*100);
    // int n = 0;
    // do{
    //     System.out.println("Guess the number 0 - 100: ");
    //     n = sc.nextInt();
    //     if(n == mynum){
    //     System.out.println("correct number");
    //     break;         
    //     }
    //     else if(mynum > n){
    //         System.out.println("The number is greater than that");
    //     }
    //    else{
    //     System.out.println("The number is smaller than that");
    //    }
    // }while(n>0);
    // System.out.println("My number was-: " + mynum);

    // linked list program

    //  LinkedList<Integer> p = new LinkedList<Integer>();
    // p.addFirst(1);
    // p.add(2);
    // p.add(3);
    // p.add(4);
    // p.add(5);
    // for(int i = 0; i<p.size(); i++){
    //     System.out.println(p.get(i));
    // }

    // array list program

    // ArrayList<Integer> q = new ArrayList<Integer>();
    // q.add(2);
    // q.add(3);
    // q.add(4);
    // q.add(5);
    // for(int i = 0; i<q.size(); i++){
    //     System.out.println(q.get(i));
    // }

    // sorting the array 

    //Arrays.sort(inputOfBuildings);

    //or performing sorting by own method
    
    // user defined function down below
    // for(int i = 0; i<inputOfBuildings.length; i++){
    //     for (int j = i + 1; j < inputOfBuildings.length; j++){
    //         Double tmp = 0.0;
    //         if(inputOfBuildings[i] > inputOfBuildings[j]){
    //             tmp = inputOfBuildings[i];
    //             inputOfBuildings[i] = inputOfBuildings[j];
    //             inputOfBuildings[j] = tmp;
    //         }
    //     }
    //     System.out.println(inputOfBuildings[i]);    
    // }

    // taking the inputs of the building and heights #1
    // then checking the height if the small one comes after the larger height display the value #3
    // printing the maximum height you can see #4

    // #1 --> taking the inputs of the building and heights 

    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter the no of buildings you want to add");
    // int numberOfBuildings = sc.nextInt();
    // System.out.println("Enter the height of the buildings");
    // int inputOfBuildings[] = new int [numberOfBuildings];
    // for(int i=0; i<numberOfBuildings; i++){
    // 	inputOfBuildings[i] = sc.nextInt();
    // 	}
    //     System.out.println(roofTopsOfBuildings(inputOfBuildings, numberOfBuildings));
    // }
    // Scanner sc = new Scanner(System.in);
    // int S = sc.nextInt(); // start point
    // int E = sc.nextInt(); // end point
    // int W = sc.nextInt(); // interval
    // while(S<=E){
    //     int celciusValue=(int)((5.0/9) * (S-32)) ;
    //     System.out.println(S + "celcius value" + celciusValue);
    //     S += W;

    // }

    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt(); // start point
    // int div = 2;
    // while(div<= n/2){
    //     if(n % div == 0){
    //         System.out.println(str);
    //     }
    //     div = div + 1;
    // }
    // sc.close();

    // }
}