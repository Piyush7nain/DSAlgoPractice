import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class GameOfLife {

    /**
     * According to Wikipedia's article: "The Game of Life, also known simply as Life,
     * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
     *
     * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1)
     * or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
     * using the following four rules (taken from the above Wikipedia article):
     *
     * Any live cell with fewer than two live neighbors dies as if caused by under-population.
     * Any live cell with two or three live neighbors lives on to the next generation.
     * Any live cell with more than three live neighbors dies, as if by over-population.
     * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     *
     * The next state of the board is determined by applying the above rules simultaneously to every cell
     * in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.
     *
     * Given the current state of the board, update the board to reflect its next state.
     *
     * Note that you do not need to return anything.
     *
     * Example 1:
     * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
     * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
     *
     *  Example 2:
     * Input: board = [[1,1],[1,0]]
     * Output: [[1,1],[1,1]]
     *
     *
     * Constraints:
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 25
     * board[i][j] is 0 or 1.
     *
     *
     * Follow up:
     *
     * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
     * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
     * */


    // to change in place we need to do update twice.
    // 1. represent state change with new number.
    //      Dead -> Dead == 0
    //      Dead -> Alive = 2
    //      Alive to dead = -1
    //      Alive to Alive = 1
    // 2. Read the values 2 as 0 and -1 as 1 while updating the current cell and assign new values.
    // 3. Replace 2 with 1 and -1 with 0 in next iteration

    int[][] dir = new int[][]{{-1,0},{-1,1},{-1,-1}, {0,1},{0,-1},{1,0},{1,-1},{1,1}};
    public void gameOfLife(int[][] board) {
        if (board.length == 1 && board[0].length == 1) { board[0][0] = 0; ;}
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = getNextState(i, j, board);
                System.out.print("Updated State : "+board[i][j]+ "\n");
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }else if (board[i][j]==2){
                    board[i][j] = 1;
                }
            }
        }
    }

    int getNextState(int i, int j, int[][] board) {
        int state = board[i][j];
        int sum =0;
        System.out.println("Cell: ["+i+","+j+"], state: "+state);
        for (int[] dir : dir) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x <0 || x >= board.length || y <0 || y >= board[0].length){
                continue;
            }
//            if (x == i && y == j) {continue;}

            if (board[x][y] == 1 || board[x][y] == -1) {
                sum++;
                System.out.println("   Dir: ["+dir[0] +","+ dir[1] +"], [x, y]: [" +x+","+y+"] , state: "+ board[x][y]+ ", sum:  "+sum);
            }
        }

        if(state==0){
            // dead to alive
            if( sum==3) {
                return 2;
            } else { // dead to dead
                return state;
            }
        }
        // alive to alive
        if(sum==3 || sum==2){
            return 1;
        } else { // alive to dead
            return -1;
        }
    }

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        game.gameOfLife(board);
        for(int[] arr: board){
            System.out.println(Arrays.toString(arr));
        }
    }
}
