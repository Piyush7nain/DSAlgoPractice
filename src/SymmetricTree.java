public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    boolean symmetric(TreeNode r1, TreeNode r2){

        if(r1==null && r2 ==null)
            return true;
        else if(r1==null && r2 !=null)
            return false;
        else if(r1!=null && r2 ==null)
            return false;

        else return (r1.val ==r2.val)
                    &&(symmetric(r1.left, r2.right))
                    &&(symmetric(r1.right, r2.left));
    }
}
