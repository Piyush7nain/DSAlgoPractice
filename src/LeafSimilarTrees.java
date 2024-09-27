import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    /**
     * Consider all the leaves of a binary tree, from left to right order,
     * the values of those leaves form a leaf value sequence
     *
     * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
     *
     * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
     *
     * Example 1
     * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * Output: true
     * */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getLeafSequence(root1, list1);
        getLeafSequence(root2, list2);
        return list2.equals(list1);
    }

    void getLeafSequence(TreeNode root, List<Integer> list){
        if(root==null)
            return;

        if(root.left==null && root.right==null){
            list.add(root.val);
        }else {
            getLeafSequence(root.left, list);
            getLeafSequence(root.right, list);
        }
    }
}
