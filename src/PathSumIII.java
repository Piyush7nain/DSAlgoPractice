import javax.swing.*;
import java.util.List;

public class PathSumIII {
    /**
     * Given the root of a binary tree and an integer targetSum,
     * return the number of paths where the sum of the values along the path equals targetSum.
     *
     * The path does not need to start or end at the root or a leaf,
     * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
     * */

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
