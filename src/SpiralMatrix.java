import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     *
     * Example 1:
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     *
     *  Example 2:
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     *
     * Constraints:
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int i= 0;
        int j = -1;
        int lm =0, rm =matrix[0].length-1, up =0, down = matrix.length-1;
        // 0 = right, 1 = down, 2 = left, 3 = up
        int direction = 0;
        while(result.size() < matrix.length * matrix[0].length) {

            if(direction == 0) {
                j++;
                if(j >= rm) {
                    direction = (direction + 1) % 4;
                    up++;
                    j=rm;
                }
            }else if(direction == 1) {
                i++;
                if(i >= down) {
                    direction = (direction + 1) % 4;
                    rm--;
                    i=down;
                }
            }else if(direction == 2) {
                j--;
                if(j <= lm) {
                    direction = (direction + 1) % 4;
                    down--;
                    j=lm;
                }
            }else if(direction == 3) {
                i--;
                if(i <= up) {
                    direction = (direction + 1) % 4;
                    lm++;
                    i=up;
                }
            }
            result.add(matrix[i][j]);
        }
        return result;
    }
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
