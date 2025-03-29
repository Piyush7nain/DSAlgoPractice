import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    /**
     * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
     *
     * Example 1:
     * Input: root = [1,2,3,null,5,null,4]
     * Output: [1,3,4]
     *
     * Example 2:
     * Input: root = [1,2,3,4,null,null,null,5]
     * Output: [1,3,4,5]
     *
     * Example 3:
     * Input: root = [1,null,3]
     * Output: [1,3]
     *
     * Example 4:
     * Input: root = []
     * Output: []
     * */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            int size = queue.size();
            if(node.right != null) {
                queue.offer(node.right);
            }
            if(node.left != null) {
                queue.offer(node.left);
            }
            while (size > 0) {
                node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                size--;
            }
        }
        return result;
    }
}
