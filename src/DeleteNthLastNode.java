class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class DeleteNthLastNode {



    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode front = head;
            ListNode back = null;
            int len = 0;
            while (front != null) {
                if (len == n) {
                    back = head;
                }
                if (back != null && len != n)
                    back = back.next;
                len++;
                front = front.next;

            }
            if (back == null)
                return head.next;
            back.next = back.next != null ? back.next.next : null;
            return head;
        }

        public ListNode removeNthFromEnd2(ListNode head, int n) {

            ListNode temp = head;
            int len = 0;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
            int rem = len - n;
            if (rem == 0)
                return head.next;
            ListNode back = head;
            ListNode front = back.next;
            int current = 1;
            while (current < rem) {
                back = front;
                front = back.next;
                current++;
            }
            back.next = front.next;

            return head;
        }
    }
}
