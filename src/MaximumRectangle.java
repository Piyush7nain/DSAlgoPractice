import java.util.Stack;

public class MaximumRectangle {

    //https://leetcode.com/problems/maximal-rectangle/description/

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int len = matrix.length;
        int width = matrix[0].length;

        int[] heights = new int[width+1];
        for (int i = 0; i < width; i++) {
            heights[i] = matrix[0][i] -'0';
        }

        int ans = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < width; j++) {
                heights[j] = matrix[i][j] - '0' ==0 ? 0: heights[j]+1;
            }
            Stack<Integer> stack = new Stack<>();
            for (int k = 0; k < heights.length; k++) {

                while(!stack.isEmpty() && heights[k] < heights[stack.peek()]) {
                    int lastHeight = heights[stack.pop()];
                    int lastWidth =k - stack.peek()-1;
                    int curSize = lastHeight *(lastWidth);
                    ans = Math.max(ans, curSize);
                }
                stack.push(k);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumRectangle mr = new MaximumRectangle();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(mr.maximalRectangle(matrix));
    }
}
