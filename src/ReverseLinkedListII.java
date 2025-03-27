public class ReverseLinkedListII {
    /**
     * https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
     * */

    /*
    *
    * m = 4, n = 7
    * n1  - n2 - n3 - n4 - n5 - n6 - n7 - n8 - n9 - n10
    * n1 - n2 - n3 - n7 - n6 - n5 - n4 - n8 - n9 - n10
    *
    *
    * n10 - n9 - n8 - n4 - n5 - n6 -n7 - n3 - n2 - n1
    *
    * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode leftEnd = null;
        ListNode start = null;
        ListNode end = null;
        ListNode RigthStart = null;

        int ind = 1;
        ListNode currNode = head;
        while(currNode != null) {
            if (ind == m) {
                start = currNode;
            }
            if (ind == n) {
                end = currNode;
            }
            if(ind == m-1) {
                leftEnd = currNode;
            }
            if(ind == n+1){
                RigthStart = currNode;
            }
            ind++;
            currNode = currNode.next;
        }
        end.next = null;

        start = reverse(start);

        // leftStart - leftEnd - end - start - RightStart - RightEnd

        start.next = RigthStart;

        if(leftEnd != null) {
            leftEnd.next = end;
        }else{
            head = end;
        }

        return head;


    }

    /*
    * n1 - n2 - n3 - n4
    *
    * */
    private ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        reverse(head.next).next = head;
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
//        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        printList(head);
        printList(reverseLinkedListII.reverseBetween(head, 1, 1));

    }

    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val + " ");
            curr = curr.next;
        }
        System.out.println(sb);
    }
}
