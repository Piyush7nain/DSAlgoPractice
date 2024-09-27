public class CountGoodNodeBinaryTree {
    /**
     * Given a binary tree root, a node X in the tree is named good if in
     * the path from root to X there are no nodes with a value greater than X.
     *
     * Return the number of good nodes in the binary tree.
     *
     * */
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root.left, root.val) + findGoodNodes(root.left, root.val) + 1;
    }

    int findGoodNodes(TreeNode node, int maxYet){
        if(node==null)
            return 0;
        int goodNode = 0;
        if(node.val>=maxYet){
            goodNode +=1;
            maxYet = node.val;
        }
        return findGoodNodes(node.left, maxYet) + findGoodNodes(node.right, maxYet) + goodNode;
    }
}
