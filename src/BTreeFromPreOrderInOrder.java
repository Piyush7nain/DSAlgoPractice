import java.util.HashMap;
import java.util.Map;

public class BTreeFromPreOrderInOrder {
    /**
     * Given two integer arrays preorder and inorder where preorder is the preorder traversal
     * of a binary tree and inorder is the inorder traversal of the same tree,
     * construct and return the binary tree.
     *
     * Example 1:
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     *       3
     *   9      20
     *       15    17
     * Output: [3,9,20,null,null,15,7]
     *
     * Example 2:
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     * */

    Map<Integer, Integer> map;
    int preOrderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        preOrderIndex = 0;
        int start = 0;
        int end = inorder.length - 1;
        TreeNode root = build(preorder, inorder, start, end);
        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = build(preorder, inorder, start, mid - 1);
        root.right = build(preorder, inorder, mid + 1, end);
        return root;
    }
}
