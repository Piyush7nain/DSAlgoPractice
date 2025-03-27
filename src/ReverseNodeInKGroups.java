public class ReverseNodeInKGroups {
    /**
     * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     *
     * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     *
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     *
     * https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-interview-150
     * */

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode first = null;
        ListNode prevEnd = null;
        ListNode start = null;
        ListNode end;
        ListNode curr = head;
        int count =1;
        while (curr != null) {
            if(count == 1) {
                start = curr;
            }
            if(count == k) {
                end = curr;
                curr = curr.next;
                end.next = null;
                reverse(start);
                start.next = null;
                if(prevEnd != null) {
                    prevEnd.next = end;
                }else{
                    first = end;
                }
                prevEnd = start;
                count = 1;
                start =null;
                continue;
            }
            curr = curr.next;
            count++;
        }
        prevEnd.next = start;

        return first;

    }
    public ListNode reverseKGroup2(ListNode head, int k) {

        int pair = 0;
        ListNode curr = head;
        ListNode[][] pairs = new ListNode[k][2];
        int index = 1;
        while (curr != null) {
            if(index%k == 1 || (k==1)) {
                pairs[pair][0] = curr;
            }
            if(index%k == 0) {
                pairs[pair][1] = curr;
                pair++;
            }
            curr = curr.next;
            index++;
        }
        int count =0;
        for(int i = 0; i < pair; i++) {
            if(pairs[i][0] != null && pairs[i][1] != null) {
                pairs[i][1].next = null;
                reverse(pairs[i][0]);
                pairs[i][0].next = null;
                if(i>0){
                    pairs[i-1][0].next = pairs[i][1];
                }
                count++;
            }
        }
        if(count<pair){
            pairs[count][0].next =pairs[count+1][0];
        }
        return pairs[0][1];
    }

    private ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        reverse(head.next).next = head;
        return head;
    }

    public static void main(String[] args) {
        ReverseNodeInKGroups reverseNodeInKGroups = new ReverseNodeInKGroups();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        printList(reverseNodeInKGroups.reverseKGroup(head, 5));

    }

    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            sb.append(" -> ");
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }
}
