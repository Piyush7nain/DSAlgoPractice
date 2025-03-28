import java.util.HashMap;
import java.util.Map;

public class BTreeFromPostOrderInOrder {

    /**
     * Given two integer arrays inorder and postorder where inorder is the
     * inorder traversal of a binary tree and postorder is the postorder traversal of the same tree,
     * construct and return the binary tree.
     *
     * Example 1:
     * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * Output: [3,9,20,null,null,15,7]
     *
     *  Example 2:
     * Input: inorder = [-1], postorder = [-1]
     * Output: [-1]
     * */

    Map<Integer, Integer> map;
    int postOrderInd;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderInd = postorder.length - 1;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int start =0;
        int end = inorder.length - 1;
        TreeNode root = build(inorder, postorder, start, end);
        return root;
    }
    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = postorder[postOrderInd--];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = build(inorder, postorder, start, mid - 1);
        root.right = build(inorder, postorder, mid + 1, end);
        return root;

    }
}
