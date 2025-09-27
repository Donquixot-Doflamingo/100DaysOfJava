import java.util.ArrayList;

public class Day53 {

    /* Question 1 -> Maximum XOR subarray
        -----------------------------------------------------
        Medium Accuracy: 47.34% Submissions: 18641 Points: 4
        -----------------------------------------------------
        Given an array arr[] of size, N. Find the subarray with maximum XOR. A subarray is a contiguous part of the array.

        Example 1:
        Input:
        N = 4
        arr[] = {1,2,3,4}
        Output: 7
        Explanation: The subarray {3,4} has maximum xor value equal to 7.
    */

    static int maxSubarrayXOR(int n, int arr[]){
        int xor=1,maxXor=1;
        for(int i=0;i<n;i++){
          xor=Math.max(arr[i],xor^arr[i]);
          maxXor=Math.max(xor,maxXor);
        }
        return maxXor;
    }

    /* Question 2 ->  Pascal Triangle 
        -----------------------------------------------------
         Easy Accuracy: 40.75% Submissions: 12757 Points: 2 
        -----------------------------------------------------
        Given a positive integer N, return the Nth row of pascal's triangle.
        Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
        Example 1:
        1
        1 1
        1 2 1
        1 3 3 1
        For N = 3, return 3rd row i.e 1 2 1

        Example 2:
        Input:
        N = 4
        Output: 1 3 3 1
        Explanation: 4th row of pascal's triangle
        is 1 3 3 1.
    */

    public static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        if(n==1){
            ArrayList<Long> v = new ArrayList<>();
            v.add(1l);
            return v;
        }
        
        final long MOD = 1000_000_007;
            
        ArrayList<Long> v = new ArrayList<>();
        ArrayList<Long> tans = nthRowOfPascalTriangle(n-1);
        v.add(1l);
        for (int i = 1; i < n-1; i++) {
            v.add((tans.get(i)+tans.get(i-1))%MOD);
            //c = ((c % MOD * (n - i)) % MOD * mod.get(i)) % MOD;
        }
        v.add(1l);
        return v;
    }

    /* Restarting the course again from where I left
        ************************************************ BACKTRACKING IN JAVA ****************************************************
    */

    /* Question 1 -> Code: Rat In A Maze
        You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
        Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
        Input Format
        Line 1: Integer N
        Next N Lines: Each line will contain ith row elements (separated by space)
        Output Format :
        The output line contains true if any path exists for the rat to reach its destination otherwise print false.
        Sample Input 1 :
        3
        {{1 0 1}, {1 0 1}, {1 1 1}}
        Sample Output 1 :
        true
    */

    public static boolean ratInAMaze(int maze[][] ){
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMaze(maze, 0, 0, path);
    }
    
    public static boolean solveMaze(int maze[][], int i, int j, int path[][]){
        int n = maze.length;
        // validity of the current path
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }

        // inculding the current path
        path[i][j] = 1;

        //destination cell
        if(i == n-1 && j == n-1){
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            return true;
        }

        //top
        if(solveMaze(maze, i-1, j, path)) return true;
        // right
        if(solveMaze(maze, i, j+1, path)) return true;
        //down
        if(solveMaze(maze, i+1, j, path)) return true;
        // left
        if(solveMaze(maze, i, j-1, path)) return true;

        return false;
    }
    
    // Question 2 -> to the above questions continuation -> Print the path
    
    public static boolean ratInAMazePrintPath(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMazePrintPaths(maze, 0, 0, path);
    }
    
    public static boolean solveMazePrintPaths(int maze[][], int i, int j, int path[][]){
        int n = maze.length;
        // validity of the current path
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }

        // inculding the current path
        path[i][j] = 1;

        //destination cell
        if(i == n-1 && j == n-1){
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            return true;
        }

        //top
        if(solveMazePrintPaths(maze, i-1, j, path)) return true;
        // right
        if(solveMazePrintPaths(maze, i, j+1, path)) return true;
        //down
        if(solveMazePrintPaths(maze, i+1, j, path)) return true;
        // left
        if(solveMazePrintPaths(maze, i, j-1, path)) return true;

        return false;
    }
    
    /* Question 3 -> Rat In a Maze All Paths

        You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination 
        i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
        Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and 
        those with value 1 are open.
        Input Format
        The first line of input contains an integer 'N' representing 
        the dimension of the maze.
        The next N lines of input contain N space-separated 
        integers representing the type of the cell.
        Output Format :
        For each test case, print the path from start position to destination position and only cells that are part of the solution 
        path should be 1, rest all cells should be 0.
        Output for every test case will be printed in a separate line.
        Note: You do not need to print anything, it has already been taken care of. Just implement the given function.
        Constraints:
        0 < N < 11 0 <= Maze[i][j] <=1

        Time Limit: 1sec
        Sample Input 1 :
        3
        1 0 1
        1 0 1
        1 1 1

        Sample Output 1 :
        1 0 0 1 0 0 1 1 1 
        Sample Output 1 Explanation : Only 1 path is possible
        1 0 0
        1 0 0
        1 1 1
        Which is printed from left to right and then top to bottom in one line.

        Sample Input 2 :
        3
        1 0 1
        1 1 1
        1 1 1
        Sample Output 2 :
        1 0 0 1 1 1 1 1 1 
        1 0 0 1 0 0 1 1 1 
        1 0 0 1 1 0 0 1 1 
        1 0 0 1 1 1 0 0 1 
        Sample Output 2 Explanation :
        4 paths are possible which are printed in the required format.
    */

    public static void ratInAMazePrintAllPath(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        printAllPaths(maze, 0, 0, path);
    }
    
    public static void printAllPaths(int maze[][], int i, int j, int path[][]){
        int n = maze.length;
        // validity of the current path
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return;
        }

        // inculding it in the current path
        path[i][j] = 1;

        //destination cell
        if(i == n - 1 && j == n - 1){
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
            path[i][j] = 0;
            return;
        }

        //top
        printAllPaths(maze, i - 1, j, path);
        // right
        printAllPaths(maze, i, j + 1, path);
        //down
        printAllPaths(maze, i + 1, j, path);
        // left
        printAllPaths(maze, i, j - 1, path);

        path[i][j] = 0;
    }
    public static void main(String[] args) {
        int maze[][] = {{1, 1, 0}, {1, 1, 0}, {1, 1, 1}};
        int n = maze.length;
        System.out.println("\n Question array \n");
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                System.out.print(maze[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("\nAnswer array\n");
        ratInAMazePrintAllPath(maze);
    }

}
