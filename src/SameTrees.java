public class SameTrees {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inOrderCompare(p, q);
    }

    boolean inOrderCompare(TreeNode p, TreeNode q){

        if( p==null && q!=null)
            return false;
        else if(q==null && p!=null)
            return false;
        else if(p==null && q==null)
            return true;
        else{
            return (p.val ==q.val)&&(inOrderCompare(p.left, q.left) )&&(inOrderCompare(p.right, q.right));
        }
    }
}
