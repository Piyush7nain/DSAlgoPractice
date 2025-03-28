import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointerII {

    /**
     * Given a binary tree
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * Populate each next pointer to point to its next right node.
     * If there is no next right node, the next pointer should be set to NULL.
     * Initially, all next pointers are set to NULL.
     *
     * Example 1:
     * Input: root = [1,2,3,4,5,null,7]
     * Output: [1,#,2,3,#,4,5,7,#]
     * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer
     * to point to its next right node, just like in Figure B. The serialized output is in level order
     * as connected by the next pointers, with '#' signifying the end of each level.
     *
     *  Example 2:
     * Input: root = []
     * Output: []
     * */

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> currQueue = new LinkedList<>();
        Queue<Node> nextQueue = new LinkedList<>();

        currQueue.add(root);
        while (!currQueue.isEmpty()) {
            Node curr = currQueue.poll();
            if(curr.left != null) nextQueue.add(curr.left);
            if(curr.right != null) nextQueue.add(curr.right);
            curr.next = currQueue.peek();
            if(currQueue.isEmpty()){
                Queue<Node> temp = currQueue;
                currQueue = nextQueue;
                nextQueue = temp;
            }
        }

        return root;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
