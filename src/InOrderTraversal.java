import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();

            inOrder(root, ans);

            return ans;
        }

            void inOrder(TreeNode root, List<Integer> ans){

                if(root == null)
                    return;
                inOrder(root.left, ans);
                ans.add(root.val);
                inOrder(root.right, ans);

            }
    }


}
