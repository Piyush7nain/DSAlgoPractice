import java.util.Arrays;

public class SetMatrixZeroes {
    /**
     *Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
     *
     * You must do it in place.
     *
     * Example 1:
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     *
     *  Example 2:
     * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *
     * Constraints:
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -231 <= matrix[i][j] <= 231 - 1
     * */

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //check if header row has zeroes
        boolean rowHasZero = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        boolean colHasZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == 0){
                for (int j = 1; j < n; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        if(rowHasZero){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(colHasZero){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] matrrix= new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeroes.setZeroes(matrrix);
        for(int[] arr : matrrix){
            System.out.println(Arrays.toString(arr));
        }
    }
}
