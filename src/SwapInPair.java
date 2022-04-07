public class SwapInPair {

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode ret = head.next;
        ListNode back = head;
        ListNode front = head.next;
        ListNode prev = null;
        while(back!=null&& front!=null){

            back.next= front.next;
            front.next = back;
            if(prev!=null)
                prev.next = front;
            prev = back;
            back = back.next;

            front = (back!=null)?back.next:null;
        }

        return ret;
    }
}
