public class ValidSudoku {

    /**
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     *
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     *
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     *
     *
     * Example 1:
     *
     *
     * Input: board =
     * [['5','3','.','.','7','.','.','.','.']
     * ,['6','.','.','1','9','5','.','.','.']
     * ,['.','9','8','.','.','.','.','6','.']
     * ,['8','.','.','.','6','.','.','.','3']
     * ,['4','.','.','8','.','3','.','.','1']
     * ,['7','.','.','.','2','.','.','.','6']
     * ,['.','6','.','.','.','.','2','8','.']
     * ,['.','.','.','4','1','9','.','.','5']
     * ,['.','.','.','.','8','.','.','7','9']]
     * Output: true
     * Example 2:
     *
     * Input: board =
     * [['8','3','.','.','7','.','.','.','.']
     * ,['6','.','.','1','9','5','.','.','.']
     * ,['.','9','8','.','.','.','.','6','.']
     * ,['8','.','.','.','6','.','.','.','3']
     * ,['4','.','.','8','.','3','.','.','1']
     * ,['7','.','.','.','2','.','.','.','6']
     * ,['.','6','.','.','.','.','2','8','.']
     * ,['.','.','.','4','1','9','.','.','5']
     * ,['.','.','.','.','8','.','.','7','9']]
     * Output: false
     * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
     * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     *
     *
     * Constraints:
     *
     * board.length == 9
     * board[i].length == 9
     * board[i][j] is a digit 1-9 or '.'.
     * */

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][][] boxes = new int[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // check row i, col j
                    int r = board[i][j] - '0';
                    if (rows[i][r] >0 ) {
                        return false;
                    }else {
                        rows[i][r] ++;
                    }
                    // check box
                    if(boxes[i/3][j/3][r] >0 ) {
                        return false;
                    }else {
                        boxes[i/3][j/3][r] ++;
                    }
                }
                if(board[j][i] != '.') {
                    // check col i, row j
                    int c = board[j][i] - '0';
                    if(cols[i][c] >0 ) {
                        return false;
                    }else{
                        cols[i][c] ++;
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board =
                {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
