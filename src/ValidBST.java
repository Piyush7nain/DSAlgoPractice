public class ValidBST {

    Integer prev;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    boolean inOrder(TreeNode root){
        if(root==null) return true;
        if(!inOrder(root.left))
            return false;
        if(prev!=null && prev >= root.val)
            return false;
        prev = root.val;
        return inOrder(root.right);
    }
}
