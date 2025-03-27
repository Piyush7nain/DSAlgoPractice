public class RemoveDuplicatesFromSortedListII {

    /**
     * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * Return the linked list sorted as well
     *
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * Eample 1:
     * Input: head = [1,2,3,3,4,4,5]
     * Output: [1,2,5]
     *
     * Example 2:
     * Input: head = [1,1,1,2,3]
     * Output: [2,3]
     * */

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = head;
        while (current != null) {
            if(current.next != null && current.next.val == current.val) {
                while(current.next != null && current.val == current.next.val) {
                    current.next = current.next.next;
                }
                if(current == head){
                    head = current.next;
                    prev = head;
                    current = head;
                }else{
                    prev.next = current.next;
                    current = current.next;
                }
            }else{
                prev = current;
                current = current.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII removeDuplicates = new RemoveDuplicatesFromSortedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(5);
        printList(removeDuplicates.deleteDuplicates(head));
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val + " ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}
