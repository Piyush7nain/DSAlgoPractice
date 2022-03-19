public class AddNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){

            int val1 = (l1!=null)? l1.val:0;
            int val2 = (l2!=null)? l2.val:0;
            int sum = (val1 + val2 + carry);
            carry = sum/10;
            cur.next = new ListNode(sum%10);

            l1 = (l1!=null)? l1.next:null;
            l2 = (l2!=null)? l2.next:null;
            cur = cur.next;

        }

        return head.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean run = true;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head =null;
        ListNode cur;
        int carry = 0;
        int val = 0;
        val = (c1.val + c2.val + carry)%10;
        carry = (c1.val + c2.val + carry)/10;
        head = cur = new ListNode(val);
        c1 = c1.next;
        c2 = c2.next;
        while(run){
            if(c1!=null && c2!=null){
                val = (c1.val + c2.val + carry)%10;
                carry = (c1.val + c2.val + carry)/10;
                cur.next = new ListNode(val);
                cur = cur.next;
                c1 = c1.next;
                c2 = c2.next;
            }else if(c1 != null ){
                val = (c1.val + carry)%10;
                carry = (c1.val + carry)/10;
                cur.next = new ListNode(val);
                cur = cur.next;
                if(carry ==0){
                    cur.next = c1.next;
                    run = false;
                }
                c1 = c1.next;
            }else if( c2 !=null){
                val = (c2.val + carry)%10;
                carry = (c2.val + carry)/10;
                cur.next = new ListNode(val);
                cur = cur.next;
                if(carry ==0){
                    cur.next = c2.next;
                    run = false;
                }
                c2 = c2.next;
            } else{
                if(carry!=0)
                    cur.next = new ListNode(carry);
                run  = false;
            }

        }

        return head;
    }
}
