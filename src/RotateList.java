public class RotateList {
    /**
     * Given the head of a linked list, rotate the list to the right by k places.
     *
     * Example 1:
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     *
     *  Example 2:
     * Input: head = [0,1,2], k = 4
     * Output: [2,0,1]
     *
     * https://leetcode.com/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
     * */

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 1;
        ListNode last = null;

        while (cur.next!=null) {
            cur = cur.next;
            if(cur.next == null) {
                last = cur;
            }
            count++;
        }
        int rotations = (k>=count)?k%count:k;
        if(rotations==0) return head;
        cur = head;
        int i =1;
        while(i< (count - rotations)){
            cur = cur.next;
            i++;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        last.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        printList(rotateList.rotateRight(head, 1));
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        StringBuffer sb = new StringBuffer();
        while (cur != null) {
            sb.append(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}
