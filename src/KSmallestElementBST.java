public class KSmallestElementBST {

    /**
     * Given the root of a binary search tree, and an integer k,
     * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     *
     * Example 1:
     *
     * Input: root = [3,1,4,null,2], k = 1
     * Output: 1
     * Example 2:
     *
     *
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * Output: 3
     * */
    int size =0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        if(ans != -1){
            return ans;
        }

        kthSmallest(root.left, k);
        size++;
        if(size == k){
            ans = root.val;
        }
        kthSmallest(root.right, k);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KSmallestElementBST obj = new KSmallestElementBST();
        System.out.println(obj.kthSmallest(root, 1));
    }
}
