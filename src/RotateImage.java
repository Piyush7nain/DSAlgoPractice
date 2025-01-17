import java.util.Arrays;

public class RotateImage {

    /**
     * https://leetcode.com/problems/rotate-image/description/
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     *
     * Example 1:
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     *
     * Example 2:
     * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     *
     *
     * Constraints:
     *
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     * */

    public void rotate(int[][] matrix) {
        int first =0;
        int last  = matrix.length-1;
        while(first<=last){
            int current = 0;
            while(current+first<last){
                int temp = matrix[first][first + current];
                matrix[first][first + current] = matrix[last -current ][first];
                matrix[last - current][first] = matrix[last][last - current];
                matrix[last][last - current] = matrix[first + current][last];
                matrix[first + current][last] = temp;
                current++;
            }
            first++;
            last--;
        }
    }
    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotateImage.rotate(matrix);
        for(int[] a : matrix){
            System.out.println(Arrays.toString(a));
        }

    }
}
