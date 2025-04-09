import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {

    /**
     * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
     *
     * Connect: A cell is connected to adjacent cells horizontally or vertically.
     * Region: To form a region connect every 'O' cell.
     * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and
     * none of the region cells are on the edge of the board.
     * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board.
     * You do not need to return anything.
     *
     * Example 1:
     * Input:
     * board = [["X","X","X","X"],
     *          ["X","O","O","X"],
     *          ["X","X","O","X"],
     *          ["X","O","X","X"]]
     * Output: [["X","X","X","X"],
     *          ["X","X","X","X"],
     *          ["X","X","X","X"],
     *          ["X","O","X","X"]]
     *
     * Explanation:
     * In the above diagram, the bottom region is not captured because
     * it is on the edge of the board and cannot be surrounded.
     *
     * Example 2:
     *
     * Input: board = [["X"]]
     *
     * Output: [["X"]]
     *
     *
     * */

    char[][] grid;
    int[][] visited;
    int rowM;
    int colM;
    boolean corner = false;
    int[][] dirs = new int[][]{{-1,0}, {0,1},{0,-1},{1,0}};
    Queue<int[]> queue = new ArrayDeque<>();

    public void solve(char[][] board) {
        this.grid = board;
        this.visited = new int[board.length][board[0].length];
        this.rowM = board.length;
        this.colM = board[0].length;
        for (int i = 0; i < rowM; i++) {
            for (int j = 0; j < colM; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    if(!isCorner(i, j)){
                        grid[i][j] = 'X';
                    }
                }
            }
        }
    }

    public boolean isCorner(int row, int col){
        if(row < 0 || row >= rowM || col < 0 || col >= colM) {
            return true;
        }
        if(visited[row][col] == 2){
            return true;
        }
        boolean isCorner = false;
        if(grid[row][col] == 'O' && visited[row][col] == 0){
            visited[row][col] = 1;
            for(int[] dir: dirs){
                isCorner = isCorner(row + dir[0], col + dir[1]) || isCorner;
            }
            if(isCorner){
                visited[row][col] = 2;
            }
            if(!isCorner){
                grid[row][col] = 'X';
                return false;
            }
        }
        return isCorner ;
    }
    public void solve2(char[][] board) {
        this.grid = board;
        this.visited = new int[board.length][board[0].length];
        this.rowM = board.length;
        this.colM = board[0].length;
        for (int i = 0; i < rowM; i++) {
            for (int j = 0; j < colM; j++) {
                if(grid[i][j] == 'O' && visited[i][j] == 0) {
                    List<int[]> pos = new ArrayList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    while(!queue.isEmpty()) {
                        int[] point = queue.poll();
                        pos.add(point);
                        for(int[] dir : dirs) {
                            addToQueue(grid, point[0]+dir[0], point[1] + dir[1]);
                        }
                    }
                    if(!corner){
                        for(int[] p : pos){
                            grid[p[0]][p[1]] = 'X';
                        }
                    }
                }
                corner = false;
            }
        }
    }

    private void addToQueue(char[][] grid, int row, int col) {
        if(row < 0 || row >= rowM || col < 0 || col >= colM) {
            corner = true;
            return;
        }
        if(grid[row][col] == 'O'  && visited[row][col] == 0) {
            visited[row][col] = 1;
            queue.add(new int[]{row, col});
        }
    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] grid = new char[][]{
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};

        for(char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        surroundedRegions.solve(grid);
        System.out.println("\n");
        for(char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
