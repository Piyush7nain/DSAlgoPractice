public class PartitionList {
    /**
     * Given the head of a linked list and a value x, partition it such that all nodes
     * less than x come before nodes greater than or equal to x.
     *
     * You should preserve the original relative order of the nodes in each of the two partitions.
     *
     * Example 1:
     * Input: head = [1,4,3,2,5,2], x = 3
     * Output: [1,2,2,4,3,5]
     *
     *  Example 2:
     * Input: head = [2,1], x = 2
     * Output: [1,2]
     *
     * https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
     * */

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode tHead = new ListNode(0);
        ListNode tTail = tHead;
        while(fast != null ) {
            if(fast.val < x) {
                if(fast == head) {
                    head = head.next;
                }
                if(fast == slow){
                    slow = slow.next;
                    tTail.next = fast;
                    tTail = tTail.next;
                    fast = fast.next;
                }else{
                    tTail.next = fast;
                    tTail = tTail.next;
                    fast = fast.next;
                    slow.next = fast;
                }
            }else{
                if(fast == slow){
                    fast = fast.next;
                }else{
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        tTail.next = head;
        return tHead.next;
    }

    public static void main(String[] args) {
        PartitionList p = new PartitionList();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(1);
        printList(p.partition(head, 3));
    }
    public static void printList(ListNode head) {
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while(curr != null) {
            sb.append(curr.val + " ");
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }
}
