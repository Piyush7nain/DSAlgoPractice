import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumHeightOfTree {

    public int minDepthBFS(TreeNode root) {

        if(root ==null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        int depth =1;
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = queue.poll();
                if(isLeaf(curr)) return depth;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }
    public int minDepth(TreeNode root) {

        if(root==null)
            return 0;
        if(isLeaf(root))
            return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left ==0)
            return right+1;
        if(right ==0)
            return left+1;
        return Math.min(left, right) +1;
    }
    boolean isLeaf(TreeNode root){
        return root.left==null && root.right ==null;
    }
}
