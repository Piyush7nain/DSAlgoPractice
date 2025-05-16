import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DeleteNodeAndReturnForest {
    /**
     * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
     * */

    Set<Integer> set;
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for(int i: to_delete) {
            set.add(i);
        }
        TreeNode newRoot = deleteNodes(root);
        if(newRoot!=null){
            res.add(newRoot);
        }
        return res;
    }

    private TreeNode deleteNodes(TreeNode root) {
        if(root == null) return null;
        TreeNode left = deleteNodes(root.left);
        TreeNode right = deleteNodes(root.right);
        if(set.contains(root.val)) {
            if(left != null) {
                res.add(left);
            }
            if(right != null) {
                res.add(right);
            }
            return null;
        }else{
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
