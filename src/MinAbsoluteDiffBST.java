public class MinAbsoluteDiffBST {
    /**
     *Given the root of a Binary Search Tree (BST), return the minimum absolute difference between
     *  the values of any two different nodes in the tree.
     *
     * Example 1:
     * Input: root = [4,2,6,1,3]
     * Output: 1
     *
     *  Example 2:
     * Input: root = [1,0,48,null,null,12,49]
     * Output: 1
     *
     * */
    int prev = -1;
    int diff = Integer.MAX_VALUE;
     public int minAbsoluteDifference(TreeNode root) {
         if (root == null) {
             return 0;
         }
         minAbsoluteDifference(root.left);
         if (prev != -1) {
             diff = Math.min(diff, Math.abs(root.val - prev));
         }
         prev = root.val;
         minAbsoluteDifference(root.right);
         return diff;
     }
}
