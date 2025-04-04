public class MaxPathSumBTree {

    /**
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the
     * sequence has an edge connecting them.
     * A node can only appear in the sequence at most once.
     * Note that the path does not need to pass through the root.
     * The path sum of a path is the sum of the node's values in the path.
     * Given the root of a binary tree, return the maximum path sum of any non-empty path.
     *
     * Example 1:
     *
     * Input: root = [1,2,3]
     * Output: 6
     * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
     *
     *  Example 2:
     * Input: root = [-10,9,20,null,null,15,7]
     *     -10
     *  9        20
     *       15      7
     * Output: 42
     * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
     *
     *  */

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        findMaxPathSum(root);
        return Math.max(maxSum, 0);
    }

    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);
        int sum1 = root.val + left + right;
        int sum2 = root.val + Math.max(left, right);
        if(sum1 > maxSum) {
            maxSum = sum1;
        }
        if(sum2 > maxSum) {
            maxSum = sum2;
        }
        if(root.val> maxSum){
            maxSum = root.val;
        }
        return Math.max(root.val, sum2);
    }

}
