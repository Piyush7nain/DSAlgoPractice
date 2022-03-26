import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null) return ans;
        int dir = 1;//left->right
        Deque<TreeNode> LR = new ArrayDeque<>();
        Deque<TreeNode> RL = new ArrayDeque<>();
        LR.addFirst(root);
        Deque<TreeNode> queue = LR;
        TreeNode curr;
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                if(dir ==1){
                    curr = queue.poll();
                    list.add(curr.val);
                    if(curr.left!=null) RL.addFirst(curr.left);
                    if(curr.right!=null) RL.addFirst(curr.right);
                }else{
                    curr = queue.poll();
                    list.add(curr.val);
                    if(curr.right!=null) LR.addFirst(curr.right);
                    if(curr.left!=null) LR.addFirst(curr.left);
                }
            }
            ans.add(list);
            dir = 1-dir;
            if(dir == 1) queue = LR;
            else queue = RL;
        }
        return ans;
    }
}
