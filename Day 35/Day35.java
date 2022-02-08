public class Day35 {

    // 3. Find a path in the maze
    public static Boolean solveMaze(int maze[][], int i, int j, 
        int path[][]){
        int n = maze.length;
        // check if the i and j are valid or the maze is blocked or the past is visited
        if(i < 0 || i >= n || j < 0 || j >= n || 
            maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }
        // include the cell in the path as visited
        path[i][j] = 1;
        // check if this is the detination path
        if(i == n-1 && j == n-1){
            // printing the task followed by code
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            return true;
        }
        // explore further in all directions
        // top
        if(solveMaze(maze, i-1, j, path)){
            return true;
        }
        // right
        if(solveMaze(maze, i, j+1, path)){
            return true;
        }
        // down
        if(solveMaze(maze, i+1, j, path)){
            return true;
        }
        // left
        if(solveMaze(maze, i, j-1, path)){
            return true;
        }
        return false;
    }

    public static Boolean ratInAMaze(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMaze(maze, 0, 0, path);
    }
    
    // 4. Print all paths in the maze
    public static void printAllPaths(int maze[][], int i, int j, 
        int path[][]){
        int n = maze.length;
        // check if the i and j are valid or the maze is blocked or the past is visited
        if(i < 0 || i >= n || j < 0 || j >= n || 
            maze[i][j] == 0 || path[i][j] == 1){
            return;
        }
        // include the cell in the path as visited
        path[i][j] = 1;
        // check if this is the detination path
        if(i == n-1 && j == n-1){
            // printing the task followed by code
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
        // explore further in all directions
        // top
        printAllPaths(maze, i-1, j, path);
        // right
        printAllPaths(maze, i, j+1, path);
        // down
        printAllPaths(maze, i+1, j, path);
        // left
        printAllPaths(maze, i, j-1, path);
        
        path[i][j] = 0;
    }

    public static void ratInAMazePrintPaths(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        printAllPaths(maze, 0, 0, path);
    }

    
    public static void main(String[] args) { 
         int maze[][] = {{1,1,1},{1,1,1},{1,1,1}};
         ratInAMazePrintPaths(maze);
        // Boolean pathPossible = ratInAMaze(maze);
        // System.out.println(pathPossible);
    }
}
